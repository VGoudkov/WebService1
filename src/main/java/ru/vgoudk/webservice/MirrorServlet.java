/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vgoudk.webservice;

import com.sun.corba.se.spi.presentation.rmi.StubAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author VGoudkov
 *
 */
enum PageVariablesType {
    METHOD("method"),
    URL("URL"),
    PATHINFO("pathInfo"),
    SESSIONID("sessionId"),
    PARAMETERS("parameters");

    private final String name;

    private PageVariablesType(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}

public class MirrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType(PageGenerator.CONTENT_TYPE);

        String message = req.getParameter( PageGenerator.MESSAGE_FIELD);
        if ( message == null || message.isEmpty()){
            resp.setStatus( HttpServletResponse.SC_FORBIDDEN);
        }
        else{
            resp.setStatus( HttpServletResponse.SC_OK);
        }
        
        Map<String, Object> paraMap = getFreemakerParametersMap(req);
        paraMap.put( PageGenerator.MESSAGE_FIELD, message == null ? "" : message);
        
        //resp.getWriter().println(getTypedParametersMap(req));
        resp.getWriter().println(PageGenerator.getInstance().getPage("page.html", paraMap));
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    protected Map<PageVariablesType, String> getTypedParametersMap(HttpServletRequest req) {
        Map< PageVariablesType, String> vars = new HashMap<>();
        vars.put(PageVariablesType.METHOD, req.getMethod());
        vars.put(PageVariablesType.URL, req.getRequestURL().toString());
        vars.put(PageVariablesType.PATHINFO, req.getPathInfo());
        vars.put(PageVariablesType.SESSIONID, req.getSession().getId());
        vars.put(PageVariablesType.PARAMETERS, req.getParameterMap().toString());
        return vars;
    }

    protected Map< String, Object> getFreemakerParametersMap(HttpServletRequest req) {
        Map<  String, Object> vars = new HashMap<>();
        vars.put(PageVariablesType.METHOD.toString(), req.getMethod());
        vars.put(PageVariablesType.URL.toString(), req.getRequestURL().toString());
        vars.put(PageVariablesType.PATHINFO.toString(), req.getPathInfo());
        vars.put(PageVariablesType.SESSIONID.toString(), req.getSession().getId());
        vars.put(PageVariablesType.PARAMETERS.toString(), req.getParameterMap().toString());
        return vars;
    }

}
