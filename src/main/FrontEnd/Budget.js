/*
Below lines of code work to print User data to console
*/

/*shows as Object object x10 on webpage*/
 async function getUsers() {
fetch('http://localhost:8080/User/100001')
  .then((response) => response.json())
  .then((data) => {
  console.log(data);
  document.getElementById('test').innerHTML = JSON.stringify(data);
    alert("Hello " + data[0].firstName + " " + data[0].surname)
     })
     .catch(err => console.log(err));
     };

/*shows as undefined on webpage*/
/*
    async function getUsers2() {
      let res = await fetch('http://localhost:8080/User);
      res = await res.json();
      users = res.users;
      document.getElementById("test").innerHTML = users;
      console.log(users);

    }
*/

  /*
  var userName = document.getElementById("userChoice").value;
  fetch('localhost:8080/Financial/' + userName)
    .then(response => response.json())
    .then(response => populatePageCustomer(response));
}

function populatePageCustomer(response) {

    document.getElementById("userName").innerHTML = response.userName;
    document.getElementById("salary").innerHTML = response.salary;
    document.getElementById("mortgage").innerHTML = response.mortgage;

}
*/

/*
const url = 'http://localhost8080/Financial';

async function getInfo() {
const response = await fetch(url);
const data = await response.json();
const {salary, mortgage} = data;

document.getElementById('sal').textContent = salary.toFixed(2);
document.getElementById('mor').textContent = mortgage.toFixed(2);
}
*/

function saveDetails() {
var update = {
'Salary':document.getElementById("salary").value,
'userName':document.getElementById("userName").value
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

