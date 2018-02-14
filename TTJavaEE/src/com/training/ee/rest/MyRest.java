package com.training.ee.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.training.ee.ejb.PersonDAO;
import com.training.ee.model.Person;

@Path("/my")
@WebService(targetNamespace="http://www.tttraining.com")
public class MyRest {

    @EJB
    private PersonDAO personDAO;
    
    @GET
    @WebMethod(exclude=true)
    public String hello() {
        return "Hello TT : " + personDAO.getId();
    }

    @PUT
    public String hello2() {
        return "Hello 2 TT";
    }

    @GET
    @Path("/yy")
    public String hello3() {
        return "Hello 3 TT";
    }

    @GET
    @Path("/zz/{name}/{age}")
    public String hello4(@PathParam("name") String isim,
                         @PathParam("age") int yas,
                         @QueryParam("surname") String soyisim,
                         @QueryParam("gender") String cinsiyet,
                         @HeaderParam("department") String department,
                         @HeaderParam("requestId") String requestId,
                         @MatrixParam("id") String id,
                         @MatrixParam("mid") String mid) {
        return "Hello 4 : "
               + " name : "
               + isim
               + " surname : "
               + soyisim
               + " age : "
               + yas
               + " gender : "
               + cinsiyet
               + " department : "
               + department
               + " requestId : "
               + requestId
               + " id : "
               + id
               + " mid : "
               + mid
               
               
               ;
    }


    @POST
    @Path("/z5/{name}/{age}")
    public String hello5(@PathParam("name") String isim,
                         @PathParam("age") int yas,
                         @FormParam("surname") String soyisim,
                         @FormParam("gender") String cinsiyet,
                         @FormParam("department") String department,
                         @FormParam("requestId") String requestId,
                         @FormParam("id") String id,
                         @FormParam("mid") String mid) {
        return "Hello 5 : "
               + " name : "
               + isim
               + " surname : "
               + soyisim
               + " age : "
               + yas
               + " gender : "
               + cinsiyet
               + " department : "
               + department
               + " requestId : "
               + requestId
               + " id : "
               + id
               + " mid : "
               + mid
               
               
               ;
    }

    @POST
    @Path("/z6/{name}/{age}")
    public String hello6(@BeanParam Person person) {
        return "Hello 6 : "
               + " name : "
               + person.getIsim()
               + " surname : "
               + person.getSoyisim()
               + " age : "
               + person.getYas()
               + " gender : "
               + person.getCinsiyet()
               + " department : "
               + person.getDepartment()
               + " requestId : "
               + person.getRequestId()
               + " id : "
               + person.getId()
               + " mid : "
               + person.getMid()
               ;
    }

    @POST
    @Path("/z7")
    public String hello7(Person person) {
        personDAO.save(person);
        return "Hello 7 : "
               + " name : "
               + person.getIsim()
               + " surname : "
               + person.getSoyisim()
               + " age : "
               + person.getYas()
               + " gender : "
               + person.getCinsiyet()
               + " department : "
               + person.getDepartment()
               + " requestId : "
               + person.getRequestId()
               + " id : "
               + person.getId()
               + " mid : "
               + person.getMid()
               ;
    }

    @POST
    @Path("/z8")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @WebMethod(operationName="helloTest")
    public Person hello8(@WebParam(name="person") @Valid Person person) {
        personDAO.save(person);
        return person;
    }
    
    @POST
    @Path("/z9")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Person> hello9(@WebParam(name="person") @QueryParam("name") String name) {
        return personDAO.getPersonByName(name);
    }
    

}
