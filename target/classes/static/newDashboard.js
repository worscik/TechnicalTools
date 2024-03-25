const navCheckboxs = document.querySelectorAll(".nav-input");
const navButtons = document.querySelectorAll(".nav-btn");
const structureSelect = document.getElementById("structure-select");
const submitButton = document.querySelector(".submit-btn");
// const toasts = new Toasts({
//   width: 300,
//   timing: "ease",
//   duration: ".5s",
//   dimOld: false,
//   position: "top-right",
// });

function init() {
  console.log("Init...");
  initNavigation();
  initStructureSelect();
  initErrorClearForInputs();
  initSubmitBuuton();
  document.querySelector('.close-btn').addEventListener('click', ()=>{
    window.location.href ='/';
  })

}

function initNavigation() {
  navButtons.forEach((button) =>
    button.addEventListener("click", () => {
      let checkboxID = button.getAttribute("data-checkbox");
      let checkboxIndex = [...navCheckboxs].find(
        (item) => item.getAttribute("data-id") === checkboxID
      );

      validateStep(button.id)
        ? (checkboxIndex.checked = !checkboxIndex.checked)
        : null;
    })
  );
}

function initErrorClearForInputs() {
  const inputs = document.querySelectorAll(".form-group input");

  inputs.forEach((input) =>
    input.addEventListener("keyup", () => {
      if (input.classList.contains("error")) {
        // usuwam klasę z inputa
        input.classList.remove("error");
        // usuwam klasę z rodzica
        input.parentNode.classList.remove("error");
        // usuwam span z tekstem
        input.parentNode.removeChild(
          input.parentNode.querySelector("span.error")
        );
      }
    })
  );
}

function initFormFields(data){
  let inputs = document.querySelectorAll('.form-group input');
  inputs.forEach(input=> {
    input.value = data[input.id] ? data[input.id] : '';
  });

  document.getElementById("structure-select").value = "other";
  document
      .getElementById("structure-input")
      .parentNode.classList.remove("hide");
  document
      .getElementById("structure-input").value = data['structure'] ? data['structure'] : '';
//   TODO: add cutLine hide
  document
      .getElementById("cutLine")
      .parentNode.classList.remove("hide");
  document
      .getElementById("cutLine").value = data['cutLine'] ? data['cutLine'] : '';

}

async function initSubmitBuuton() {
  submitButton.addEventListener("click", async () => {
    let data = getDataFromForm();
    // uderzenie do API
    let loader = createLoader();
    const result = await fetchData(data);
    removeLoader(loader);
    if(result){
       createReponseModal(result);
        document.getElementById('transform-text').textContent=result;
    }
  });
}

async function fetchData(data) {

  try {
    const response = await fetch("/create", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    });

    if (response.status === 200) {
      const responseText = await response.json();
      return responseText.result;
    } else {
      console.error(
          "Error: Unexpected response status:",
          response.status,
          response
      );
      // toasts.push({
      //   title: "Error",
      //   content: `Error: Unexpected response status: ${response.status}`,
      //   style: "error",
      //   dismissAfter: "2s",
      // });
      return null
    }
  } catch (error) {
    console.error("Error:", error);
    return  null;
  }
}

function validateStep(id) {
  switch (Number(id)) {
    case 1:
    case 3:
    case 5:
    case 7:
    case 9:
      return true;
    case 0:
      // Sprawdzanie czy jeśli selekt ma value other to czy pole struktury nie jest puste
      if (structureSelect.value != "other") return true;
      if (!document.getElementById("structure-input").value) {
        addErrorMessage(
          document.getElementById("structure-input"),
          "The field cannot be empty"
        );
        // toasts.push({
        //   title: "Empty field",
        //   content: `The field cannot be empty`,
        //   style: "error",
        //   dismissAfter: "2s",
        // });
        return false;
      }
      return true;
    case 2: {
      if (!document.getElementById("id").value) {
        addErrorMessage(
          document.getElementById("id"),
          "The field cannot be empty"
        );
        // toasts.push({
        //   title: "Empty field",
        //   content: `Field external_id is empty, enter the value!`,
        //   style: "error",
        //   dismissAfter: "2s",
        // });
        return false;
      }
      return true;
    }
    case 4: {
      let flag = true;
      // sprawdzenie czy jeśli jendo pole ma wartość to czy deugie też
      ["newProduct", "available", "bestseller", "gender"].forEach(
        (item) => {
          if (
            document.getElementById(item+'Key').value &&
            !document.getElementById(item + "Value").value
          ) {
            addErrorMessage(
              document.getElementById(item + "Value"),
              "The field cannot be empty"
            );
            flag = false;
          }
          if (
            document.getElementById(item + "Value").value &&
            !document.getElementById(item+'Key').value
          ) {
            addErrorMessage(
              document.getElementById(item+'Key'),
              "The field cannot be empty"
            );
            flag = false;
          }
        }
      );
      // toasts.push({
      //   title: "Empty field",
      //   content: `The field cannot be empty`,
      //   style: "error",
      //   dismissAfter: "2s",
      // });
      return flag;
    }
    default:
      return true;
  }
}

async  function initStructureSelect() {
  //Pobranie listy z API
  const strucureList = await fetchStructures();

  strucureList.forEach((item) => {
    structureSelect.insertBefore(
      createNewOption(item, item, item),
      structureSelect.firstChild
    );
  });

  // Dodaj event zmiany selekta i zarządzaj ukrytym polem input
  structureSelect.addEventListener("change", () => {
    if (structureSelect.value === "other") {
      document
        .getElementById("structure-input")
        .parentNode.classList.remove("hide");
      document
          .getElementById("cutLine")
          .parentNode.classList.remove("hide");
    } else {
      document
        .getElementById("structure-input")
        .parentNode.classList.add("hide");

      document
          .getElementById("cutLine")
          .parentNode.classList.remove("hide");
    }
  });

  // Jeśli strukrty są puste to ustaw other jako value i pokaż input
  if (strucureList.length > 0) {
    structureSelect.value = strucureList[strucureList.length - 1];
  } else {
    structureSelect.value = "other";
    document
      .getElementById("structure-input")
      .parentNode.classList.remove("hide");
  }

  if(localStorage.getItem('redirect')==='true'){
    localStorage.setItem('redirect', true);
    initFormFields(JSON.parse(localStorage.getItem('mapping')));
  }
}

async function fetchStructures() {
  let result = [];
  try {
    const response = await fetch("/structures", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      }
    });
    if (response.status === 200) {
      const body = await response.json();
      result=body;
    } else {
      console.error(
          "Error: Unexpected response status:",
          response.status,
          response
      );
      // toasts.push({
      //   title: "Error",
      //   content: `Error: Unexpected response status: ${response.status}`,
      //   style: "error",
      //   dismissAfter: "2s",
      // });
      return null
    }
  } catch (error) {
    console.error("Error:", error);
    return  null;
  }


  return result;
  // Expected output: "resolved"
}

async function fetchTransform(mapping) {
  try {
    //  fetch
    await delay(1000); // You mock a delay here
    return await "text"; // Resolve value from `res` promise.
  } catch (err) {
    throw new Error("error.unknown");
  }
}

function createNewOption(value, text, name) {
  if (!!value & !!name & !!text) {
    let option = document.createElement("option");
    option.setAttribute("name", name);
    option.textContent = text;
    option.value = value;
    return option;
  }
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

function getDataFromForm() {
  const fields = {
    id: document.getElementById("id").value,
    name: document.getElementById("name").value,
    newProductKey: document.getElementById("newProductKey").value,
    newProductValue: document.getElementById("newProductValue").value,
    availableKey: document.getElementById("availableKey").value,
    availableValue: document.getElementById("availableValue").value,
    bestsellerKey: document.getElementById("bestsellerKey").value,
    bestsellerValue: document.getElementById("bestsellerValue").value,
    brand: document.getElementById("brand").value,
    categories: document.getElementById("categories").value,
    categoryMain: document.getElementById("categoryMain").value,
    description: document.getElementById("description").value,
    detail1: document.getElementById("detail1").value,
    detail2: document.getElementById("detail2").value,
    detail3: document.getElementById("detail3").value,
    detail4: document.getElementById("detail4").value,
    detail5: document.getElementById("detail5").value,
    manufacturer: document.getElementById("manufacturer").value,
    price: document.getElementById("price").value,
    currency: document.getElementById("currency").value,
    pricePromo: document.getElementById("pricePromo").value,
    quantity: document.getElementById("quantity").value,
    urlProduct: document.getElementById("urlProduct").value,
    // To zawsze jak tru
    cutUTM: true,
    urlImg: document.getElementById("urlImg").value,
    genderKey: document.getElementById("genderKey").value,
    genderValue: document.getElementById("genderValue").value,
    popularity: document.getElementById("popularity").value,
    season: document.getElementById("season").value,
    color: document.getElementById("color").value,
    urlCategory: "",
    urlCategoryMark: "",
    addidtionalImage: "",
    intDetail1: "",
    intDetail2: "",
    intDetail3: "",
  };

  const structure =
    structureSelect.value === "other"
      ? document.getElementById("structure-input").value
      : document.getElementById("structure-select").value;

  // const mathLine = document.getElementById("matchLine").value;
  const cutLine = document.getElementById("cutLine").value;

  return {
    StructureFile: structure,
    CutLine: cutLine,
    MatchLine: '',
    Fields: fields,
  };
}

function createReponseModal(text) {
  const responseElement = document.createElement("div");
  responseElement.classList.add("response");
  responseElement.id = "response";
  responseElement.innerHTML = ` <h1 class="title">Transform</h1>
  <div class="main">
    <textarea id="transform-text" placeholder="Enter text here"></textarea>
  </div>
  <div class="btn-group">
    <label class="btn" id="close-mapping-button" onclick="closeResponseElement()">Close</label>
    <label class="btn" id="copy-mapping-button" onclick="copyResponsElement()">Copy</label>
  </div>
  <div class="close-button" onclick="closeResponseElement()" >&#10006;</div>`;

  document.querySelector(".container").appendChild(responseElement);
}

function closeResponseElement() {
  document.getElementById("response").remove();
  moveToFirstStep();
}

async function copyResponsElement() {
     try {
      let text = document.getElementById("transform-text").value;
      await navigator.clipboard.writeText(text);

       let btn = document.getElementById("copy-mapping-button");
       btn.classList.toggle("copied");
       btn.innerHTML = "Copied!";
       setTimeout(function(){
         btn.classList.toggle("copied");
         btn.innerHTML = "Copy";
       }, 3000);
    } catch (err) {
      console.error('Failed to copy: ', err);
    }
   // toasts.push({
  //   title: "Success",
  //   content: `Coopied!`,
  //   style: "success",
  //   dismissAfter: "2s",
  // });
}

function clearResponseElement() {
  document.getElementById("transform-text").value = "";
  // toasts.push({
  //   title: "Success",
  //   content: `Form cleared`,
  //   style: "success",
  //   dismissAfter: "2s",
  // });
}

function moveToFirstStep() {
  navCheckboxs.forEach((item) => {
    item.checked = false;
  });
}

function initTooltips() {
  const tooltips = document.querySelectorAll(".tooltip");

  tooltips.style.width = tooltips.querySelector(".tooltip-tex");
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

init();

// testowe metody lub mock
function resolveAfter2Seconds() {
  return new Promise((resolve) => {
    setTimeout(() => {
      {
        resolve(["asd", "dsa"]);
      }
    }, 2000);
  });
}

const delay = (ms) => new Promise((resolve) => setTimeout(resolve, ms));
