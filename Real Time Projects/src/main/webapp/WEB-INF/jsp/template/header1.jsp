
<div class="row">
<div class="col-sm-2">
  <img src="<c:url value='/images/images-doctors.jpg'/> " class="img-rounded" alt="Cinque Terre" width="100" height="100"> 
   <h4>Rounded Corners</h4>
  <p>The .img-rounded class adds rounded corners to an image (not available in IE8):</p>     
  </div>
</div>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav margin-left-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">Page 1</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 2
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Page 2-1</a></li>
            <li><a href="#">Page 2-2</a></li>
            <li><a href="#">Page 2-3</a></li> 
          </ul>
        </li>
        <li><a href="#">Page 3</a></li> 
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-logout"></span> Logout</a></li>
        <!-- <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li> -->
      </ul>
    </div>
  </div>
</nav>
<script>
$(document).ready(function(){
	//alert("readyyyyyyyyyy");
	$(".dropdown-toggle").click(function(){
		$(".dropdown-menu").toggle();
	})
	
	$(".navbar-header").click(function(){
		$("#myNavbar").toggle();
	});
	
});
</script>

