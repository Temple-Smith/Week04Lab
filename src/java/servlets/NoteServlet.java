package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        //declare variable of javabean Note class.
        Note vNote;
        //Following code is provided by instructor
        //find real path for note.txt in user's environment
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        //Research BufferedReader again...
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        //instantiate vnote variable
        vNote = new Note(br.readLine(), br.readLine());
        br.close();
        
        request.setAttribute("title", vNote.getTitle());
        request.setAttribute("contents", vNote.getContents());
        
       if(request.getParameter("edit") == null){
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
       }
       else {
        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                .forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //declare variable of javabean Note class.
        Note eNote;
        //Following code is provided by instructor
        //find real path for note.txt in user's environment
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        //Research BufferedReader again...
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        //instantiate vnote variable
        eNote = new Note(request.getParameter("title"), request.getParameter("contents"));
     
        
        pw.println(eNote.getTitle());
        pw.println(eNote.getContents());
        pw.close();
        
        request.setAttribute("title", eNote.getTitle());
        request.setAttribute("contents", eNote.getContents()); 
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
    }
}

