$( document ).ready(function() {
	
	var url = window.location;
	
	$("#BtnSaveNewDiscoverer").click(function (event) {
        event.preventDefault();
        
        var discoverer = {
                firstname: $("#firstname").val(),
                lastname:$("#lastname").val(),
                middlename:$("#middlename").val()
            }
        
        $.ajax({
            type: "POST",
            url: url + '/postdiscoverer',
            processData: false,
            //contentType: false,
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(discoverer),
            dataType: 'json',
            success: function (data) {
                default_get();
                resetData();
            }
        });
    });
  
	$("#BtnDelDiscoverer").click(function (event) {
		var id = $("#DiscoverersList option:selected").attr('value');
		$.ajax({
            type: "POST",
            url: url + '/deldiscoverer',
            data: {"id" : id},
            success: function (data) {
                default_get();
                resetData();
            }
        });
    });
	
	function resetData()	{
    	$("#firstname").val("");
    	$("#lastname").val("");
    	$("#middlename").val("");
    }

})