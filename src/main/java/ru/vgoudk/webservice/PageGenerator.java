/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vgoudk.webservice;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/**
 *
 * @author VGoudkov
 */
public class PageGenerator {

    public static final String CONTENT_TYPE = "text/html;charset=utf-8";
    public static final String HTML_DIR = "templates";
    public static final String MESSAGE_FIELD = "message";

    private static PageGenerator generator;
    private final Configuration cfg;

    public synchronized static PageGenerator getInstance() {
        if (generator == null) {
            generator = new PageGenerator();
        }
        return generator;
    }

    public String getHelloPage(String fileName, Map<String, Object> data) {
        return "Hello from PageGenerator!";
    }

    public String getPage(String fileName, Map<String, Object> data) {
        Writer stream = new StringWriter();

        try {
            Template template = cfg.getTemplate(HTML_DIR + File.separator + fileName);
            template.process(data, stream);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
        return stream.toString();
    }

    public PageGenerator() {
        cfg = new Configuration();
    }

}
