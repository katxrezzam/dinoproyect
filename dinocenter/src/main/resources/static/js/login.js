const toggles = document.querySelectorAll(".toggle"), inputs = document.querySelectorAll(".input-password");

let i = 0;

for (const toggle of toggles){
    let input =  inputs[i];
    i = i + 1;
    toggle.addEventListener("click",()=>{
        if(input.type ==="password"){
            input.type = "text";
            toggle.classList.replace("bi-eye-slash-fill", "bi-eye-fill");
        }
        else{
            input.type = "password";
            toggle.classList.replace("bi-eye-fill","bi-eye-slash-fill");
        }
        })
}
const labelSignUp = document.querySelector(".signup-form label");
const labelLogin = document.querySelector(".login-form label");
const checkBox = document.querySelector("#flip");
const inputsSingup = document.querySelectorAll(".signup-form input");
const inputsLogin = document.querySelectorAll(".login-form input");



if(!checkBox.checked){
    for(let input of inputsSingup){
        input.removeAttribute('required')
    }
}

labelLogin.addEventListener('click',()=>{
    for(let input of inputsLogin){
        input.removeAttribute('required')
        input.value='';
    }
    for(let input of inputsSingup){
        input.setAttribute('required','')
    }
})

labelSignUp.addEventListener('click',()=>{
    for(let input of inputsSingup){
        input.value = '';
    }
    for(let input of inputsLogin){
        input.setAttribute('required','')
    }
})


