
/*$("#FrmNewDiscoverer").submit(function(e) {
        e.preventDefault();
        
        $.ajax({
          type: 'POST',
          url:  url + '/postdiscoverer',
          data: $('#FrmNewDiscoverer').serialize(),
          success: function () {
				  alert('sended');
          }
        });
        
});*/
 
$( document ).ready(function() {
	
	var url = window.location;
	
	$("#BtnSaveNewDiscoverer").click(function (event) {
        event.preventDefault();
        
        //var form = $('#FrmNewDiscoverer')[0];
        //var data = new FormData(form);
        
        var discoverer = {
                firstname: $("#firstname").val(),
                lastname:$("#lastname").val(),
                middlename:$("#middlename").val()
            }
        
        //alert(data.firstname);
        $.ajax({
            type: "POST",
            url: url + '/postdiscoverer',
            processData: false,
            contentType: false,
            data: JSON.stringify(discoverer),
            dataType: 'json',
            success: function (data) {
                //alert('SUCCESS', data);
                resetData();
            },
            error: function (e) {
                console.log("ERROR : ", e);
            }
        });

    });
  
    /*
    
    function ajaxPost(){
    	
    	var formData = {
    		firstname : $("#firstname").val(),
    		lastname :  $("#lastname").val(),
    		middlename :  $("#lastname").val()
    	}
    	
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : url + "/postdiscoverer",
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(result) {
				if(result.status == "Done"){
					alert(result.data.firstname);
					//$("#postResultDiv").html("<strong>" + "Post Successfully! Discoverer's Info: FirstName = " 
						//	+ result.data.firstname + " ,LastName = " + result.data.lastname + "</strong>");
				}else{
					alert('Error post');
					//$("#postResultDiv").html("<strong>Error</strong>");
				}
				console.log(result);
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
    	
    	// Reset FormData after Posting
    	resetData();
 
    }
    */
    function resetData(){
    	$("#firstname").val("");
    	$("#lastname").val("");
    	$("#middlename").val("");
    }
})