const toasts = new Toasts({
  width: 300,
  timing: "ease",
  duration: ".5s",
  dimOld: false,
  position: "top-right",
});

const backButton = document.getElementById("back-button");
const responseTextElement = document.getElementById("response-text");
let formData = {};
const structureList = [
  "rss/channel/item",
  "root/item",
  "products/product",
  "feed/entry",
  "offers/group/o",
];

//Button listenery
const clearButton = document.getElementById("clear-button");
const submitButton = document.getElementById("submit-button");
const closeModalButton = document.getElementById("close-button");
const closeModalIcon = document.getElementById("close-icon");
const copyButton = document.getElementById("copy-button");
const loadButton = document.getElementById("load-button");
const loadMappingButton = document.getElementById("load-mapping-button");
const clearMappingButton = document.getElementById("clear-mapping-button");

clearButton.addEventListener("click", () => {
  document.querySelectorAll("input").forEach((item) => {
    item.type === "text" ? (item.value = "") : null;
    item.type === "checkbox" ? (item.checked = false) : null;
  });
  toasts.push({
    title: "Success",
    content: `Form cleared`,
    style: "success",
    dismissAfter: "2s",
  });
});

closeModalButton.addEventListener("click", () => {
  hideModal();
});

closeModalIcon.addEventListener("click", () => {
  hideModal();
});

document.addEventListener("keydown", (event) => {
  if (event.isComposing || event.key === "Escape") {
    hideModal();
  }
});

copyButton.addEventListener("click", () => {
  const tempTextArea = document.createElement("textarea");
  tempTextArea.value = document.getElementById("response-text").innerText;

  document.body.appendChild(tempTextArea);
  tempTextArea.select();
  document.execCommand("copy");
  document.body.removeChild(tempTextArea);
  toasts.push({
    title: "Success",
    content: `Text copied`,
    style: "success",
    dismissAfter: "2s",
  });
});

submitButton.addEventListener("click", fetchData);

loadButton.addEventListener("click", () => {
  showModal("transform");
});

clearMappingButton.addEventListener("click", () => {
  document.getElementById("transform-text").value = "";
  toasts.push({
    title: "Success",
    content: `Transform cleared`,
    style: "success",
    dismissAfter: "2s",
  });
});

loadMappingButton.addEventListener("click", async () => {
  console.log("loadMappingButton");
  const transform = document.getElementById("transform-text").value;

  if (transform.length > 0) {
    try {
      const response = await fetch("template", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ xsl: transform }),
      });

      if (response.status === 200) {
        const responseText = await response.json();
        loadDataToForm(responseText);
        hideModal();
      } else {
        console.error(
          "Error: Unexpected response status:",
          response.status,
          response
        );
        toasts.push({
          title: "Error",
          content: `Error: Unexpected response status: ${response.status}`,
          style: "error",
          dismissAfter: "2s",
        });
      }
    } catch (error) {
      console.error("Error:", error);
    }
  } else {
    toasts.push({
      title: "Error",
      content: `Please enter transform`,
      style: "error",
      dismissAfter: "2s",
    });
  }
});

//select listener

const selectStructureElement = document.getElementById("structure");
const inputStructureElement = document.getElementById("structure-input");

selectStructureElement.addEventListener("change", (e) => {
  e.target.value === "other"
    ? (inputStructureElement.style.display = "block")
    : (inputStructureElement.style.display = "none");
  console.log("select change", e.target.value);
});

//usuwanie errora przy edycji inputa
document.querySelectorAll("input").forEach((item) => {
  item.addEventListener("input", () => {
    item.classList.remove("error");
  });
});

//Utils
async function fetchData() {
  console.log("fetching data...");

  const formFields = getDataFromForm();
  // validacja
  if (!validDateFromForm(formFields)) return;

  try {
    const response = await fetch("/template", {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formFields),
    });

    if (response.status === 200) {
      const responseText = await response.json();
      responseTextElement.textContent = responseText.result;
      showModal();
    } else {
      console.error(
        "Error: Unexpected response status:",
        response.status,
        response
      );
      toasts.push({
        title: "Error",
        content: `Error: Unexpected response status: ${response.status}`,
        style: "error",
        dismissAfter: "2s",
      });
    }
  } catch (error) {
    console.error("Error:", error);
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
    cutUTM: document.getElementById("cutUTM").checked,
    urlImg: document.getElementById("urlImg").value,
    genderKey: document.getElementById("genderKey").value,
    genderValue: document.getElementById("genderValue").value,
    urlCategory: document.getElementById("default").value,
    urlCategoryMark: document.getElementById("default").value,
    popularity: document.getElementById("popularity").value,
    season: document.getElementById("season").value,
    color: document.getElementById("color").value,
    additionalImage: document.getElementById("default").value,
    intDetail1: document.getElementById("default").value,
    intDetail2: document.getElementById("default").value,
    intDetail3: document.getElementById("default").value,
  };

  const structure =
    selectStructureElement.value === "other"
      ? inputStructureElement.value
      : document.getElementById("structure").value;

  return {
    StructureFile: structure,
    Fields: fields,
  };
}

function validDateFromForm(data) {
  let error = true;

  if (!data.StructureFile || data.Fields === " ") {
    error = false;
    document.getElementById("structure-input").classList.add("error");
    toasts.push({
      title: "Filed error",
      content: "Structure is required",
      style: "error",
      dismissAfter: "2s",
    });
  }
  if (!data.Fields.id || data.Fields.id.length === 0) {
    error = false;
    document.getElementById("id").classList.add("error");
    toasts.push({
      title: "Filed error",
      content: "ID is required",
      style: "error",
      dismissAfter: "2s",
    });
  }
  return error;
}

function loadDataToForm(data) {
  const formInputs = document.querySelectorAll(".form-row input");

  formInputs.forEach((input) => {
    if (input.id === "structure-input") {
      if (structureList.includes(data["structure"])) {
        selectStructureElement.value = data["structure"];
      } else {
        selectStructureElement.value = "other";
        inputStructureElement.value = data["structure"];
        inputStructureElement.style.display = "block";
        //          toasts.push({
        //              title: "Error",
        //              content: "Wrong structure type.",
        //              style: "error",
        //              dismissAfter: "2s",
        //            });
      }
    } else if (input.id === "cutUTM") {
      input.checked = data[input.id];
    } else {
      input.value = data[input.id];
    }
  });
}

// MODAL
const modal = document.getElementById("modal");
const responseModalContent = document.getElementById("response");
const transformModalContent = document.getElementById("transform");

function showModal(type = "response") {
  modal.classList.remove("hide");
  if (type === "response") {
    responseModalContent.classList.remove("hide");
    transformModalContent.classList.add("hide");
  }
  if (type === "transform") {
    responseModalContent.classList.add("hide");
    transformModalContent.classList.remove("hide");
  }
}

function hideModal() {
  modal.classList.add("hide");
}
