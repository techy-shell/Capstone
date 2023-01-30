
function getInfo() {
  var userName = document.getElementById("userChoice").value;
  fetch('localhost:8080/Financial/' + userName)
    .then(response => response.json())
    .then(response => populatePageCustomer(response));
}

function populatePageCustomer(response) {

    document.getElementById("userName").innerHTML = response.userName;
    document.getElementById("salary").innerHTML = response.Financial.salary;
    document.getElementById("mortgage").innerHTML = response.Financial.mortgage;

}

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
