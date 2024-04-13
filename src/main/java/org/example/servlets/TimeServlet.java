package org.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@WebServlet(value = "/time")
public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rowLocalDateTime;
        StringBuilder stringBuilder = new StringBuilder();
        if (Utils.hasParameter(req, Utils.TIME_ZONE_PATH)) {
            String zoneId = req.getParameter(Utils.TIME_ZONE_PATH);
            rowLocalDateTime = LocalDateTime.now(ZoneId.of(zoneId))
                    .format(DateTimeFormatter
                            .ofPattern("yyyy-MM-dd HH:mm:ss"));
            stringBuilder.append(rowLocalDateTime);
            stringBuilder.append(" ").append(zoneId);
        } else {
            rowLocalDateTime = LocalDateTime.now()
                    .format(DateTimeFormatter
                            .ofPattern("yyyy-MM-dd HH:mm:ss"));
            stringBuilder.append(rowLocalDateTime);
            stringBuilder.append(" UTC");
        }
        resp.setContentType("text/html: charset=utf-8");
        resp.getWriter().write(stringBuilder.toString());
        resp.getWriter().close();
    }
}
