window.onload = function () {
    document.getElementById('addThought').onclick = addThought;
}


function addThought() {

    var thought = document.getElementById('thoughtarea').value;

    if (thought.length > 0) {
        var xmlhttp = getXmlHttp(); // Создаём объект XMLHTTP
        xmlhttp.open('POST', '/profile/addThought', true); // Открываем асинхронное соединение
        xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); // Отправляем кодировку
        xmlhttp.send('thought=' + encodeURIComponent(thought)); // Отправляем POST-запрос

        var newTr = document.createElement('tr');
        newTr.innerHTML = '<td>' + thought + '</td><td> a moment ago </td>';
        var thoughtsTable = document.getElementById('thoughtsTable');
        thoughtsTable.insertBefore(newTr, thoughtsTable.firstChild);
        document.getElementById('thoughtarea').value = '';
    }
}

function getXmlHttp() {
    var xmlhttp;
    try {
        xmlhttp = new ActiveXObject('Msxml2.XMLHTTP');
    } catch (e) {
        try {
            xmlhttp = new ActiveXObject('Microsoft.XMLHTTP');
        } catch (E) {
            xmlhttp = false;
        }
    }
    if (!xmlhttp && typeof XMLHttpRequest != 'undefined') {
        xmlhttp = new XMLHttpRequest();
    }
    return xmlhttp;
}