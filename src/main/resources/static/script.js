"use strict"

const listaButoane = document.querySelectorAll("#edit");
const listaP = document.querySelectorAll("#catalogEntry>p");
const listaInput = document.querySelectorAll("#catalogEntry>input");

//console.log(listaButoane);
//console.log(listaP);
//console.log(listaInput);

listaButoane.forEach((element, index) => element.addEventListener('click', (e) => {

    if (window.getComputedStyle(listaP[index*3], null).display === "block") {
        e.preventDefault();

        element.innerHTML = `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><!--! Font Awesome Pro 6.1.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2022 Fonticons, Inc. --><path d="M0 256C0 114.6 114.6 0 256 0C397.4 0 512 114.6 512 256C512 397.4 397.4 512 256 512C114.6 512 0 397.4 0 256zM371.8 211.8C382.7 200.9 382.7 183.1 371.8 172.2C360.9 161.3 343.1 161.3 332.2 172.2L224 280.4L179.8 236.2C168.9 225.3 151.1 225.3 140.2 236.2C129.3 247.1 129.3 264.9 140.2 275.8L204.2 339.8C215.1 350.7 232.9 350.7 243.8 339.8L371.8 211.8z"/></svg>`

        listaInput[index*3].value = listaP[index*3].firstChild.innerHTML;
        listaInput[index*3+1].value = listaP[index*3+1].innerHTML;
        listaInput[index*3+2].value = listaP[index*3+2].innerHTML;

        listaP[index*3].style.display = "none";
        listaP[index*3+1].style.display = "none";
        listaP[index*3+2].style.display = "none";

        listaInput[index*3].style.display = "block";
        listaInput[index*3+1].style.display = "block";
        listaInput[index*3+2].style.display = "block";
    }


}))