const incrementCount1 = document.getElementById("LikeButton1");
const incrementCount2 = document.getElementById("LikeButton2");
const incrementCount3 = document.getElementById("LikeButton3");

var isliked1 = false;
var isliked2 = false;
var isliked3 = false;

const totalCount1 = document.getElementById("like1");
const totalCount2 = document.getElementById("like2");
const totalCount3 = document.getElementById("like3");

var count1 = 986;
var count2 = 555;
var count3 = 343;

totalCount1.innerHTML = count1;
totalCount2.innerHTML = count2;
totalCount3.innerHTML = count3;

function handleIncrement1() {
	if(!isliked1) {
  count1++;
  totalCount1.innerHTML = count1;
  isliked1 =true;
   document.getElementById("arrow1").style.color = "#3ca668";
	}
else {
	count1--;
  totalCount1.innerHTML = count1;
  isliked1 = false;
  document.getElementById("arrow1").style.color = "grey";
}
};

function handleIncrement2() {
	if(!isliked2) {
      count2++;
      totalCount2.innerHTML = count2;
      isliked2 =true;
      document.getElementById("arrow2").style.color = "#3ca668";
    	}
    else {
    	count2--;
      totalCount2.innerHTML = count2;
      isliked2 = false;
      document.getElementById("arrow2").style.color = "grey";
    }
  };

  function handleIncrement3() {
	if(!isliked3) {
      count3++;
      totalCount3.innerHTML = count3;
      isliked3 =true;
      document.getElementById("arrow3").style.color = "#3ca668";
    	}
    else {
    	count3--;
      totalCount3.innerHTML = count3;
      isliked3 = false;
      document.getElementById("arrow3").style.color = "grey";
    }
  };
//end of like buttons

var isopen = false;
function openForm() {
if(!isopen) {
  document.getElementById("myForm").style.display = "block";
  document.getElementById("footer").style.height = "750px";
  isopen = true;
  }
  else{
   document.getElementById("myForm").style.display = "none";
    document.getElementById("footer").style.height = "200px";
    isopen = false;
  }}
// end of contact us

function selectOpt() {
         selEl = document.getElementById('topic');
         op = selEl.value;
         document.getElementById('selectedTopic').innerHTML = "Your chosen topic: " + op;
         }

 async function getUserInfo() {
 var userID = document.getElementById('userID').value;
fetch('http://localhost:8080/User/' + userID)
  .then((response) => response.json())
  .then((data) => {
    document.getElementById('callback').innerHTML = data[0].firstName + " " + data[0].surname +
    ", you will be contacted within the next two working days. You will receive an email confirmation of your request.";
     })
     .catch(err => console.log(err));
     };

     //number checker from jake

    function numbersOnly(idName) {
    var numbers = /^[0-9]+$/;
    var firstName = document.getElementById(idName).value;
    if(firstName.match(numbers)){
    console.log("good");
    } else {
    //alert("Numbers only");
    document.getElementById(idName).style.backgroundColor = "red";
    }
    }

    //on submit
    function validateForms(id){
    var numbers = /^[0-9]+$/;
    var firstName = document.getElementById(id).value;

    if(firstName.match(numbers)){
    document.console.log("good");
    } else {
    alert("UserID should be in number format");
    }
    }

/*
Code to add contact method to database
*/
function getRadio(type){
    document.getElementById("result").value = type;
    }
    function saveContactDetails() {
    var update = {
    'userID':document.getElementById("userID").value,
    'email':document.getElementById("email1").value,
    'tel':document.getElementById("tel").value,
    'topic':document.getElementById("topic").value,
    'contactRequest':document.getElementById("result").value
    };

    fetch ('http://localhost:8080/contact', {
    method: 'POST',
    headers: {
    'Content-Type':'application/json',
    },
    body: JSON.stringify(update)
    })
    .then(response => response.json())
    .then(response => console.log(JSON.stringify(response)));
    }
