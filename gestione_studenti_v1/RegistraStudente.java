package com.example.test4;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(name = "RegistraStudente", value = "/registra-studente")
public class RegistraStudente extends HttpServlet {
    private String message;

    public void init() {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        {
            try {

                // Initialize the database
                Connection con = DatabaseConnection.initializeDatabase();

                // Create a SQL query to insert data into demo table
                // demo table consists of two columns, so two '?' is used
                PreparedStatement st = con
                        .prepareStatement("insert into studente values(?, ?,?,?,?,?)");

                // For the parameter get the data using request object
                st.setInt(1, Integer.valueOf(request.getParameter("studente_id")));

                // Same for second parameter
                st.setString(2, request.getParameter("nome"));
                // Same for third parameter
                st.setString(3, request.getParameter("cognome"));
                // Same for fourth parameter
                st.setString(4, request.getParameter("data_di_nascita"));
                // Same for fifth parameter
                st.setString(5, request.getParameter("email"));
                // Same for sixth parameter
                st.setString(6, request.getParameter("corso_di_studio"));


                // Execute the insert command using executeUpdate() to make changes in database
                st.executeUpdate();

                // Close all the connections
                st.close();
                con.close();

                // Get a writer pointer
                // to display the successful result
                PrintWriter out = response.getWriter();
                out.println("<html><body><b>Studente registrato nel DB con successo"
                        + "</b></body></html>");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void destroy() {
    }
}