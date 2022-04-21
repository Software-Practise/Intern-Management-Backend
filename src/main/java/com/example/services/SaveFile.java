package com.example.services;

import java.io.*;
import javax.servlet.*;

public class SaveFile implements Servlet {

    ServletConfig config = null;

    @Override
    public void init(ServletConfig servletConfig) {
        config = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
    //    res.setContentType("text/html");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
