package servlet;

import controller.UsersController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.Util;

@WebServlet(name = "AuthServlet", urlPatterns = {"/Auth"})
public class AuthServlet extends HttpServlet {

    private final UsersController usersController = new UsersController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd;
        rd = req.getRequestDispatcher("views/login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (Util.isEmail(email)) {
            if (usersController.auth(email, password)) {
                HttpSession session = req.getSession();
                session.setAttribute("usuarioLogado", usersController.findUserByCredentials(email, password));
                resp.sendRedirect("/Albums/create");
            } else {
                Cookie error = new Cookie("error", "Credenciais inválidas.");
            }
        } else {
            Cookie error = new Cookie("error", "Credenciais inválidas.");
            error.setMaxAge(1);
        }
        resp.sendRedirect("/Auth");
    }

}
