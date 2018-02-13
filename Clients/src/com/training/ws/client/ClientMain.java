package com.training.ws.client;

import javax.xml.ws.BindingProvider;
// wsimport.exe -keep -Xnocompile -p com.training.ws.client http://localhost:8080/TTJavaEE/MyRest?wsdl
public class ClientMain {

    public static void main(String[] args) {
        MyRestService myRestService = new MyRestService();
        MyRest myRestPort = myRestService.getMyRestPort();
        BindingProvider bindingProvider = (BindingProvider) myRestPort;
        bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                                                "http://localhost:8081/TTJavaEE/MyRest");
        bindingProvider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY,
                "osman");
        bindingProvider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY,
                "osman");
        bindingProvider.getRequestContext().put("javax.xml.ws.client.connectionTimeout",
                "2000");
        bindingProvider.getRequestContext().put("javax.xml.ws.client.receiveTimeout",
                "2000");
        String hello2 = myRestPort.hello2();
        System.out.println("Hello 2 returned : "
                           + hello2);
    }

}
