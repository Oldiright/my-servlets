package org.example.servlets;

import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
@WebFilter(value = "/time")
public class  TimezoneValidateFilter extends HttpFilter {

}
