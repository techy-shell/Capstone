/*
function getInfo() {
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


getText("localhost:8080/Financial");

async function getText(url) {
  let myObject = await fetch(url);
  let myText = await myObject.text();
  document.getElementById("demo").innerHTML = myText;
}
