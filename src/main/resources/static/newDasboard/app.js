const navCheckboxs = document.querySelectorAll(".nav-input");
const navButtons = document.querySelectorAll(".nav-btn");

function init() {
  console.log("Init...");
  initNavigation();
}

init();

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

console.log(navCheckboxs, navButtons);
