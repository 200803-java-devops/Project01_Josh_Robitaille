package com.josh.web;

import java.io.File;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.WebResourceSet;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

public class Firewall {


    public static void main(String[] args) {
        setupServlet();
        
    }

    public static void setupServlet() {
        final String base = new File("./").getAbsolutePath();
        Tomcat firewallServer = new Tomcat();
        firewallServer.setBaseDir(new File("Firewall/target/tomcat/").getAbsolutePath());
        firewallServer.setPort(8989);
        firewallServer.getConnector();
        Context context = firewallServer.addWebapp("", base);
        WebResourceRoot resources = new StandardRoot(context);
        WebResourceSet resourceSet = new DirResourceSet(resources, "/WEB-INF/classes", base, "/");
        resources.addPreResources(resourceSet);
        context.setResources(resources);
        try {
            firewallServer.start();
            firewallServer.getServer().await();
        } catch (LifecycleException e) {
            System.err.println("Could not start firewall servlet");
        }
    }
}