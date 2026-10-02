package com.demo;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.handler.DispatcherServletWebRequest;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws LifecycleException {

        System.out.println("Starting Application.....");

        Tomcat server = new Tomcat();
        server.setPort(8080);

        Context context = server.addContext("", null);

        AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
        springContext.register(AppConfig.class, WebConfig.class);

        DispatcherServlet servlet = new DispatcherServlet(springContext);

        server.addServlet(context,"dispatcher", servlet);
        context.addServletMapping("/","dispatcher");

        server.start();
        System.out.println("Application Started....." + server.getServer().getAddress() +":"+ server.getConnector().getPort());
        server.getServer().await();

    }
}