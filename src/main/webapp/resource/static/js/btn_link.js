document.querySelector(".btn-link").addEventListener("click", () => {
    window.location.href = document.querySelector(".div-link").attributes["data-href"].value;
});