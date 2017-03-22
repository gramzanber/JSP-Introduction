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
                <li role="presentation"><a href="Home">Home</a></li>
                <li role="presentation" class="active"><a href="Shopping_Cart">Shopping Cart</a></li>
            </ul>
            <div class="jumbotron text-center">
                <h1>Tyrel Tachibana</h1>
                <p>p2TyrelT</p>
                <h2 class="text-center">Welcome to Tachibana Electric Company! <br/> Number one local reseller electric components!</h2>
            </div>
        </div>
        <div id="body" class="container">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><h1 class="text-center">Shopping Cart</h1></h3>
                </div>
                <% com.ttachibana.model.ShoppingCartModel cart = (com.ttachibana.model.ShoppingCartModel)session.getAttribute("Cart"); %>
                <% if(cart != null && !cart.cartEmpty()) { %>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-2">Item Name</div>
                            <div class="col-md-2">Base Price</div>
                            <div class="col-md-2">Amount</div>
                            <div class="col-md-2">Total</div>
                        </div>
                    </div>
                    <% for(int i = 0; i < cart.numberOfItems(); i = i + 1) { %>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-2"><%=cart.getItemName(i)%></div>
                                <div class="col-md-2"><%=cart.getItemBaseAmount(i)%></div>
                                <div class="col-md-2"><%=cart.getItemQauntity(i)%></div>
                                <div class="col-md-2"><%=cart.getItemTotal(i)%></div>
                            </div>
                        </div>
                    <% } %>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-2"></div>
                            <div class="col-md-2"></div>
                            <div class="col-md-2"></div>
                            <div class="col-md-2"><%=cart.getGrandTotal(1)%></div>
                        </div>
                        <br />
                        <a class="text-center col-md-12" href="Home">Browse</a>
                    </div>
                <% } else { %>
                    <div class="panel-body">
                        No items please shop more!<br />
                        <a href="Home">Browse</a>
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