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

 async function getUserInfo() {
 var userID = document.getElementById('userID').value;
fetch('http://localhost:8080/User/' + userID)
  .then((response) => response.json())
  .then((data) => {
  console.log(data);
    document.getElementById('callback').innerHTML = data[0].firstName + " " + data[0].surname + ", you will receive a callback within the next two working days on 0" + data[0].tel + ". You will receive an email confirmation for your callback at " + data[0].email + ".";
     })
     .catch(err => console.log(err));
     };