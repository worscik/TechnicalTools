const sendButton = document.getElementById("send-tranform-button");
const clearButton = document.getElementById("clear-tranform-button");
const goToButton = document.getElementById("goTo-button")
const closeButton = document.getElementById("close-mapping-button");

function init(){
   initButtons();
   initErrorClear()
}

function initButtons(){
    clearButton.addEventListener("click", () =>
        document.getElementById('transform-text').value = ''
    );

    closeButton.addEventListener("click", () =>
        document.getElementById("response").classList.add("hide")
    );

    goToButton.addEventListener("click", () => {
            console.log('goTo click');
        }
    );

    sendButton.addEventListener("click", () => {
            let data = getData();
            let valid = validateData(data);
            if (!valid.status) {
                addErrorMessage(document.getElementById('transform-text'), valid.message);
                return;
            }
            document.getElementById("response").classList.remove("hide")
        }
    );
}

init();

function getData(){
    return document.getElementById('transform-text').value;
}

function validateData(data){
    if(!data) return {status: false, message: 'The field cannot be empty'}
    if(data.length <100 ) return {status: false, message: 'Enter correct transform'}
    return {status: true, message: ''}
}

function addErrorMessage(inputNode, errorMessage) {
    if(!inputNode.classList.contains('error')){
        const parentNode = inputNode.parentNode;
        parentNode.classList.add("error");
        inputNode.classList.add("error");

        let errorElement = document.createElement("span");
        errorElement.textContent = errorMessage;
        errorElement.classList = "error";
        parentNode.appendChild(errorElement);
    }
}

function initErrorClear() {
    // textarea
    const textarea = document.getElementById("transform-text");
    textarea.addEventListener("keyup", () => {
            if (textarea.classList.contains("error")) {
                // usuwam klasę z inputa
                textarea.classList.remove("error");
                // usuwam klasę z rodzica
                textarea.parentNode.classList.remove("error");
                // usuwam span z tekstem
                textarea.parentNode.removeChild(
                    textarea.parentNode.querySelector("span.error")
                );
            }
        })

}