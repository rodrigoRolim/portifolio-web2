package br.edu.utfpr.web2.servlet;

import br.edu.utfpr.web2.controller.UsersController;
import br.edu.utfpr.web2.model.User;
import br.edu.utfpr.web2.util.Util;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/Register"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher rd;
        rd = req.getRequestDispatcher("views/register.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String nome = req.getParameter("name");
        String email = req.getParameter("email");
        String pwd = req.getParameter("password");
        String pwdConfirm = req.getParameter("confirm-password");

        UsersController userController = new UsersController();
        Cookie erro = null;

        if (pwd.equals(pwdConfirm)) {
            if (!Util.isEmail(email)) {
                erro = new Cookie("mensagem", "Email invalido");
                resp.addCookie(erro);
            } else {
                User user = new User(nome, pwd, email);
                userController.store(user);
                userController.auth(email, pwd);
                Cookie mensagem = new Cookie("mensagem", "Login realizado com sucesso");
                resp.addCookie(mensagem);
            }
        } else {
            erro = new Cookie("mensagem", "As senhas informadas sao diferentes");
            resp.addCookie(erro);
        }
        if (erro == null) {
            resp.sendRedirect("/Register");
        } else {
            resp.sendRedirect("/Albums");
        }
    }

}
