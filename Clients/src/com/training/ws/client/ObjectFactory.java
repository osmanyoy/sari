
package com.training.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.training.ws.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Hello3Response_QNAME = new QName("http://www.tttraining.com", "hello3Response");
    private final static QName _Hello5Response_QNAME = new QName("http://www.tttraining.com", "hello5Response");
    private final static QName _Hello4Response_QNAME = new QName("http://www.tttraining.com", "hello4Response");
    private final static QName _Hello7Response_QNAME = new QName("http://www.tttraining.com", "hello7Response");
    private final static QName _HelloTest_QNAME = new QName("http://www.tttraining.com", "helloTest");
    private final static QName _HelloTestResponse_QNAME = new QName("http://www.tttraining.com", "helloTestResponse");
    private final static QName _Hello6Response_QNAME = new QName("http://www.tttraining.com", "hello6Response");
    private final static QName _Person_QNAME = new QName("http://www.tttraining.com", "person");
    private final static QName _Hello5_QNAME = new QName("http://www.tttraining.com", "hello5");
    private final static QName _Hello4_QNAME = new QName("http://www.tttraining.com", "hello4");
    private final static QName _Hello3_QNAME = new QName("http://www.tttraining.com", "hello3");
    private final static QName _Hello2_QNAME = new QName("http://www.tttraining.com", "hello2");
    private final static QName _Hello7_QNAME = new QName("http://www.tttraining.com", "hello7");
    private final static QName _Hello2Response_QNAME = new QName("http://www.tttraining.com", "hello2Response");
    private final static QName _Hello6_QNAME = new QName("http://www.tttraining.com", "hello6");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.training.ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Hello3Response }
     * 
     */
    public Hello3Response createHello3Response() {
        return new Hello3Response();
    }

    /**
     * Create an instance of {@link Hello5Response }
     * 
     */
    public Hello5Response createHello5Response() {
        return new Hello5Response();
    }

    /**
     * Create an instance of {@link Hello4Response }
     * 
     */
    public Hello4Response createHello4Response() {
        return new Hello4Response();
    }

    /**
     * Create an instance of {@link Hello7Response }
     * 
     */
    public Hello7Response createHello7Response() {
        return new Hello7Response();
    }

    /**
     * Create an instance of {@link HelloTest }
     * 
     */
    public HelloTest createHelloTest() {
        return new HelloTest();
    }

    /**
     * Create an instance of {@link HelloTestResponse }
     * 
     */
    public HelloTestResponse createHelloTestResponse() {
        return new HelloTestResponse();
    }

    /**
     * Create an instance of {@link Hello6Response }
     * 
     */
    public Hello6Response createHello6Response() {
        return new Hello6Response();
    }

    /**
     * Create an instance of {@link PersonType }
     * 
     */
    public PersonType createPersonType() {
        return new PersonType();
    }

    /**
     * Create an instance of {@link Hello4 }
     * 
     */
    public Hello4 createHello4() {
        return new Hello4();
    }

    /**
     * Create an instance of {@link Hello5 }
     * 
     */
    public Hello5 createHello5() {
        return new Hello5();
    }

    /**
     * Create an instance of {@link Hello2 }
     * 
     */
    public Hello2 createHello2() {
        return new Hello2();
    }

    /**
     * Create an instance of {@link Hello3 }
     * 
     */
    public Hello3 createHello3() {
        return new Hello3();
    }

    /**
     * Create an instance of {@link Hello2Response }
     * 
     */
    public Hello2Response createHello2Response() {
        return new Hello2Response();
    }

    /**
     * Create an instance of {@link Hello6 }
     * 
     */
    public Hello6 createHello6() {
        return new Hello6();
    }

    /**
     * Create an instance of {@link Hello7 }
     * 
     */
    public Hello7 createHello7() {
        return new Hello7();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link PersonExtra }
     * 
     */
    public PersonExtra createPersonExtra() {
        return new PersonExtra();
    }

    /**
     * Create an instance of {@link Spouse }
     * 
     */
    public Spouse createSpouse() {
        return new Spouse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello3Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tttraining.com", name = "hello3Response")
    public JAXBElement<Hello3Response> createHello3Response(Hello3Response value) {
        return new JAXBElement<Hello3Response>(_Hello3Response_QNAME, Hello3Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello5Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tttraining.com", name = "hello5Response")
    public JAXBElement<Hello5Response> createHello5Response(Hello5Response value) {
        return new JAXBElement<Hello5Response>(_Hello5Response_QNAME, Hello5Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello4Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tttraining.com", name = "hello4Response")
    public JAXBElement<Hello4Response> createHello4Response(Hello4Response value) {
        return new JAXBElement<Hello4Response>(_Hello4Response_QNAME, Hello4Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello7Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tttraining.com", name = "hello7Response")
    public JAXBElement<Hello7Response> createHello7Response(Hello7Response value) {
        return new JAXBElement<Hello7Response>(_Hello7Response_QNAME, Hello7Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloTest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tttraining.com", name = "helloTest")
    public JAXBElement<HelloTest> createHelloTest(HelloTest value) {
        return new JAXBElement<HelloTest>(_HelloTest_QNAME, HelloTest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloTestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tttraining.com", name = "helloTestResponse")
    public JAXBElement<HelloTestResponse> createHelloTestResponse(HelloTestResponse value) {
        return new JAXBElement<HelloTestResponse>(_HelloTestResponse_QNAME, HelloTestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello6Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tttraining.com", name = "hello6Response")
    public JAXBElement<Hello6Response> createHello6Response(Hello6Response value) {
        return new JAXBElement<Hello6Response>(_Hello6Response_QNAME, Hello6Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tttraining.com", name = "person")
    public JAXBElement<PersonType> createPerson(PersonType value) {
        return new JAXBElement<PersonType>(_Person_QNAME, PersonType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello5 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tttraining.com", name = "hello5")
    public JAXBElement<Hello5> createHello5(Hello5 value) {
        return new JAXBElement<Hello5>(_Hello5_QNAME, Hello5 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello4 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tttraining.com", name = "hello4")
    public JAXBElement<Hello4> createHello4(Hello4 value) {
        return new JAXBElement<Hello4>(_Hello4_QNAME, Hello4 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello3 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tttraining.com", name = "hello3")
    public JAXBElement<Hello3> createHello3(Hello3 value) {
        return new JAXBElement<Hello3>(_Hello3_QNAME, Hello3 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tttraining.com", name = "hello2")
    public JAXBElement<Hello2> createHello2(Hello2 value) {
        return new JAXBElement<Hello2>(_Hello2_QNAME, Hello2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello7 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tttraining.com", name = "hello7")
    public JAXBElement<Hello7> createHello7(Hello7 value) {
        return new JAXBElement<Hello7>(_Hello7_QNAME, Hello7 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello2Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tttraining.com", name = "hello2Response")
    public JAXBElement<Hello2Response> createHello2Response(Hello2Response value) {
        return new JAXBElement<Hello2Response>(_Hello2Response_QNAME, Hello2Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello6 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tttraining.com", name = "hello6")
    public JAXBElement<Hello6> createHello6(Hello6 value) {
        return new JAXBElement<Hello6>(_Hello6_QNAME, Hello6 .class, null, value);
    }

}
