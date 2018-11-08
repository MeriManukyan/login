function validate() {
    var xml = new XMLHttpRequest();
    xml.onreadystatechange = function () {
        if (this.readyState = 4 && this.status == 200) {
            if (this.getResponseHeader("status") == "true") {
                document.getElementById("validate").innerHTML = "User with this name already exists!";
            }
        }
    };
    xml.open("post", "/validate", true);
    xml.send(JSON.stringify(document.getElementById("registerName").value));
}

