package br.edu.utfpr.web2.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlbumCreateServletpaesjoaopa", urlPatterns = {"/Albums/create"})
public class AlbumCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getSession().getAttribute("logado") != null) {
            resp.sendRedirect("/Auth");
        }
        RequestDispatcher rd = req.getRequestDispatcher("/views/albums/create.jsp");
        rd.include(req, resp);

    }

}
