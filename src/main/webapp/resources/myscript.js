$(document).ready(function() {
	$("#more-button").click(function() {
		$.getJSON("/rest2/ex999.json", function(data) {
			$.each(data, function(k, v) {
				$("#list").append("<li>" + v + "</li>");
			});
		});
	});
});