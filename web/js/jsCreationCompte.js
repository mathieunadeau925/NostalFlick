    var infoAdmin = document.getElementById("compteAdmin");
    var infoClient = document.getElementById("compteClient");
    function compteAdmin() {
        infoAdmin.classList.remove("is-hidden");
        infoClient.classList.add("is-hidden");
    }
        function compteClient() {
        infoClient.classList.remove("is-hidden");
        infoAdmin.classList.add("is-hidden");
    }

