package com.training.ee.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;

@Entity
@Table(name="PersonTable",indexes= {
        @Index(columnList="name,surname",unique=true,name="my_ns_index")
})
@SecondaryTable(name="personsecond")
public class Person {
    
    @Id
    @GeneratedValue
    private long personId;
    @Column(name="name",length=20,nullable=false)
    @PathParam("name")
    private String isim;
    @Column(name="age",nullable=false)
    @PathParam("age")
    private int yas;
    @Column(name="surname",length=20,nullable=false)
    @FormParam("surname")
    private String soyisim;
    @Column(name="gender",length=10,nullable=false)
    @FormParam("gender")
    private String cinsiyet;
    @FormParam("department")
    private String department;
    @FormParam("requestId")
    private String requestId;
    @Column(unique= true,table="personsecond")
    @FormParam("id")
    private String id;
    @Column(unique= true,table="personsecond")
    @FormParam("mid")
    private String mid;
    
    @Embedded
    private PersonExtra personExtra;
    
    @OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    private Spouse spouse;
    
    @OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    private List<Address> addressList;
    
    public String getIsim() {
        return isim;
    }
    public void setIsim(String isim) {
        this.isim = isim;
    }
    public int getYas() {
        return yas;
    }
    public void setYas(int yas) {
        this.yas = yas;
    }
    public String getSoyisim() {
        return soyisim;
    }
    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }
    public String getCinsiyet() {
        return cinsiyet;
    }
    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getRequestId() {
        return requestId;
    }
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getMid() {
        return mid;
    }
    public void setMid(String mid) {
        this.mid = mid;
    }
    public PersonExtra getPersonExtra() {
        return personExtra;
    }
    public void setPersonExtra(PersonExtra personExtra) {
        this.personExtra = personExtra;
    }
    public Spouse getSpouse() {
        return spouse;
    }
    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }
    public List<Address> getAddressList() {
        return addressList;
    }
    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
    
    
}
