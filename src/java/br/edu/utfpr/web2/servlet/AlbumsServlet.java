package br.edu.utfpr.web2.servlet;


import br.edu.utfpr.web2.model.Album;
import br.edu.utfpr.web2.model.Photo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "Albums", urlPatterns = {"/albums"})
public class AlbumsServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        req.getRequestDispatcher("/views/index.jsp").forward(req,resp);
    }
  
}
