 async function getHelp() {
 var cityID = document.getElementById('city').value;
fetch('http://localhost:8080/localhelp/' + cityID)
  .then((response) => response.json())
  .then((info) => {
  console.log(info);
    document.getElementById('supportName').innerHTML = info[0].supportName;
      document.getElementById('supportInfo').innerHTML =  info[0].description;
     })
     .catch(err => console.log(err));
     };

/*let selects = document.querySelectorAll(".options select");
let requestURL = "http://localhost:8080/LocalHelp/latest?cityID=Birmingham,Cornwall,Derby,Edinburgh,Leeds,Leicester,Liverpool,Manchester,Newcastle,Portsmouth"
async function fetchHelp(){
let res = await fetch(requestURL);
res = await res.json();
city = res.city;
populateOptions();
};

function populateOptions(){
let val = "";
Object.keys(city).forEach(code => {
let str = `<option value="${code}">${code}</option>`;
val += str;
});
selects.forEach((s) => (s.innerHTML = val));
};*/
