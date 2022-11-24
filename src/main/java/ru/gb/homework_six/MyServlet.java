package ru.gb.homework_six;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getRequestURI().equals("/hello")) {
            resp.setContentType("text/html");
            resp.getWriter().print("<html><head></head><body><h1>Hello World!!!</h1></body></html>");
        }
        else {
            throw new IllegalStateException("Help, I don't know what to do with this url");
        }
    }
}
