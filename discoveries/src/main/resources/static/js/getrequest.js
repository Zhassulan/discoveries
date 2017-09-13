//Adding to special select list array of objects
function FillList(listname, list)	{
$.each(list.data, function(i, discoverer)	{
	var txt = '';
	var i = 0;
	for (var key in discoverer)	{
	    var val = discoverer[key];
	    if (i > 0)
	    	txt += ' ' + val;
	    i++;
	    }
	val = val.trim();
	var added = document.createElement('option');
	var select = $(listname);
    added.value = discoverer.id;
    added.innerHTML = txt;
    select.append(added);
	});
}

$( document ).ready(function() {
	
	var url = window.location;
	
	//fill discoverers list when discoverers page loaded 
	$.ajax({
		  url: '/discoverers.html',
		  success: function()	{
			  //alert('s');
			  $.get(url + "/getdiscoverers", function(data)	{
				  FillList("#DiscoverersList", data);
			  });
		  }
		});
	
	// GET REQUEST
	$("#getBtn").click(function(event){
		event.preventDefault();
		ajaxGet();
	});

	// DO GET
	function ajaxGet(){

		/*
		 $.ajax({
			type : "GET",
			url : url + "/getdiscoverers",
			success: function(result){
				if	(result.status == "Done")	{
					$.each(result.data, function(i, discoverer)
						{
						$('#getDiscoverersDiv.DiscoverersList').append('<option value="' + discoverer.id + '">' + discoverer.lastname + ' ' +  discoverer.firstname + ' ' + discoverer.middlename + '</option>')
						});
				}
			},
			error : function(e) {
				$("#getDiscoverersDiv").html("<strong>Error loading all discoverers</strong>");
			}
		});*/	
	}
})