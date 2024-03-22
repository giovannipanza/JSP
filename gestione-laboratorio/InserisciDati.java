package com.example.gestionedatabase_5u_v1;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

//annotazione per mappare la servlet
@WebServlet(name = "InserisciDati", value = "/inserisci-dati")

public class InserisciDati extends HttpServlet {
    private String message;
    Connection con = null;

    public void init() {
        message = "Sono la Servlet che andrà ad inserire dei dati nel database!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");

        //estrapolo i dati dal form presente nella pagina inserisci.jsp
        String data_intervento = request.getParameter("data_intervento");
        String descrizione = request.getParameter("descrizione");
        String tecnico = request.getParameter("tecnico");
        out.println("<h2>Data intervento: " + data_intervento + "</h2>");
        out.println("<h2>Descrizione: " + descrizione + "</h2>");
        out.println("<h2>Tecnico: " + tecnico + "</h2>");

        //inizio a interagire col DB
        try {
            con = DatabaseConnection.initializeDatabase();
            Statement st = con.createStatement();
            String sql= "INSERT INTO manutenzione(data_intervento, descrizione, tecnico) VALUES ('" + data_intervento + "', '" + descrizione + "', '" + tecnico + "')";
            st.executeUpdate(sql);
            out.println("<h2>Record inserito con successo!</h2>");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h2>Errore nell'inserimento del record!</h2>");
        }

        out.println("</body></html>");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    public void destroy() {
    }
}
