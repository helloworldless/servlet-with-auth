package com.davidagood.servlet;

import com.davidagood.model.AuthenticationResult;
import com.davidagood.service.AuthService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import static com.davidagood.servlet.RequestAuthServlet.COOKIE_SIMPLE_ACCESS_TOKEN;
import static java.util.Objects.nonNull;

@WebServlet(name = "app", urlPatterns = "/app")
public class AppServlet extends HttpServlet {

    private final AuthService authService = new AuthService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        PrintWriter writer = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        Cookie tokenCookie = Arrays.stream(cookies).filter(cookie -> cookie.getName().equals(COOKIE_SIMPLE_ACCESS_TOKEN)).findAny().orElse(null);

        if (nonNull(tokenCookie)) {
            AuthenticationResult authenticationResult = authService.checkAuthenticated(tokenCookie.getValue());
            if (authenticationResult.isSuccess()) {
                req.setAttribute("userName", authenticationResult.getAuthenticatedUser().getUserName());
                req.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(req, resp);
            } else {
                resp.setStatus(401);
                writer.println("Authorization error");
            }

        } else {
            resp.sendRedirect("auth");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("POSTed to app servlet");
    }
}
