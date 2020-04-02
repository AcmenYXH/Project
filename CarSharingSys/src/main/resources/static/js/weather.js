$.post("weather", function(data) {
		console.log(data);
		/*data=JSON.parse(data);*/
		$("#weather").html(data.weather);
		$("#uv_index").html(data.uv_index);
		$("#travel_index").html(data.travel_index);
});