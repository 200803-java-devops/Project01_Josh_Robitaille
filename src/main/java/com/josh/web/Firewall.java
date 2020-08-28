package com.josh.web;

import java.io.File;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Firewall {


    public static void main(String[] args) {
        setupServlet();
        
    }

    public static void setupServlet() {
        String servletContextPath = "/Firewall";
        Tomcat firewallServer = new Tomcat();
        firewallServer.setBaseDir(new File("target/tomcat/").getAbsolutePath());
        firewallServer.setPort(8989);
        firewallServer.getConnector();
        firewallServer.addWebapp(servletContextPath, new File("src/main/resources/").getAbsolutePath());
        firewallServer.addServlet(servletContextPath, "FirewallServlet", new FirewallServlet()).addMapping("/wall-of-fire");
        try {
            firewallServer.start();
        } catch (LifecycleException e) {
            System.err.println("Could not start firewall servlet");
        }
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    firewallServer.stop();
                } catch (LifecycleException e) {
                    System.err.println("Could not shut down firewall servlet");
                }
            }
        });
    }
}