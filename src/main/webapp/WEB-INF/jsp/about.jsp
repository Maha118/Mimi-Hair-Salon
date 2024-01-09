<%@ page contentType="text/html; charset=UTF-8" language="java" %>
	<jsp:include page="./include/header.jsp"/>

<head>
<style>
.paddingTB60 {
	padding: 60px 0px 60px 0px;
}

.gray-bg {
	background: #F1F1F1 !important;
}

.about-title {

}

.about-title h1 {
	color: #535353;
	font-size: 45px;
	font-weight: 600;
}

.about-title span {
	color: #AF0808;
	font-size: 45px;
	font-weight: 700;
}

.about-title h3 {
	color: #535353;
	font-size: 23px;
	margin-bottom: 24px;
}

.about-title p {
	color: #7a7a7a;
	line-height: 1.8;
	margin: 0 0 15px;
}

.about-paddingB {
	padding-bottom: 12px;
}

.about-img {
	padding-left: 57px;
}

/* Social Icons */
.about-icons {
	margin: 48px 0px 48px 0px;
}

.about-icons i {
	margin-right: 10px;
	padding: 0px;
	font-size: 35px;
	color: #323232;
	box-shadow: 0 0 3px rgba(0, 0, 0, .2);
}

.about-icons li {
	margin: 0px;
	padding: 0;
	display: inline-block;
}

#social-fb:hover {
	color: #3B5998;
	transition: all .001s;
}

#social-tw:hover {
	color: #4099FF;
	transition: all .001s;
}

#social-gp:hover {
	color: #d34836;
	transition: all .001s;
}

#social-em:hover {
	color: #f39c12;
	transition: all .001s;
}
</style>
  <meta charset="utf-8">

<title>About Us</title>
</head>
<body>
	<div class="about-section paddingTB60 gray-bg">
		<div class="container">
			<div class="row">
				<div class="col-md-7 col-sm-6">
					<div class="about-title clearfix">
						<h1>
							<b><span class="">MIMI </span>Hair Salon</b>
						</h1>
						<h3>Welcome to our Salon
							!!</h3>
						<p class="about-paddingB"> Mimi Hair Salon has been serving customers for more than a decade. Our top priority is making sure our
                           clients have an amazing experience. We're dedicated to giving you the very best service.
                           Our hairstylists are always learning and improving their skills. They stay up-to-date with the newest trends
                           and techniques. This way, we can always offer you the latest and greatest in hairstyles. We believe in
                           ongoing training to provide you with the most stylish and up-to-date looks.
                           At Mimi Hair Salon, we want you to feel confident and happy with your hair. Our team is committed to
                           creating a welcoming and trendy environment for our clients. Come experience the difference at Mimi Hair
                           Salon, where style and service meet!
						<div class="about-icons"></div>
					</div>
				</div>
				<div class="col-md-5 col-sm-6">
					<div class="about-img">
						<img
							src="https://images.unsplash.com/photo-1512496015851-a90fb38ba796?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTd8fHNhbG9ufGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60"
							style="width: 550px; height: 500px;" alt="">
					</div>
				</div>
			</div>
		</div>
	</div>

<jsp:include page="./include/footer.jsp"/>