function sendMessage() {
    var messages = document.getElementById("messages");
    messages.innerHTML = "";
    var xml = new XMLHttpRequest();
    xml.onreadystatechange = function () {
        var json = xml.responseText;
        users = JSON.parse(json);
        if (this.readyState === 4 && this.status === 200) {
            draw(users);
        }
    };
    message = {
        receiverName: receiver,
        text: document.getElementById("text").value
    };
    xml.open("post", "/message", true);
    xml.send(JSON.stringify(message));
}