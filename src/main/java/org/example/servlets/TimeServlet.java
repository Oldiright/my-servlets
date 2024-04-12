package org.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

@WebServlet(value = "/time")
public class TimeServlet extends HttpServlet {
    public static final String TIME_ZONE_PATH = "timezone";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDateTime localDateTime = LocalDateTime.now();
        String[] rowLocalDateTime = localDateTime.toString().split("T");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(rowLocalDateTime[0]).append(" ").append(rowLocalDateTime[1].split("\\.")[0]);
        if (hasParameter(req, TIME_ZONE_PATH)) {
            stringBuilder.append(" ").append(req.getParameter(TIME_ZONE_PATH));
        } else {
            stringBuilder.append(" UTC");
        }
        resp.setContentType("text/html: charset=utf-8");
        resp.getWriter().write(stringBuilder.toString());
        resp.getWriter().close();
    }

    private boolean hasParameter(HttpServletRequest req, String parameterName) {
        Map<String, String[]> parameterMap = req.getParameterMap();
        if(!parameterMap.containsKey(parameterName) || parameterMap.get(parameterName) == null) {
            return false;
        }
        return true;
    }
}
