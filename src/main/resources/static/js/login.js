const form =document.querySelector('form');
form.addEventListener('submit',e => {
    e.preventDefault();
    const userId = document.getElementById('userId').value;
    const userPassword = document.getElementById('userPassword').value;
    console.log(userId,userPassword);


})