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
    URL("url"),
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

    final String MESSAGE_FIELD = "message";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //resp.getWriter().println(PageGenerator.getInstance().getPage("", null));
        resp.getWriter().println( getParametersMap(req));
        resp.setContentType(PageGenerator.CONTENT_TYPE);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    protected Map<PageVariablesType, String> getParametersMap(HttpServletRequest req) {
        Map< PageVariablesType, String> vars = new HashMap<>();
        vars.put(PageVariablesType.METHOD, req.getMethod());
        vars.put(PageVariablesType.URL, req.getRequestURL().toString());
        vars.put(PageVariablesType.PATHINFO, req.getPathInfo());
        vars.put(PageVariablesType.SESSIONID, req.getSession().getId());
        vars.put(PageVariablesType.PARAMETERS, req.getParameterMap().toString());
        vars.put(PageVariablesType.PARAMETERS, req.getParameterMap().toString());
        return vars;
    }

}
