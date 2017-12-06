package com.training.ee.model;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.Vetoed;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Vetoed
@NamedQueries({ @NamedQuery(name = "getAllEmployees", query = "select e from Employee e"),
                @NamedQuery(name = "getAllEmployeesByName", query = "select e from Employee e where e.name = :nn") })
@NamedNativeQueries({ @NamedNativeQuery(name = "getAllEmployeesNative", query = "SELECT * FROM CALISAN") })

@Entity
@Table(name = "calisan", indexes = { @Index(name = "name_index", columnList = "isim") })
@SecondaryTable(name = "yetkiler")
public class Employee {

	@Id
	@GeneratedValue
	private long employeeId;

	@Size(max = 20)
	@Column(name = "isim", length = 20, nullable = false)
	private String name;
	// @Pattern(regexp="")
	@NotNull
	private String surname;
	private EGender gender;
	@Past
	private Date birthdate;

	@Column(name = "kullanici", table = "yetkiler")
	private String username;
	@Column(name = "sifre", table = "yetkiler")
	private String password;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "city", column = @Column(name = "sehir")) })
	private Address address;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private EmployeeInfo employeeInfo;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "employee")
	private List<EmailAdresses> emailAdresses;

	@PrePersist
	@PreUpdate
	public void encode() {
		this.password = Base64.getEncoder()
		                      .encodeToString(this.password.getBytes());
	}

	@PostLoad
	@PostPersist
	@PostUpdate
	public void decode() {
		this.password = new String(Base64.getDecoder()
		                                 .decode(this.password.getBytes()));
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public EGender getGender() {
		return this.gender;
	}

	public void setGender(final EGender gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(final Date birthdate) {
		this.birthdate = birthdate;
	}

	public long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(final long employeeId) {
		this.employeeId = employeeId;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(final Address address) {
		this.address = address;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public EmployeeInfo getEmployeeInfo() {
		return this.employeeInfo;
	}

	public void setEmployeeInfo(final EmployeeInfo employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	public List<EmailAdresses> getEmailAdresses() {
		return this.emailAdresses;
	}

	public void setEmailAdresses(final List<EmailAdresses> emailAdresses) {
		this.emailAdresses = emailAdresses;
	}

}
