<%@ page import="com.example.gestionedatabase_5u_v1.DatabaseConnection" %><%--
  Created by IntelliJ IDEA.
  User: giovannipanza
  Date: 22/03/24
  Time: 11:41
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.example.gestionedatabase_5u_v1.DatabaseConnection" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Visualizzazione dati manutenzione</title>
</head>
<body>
<h1>Visualizzazione dati manutenzione</h1>

<%
    // Connessione al database
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DatabaseConnection.initializeDatabase();

    // Query per recuperare i dati
    Statement stmt = con.createStatement();
    String query = "SELECT * FROM manutenzione";
    ResultSet rs = stmt.executeQuery(query);
%>

<table border="1">
    <tr>
        <th>Data Intervento</th>
        <th>Descrizione</th>
        <th>Tecnico</th>
    </tr>

    <% while (rs.next()) { %>
    <tr>
        <td><%= rs.getDate("data_intervento") %></td>
        <td><%= rs.getString("descrizione") %></td>
        <td><%= rs.getString("tecnico") %></td>
    </tr>
    <% } %>
</table>

<%
    // Chiusura di connessione e statement
    rs.close();
    stmt.close();
    con.close();
%>
</body>
</html>
