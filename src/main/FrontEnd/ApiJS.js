var likes = document.getElementById("like2").value;
var liked = false;
button = document.getElementById("LikeButton");

function show() {
    button.innerHTML = likes + "like2";
}

button.onclick = function() {
    if (liked == false) {
        liked = true;
        likes++;
        show();
    } else {
        liked = false;
        likes--;
        show();
    }
};