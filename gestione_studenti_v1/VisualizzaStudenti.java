package com.example.test4;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;

@WebServlet(name = "VisualizzaStudenti", value = "/visualizza-studenti")
public class VisualizzaStudenti extends HttpServlet {
    private String message;

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;

            try {
                // Ottieni il DataSource
                MysqlDataSource dataSource = DatabaseConnection2.getDataSource();

                // Crea una connessione
                connection = dataSource.getConnection();

                // Crea una query
                String query = "SELECT * FROM studente";
                statement = connection.prepareStatement(query);

                // Esegui la query
                resultSet = statement.executeQuery();

                // Elabora i risultati
                // Crea il codice HTML
                StringBuilder html = new StringBuilder();
                html.append("<html>");
                html.append("<head>");
                html.append("<title>Utenti</title>");
                html.append("</head>");
                html.append("<body>");
                html.append("<h1>Lista studenti</h1>");
                html.append("<table border='1'>");
                html.append("<tr>");
                html.append("<th>ID</th>");
                html.append("<th>Nome</th>");
                html.append("<th>Cognome</th>");
                html.append("</tr>");
                while (resultSet.next()) {
                    int id = resultSet.getInt("studente_id");
                    String nome = resultSet.getString("nome");
                    String cognome = resultSet.getString("cognome");
                    html.append("<td>").append(id).append("</td>");
                    html.append("<td>").append(nome).append("</td>");
                    html.append("<td>").append(cognome).append("</td>");
                    html.append("</tr>");
                }
                html.append("</table>");
                html.append("</body>");
                html.append("</html>");

                // Invia la risposta HTML
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println(html.toString());

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Chiudi le risorse
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }

}