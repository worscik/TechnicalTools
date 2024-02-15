const navCheckboxs = document.querySelectorAll(".nav-input");
const navButtons = document.querySelectorAll(".nav-btn");
const structureSelect = document.getElementById("structure-select");

function init() {
  console.log("Init...");
  initNavigation();

  structureSelect.addEventListener("change", () => {
    console.log(structureSelect.value);
    console.log(
      document.getElementById("structure-input").parentNode.classList
    );
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

  console.log(structureSelect.value);
}

function initNavigation() {
  navButtons.forEach((button) =>
    button.addEventListener("click", () => {
      let checkboxID = button.getAttribute("data-checkbox");
      let checkboxIndex = [...navCheckboxs].find(
        (item) => item.getAttribute("data-id") === checkboxID
      );
      checkboxIndex.checked = !checkboxIndex.checked;
    })
  );
}

init();
