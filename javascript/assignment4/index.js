// document.cookie = 'name = rakesh; expires='+new Date(2023,0,2).toUTCString()
// document.cookie = 'lastname = miryala; expires='+new Date(2023,0,2).toUTCString()

document.cookie = "name=saicharan"


var localScore = 0
function localBtn(){
    localScore++;
    localStorage.setItem('localScore',localScore)
}

let sessionScore=0
function sessionBtn(){
    sessionScore++;
    sessionStorage.setItem('sessionScore',sessionScore);
}