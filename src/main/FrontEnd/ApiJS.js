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

const handleIncrement1 = () => {
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

const handleIncrement2 = () => {
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

  const handleIncrement3 = () => {
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
//end


var discussion = document.getElementById('topic').value;


 async function getUserInfo() {
 var userID = document.getElementById('userID').value;
fetch('http://localhost:8080/User/' + userID)
  .then((response) => response.json())
  .then((data) => {
    document.getElementById('callback').innerHTML = data[0].firstName + " " + data[0].surname +
    ", you will receive a callback within the next two working days on 0" + data[0].tel + " to discuss " +
    discussion + ". You will receive an email confirmation for your callback at " + data[0].email + ".";
     })
     .catch(err => console.log(err));
     };
