package br.edu.utfpr.web2.servlet;


import br.edu.utfpr.web2.model.User;
import br.edu.utfpr.web2.persistency.UserPersistency;
import br.edu.utfpr.web2.util.Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Register", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    private Object pageContext;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        RequestDispatcher view =  req.getRequestDispatcher("/views/register.jsp");
        
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        try {
           System.out.println("entrei aqui");
            User user = new User(req.getParameter("name"), req.getParameter("password"));
            UserPersistency userPersistency = new UserPersistency();
            userPersistency.createUser(user);
            String images_path = req.getServletContext().getRealPath("/resource");
            req.getSession(true);
            //pageContext.setAttribute("url",images_path);
            resp.sendRedirect("albums");
            
        } catch (Exception ex) {
           //JOptionPane.showMessageDialog(null, "take error");
            ex.printStackTrace();
        }
        
    }

}
