// Get all users
var url  = "http://localhost:8081/controller//crud/agente";
var xhr  = new XMLHttpRequest()
xhr.open('GET', url, true)
xhr.onload = function () {
	var users = JSON.parse(xhr.responseText);
	if (xhr.readyState == 4 && xhr.status == "200") {
		console.table(users);
	} else {
		console.error(users);
	}
}
xhr.send(null);