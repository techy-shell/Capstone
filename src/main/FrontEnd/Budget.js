/*
 below function is to pull through financial information from DB using API
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
Below function is for expenditure calculation & pulls through API income data
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

function getCalc(m,c,g,w,f,t){
return (m+c+g+w+f+t)
}

var userID = document.getElementById('userName2').value;

fetch('http://localhost:8080/TotalIncome/' + userID)
  .then((response) => response.json())
  .then((data) => {
  document.getElementById("includeIncome").innerHTML = "Total income - £" + data[0].totalIncome;
     })

fetch('http://localhost:8080/TotalIncome/' + userID)
  .then(res => res.json())
  .then(data => {
    const remainingBalance = (data[0].totalIncome - total);
    const potSavings = ((remainingBalance/2) * 12);
    if (remainingBalance >= 0){
    document.getElementById("remainBal").innerHTML = "You will have £" + remainingBalance + " remaining at the end of the month";
    document.getElementById("savings").innerHTML = "If you saved 50% of your remaining balance each month, by the end of the year you would have £" + potSavings + " in your savings account.";
    document.getElementById("standingOrder").innerHTML = "If you have a savings account with us already, you can set up a monthly standing order to move funds from your current account into your savings account each month automatically. If you need help on how to set a standing order up, please watch our ‘How To’ video on setting up Standing Orders here.";
    document.getElementById("savingsAcc").innerHTML = "If you don’t have a bank account already, we offer our Everyday Savings Account which allows you to deposit and withdraw money at any time without any penalties. It offers 15% interest on balances below £1000, 10% on balances between £1000-£3000 and 5% on any balance above £3000. To open an Everyday Savings Account, click here.";
    document.getElementById("concern").innerHTML = "If you are concerned about how much is left of your income each month, consider having a review with one of our advisors to see if we can help decrease your monthly expenditure. Please complete the callback form below to book your appointment.";
    } else if (remainingBalance < 0){
    document.getElementById("remainBal").innerHTML = "You will have £" + remainingBalance + " remaining at the end of the month. You may want to consider one of the following lending options to help support you financially: ";
    document.getElementById("loan").innerHTML = "Loan - A loan may be suitable if you think borrowing a fixed amount over a fixed period of time would be the best support for you. It could be helpful as you’ll know how long it will take to repay the loan and how much you need to pay back each month or if you are looking to consolidate debt or have a large one-off purchase to make. Our loan interest rates start at 4% APR and minimum loan amount is £2000. If you think this may be the right option for you or if you want to know more, please click here.";
    document.getElementById("overdraft").innerHTML = "Arranged overdraft - Our arranged overdraft allows you to go overdrawn up to an agreed limit, so it could help cover an unplanned expense. Think of it as a short-term safety net for your current account if you think you may go over on your monthly budget by a small amount and can afford it to pay it back. The interest rate on our arranged overdraft is 35% APR (variable) and a monthly fee of £5. You would only pay interest and the monthly charge if you use it. If you think this is the right option for you, it only takes about 5 minutes to apply. To apply or find out more about over Arranged overdrafts, please click here.";
    document.getElementById("creditCard").innerHTML = "Credit card - A credit card allows you to buy things up to an agreed limit and pay for them later. You could use it to make larger one off purchases and pay for them later, either in one go or in chunks. You can use a credit card to consolidate other credit or store card balances. Our Standard Rate credit card interest is 18% APR. If you would like to learn more about our credit card or to apply for one, please click here.";
    document.getElementById("mortgageInfo").innerHTML = "Mortgage review - If you have not had a mortgage review in the last 12 months, please consider having a review with one of our advisors. We could potentially save you money on your monthly mortgage payment, reduce your mortgage term or discuss the possibility to have a 3 month mortgage payment break. If you think this could be beneficial option for you, please complete the callback form below to book your mortgage review.";
    document.getElementById("review").innerHTML = "You may benefit from having a financial review to go over your current out goings to see if we can help reduce them. To book an appointment please complete the below callback request.";
    } else {
    document.getElementById("remainBal").innerHTML = "Error";
    }
  })

  document.getElementById("result").innerHTML = "Mortgage - £" + mtg + ", Council Tax - £" + ctax +
  ", Gas and Electricity - £" + gas + ", Water - £" + water + ", Food - £" + food + " and Travel - £" + travel;
  document.getElementById("totalExp").innerHTML = "Total Expenditure - £" + total;
}

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
Positive remaining balance -
Negative remaining balance -
You may benefit from having a financial review to go over your current out goings to see if we can help reduce them. To book an appointment please complete the below callback request - *take same code from homepage & amend for financial review*
You may want to consider one of the following lending options to help support you financially:
*Undefined list options*
Arranged overdraft - Our arranged overdraft allows you to go overdrawn up to an agreed limit, so it could help cover an unplanned expense. Think of it as a short-term safety net for your current account if you think you may go over on your monthly budget by a small amount and can afford it to pay it back. The interest rate on our arranged overdraft is 35% APR (variable) and a monthly of £5. You would only pay interest and the monthly charge if you use it. If you think this is the right option for you, it only takes about 5 minutes to apply. To apply or find out more about over Arranged overdrafts, please click here.
Loan - A loan may be suitable if you think borrowing a fixed amount over a fixed period of time would be the best support for you. It could be helpful as you’ll know how long it will take to repay the loan and how much you need to pay back each month or if you are looking to consolidate debt or have a large one-off purchase to make. Our loan interest rates start at 4% APR and minimum loan amount is £2000. If you think this may be the right option for you or if you want to know more, please click here.
Credit card - A credit card allows you to buy things up to an agreed limit and pay for them later. You could use it to make larger one off purchases and pay for them later, either in one go or in chunks. You can use a credit card to consolidate other credit or store card balances. Our Standard Rate credit card interest is 18% APR. If you would like to learn more aboubt our credit card or to apply for one, please click here.
Mortgage review - If you have not had a mortgage review in the last 12 months, please consider having a review with one of our advisors. We could potentially save you money on your monthly mortgage payment, reduce your mortgage term or discuss the possibility to have a 3 month mortgage payment break. If you think this could be beneficial option for you, please complete the callback form below to book your mortgage review. - *take same code from homepage & amend for financial review*
*/
