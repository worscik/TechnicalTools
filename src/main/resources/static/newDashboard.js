const navCheckboxs = document.querySelectorAll(".nav-input");
const navButtons = document.querySelectorAll(".nav-btn");
const structureSelect = document.getElementById("structure-select");
const submitButton = document.querySelector(".submit-btn");
// const toasts = new Toast({
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

async function initSubmitBuuton() {
  submitButton.addEventListener("click", async () => {
    let data = getDataFromForm();
    // uderzenie do API
    let loader = createLoader();
    const result = await fetchTransform();
    removeLoader(loader);

    console.log(result);
    createReponseModal(result);
  });
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
        return false;
      }
      return true;
    case 2: {
      if (!document.getElementById("external-id").value) {
        addErrorMessage(
          document.getElementById("external-id"),
          "The field cannot be empty"
        );
        // toasts.push({
        //   title: "Empty field",
        //   content: `Field external_id is empty, pls enter value!`,
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
      ["new-product", "availability", "bestseller", "gender"].forEach(
        (item) => {
          if (
            document.getElementById(item).value &&
            !document.getElementById(item + "-value").value
          ) {
            addErrorMessage(
              document.getElementById(item + "-value"),
              "The field cannot be empty"
            );
            flag = false;
          }
          if (
            document.getElementById(item + "-value").value &&
            !document.getElementById(item).value
          ) {
            addErrorMessage(
              document.getElementById(item),
              "The field cannot be empty"
            );
            flag = false;
          }
        }
      );
      return flag;
    }
    default:
      return true;
  }
}

function initStructureSelect() {
  //Pobranie listy z API
  const strucureList = fetchStructures();

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
    } else {
      document
        .getElementById("structure-input")
        .parentNode.classList.add("hide");
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
}

function fetchStructures() {
  let result = [
    "products/product",
    "items/item",
    "rss/channel/item",
    "feed/entry",
  ];

  return result;
  // Expected output: "resolved"
}

async function fetchTransform(mapping) {
  try {
    //  fetch
    await delay(5000); // You mock a delay here
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
  const parentNode = inputNode.parentNode;
  parentNode.classList.add("error");
  inputNode.classList.add("error");
  let errorElement = document.createElement("span");
  errorElement.textContent = errorMessage;
  errorElement.classList = "error";
  parentNode.appendChild(errorElement);
}

function getDataFromForm() {
  const fields = {
    id: document.getElementById("external-id").value,
    name: document.getElementById("name").value,
    newProductKey: document.getElementById("new-product").value,
    newProductValue: document.getElementById("new-product-value").value,
    availableKey: document.getElementById("availability").value,
    availableValue: document.getElementById("availability-value").value,
    bestsellerKey: document.getElementById("bestseller").value,
    bestsellerValue: document.getElementById("bestseller-value").value,
    brand: document.getElementById("brand").value,
    categories: document.getElementById("categories").value,
    categoryMain: document.getElementById("main-category").value,
    description: document.getElementById("description").value,
    detail1: document.getElementById("detail-1").value,
    detail2: document.getElementById("detail-2").value,
    detail3: document.getElementById("detail-3").value,
    detail4: document.getElementById("detail-4").value,
    detail5: document.getElementById("detail-5").value,
    manufacturer: document.getElementById("manufacturer").value,
    price: document.getElementById("price").value,
    currency: document.getElementById("currency").value,
    pricePromo: document.getElementById("sale-price").value,
    quantity: document.getElementById("quantity").value,
    urlProduct: document.getElementById("product-url").value,
    // To zawsze jak tru
    cutUTM: true,
    urlImg: document.getElementById("image-url").value,
    genderKey: document.getElementById("gender").value,
    genderValue: document.getElementById("gender-value").value,
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
      ? inputStructureElement.value
      : document.getElementById("structure-input").value;

  const mathLine = document.getElementById("match-line").value;
  const cutLine = document.getElementById("cut-line").value;

  return {
    StructureFile: structure,
    CutLine: cutLine,
    MatchLine: mathLine,
    Fields: fields,
  };
}

function createReponseModal(text) {
  const responseElement = document.createElement("div");
  responseElement.classList.add("response");
  responseElement.id = "response";
  responseElement.innerHTML = ` <h1 class="title">Transform</h1>
  <div class="main">
    <textarea id="transform-text" placeholder="Enter text here">${text}</textarea>
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

function copyResponsElement() {
  console.log("Copied!!!");
  var copyText = document.getElementById("transform-text");

  // Select the text field
  copyText.select();
  copyText.setSelectionRange(0, 99999); // For mobile devices

  // Copy the text inside the text field
  navigator.clipboard.writeText(copyText.value);
  // toasts.push({
  //   title: "Success",
  //   content: `Coopied!`,
  //   style: "success",
  //   dismissAfter: "2s",
  // });
}

function clearResponseElement() {
  console.log("Clear!!!");
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