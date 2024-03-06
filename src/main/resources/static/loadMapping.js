const sendButton = document.getElementById("send-tranform-button");
const clearButton = document.getElementById("clear-tranform-button");
const goToButton = document.getElementById("goTo-button")
const closeButton = document.getElementById("close-mapping-button");

clearButton.addEventListener("click", ()=>
    document.getElementById('transform-text').value = ''
);

closeButton.addEventListener("click", () =>
    document.getElementById("response").classList.add("hide")
);

goToButton.addEventListener("click", () =>{
        console.log('goTo click');
    }
);

sendButton.addEventListener("click", () =>{
    let data = getData();
    if(!validateData(data)){
        console.log(data)
    }
    document.getElementById("response").classList.remove("hide")
    }
);

function getData(){
    return document.getElementById('transform-text').value;
}

function validateData(data){
    if(data.length <100 ) return false
}
