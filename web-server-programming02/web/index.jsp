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
                <li role="presentation"><a href="Shopping_Cart">Shopping Cart</a></li>
            </ul>
            <div class="jumbotron text-center">
                <h1>Tyrel Tachibana</h1>
                <p>p2TyrelT</p>
                <h2 class="text-center">Welcome to Tachibana Electric Company! <br/> Number one local reseller electric components!</h2>
            </div>
        </div>
        <div id="body" class="container">
            <h2 class="text-center">Web Server Programming</h2><br/>
            <form method="post" action="ShoppingCart">
                <div class="row form-group">
                    <img class="col-md-2 img-circle" height="150" width="150" src="image/Laptop-icon.png" alt="Tachibana Logo"/>
                    <label>Laptop - 399.99$</label><br/>
                    <textarea cols="100" readonly>17" tri-directional screen, 2-core/4-ton processor, mega RAM, sooped up graphics!</textarea><br/>
                    <input name="item1" type="submit" value="Add to Cart" class="btn btn-default"/>
                </div>
            </form>
            <form method="post" action="ShoppingCart">
                <div class="row form-group">
                    <img class="col-md-2 img-circle" height="150" width="150" src="image/980638223.jpg" alt="Tachibana Logo"/>
                    <label>Generic PC - 399.99$</label><br/>
                    <textarea cols="100" readonly>Not your grandmothers PC, this is a genuine original generic PC! With all the fix'ins.</textarea><br/>
                    <input name="item2" type="submit" value="Add to Cart" class="btn btn-default"/>
                </div>
            </form>
            <form method="post" action="ShoppingCart">
                <div class="row form-group">
                    <img class="col-md-2 img-circle" height="150" width="150" src="image/HP-TV-icon.png" alt="Tachibana Logo"/>
                    <label>Big Television - 499.99$</label><br/>
                    <textarea cols="100" readonly>This TV is a full on boatload in size, so you can watch all your programs!</textarea><br/>
                    <input name="item3" type="submit" value="Add to Cart" class="btn btn-default"/>
                </div>
            </form>
            <form method="post" action="ShoppingCart">
                <div class="row form-group">
                    <img class="col-md-2 img-circle" height="150" width="150" src="image/2073251107_1d68d60707.jpg" alt="Tachibana Logo"/>
                    <label>Downward facing dog Tablet - 499.99$</label><br/>
                    <textarea cols="100" readonly>Most laptops are doing yoga today, with all their positions! But do not discount our downward facing dog tablet!</textarea><br/>
                    <input name="item4" type="submit" value="Add to Cart" class="btn btn-default"/>
                </div>
            </form>
            <form method="post" action="ShoppingCart">
                <div class="row form-group">
                    <img class="col-md-2 img-circle" height="150" width="150" src="image/3624060-smartphone-applications-icons.jpg" alt="Tachibana Logo"/>
                    <label>Oh so smart phone - 499.99$</label><br/>
                    <textarea cols="100" readonly>This phone is not just a smart phone, it is a OH SO SMART PHONE!</textarea><br/>
                    <input name="item5" type="submit" value="Add to Cart" class="btn btn-default"/>
                </div>
            </form>
            <br />
            <form method="post" action="ShoppingCart">
                <div class="text-center">
                    <input type="submit" value="See Cart" class="btn btn-default"/>
                </div>
            </form>
            <br />
        </div>
        <div id="Footer" class="container">
            <p class="text-center">
                <a href="http://www.tachibanasoftware.com/">Tachibana Software</a>
            </p>
        </div>
    </body>
</html>
