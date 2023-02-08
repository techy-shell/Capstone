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