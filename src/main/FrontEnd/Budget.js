/*
Below lines of code work to print User data to console
*/

/*shows as Object object x10 on webpage*/
 async function getUsers() {
fetch('http://localhost:8080/User')
  .then((response) => response.json())
  .then((data) => {
  document.getElementById('test').innerHTML = data;
  console.log(data);
  })};

/*shows as undefined on webpage*/
    async function getUsers2() {
      let res = await fetch('http://localhost:8080/User);
      res = await res.json();
      users = res.users;
      document.getElementById("test").innerHTML = users;
      console.log(users);
    }

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



