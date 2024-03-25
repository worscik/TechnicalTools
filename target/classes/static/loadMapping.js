const sendButton = document.getElementById("send-tranform-button");
const clearButton = document.getElementById("clear-tranform-button");
const goToButton = document.getElementById("goTo-button")
const closeButton = document.getElementById("close-mapping-button");

function init(){
    clearLocalStorage();
   initButtons();
   initErrorClear()
}

function initButtons(){
    document.querySelector('.close-btn').addEventListener('click', ()=>{
        window.location.href ='/';
    })

    clearButton.addEventListener("click", () =>
        document.getElementById('transform-text').value = ''
    );

    closeButton.addEventListener("click", () =>
        document.getElementById("response").classList.add("hide")
    );

    goToButton.addEventListener("click", () => {
            localStorage.setItem('redirect', true);
            window.location.href ='/newDasboard'
        }
    );

    sendButton.addEventListener("click", async () => {

            let data = getData();
            let valid = validateData(data);
            if (!valid.status) {
                addErrorMessage(document.getElementById('transform-text'), valid.message);
                return;
            }

        let loader = createLoader();
        const result = await fetchData(data);
        removeLoader(loader);
        if(result){
            createReponseElement(result);
            console.log(result)
            localStorage.setItem('mapping', JSON.stringify(result))
            document.getElementById("response").classList.remove("hide")
        }

        }
    );
}

init();

function clearLocalStorage(){
    localStorage.clear()
}

async function fetchData(data) {

    try {
        const response = await fetch("/readFromFile", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(data),
        });
        if (response.status === 200) {
            const responseText = await response.json();
            return responseText;
        } else {
            console.error(
                "Error: Unexpected response status:",
                response.status,
                response
            );
            return null
        }
    } catch (error) {
        console.error("Error:", error);
        return  null;
    }
}

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

function createLoader() {
    const loader = document.createElement("span");
    loader.classList.add("loader");
    document.body.append(loader);
    return loader;
}

function removeLoader(loader) {
    loader.remove();
}

function createReponseElement(data){
    let fieldsElements = document.querySelectorAll('.field')

    fieldsElements.forEach(el =>{
        let data_id = el.getAttribute('data-id');
        let value = data[data_id];
        // if(data_id === 'matchLine'){
        //     value = String(data[data_id]).split('|').map((item,index) => index != 0 ? item : '').join(' | ');
        //     console.log(value)
        // }

        if(value) el.textContent = value;
        else el.textContent = '';

    })

}

