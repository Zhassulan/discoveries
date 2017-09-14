//Adding to special select list array of objects
function FillList(listname, list)	{
$.each(list.data, function(i, discoverer)	{
	var txt = '';
	var b = false;
	for (var key in discoverer)	{
	    var val = discoverer[key];
	    if (b == true)
	    	txt += ' ' + val;
	    if (b == false) b = true;
	    }
	var added = document.createElement('option');
	var select = $(listname);
    added.value = discoverer.id;
    added.innerHTML = txt;
    select.append(added);
	});
}

//Fill discoverers list on discoverers page
function default_get()	{
$("#DiscoverersList").empty();
var url = window.location;
	$.ajax({
		  url: '/discoverers.html',
		  success: function()	{
			  $.get(url + "/getdiscoverers", function(data)	{
				  FillList("#DiscoverersList", data);
			  });
		  }
		});	
}

//Fill stars list on stars page
function default_get_stars()	{
	$("#StarsList").empty();
	var url = window.location;
		$.ajax({
			  url: '/',
			  success: function()	{
				  $.get(url + "/getstars", function(data)	{
					  FillList("#StarsList", data);
				  });
			  }
			});	
	}

//Override ready
$( document ).ready(function() {
	
	var url = window.location;
	//last part of url
	var url_lastpart = location.href.substr(location.href.lastIndexOf('/') + 1);
	//fill list of discoverers or stars, dependently to current page
	if (url_lastpart == 'discoverers.html') default_get(); else default_get_stars();
	
	//Fill and load edit discoverer form
	$("#BtnEditDiscoverer").click(function (event) {
			var id = $("#DiscoverersList option:selected").attr('value');
			$.ajax({
	            type: "GET",
	            url: url + '/getdiscoverer',
	            data: {"id" : id},
	            success: function (data) {
	            	var str = JSON.stringify(data);
	            	var obj = JSON.parse(str);
	            	  for(k in obj)
	                  	{
	            		if (k == 'data')
	            			{
	            			$('#id1').val(obj[k].id);
	            			$('#firstname1').val(obj[k].firstname);
	            			$('#lastname1').val(obj[k].lastname);
	            			$('#middlename1').val(obj[k].middlename);
	            			}
	                  	} 
	            	$('#FrmModalEditDiscoverer').modal('show');
	            }
	        });
	    });
	
})