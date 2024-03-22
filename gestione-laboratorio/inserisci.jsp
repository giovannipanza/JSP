<%--
  Created by IntelliJ IDEA.
  User: giovannipanza
  Date: 22/03/24
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pagina di inserimento</title>
</head>
<body>
    <%= "<h1>Pagina di inserimento della manutenzione</h1>"%>

    <form action="inserisci-dati" method="post">
        <label for="data_intervento">Data intervento:</label>
        <input type="date" id="data_intervento" name="data_intervento" required>
        <br>
        <label for="descrizione">Descrizione:</label>
        <br>
        <textarea id="descrizione" name="descrizione" rows="5" cols="50" required></textarea>
        <br>
        <label for="tecnico">Tecnico:</label>
        <input type="text" id="tecnico" name="tecnico" required>
        <br>
        <br>
        <input type="submit" value="Inserisci">
    </form>
</body>
</html>
