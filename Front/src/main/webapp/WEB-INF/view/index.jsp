<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Index Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
	.bs-example{
    	margin: 20px;
    }
</style>
<%--<jsp:include page="showProduct.jsp" />  --%>
</head>
<body>
${ExistingMessage}
<div class="bs-example">
    <nav id="myNavbar" class="navbar navbar-inverse" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                
                
                <a class="navbar-brand" href="#">Electronics</a>
          		
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="#">HOME</a></li>
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">PROFILE<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="">show profile</a></li>
                    	</ul></li>
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">MESSAGES<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="viewcart">cart</a></li>
                            <li><a href="#">Drafts</a></li>
                            <li><a href="#">Sent Items</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Trash</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                    	<li><a href="#" data-toggle="dropdown" class="dropdown-toggle"><span class="glyphicon glyphicon-user"></span> Sign Up<b class="caret"></b></a>
                     
                        	<ul class="dropdown-menu">
                            	<li><a href="login">Login action</a></li>
                            	<li><a href="register">Registration action</a></li>
         
                        	</ul>
                    	</li>
                    </li>
                </ul>     
            </div><!-- /.navbar-collapse -->
        </div>
    </nav>
</div>
<!-- =================================-->
<div class="container">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="1" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="2" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="3" class="active"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img class="img-rounded" class="img-responsive center-block"
      src="C:\Users\user1\Desktop\elec\ele.jpg" style="width:100%" "height="50%">
    </div>
    <div class="item">
    <img class="img-rounded" class="img-responsive center-block"
      src="C:\Users\user1\Desktop\elec\ele1.png" style="width:100%" "height="50%">
    </div>

    <div class="item">
    <img class="img-rounded" class="img-responsive center-block"
      src="C:\Users\user1\Desktop\elec\ele2.jpg" style="width:100%" "height="20%">
    </div>
 
  </div>
  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>


<div class="container-fluid">


          
        <div class="row">
<c:forEach items="${ProductList}" var="product">     
            <div class="col-md-3 col-sm-4">
                <div class="thumbnail">
                <img src="/Front/myImage/imageDisplay?id=${product.id}" alt="" width="298" height="398" />
                <%-- <img src="<c:url value="/resources/assets/img/rv_1-gito-1.jpg"/>">
                    --%> <div class="caption">
                        <h3>${product.name}</h3>
                        <ul>
                         <p>${product.description}</p>
                        <li>Price: Rs.<Strong>${product.price}</Strong></li>
                       
     
                   <form:form action="addtoCart/${product.id}" method="POST">
                                <input type="submit" value="Add to Cart" class="btn btn-primary">
                                </form:form>
                                
                                </ul>
                            </div>
                        </div>
                    </div>
         
           </c:forEach>       
                </div>
                
         
        </div>
<br/><br/><br/><br/>
	<jsp:include page="footer.jsp"></jsp:include> 
</body>

</html> 
