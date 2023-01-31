function getAllUsers() {
//var newColor = document.getElementById('choice').value;
 fetch('localhost:8080/User')
 .then(response => response.json)
 .then(response => populate(response));
//  const elem = document.getElementById('no1');
//  elem.style.color = newColor;
}
function populate(response) {
document.getElementById("no1").innerHTML = response.firstName;
}

