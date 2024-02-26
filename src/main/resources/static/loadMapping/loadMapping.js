const sendButton = document.getElementById("send-tranform-button");

sendButton.addEventListener("click", () =>
  document.getElementById("response").classList.remove("hide")
);

const closeButton = document.getElementById("close-mapping-button");

closeButton.addEventListener("click", () =>
  document.getElementById("response").classList.add("hide")
);
