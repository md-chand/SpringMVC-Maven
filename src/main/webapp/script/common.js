function testJQuery() {
	alert($('#tempId').val());
}

function getStates() 
{
	var value = $("#country").val();
	$.ajax({
		url : "/springmvc/services/auth/getStates?country="+ value,
		type : "GET",
		success : function(response) {
			jQuery("#states").html(response);
		},
		failure : function(response) {
			alert(response.responseText);
		},
		error : function(response) {
			alert(response.responseText);
		}
	});
}

function getReportAttributes()
{
	var category = $('input:radio[name=category]:checked').val();
	$.ajax({
		url : "/springmvc/services/auth/getReportAttributes?category="+ category,
		type : "GET",
		success : function(response) {
			jQuery("#report_attribute").html(response);
		},
		failure : function(response) {
			alert(response.responseText);
		},
		error : function(response) {
			alert(response.responseText);
		}
	});
}

function selectAllStates() 
{
	if ($("#selectAll").prop('checked') == true) 
	{
		$('#country_state option').prop('selected', true);
	} 
	else 
	{
		$('#country_state option').prop('selected', false);
	}
}