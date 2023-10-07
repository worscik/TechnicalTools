const backButton = document.getElementById("back-button");
const responseTextElement = document.getElementById("response-text");
let formData = {};
const structureList = ['rss/channel/item', 'root/item', 'products/product', 'feed/entry', 'offers/group/o'];



//Button listenery
const clearButton = document.getElementById('clear-button');
const submitButton = document.getElementById('submit-button');
const closeModalButton = document.getElementById('close-button');
const closeModalIcon = document.getElementById('close-icon');
const copyButton = document.getElementById('copy-button');

clearButton.addEventListener("click", () => {
    document.querySelectorAll('input').forEach(item => {
        item.type === 'text' ? item.value = '' : null;
        item.type === 'checkbox' ? item.checked = false : null;
    })
})

closeModalButton.addEventListener('click', () => {
    document.querySelector('.response-overlay').classList.add('hide');
})

closeModalIcon.addEventListener('click', () => {
    document.querySelector('.response-overlay').classList.add('hide');
})

document.addEventListener("keydown", (event) => {
    if (event.isComposing || event.key === 'Escape') {
        document.querySelector('.response-overlay').classList.add('hide');
    }
});

copyButton.addEventListener("click", () => {
    const tempTextArea = document.createElement("textarea");
    tempTextArea.value = document.getElementById('response-text').innerText;;
 
    document.body.appendChild(tempTextArea);
    tempTextArea.select();
    document.execCommand("copy");
    document.body.removeChild(tempTextArea);
})

submitButton.addEventListener("click", fetchData);

//usuwanie errora przy edycji inputa
document.querySelectorAll('input').forEach(item => {
    item.addEventListener('input', ()=>{
        item.classList.remove('error');
    })
        
})



//Utils
async function fetchData() {
    console.log('fetching data...');

    const formFields = getDataFromForm();
    // validacja
    if (!validDateFromForm(formFields)) return;


     try {
         const response = await fetch("/create", {
             method: "POST",
             headers: {
                 "Content-Type": "application/json"
             },
             body: JSON.stringify(formFields)
         });

         if (response.status === 200) {
             const responseText = await response.json();
             responseTextElement.textContent = responseText.result;
             document.querySelector('.response-overlay').classList.toggle('hide')

         } else {
             console.error("Error: Unexpected response status:", response.status);
         }
     } catch (error) {
         console.error("Error:", error);
    }

}

function getDataFromForm() {
    const fields = {
        "id": document.getElementById("id").value,
        "name": document.getElementById("name").value,
        "newProductKey": document.getElementById("newProductKey").value,
        "newProductValue": document.getElementById("newProductValue").value,
        "availableKey": document.getElementById("availableKey").value,
        "availableValue": document.getElementById("availableValue").value,
        "bestsellerKey": document.getElementById("bestsellerKey").value,
        "bestsellerValue": document.getElementById("bestsellerValue").value,
        "brand": document.getElementById("brand").value,
        "categories": document.getElementById("categories").value,
        "categoryMain": document.getElementById("categoryMain").value,
        "description": document.getElementById("description").value,
        "detail1": document.getElementById("detail1").value,
        "detail2": document.getElementById("detail2").value,
        "detail3": document.getElementById("detail3").value,
        "detail4": document.getElementById("detail4").value,
        "detail5": document.getElementById("detail5").value,
        "manufacturer": document.getElementById("manufacturer").value,
        "price": document.getElementById("price").value,
        "currency": document.getElementById("currency").value,
        "pricePromo": document.getElementById("pricePromo").value,
        "quantity": document.getElementById("quantity").value,
        "urlProduct": document.getElementById("urlProduct").value,
        "cutUTM": document.getElementById("cutUTM").checked,
        "urlImg": document.getElementById("urlImg").value,
        "genderKey": document.getElementById("genderKey").value,
        "genderValue": document.getElementById("genderValue").value,
        "urlCategory": document.getElementById("default").value,
        "urlCategoryMark": document.getElementById("default").value,
        "popularity": document.getElementById("popularity").value,
        "season": document.getElementById("season").value,
        "color": document.getElementById("color").value,
        "addidtionalImage": document.getElementById("default").value,
        "intDetail1": document.getElementById("default").value,
        "intDetail2": document.getElementById("default").value,
        "intDetail3": document.getElementById("default").value,
    };
    const structure = document.getElementById("structure").value;

    return {
        "StructureFile": structure,
        "Fields": fields
    };
}

function validDateFromForm(data) {
    let error = true;
  
    if (!data.StructureFile || data.Fields === ' ') {
        error = false;
        document.getElementById("structure").classList.add('error')
    }
    if (!data.Fields.id || data.Fields.id.length === 0) {
        error = false;
        document.getElementById("id").classList.add('error')
    }
    return error;
}

//???Do usuniecia???//
// function insertResponseBelowForm(response) {

//     // Tworzenie kontenera na odpowiedź
//     const responseDiv = document.createElement("div");
//     responseDiv.classList.add("response-container");

//     const responseContent = document.createElement("div");
//     responseContent.classList.add("response-content");

//     const copyButton = document.createElement("button");
//     copyButton.textContent = "COPY";
//     copyButton.classList.add("copy-button");
//     copyButton.addEventListener("click", function () {
//         const tempTextArea = document.createElement("textarea");
//         tempTextArea.value = response;
//         document.body.appendChild(tempTextArea);
//         tempTextArea.select();
//         document.execCommand("copy");
//         document.body.removeChild(tempTextArea);
//     });

//     // const backButton = document.createElement("button");
//     // backButton.textContent = "BACK";
//     // backButton.classList.add("back-button");
//     // backButton.addEventListener("click", function () {
//     //     // Przywrócenie formularza i ukrycie odpowiedzi
//     //     responseDiv.style.display = "none";
//     //     form.style.display = "block";
//     // });

//     const responseTextElement = document.createElement("pre");
//     responseTextElement.textContent = response;

//     responseContent.appendChild(copyButton);
//     // responseContent.appendChild(backButton);
//     responseContent.appendChild(responseTextElement);

//     responseDiv.appendChild(responseContent);

//     // Dodawanie odpowiedzi pod formularzem
//     document.body.appendChild(responseDiv);


// }

// function showResponseOverlay(response) {
//     const responseOverlay = document.getElementById("response-overlay");
//     const responseTextElement = document.getElementById("response-text");
//     const copyButton = document.getElementById("copy-button");
//     // const backButton = document.getElementById("back-button");

//     responseTextElement.textContent = response;
//     responseOverlay.style.display = "flex";
// }
// copyButton.addEventListener("click", function () {
//     const tempTextArea = document.createElement("textarea");
//     tempTextArea.value = responseTextElement.textContent;
//     document.body.appendChild(tempTextArea);
//     tempTextArea.select();
//     document.execCommand("copy");
//     document.body.removeChild(tempTextArea);
// });
