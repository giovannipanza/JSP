<%--
  Created by IntelliJ IDEA.
  User: giovannipanza
  Date: 15/03/24
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inserisci studente</title>
</head>
<body>
<h1>Inserisci studente</h1>
<form action="./registra-studente" method="post">
    <label>Matricola</label>
    <input type="text" name="studente_id" required>
    <br>
    <label>Nome</label>
    <input type="text" name="nome" required>
    <br>
    <label>Cognome</label>
    <input type="text" name="cognome" required>
    <br>
    <label>Data di nascita</label>
    <input type="date" name="data_di_nascita" required>
    <br>
    <label>Email</label>
    <input type="email" name="email" required>
    <br>
    <label>Corso di studi</label>
    <input type="text" name="corso_di_studi" required>

    <input type="submit" value="Inserisci">

</body>
</html>
