/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vgoudk.webservice;

import org.eclipse.jetty.server.Server;

/**
 *
 * @author VGoudkov
 */
public class Step_1_4__7 {

    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);
        
        server.start();
        server.join();
        
    }
}