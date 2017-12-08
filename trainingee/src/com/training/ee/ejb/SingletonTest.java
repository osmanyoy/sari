package com.training.ee.ejb;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.annotation.Resource;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.DependsOn;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

/**
 * Session Bean implementation class SingletonTest
 */
@Singleton
@Startup
@DependsOn({})
@LocalBean
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class SingletonTest {
	private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	@Resource
	private TimerService timerService;

	/**
	 * Default constructor.
	 */
	public SingletonTest() {
	}

	// @Lock(LockType.READ)
	public String test1() {
		this.timerService.createSingleActionTimer(10000,
		                                          null);

		try {
			this.readWriteLock.readLock()
			                  .tryLock(30000,
			                           TimeUnit.MILLISECONDS);
			String srt = "test1";

			return srt;
		} catch (Exception e) {
		} finally {
			this.readWriteLock.readLock()
			                  .unlock();
		}
		return null;
	}

	@Timeout
	public void timerTimeout(final Timer timer) {

	}

	// @Lock(LockType.READ)
	public String test2() {
		try {
			this.readWriteLock.readLock()
			                  .tryLock(30000,
			                           TimeUnit.MILLISECONDS);
			String srt = "test1";

			return srt;
		} catch (Exception e) {
		} finally {
			this.readWriteLock.readLock()
			                  .unlock();
		}
		return null;
	}

	// @Lock(LockType.WRITE)
	public String test3() {
		try {
			this.readWriteLock.writeLock()
			                  .tryLock(30000,
			                           TimeUnit.MILLISECONDS);
			String srt = "test1";

			return srt;
		} catch (Exception e) {
		} finally {
			this.readWriteLock.writeLock()
			                  .unlock();
		}
		return null;
	}

	@Schedule(hour = "*", minute = "*/20", second = "*", persistent = false)
	public void timerTest() {
		System.out.println("Timer test executed");
	}

}
