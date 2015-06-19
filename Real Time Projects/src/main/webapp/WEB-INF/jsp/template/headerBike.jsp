<nav class="navbar">
	<div class="container-fluid">
		<div class="navbar-header">
		<a class="navbar-brand" href="#">   
		<img src="<c:url value='/images/motorbiking_2.jpg' />" class="img-rounded img-default" alt="Cinque Terre" width="60" height="50"> </a>
		<a class="navbar-brand" href="#"> <span class="font-color-white">  Motor Cross </span></a>
		</div>
		<div>
			<ul class="nav navbar-nav">
				<li class="header-li-margin"> <a href="#">    <span class="font-color-white">Home </span></a></li>
				<li class="header-li-margin"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">  <span class="font-color-white"> Page 1 </span> <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Page 1-1</a></li>
						<li><a href="#">Page 1-2</a></li>
						<li><a href="#">Page 1-3</a></li>
					</ul></li>
				<li class="header-li-margin"><a href="#"> <span class="font-color-white">  Page 2</span></a></li>
				<li class="header-li-margin"><a href="#"> <span class="font-color-white"> Page 3</span> </a></li>
				<li class="header-li-margin"><a href="#"><span class="font-color-white">Page 4 </span></a></li>
				<li class="header-li-margin"><a href="#"><span class="font-color-white">Page 4 </span></a></li>
			</ul>
		</div>
	</div>
</nav>
<script>
$(document).ready(function(){
	//alert("ready");
	$(".dropdown-toggle").click(function(){
		$(".dropdown-menu").toggle();
	});
});
</script>