/*
 Below function is to pull through financial information from DB using API in the Income box
*/

 async function getUsers() {
 var userID = document.getElementById('userName').value;
fetch('http://localhost:8080/Financial/' + userID)
  .then((response) => response.json())
  .then((data) => {
  console.log(data);
    document.getElementById('salaryInfo').innerHTML = "Your current monthly salary is £" + data[0].salary;
    document.getElementById('benefitsInfo').innerHTML = "Your current monthly benefits are £" +data[0].benefit;
     })
     .catch(err => console.log(err));
     };

/*
 Below function pushes updated info for income through to the Finances table in the DB using API
*/

function saveDetails() {
var update = {
'salary':document.getElementById("salary").value,
'userName':document.getElementById("userName").value,
'benefit':document.getElementById("benefits").value
};

fetch ('http://localhost:8080/update', {
method: 'POST',
headers: {
'Content-Type':'application/json',
},
body: JSON.stringify(update)
})
.then(response => response.json())
.then(response => console.log(JSON.stringify(response)));
}

/*
Below function is for expenditure calculation & pulls through API income data in the Expenditure Box
*/

function calcBudget() {

var mtg = document.getElementById("mortgage").value;
var ctax = document.getElementById("councilTax").value;
var gas = document.getElementById("gasElectricity").value;
var water = document.getElementById("water").value;
var food = document.getElementById("food").value;
var travel = document.getElementById("travel").value;

var mtg1 = parseInt(mtg);
var ctax1 = parseInt(ctax);
var gas1 = parseInt(gas);
var water1 = parseInt(water);
var food1 = parseInt(food);
var travel1 = parseInt(travel);

var total = getCalc(mtg1,ctax1,gas1,water1,food1,travel1);

var xValues = ["Mortgage/Rent", "Council Tax", "Energy", "Water", "Food", "Travel"];
var yValues = [mtg1, ctax1, gas1, water1, food1, travel1];
var barColors = [
  "#b91d47",
  "#00aba9",
  "#2b5797",
  "#e8c3b9",
  "#1e7145"
];

new Chart("myChart", {
  type: "doughnut",
  data: {
    labels: xValues,
    datasets: [{
      backgroundColor: barColors,
      data: yValues
    }]
  },
  options: {
    title: {
      display: true,
      text: "Monthly Expenditure"
    }
  }
});

function getCalc(m,c,g,w,f,t){
return (m+c+g+w+f+t)
}

var userID = document.getElementById('userName2').value;
var userID2 = document.getElementById('userID2').value;


fetch('http://localhost:8080/TotalIncome/' + userID)
  .then((response) => response.json())
  .then((data) => {
  document.getElementById("includeIncome").innerHTML = "User " + userID + " income - £" + data[0].totalIncome;
     })

fetch('http://localhost:8080/TotalIncome/' + userID2)
  .then((response) => response.json())
  .then((data) => {
  document.getElementById("includeIncome2").innerHTML = "User " + userID2 + " income - £" + data[0].totalIncome;
     })

fetch('http://localhost:8080/DualIncome/' + userID + '/' + userID2)
  .then(res => res.json())
  .then(data => {
    const remainingBalance = (data[0].dualIncome - total);
    const potSavings = ((remainingBalance/2) * 12);
    if (remainingBalance >= 0){
    document.getElementById("remainBal").innerHTML = "You will have £" + remainingBalance + " remaining at the end of the month";
    document.getElementById("savings").innerHTML = "If you saved 50% of your remaining balance each month, by the end of the year you would have £" + potSavings + " in your savings account.";
    document.getElementById("standingOrder").innerHTML = "If you have a savings account with us already, you can set up a monthly standing order to move funds from your current account into your savings account each month automatically.";
    document.getElementById("savingsAcc").innerHTML = "If you don’t have a bank account already, we offer our Everyday Savings Account which allows you to deposit and withdraw money at any time without any penalties. It offers 15% interest on balances below £1000.";
    document.getElementById("concern").innerHTML = "If you are concerned about how much is left of your income each month, consider having a review with one of our advisors to see if we can help decrease your monthly expenditure. Please complete the contact form below to book your appointment.";
    } else if (remainingBalance < 0){
    document.getElementById("remainBal").innerHTML = "You will have £" + remainingBalance + " remaining at the end of the month. You may want to consider one of the following lending options to help support you financially: ";
    document.getElementById("loan").innerHTML = "Loan - A loan may be suitable if you think borrowing a fixed amount over a fixed period of time would be the best support for you. Our loan interest rates start at 4% APR and minimum loan amount is £2000.";
    document.getElementById("overdraft").innerHTML = "Arranged overdraft - Our arranged overdraft allows you to go overdrawn up to an agreed limit, so it could help cover an unplanned expense.The interest rate on our arranged overdraft is 35% APR (variable) and a monthly fee of £5.";
    document.getElementById("creditCard").innerHTML = "Credit card - A credit card allows you to buy things up to an agreed limit and pay for them later. You could use it to make larger one off purchases and pay for them later, either in one go or in chunks. Our Standard Rate credit card interest is 18% APR.";
    document.getElementById("mortgageInfo").innerHTML = "Mortgage review - Consider having a review with one of our advisors. We could potentially save you money on your monthly mortgage payment, reduce your mortgage term or discuss the possibility to have a 3 month mortgage payment break.";
    document.getElementById("review").innerHTML = "You may benefit from having a financial review to go over your current out goings to see if we can help reduce them. To book an appointment please complete the below contact request.";
    } else {
    document.getElementById("remainBal").innerHTML = "Error";
    }
  })

  document.getElementById("totalExp").innerHTML = "Total Expenditure - £" + total;
}

/*
 Below function is for a callback option for the user to request a callback
*/

function selectOpt() {
         selEl = document.getElementById('topic');
         op = selEl.value;
         document.getElementById('selectedTopic').innerHTML = "Your chosen topic: " + op;
         }

   async function getCallback() {
   var userID = document.getElementById('userID3').value;
  fetch('http://localhost:8080/User/' + userID)
    .then((response) => response.json())
    .then((data) => {
      document.getElementById('callback').innerHTML = data[0].firstName + " " + data[0].surname +
      ", you will receive a callback within the next two working days on 0" + data[0].tel +
      ". You will receive an email confirmation for your callback at " + data[0].email + ".";
       })
       .catch(err => console.log(err));
       };


//on submit

    function validateForms(id){
    var numbers = /^[0-9]+$/;
    var firstName = document.getElementById(id).value;

    if(firstName.match(numbers)){
    document.console.log("good");
    } else {
    alert("Details should be in number format");
    }
    }
  function validateForms2(id,id2){
    var numbers = /^[0-9]+$/;
    var firstName = document.getElementById(id).value;
    var secondValue = document.getElementById(id2).value;
    if(firstName.match(numbers) && secondValue.match(numbers)){
    document.console.log("good");
    } else {
    alert("Details should be in number format");
    }
    }

     function validateForms7(id,id2,id3,id4,id5,id6,id7,id8){
        var numbers = /^[0-9]+$/;
        var firstName = document.getElementById(id).value;
        var secondValue = document.getElementById(id2).value;
        var thirdValue = document.getElementById(id3).value;
        var fourthValue = document.getElementById(id4).value;
        var fifthValue = document.getElementById(id5).value;
        var sixthValue = document.getElementById(id6).value;
        var seventhValue = document.getElementById(id7).value;
        var eighthValue = document.getElementById(id8).value;
        if(firstName.match(numbers) && secondValue.match(numbers) && thirdValue.match(numbers) && fourthValue.match(numbers)
        && fifthValue.match(numbers) && sixthValue.match(numbers) && seventhValue.match(numbers) && eighthValue.match(numbers)){
        document.console.log("good");
        } else {
        alert("Details should be in number format");
        }
        }
