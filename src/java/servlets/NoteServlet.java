package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author awarsyle
 */
public class NoteServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        String edit = request.getParameter("edit");
        request.setAttribute("edit",edit);
        edit = "yes";
        
        
        if (edit.equals("no")) {
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
        edit = "yes";
        }
        

        else if(edit.equals("yes")) {
        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                .forward(request, response);
       }
        return;
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        
        String edit = request.getParameter("edit");
        request.setAttribute("edit",edit);
        edit = "yes";
        if(edit.equals("yes")) {
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
       }
        return;
//        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
//                .forward(request, response);
//
//        return;
    }
}

