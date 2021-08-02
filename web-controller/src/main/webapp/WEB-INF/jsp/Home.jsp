<!DOCTYPE html> 
<html lang="en"> 
  
<head> 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="style/home-style.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <title>Home</title>
</head>
<body style="background-image: url('images/bg-01.jpg'); ">
    <nav class="navbar navbar-dark nav_bg">
        <a class="navbar-brand" href="#">
        <img src="images/icons/logo.png" width="30" height="30" class="d-inline-block align-top" alt="">
         Portfolio Manager</a>
        <form action="/logout" method="GET"><button type="button float-right" class="login100-form-btn">Logout</button></form>
      </nav>
    <br>
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <div class="card card-body text-center">
                    <img class="card-img-top img-fluid" src="https://www.thestreet.com/.image/t_share/MTY5NDYzMzA2MzI1NTk5NzA3/stock-vs-shares.png" style="width:600x;height:300px;" alt="Card image cap">
                    <div class="card-block">
                        <h4 class="card-title pt-2">Calculate Portfolio</h4>
                        <p class="card-text">Click to view my portfolio</p>
                        <form action="/viewNetworth" method="GET"><button type="submit" value="submit" class="btn btn-outline-primary btn_1">Calculate Portfolio</button></form>
                        <p></p>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="card card-body text-center">
                    <img class="card-img-top img-fluid" src="https://g.foolcdn.com/image/?url=https%3A%2F%2Fg.foolcdn.com%2Feditorial%2Fimages%2F606349%2Finvestor-pressing-sell-button-getty.jpg&w=700&op=resize" style="width:600x;height:300px;" alt="Card image cap">
                    <div class="card-block">
                        <h4 class="card-title pt-2">Sell </h4>
                        <p class="card-text">Click to sell a stock</p>
                        <form action="/sellAssets" method="GET"><button type="submit" name="submit" class="btn btn-outline-primary btn_1">Sell Stock</button></form>
                        <p></p>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body> 
</html> 

