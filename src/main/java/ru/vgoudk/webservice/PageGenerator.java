/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vgoudk.webservice;

import java.util.Map;

/**
 *
 * @author VGoudkov
 */
public class PageGenerator {

    public static final String CONTENT_TYPE = "text/html;charset=utf-8";
    
    
    private static PageGenerator generator;

    public synchronized static PageGenerator getInstance() {
        if (generator == null) {
            generator = new PageGenerator();
        }
        return generator;
    }

    public String getPage(String fileName, Map<String, Object> data) {
        return "Hello from PageGenerator!";
    }
    
    
    
}
