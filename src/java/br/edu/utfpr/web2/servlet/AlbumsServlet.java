package br.edu.utfpr.web2.servlet;

import br.edu.utfpr.web2.controller.AlbumController;
import br.edu.utfpr.web2.controller.PhotoController;
import br.edu.utfpr.web2.model.Album;
import br.edu.utfpr.web2.model.Photo;
import com.sun.xml.ws.installer.UpdateSharedLoaderProp;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet(name = "AlbumsServlet", urlPatterns = {"/Albums"})
public class AlbumsServlet extends HttpServlet {

    private final String UPLOAD_DIRECTORY = "/home/a1713477/UPLOADS";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher reqdispatcher = req.getRequestDispatcher("views/albums/list.jsp");

        AlbumController albumController = new AlbumController();
        String q = req.getParameter("q");
        ArrayList<Album> albums = new ArrayList<>();
        if (q == null) {
            albums = albumController.search("");
        } else {
            albums = albumController.search(q);
        }

        req.setAttribute("albums", albums);

        reqdispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(req)) {
            try {

                Album album = new Album();

                AlbumController albumController = new AlbumController();
                PhotoController photoController = new PhotoController();

                album.setTitle(req.getParameter("title"));
                album.setDescription(req.getParameter("description"));
                albumController.store(album);
                int idAlbum = albumController.lastId();
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req);
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        String name = new File(item.getName()).getName();
                        String path = UPLOAD_DIRECTORY + File.separator + name;

                        if (item.getFieldName().equals("cover")) {
                            album.setCoverPath(name);
                        } else {
                            Photo p = new Photo();
                            p.setAlbumsId(idAlbum);
                            p.setPath(path);
                            p.setTitle(name);
                            photoController.store(p);
                        }
                        item.write(new File(path));
                    }
                }
                req.setAttribute("message", "Arquivos gravados com sucesso!");
            } catch (Exception e) {
                System.err.println("Erro no upload dos arquivos");
                req.setAttribute("message", "Erro no upload dos arquivos: " + e);
            }
        } else {
            req.setAttribute("message", "Não permitido!");
        }
        req.getRequestDispatcher("views/albums/list.jsp").forward(req, resp);
    }

}
