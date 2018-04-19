package br.edu.utfpr.web2.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlbumCreateServlet", urlPatterns = {"/Albums/create"})
public class AlbumCreateServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        RequestDispatcher rd = req.getRequestDispatcher("/views/albums/create.jsp");
        rd.include(req, resp);
    }
    
}
