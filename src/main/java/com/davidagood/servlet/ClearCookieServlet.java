package com.davidagood.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.davidagood.servlet.RequestAuthServlet.COOKIE_SIMPLE_ACCESS_TOKEN;

@WebServlet(name = "clearCookie", urlPatterns = "/clearCookie")
public class ClearCookieServlet extends HttpServlet {

    private static void deleteCookie(String name, HttpServletResponse response) {
        Cookie cookie = new Cookie(name, "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        deleteCookie(COOKIE_SIMPLE_ACCESS_TOKEN, resp);
        resp.sendRedirect("app");
    }
}
