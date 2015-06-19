<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
<div class="form-group" >
<label for="username">Please enter user name
<input name="username" id="username"  />
</label>
</div>

</div>
<div class="container">
  <h2>Image Gallery</h2>  
  <p>The .thumbnail class can be used to display an image gallery. Click on the images to see it in full size:</p>            
  <div class="row">
    <div class="col-md-4">
      <a href="pulpitrock.jpg" class="thumbnail">
        <p>Pulpit Rock: A famous tourist attraction in Forsand, Ryfylke, Norway.</p>    
        <img src="<c:url value='/images/download.jpg'/> " alt="Pulpit Rock" style="width:150px;height:150px">
      </a>
    </div>
    <div class="col-md-4">
      <a href="moustiers-sainte-marie.jpg" class="thumbnail">
        <p>Moustiers-Sainte-Marie: Considered as one of the "most beautiful villages of France".</p>
        <img src="<c:url value='/images/download.jpg'/> " alt="Moustiers Sainte Marie" style="width:150px;height:150px">
      </a>
    </div>
    <div class="col-md-4">
      <a href="cinqueterre.jpg" class="thumbnail">
        <p>The Cinque Terre: A rugged portion of coast in the Liguria region of Italy.</p>      
        <img src="<c:url value='/images/download.jpg'/> " alt="Cinque Terre" style="width:150px;height:150px">
      </a>
    </div>
  </div>
  <div class="jumbotron"> Colton Point State Park is a 368-acre (149 ha) Pennsylvania state park in the United States. It is on the west side of Tioga County's Pine Creek Gorge, also known as the Grand Canyon of Pennsylvania, which is 800 feet (240 m) deep and nearly 4,000 feet (1,200 m) across at this location. The park, named for Henry Colton, a Williamsport lumberman who cut timber there starting in 1879, extends from the creek in the bottom of the gorge up to the rim and across part of the plateau to the west. Known for its views of the gorge, it offers opportunities for picnicking, hiking, fishing, hunting, whitewater boating, and camping. It was chosen by the Pennsylvania Department of Conservation and Natural Resources for its "Twenty Must-See Pennsylvania State Parks" list. Pine Creek has carved the gorge through five major rock formations from the Devonian and Carboniferous periods. A path along Pine Creek was first used by Native Americans, then lumbermen, and from 1883 to 1988 it was the route of a railroad. The gorge was named a National Natural Landmark in 1968. (  </div>
</div>

<script>
 
$("#username").autocomplete({ 
	source:'autoComplete?param='+$("#user").val(),     // provide the name of the PHP source file here
	minLength: 1,  
	minLength:3,
	 select: function(event, ui ) { 
		 // This select function will be called when we select a value  from the auto populated searchbox.
		// alert();
	} 
	});
  </script>