let accNo = null;
const URL = "http://localhost:8080/atm";

function login() {
    let a = document.getElementById("accNo").value;
    let p = document.getElementById("pin").value;

    fetch(`${URL}/login?accNo=${a}&pin=${p}`, { method: "POST" })
    .then(res => res.json())
    .then(data => {
        accNo = a;
        document.getElementById("login").style.display = "none";
        document.getElementById("dashboard").style.display = "block";
    });
}

function balance() {
    fetch(`${URL}/balance/${accNo}`)
    .then(res => res.text())
    .then(d => document.getElementById("bal").innerText = d);
}

function deposit() {
    let amt = document.getElementById("amt").value;

    fetch(`${URL}/deposit?accNo=${accNo}&amt=${amt}`, { method: "POST" })
    .then(() => balance());
}

function withdraw() {
    let amt = document.getElementById("amt").value;

    fetch(`${URL}/withdraw?accNo=${accNo}&amt=${amt}`, { method: "POST" })
    .then(() => balance());
}

function logout() {
    location.reload();
}