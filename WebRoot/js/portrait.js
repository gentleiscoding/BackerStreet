// JavaScript Document
var click_times = 0;
var portrait_number = 1;
// var obj=document.getElementById("blo2");
function show_photos() {
	click_times = (click_times + 1) % 2;
	if (click_times == 1) {
		var obj = document.getElementById("photos");
		obj.style.display = 'inline-block';
	} else {
		var obj = document.getElementById("photos");
		obj.style.display = 'none';
	}
}
function change_portrait(portrait_number) {
	var obj = document.getElementById("portrait");
	if (portrait_number == 1) {
		obj.src = '../img/portrait/1.jpeg';
		$("#photonumber")
				.html(
						"<input type=\"hidden\" name=\"pnumber\"  id=\"pnumber\" value=1 />");
	}
	if (portrait_number == 2) {
		obj.src = '../img/portrait/2.jpeg';
		$("#photonumber")
				.html(
						"<input  type=\"hidden\" name=\"pnumber\"   id=\"pnumber\" value=2/>");
	}
	if (portrait_number == 3) {
		obj.src = '../img/portrait/3.jpeg';
		$("#photonumber")
				.html(
						"<input type=\"hidden\"  name=\"pnumber\"  id=\"pnumber\"  value=3 />");
	}
	if (portrait_number == 4) {
		obj.src = '../img/portrait/4.jpeg';
		$("#photonumber")
				.html(
						"<input type=\"hidden\"  name=\"pnumber\"  id=\"pnumber\"  value=4/>");
	}
	if (portrait_number == 5) {
		obj.src = '../img/portrait/5.jpeg';
		$("#photonumber")
				.html(
						"<input  type=\"hidden\" name=\"pnumber\"   id=\"pnumber\" value=5 />");
	}
	if (portrait_number == 6) {
		obj.src = '../img/portrait/6.jpeg';
		$("#photonumber")
				.html(
						"<input  type=\"hidden\" name=\"pnumber\"   id=\"pnumber\" value=6 />");
	}
	if (portrait_number == 7) {
		obj.src = '../img/portrait/7.jpeg';
		$("#photonumber")
				.html(
						"<input  type=\"hidden\" name=\"pnumber\"   id=\"pnumber\" value=7 />");
	}
	if (portrait_number == 8) {
		obj.src = '../img/portrait/8.jpeg';
		$("#photonumber")
				.html(
						"<input type=\"hidden\"  name=\"pnumber\"   id=\"pnumber\" value=8 />");
	}
	if (portrait_number == 9) {
		obj.src = '../img/portrait/9.jpeg';
		$("#photonumber")
				.html(
						"<input  type=\"hidden\" name=\"pnumber\"   id=\"pnumber\" value=9 />");
	}
	if (portrait_number == 10) {
		obj.src = '../img/portrait/10.jpeg';
		$("#photonumber")
				.html(
						"<input  type=\"hidden\" name=\"pnumber\"  id=\"pnumber\"  value=10 />");
	}
	if (portrait_number == 11) {
		obj.src = '../img/portrait/11.jpeg';
		$("#photonumber")
				.html(
						"<input  type=\"hidden\" name=\"pnumber\"  id=\"pnumber\"  value=11 />");
	}
	if (portrait_number == 12) {
		obj.src = '../img/portrait/12.jpeg';
		$("#photonumber")
				.html(
						"<input  type=\"hidden\" name=\"pnumber\"   id=\"pnumber\" value=12 />");
	}
	if (portrait_number == 13) {
		obj.src = '../img/portrait/13.jpeg';
		$("#photonumber")
				.html(
						"<input  type=\"hidden\" name=\"pnumber\"   id=\"pnumber\" value=13 />");
	}
	if (portrait_number == 14) {
		obj.src = '../img/portrait/14.jpeg';
		$("#photonumber")
				.html(
						"<input type=\"hidden\"  name=\"pnumber\"   id=\"pnumber\" value=14 />");
	}
	if (portrait_number == 15) {
		obj.src = '../img/portrait/15.jpeg';
		$("#photonumber")
				.html(
						"<input type=\"hidden\"  name=\"pnumber\"   id=\"pnumber\" value=15 />");
	}
	if (portrait_number == 16) {
		obj.src = '../img/portrait/16.jpeg';
		$("#photonumber")
				.html(
						"<input type=\"hidden\"  name=\"pnumber\"   id=\"pnumber\" value=16 />");
	}
}