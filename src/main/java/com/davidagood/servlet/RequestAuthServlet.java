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

@WebServlet(name = "requestAuth", urlPatterns = "/requestAuth")
public class RequestAuthServlet extends HttpServlet {

    public static final String COOKIE_SIMPLE_ACCESS_TOKEN = "simple_access_token";

    private final AuthService authService = new AuthService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        AuthenticationResult authenticationResult = authService.authenticate(userName);

        if (authenticationResult.isSuccess()) {
            Cookie tokenCookie = new Cookie(COOKIE_SIMPLE_ACCESS_TOKEN, authenticationResult.getAuthenticatedUser().getToken());
            tokenCookie.setMaxAge(60);
            resp.addCookie(tokenCookie);
            resp.sendRedirect("app");
        } else {
            resp.setStatus(401);
            req.getRequestDispatcher("/WEB-INF/jsp/auth-failed.jsp").forward(req, resp);
        }

    }
}
