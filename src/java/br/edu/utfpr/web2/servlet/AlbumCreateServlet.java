package br.edu.utfpr.web2.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(
        name = "AlbumsCreate", 
        urlPatterns = {"/albums/create"})
@MultipartConfig(fileSizeThreshold=1024*1024*2,
                 maxFileSize=1024*1024*10,
                 maxRequestSize=1024*1024*50)
public class AlbumCreateServlet extends HttpServlet {
    private static int id = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getSession()!= null) {
           RequestDispatcher rd = req.getRequestDispatcher("/views/albums/create.jsp");
           rd.forward(req, resp);
        }
    
       
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        System.out.println("entrou em create album");
          Part part = req.getPart("photos");
        String images_path = req.getServletContext().getRealPath("/resource");
        System.out.println(images_path);
        InputStream in = part.getInputStream();
        if (part.getContentType().equals("image/png")) {
            Files.copy(in, Paths.get(images_path + "/" + "image"+this.id++ + ".png"), StandardCopyOption.REPLACE_EXISTING);
        }
        System.out.println(Paths.get(images_path + "/" + "image"+this.id++ + ".png"));
        part.delete();
        resp.sendRedirect("/portifolio-web2/albums/create");
    }

}
