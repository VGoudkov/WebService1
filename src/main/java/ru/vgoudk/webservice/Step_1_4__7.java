/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vgoudk.webservice;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 *
 * @author VGoudkov
 */
public class Step_1_4__7 {

    public static void main(String[] args) throws Exception {

        Frontend frontend = new Frontend();
        
        Server server = new Server(8080);
        ServletContextHandler context =
            new ServletContextHandler( ServletContextHandler.SESSIONS);
        server.setHandler(context);
        context.addServlet(new ServletHolder( frontend), "/authform");
        server.start();
        server.join();
        
    }
}
