<!DOCTYPE html>
<html>
    <head>
	<title> Tyrel Tachibana </title>
	<link rel="shortcut icon" href="http://www.ttachibana.com/Image/Tachibana_Icon.png" />
        <link rel="icon" href="http://www.ttachibana.com/Image/Tachibana_Icon.png" />
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css" />
        <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
        <meta name="Description" content="I am a software developer, and this is my portfolio.">
        <meta name="Author" content="Tyrel tachibana" />
        <meta name="Keywords" content="Tachibana, Software, Code">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta charset="UTF-8">
    </head>
    <body>
        <div id="Header">
            <ul id="Navigation_Bar" class="nav nav-tabs">
                <li role="presentation" class="active"><a href="Home">Home</a></li>
            </ul>
            <div class="jumbotron text-center">
                <h1>Tyrel Tachibana</h1>
                <p>p1TyrelT</p>
            </div>
        </div>
        <div id="body" class="container">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><h1>Error</h1></h3>
                </div>
                <% if(session.getAttribute("Error") != null) { %>
                <div class="panel-body">
                    <%=session.getAttribute("Error")%>
                </div>
                <% } %>
            </div>
        </div>
        <div id="Footer" class="container">
            <p class="text-center">
                <a href="http://www.tachibanasoftware.com/">Tachibana Software</a>
            </p>
        </div>
    </body>
</html>