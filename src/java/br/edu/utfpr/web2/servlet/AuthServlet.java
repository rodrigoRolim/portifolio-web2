package br.edu.utfpr.web2.servlet;

import br.edu.utfpr.web2.controller.UsersController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.edu.utfpr.web2.util.Util;

@WebServlet(name = "AuthServlet", urlPatterns = {"/Auth"})
public class AuthServlet extends HttpServlet {

    private final UsersController usersController = new UsersController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd;
        rd = req.getRequestDispatcher("views/login.jsp");
        Cookie[] cookies = req.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("error") && !cookies[i].getValue().equals("")) {
                req.setAttribute("hasError", cookies[i].getValue());
                cookies[i].setValue("");
                cookies[i].setMaxAge(0);
                resp.addCookie(cookies[i]);
            }
            if (cookies[i].getName().equals("errorEmail") && !cookies[i].getValue().equals("")) {
                req.setAttribute("hasErrorEmail", cookies[i].getValue());
                cookies[i].setValue("");
                cookies[i].setMaxAge(0);
                resp.addCookie(cookies[i]);
            }
        }
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Cookie error = null;
        Cookie errorEmail = null;
        
        if (Util.isEmail(email)) {
            if (usersController.auth(email, password)) {
                HttpSession session = req.getSession();
                session.setAttribute("usuarioLogado", usersController.findUserByCredentials(email, password));
                resp.sendRedirect("/Albums/create");
            } else {
                error = new Cookie("error", "Credenciais invalidas.");
            }
        } else {
            error = new Cookie("error", "Email invalido.");
            resp.addCookie(error);
        }
        errorEmail = new Cookie("errorEmail", email);
        if (error != null) {
            resp.addCookie(errorEmail);
            resp.addCookie(error);
        }
        resp.sendRedirect("/Auth");
    }
}
