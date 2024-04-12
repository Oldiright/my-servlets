package org.example.servlets;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Main {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String[] rowLocalDateTime = localDateTime.toString().split("T");

        System.out.println(rowLocalDateTime[0] + " " + rowLocalDateTime[1].split("\\.")[0]);
    }
}
