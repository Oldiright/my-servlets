package org.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(value = "/time")
public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDateTime localDateTime = LocalDateTime.now();
        String[] rowLocalDateTime = localDateTime.toString().split("T");
        StringBuilder stringBuilder = new StringBuilder();
        String timezone = req.getParameter("timezone");
        stringBuilder.append(rowLocalDateTime[0]).append(" ").append(rowLocalDateTime[1].split("\\.")[0]);
        if(timezone != null) {
            stringBuilder.append(" ").append(timezone);
        } else {
            stringBuilder.append(" UTC");
        }
        resp.setContentType("text/html: charset=utf-8");
        resp.getWriter().write(stringBuilder.toString());
        resp.getWriter().close();
    }
}
