package com.training.ee.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.training.ee.model.Employee;
import com.training.ee.model.EmployeeInfo;

/**
 * Session Bean implementation class EmployeeDAO
 */
@Stateless
@LocalBean
public class EmployeeDAO {

	@PersistenceContext(unitName = "trainingee")
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public EmployeeDAO() {
		// TODO Auto-generated constructor stub
	}

	// @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void save(final Employee employee) {
		this.entityManager.persist(employee);
	}

	public List<Employee> getAllEmployees() {
		TypedQuery<Employee> createQuery = this.entityManager.createQuery("select e from Employee e",
		                                                                  Employee.class);
		return createQuery.getResultList();
	}

	public List<Employee> fillAllEmployee(final List<Employee> detachedList) {
		List<Employee> employees = new ArrayList<>();
		for (Employee employee : detachedList) {
			Employee mergedEmployee = this.entityManager.merge(employee);
			EmployeeInfo employeeInfo = mergedEmployee.getEmployeeInfo();
			employees.add(mergedEmployee);
		}
		return employees;

	}

	public List<Employee> getAllEmployees2() {
		TypedQuery<Employee> createQuery = this.entityManager.createNamedQuery("getAllEmployees",
		                                                                       Employee.class);
		return createQuery.getResultList();
	}

	public void deleteEmployee(final Employee employee) {
		this.entityManager.remove(employee);
	}

	public Employee getEmployee(final long emloyeeId) {
		return this.entityManager.find(Employee.class,
		                               emloyeeId);
	}

	public List<Employee> getEmployeeByName(final String name) {
		// EntityManagerFactory entityManagerFactory = null;
		// EntityManager createEntityManager =
		// entityManagerFactory.createEntityManager();
		// try {
		// createEntityManager.getTransaction()
		// .begin();
		//
		// createEntityManager.getTransaction()
		// .commit();
		// } catch (Exception e) {
		// createEntityManager.getTransaction()
		// .rollback();
		// } finally {
		// createEntityManager.close();
		// }
		TypedQuery<Employee> createQuery = this.entityManager.createNamedQuery("getAllEmployees",
		                                                                       Employee.class);
		createQuery.setParameter("nn",
		                         name);
		return createQuery.getResultList();
	}

}
