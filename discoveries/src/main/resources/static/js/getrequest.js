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
	val = val.trim();
	var added = document.createElement('option');
	var select = $(listname);
    added.value = discoverer.id;
    added.innerHTML = txt;
    select.append(added);
	});
}

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

$( document ).ready(function() {
	var url = window.location;

	//fill discoverers list when discoverers page loaded 
	default_get();
	
	$("#BtnEditDiscoverer").click(function (event) {
			var id = $("#DiscoverersList option:selected").attr('value');
			$.ajax({
	            type: "GET",
	            url: url + '/getdiscoverer',
	            data: {"id" : id},
	            success: function (data) {
	            	var str = JSON.stringify(data);
	            	var obj = JSON.parse(str);
	            	
	            	for (var key in obj)	{
	            	    var val = obj[key];
	            	    alert(val);
	            	    }
	            	
	            	$('#id1').val(obj.id);
	            	$('#firstname1').val(obj.firstname);
	            	$('#FrmModalEditDiscoverer').modal('show');
	            }
	        });
	    });
	
})