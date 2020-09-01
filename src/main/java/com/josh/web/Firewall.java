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
        Tomcat server = new Tomcat();
        setupServlet(server);  
        startServer(server);      
    }

    public static void setupServlet(Tomcat server) {
        final String base = new File("./").getAbsolutePath();
        
        server.setBaseDir(new File("Firewall/target/tomcat/").getAbsolutePath());
        server.setPort(8989);
        server.getConnector();
        Context context = server.addWebapp("", base);
        WebResourceRoot resources = new StandardRoot(context);
        WebResourceSet resourceSet = new DirResourceSet(resources, "/WEB-INF/classes", base, "/");
        resources.addPreResources(resourceSet);
        context.setResources(resources);
    }

    public static void startServer(Tomcat server){
        try {
            server.start();
            server.getServer().await();
        } catch (LifecycleException e) {
            System.err.println("Could not start firewall servlet");
        }
    }
}