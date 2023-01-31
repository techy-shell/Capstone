function getAllUsers() {
//var newColor = document.getElementById('choice').value;
 fetch('http://localhost:8080/User')
 .then(response => response.json)
 .then(response => populate(response));
//  const elem = document.getElementById('no1');
//  elem.style.color = newColor;
}
function populate(response) {
document.getElementById("no1").innerHTML = response;
}

//var likes = document.getElementById("like2").value;
//var liked = false;
//button = document.getElementById("LikeButton");
//
//function show() {
//    button.innerHTML = likes + "like2";
//}
//
//button.onclick = function() {
//    if (liked == false) {
//        liked = true;
//        likes++;
//        show();
//    } else {
//        liked = false;
//        likes--;
//        show();
//    }
//};