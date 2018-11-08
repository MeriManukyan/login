var receiver;
var messages;
function myPrint() {
    var xml = new XMLHttpRequest();
    xml.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var json = this.responseText;
            users = JSON.parse(json);
            usersWrite(users);
        }
    };
    xml.open("get", "/login", true);
    xml.send();
}

function usersWrite(arr) {

    var messages = document.getElementById("messages");
    messages.textContent="";
    for (var j in arr) {
        var table = document.getElementById("list");
        var tr = document.createElement("tr");
        table.appendChild(tr);
        var td = document.createElement("td");
        tr.appendChild(td);
        td.innerHTML += arr[j].name;
        receiver = arr[j].name;
        td.innerHTML += countNoteRead(receiver);
        td.setAttribute("id", arr[j].name);
        td.onclick = function (e) {
            receiver = e.toElement.id;
            generateMessages(receiver);
            draw(messages);
        }
    }
}