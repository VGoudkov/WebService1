/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vgoudk.webservice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author VGoudkov
 */
public class MirrorServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType( PageGenerator.CONTENT_TYPE);
        resp.setStatus( HttpServletResponse.SC_OK);
        String keyValue = req.getParameter("key");
        String ret = keyValue != null? keyValue : "Mirror servlet: no key set" ;
        resp.getWriter().println( ret);
    }
    
}
