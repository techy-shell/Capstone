const incrementCount1 = document.getElementById("LikeButton1");
const decrementCount1 = document.getElementById("decrement-count1");
const incrementCount2 = document.getElementById("LikeButton2");
const decrementCount2 = document.getElementById("decrement-count2");
const incrementCount3 = document.getElementById("LikeButton3");
const decrementCount3 = document.getElementById("decrement-count3");

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
  count1++;
  totalCount1.innerHTML = count1;
};

const handleDecrement1 = () => {
  count1--;
  totalCount1.innerHTML = count1;
};
const handleIncrement2 = () => {
	count2++;
	totalCount2.innerHTML = count2;
  };
  const handleDecrement2 = () => {
	count2--;
	totalCount2.innerHTML = count2;
  };
  const handleIncrement3 = () => {
	count3++;
	totalCount3.innerHTML = count3;
  };
  const handleDecrement3 = () => {
	count3--;
	totalCount3.innerHTML = count3;
  };
incrementCount1.addEventListener("click", handleIncrement1);
// decrementCount1.addEventListener("click", handleDecrement1);
incrementCount2.addEventListener("click", handleIncrement2);
// decrementCount2.addEventListener("click", handleDecrement2);
incrementCount3.addEventListener("click", handleIncrement3);
// decrementCount3.addEventListener("click", handleDecrement3);
//end


 async function getUserInfo() {
 var userID = document.getElementById('userID').value;
fetch('http://localhost:8080/User/' + userID)
  .then((response) => response.json())
  .then((data) => {
    document.getElementById('callback').innerHTML = data[0].firstName + " " + data[0].surname + ", you will receive a callback within the next two working days on 0" + data[0].tel + ". You will receive an email confirmation for your callback at " + data[0].email + ".";
     })
     .catch(err => console.log(err));
     };
