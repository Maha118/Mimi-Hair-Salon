<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./include/header.jsp"/>
<head>
 <style>
        .cont{
            width: 400px;
            position: relative;
            overflow: hidden;
        }
        .cont img{
            width: 100%;
            height: auto;
        }
        .cont:hover .t{
            top: 0;
        }
        .t{
            color: white;
            background-color: rgba(0,0,0,0.8);
            position: absolute;
            top: -100%;
            height: 100%;
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            transition: all 0.4s;
        }
    </style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="jumbotron">
  <div class="container text-center">
    <h1>Welcome to Mimi Hair Salon</h1>
    <p> We're a friendly hair salon that helps everyone - Women and kids - look and feel great.
    Our experienced stylists know all the latest styles and can give you the look you want.
    Whether you need a classic cut or something trendy, we've got it covered. We're here to make you feel fantastic from the moment you step in until you leave. Come visit us for a welcoming and stylish experience, where our skilled team is ready to make you look and feel your best!</p>
  </div>
</div>

<div class="container-fluid bg-3 text-center">
  <h4>Our Services</h4><br>
  <div class="row">
    <div class="col-sm-3">
      <p>Consulting</p>
      <img src="https://images.unsplash.com/photo-1600948836101-f9ffda59d250?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8c2Fsb258ZW58MHx8MHx8fDA%3D&auto=format&fit=crop&w=500&q=60" class="img-responsive" style="width:100%" alt="Image">
    </div>
    <div class="col-sm-3">
      <p>Hair Care</p>
      <img src="https://images.unsplash.com/photo-1580618672591-eb180b1a973f?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8c2Fsb258ZW58MHx8MHx8fDA%3D&auto=format&fit=crop&w=500&q=60" class="img-responsive" style="width:100%" alt="Image">
    </div>
    <div class="col-sm-3">
      <p>Make Up</p>
      <img src="https://images.unsplash.com/photo-1595944024804-733665a112db?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTV8fHNhbG9ufGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60" class="img-responsive" style="width:100%" alt="Image">
    </div>
    <div class="col-sm-3">
      <p>Hair Cut</p>
      <img src="https://plus.unsplash.com/premium_photo-1661542336139-d7c1fe9a2adf?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTN8fG1lbnMlMjBzYWxvbnxlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&w=500&q=60" class="img-responsive" style="width:100%" alt="Image">
    </div>
  </div>
</div><br>

<!-- <div class="container-fluid bg-3 text-center">
  <div class="row">
    <div class="col-sm-3">
      <p>Some text..</p>
      <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
    </div>
    <div class="col-sm-3">
      <p>Some text..</p>
      <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
    </div>
    <div class="col-sm-3">
      <p>Some text..</p>
      <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
    </div>
    <div class="col-sm-3">
      <p>Some text..</p>
      <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
    </div>
  </div>
</div><br><br></h3> -->


<jsp:include page="./include/footer.jsp"/>