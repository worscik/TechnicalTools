const navCheckboxs = document.querySelectorAll(".nav-input");
const navButtons = document.querySelectorAll(".nav-btn");
const structureSelect = document.getElementById("structure-select");

function init() {
  console.log("Init...");
  initNavigation();
  initStructureSelect();
  initErrorClearForInputs();
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
