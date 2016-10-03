//将序列化成json格式后日期(毫秒数)转成日期格式
function ChangeDateFormat(cellval) {
    if (!cellval) return '';
    var date = new Date(parseInt(cellval.replace("/Date(", "").replace(")/", ""), 10));
    var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
    var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
    var hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
    var minu = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
    var sec = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();

    return date.getFullYear() + "-" + month + "-" + currentDate + " " + hour + ":" + minu + ":" + sec;
}

function ChangeShortDateFormat(cellval) {
    if (!cellval) return '';
    var date = new Date(parseInt(cellval.replace("/Date(", "").replace(")/", ""), 10));
    var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
    var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
    var hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
    var minu = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
    var sec = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();

    return date.getFullYear() + "-" + month + "-" + currentDate; //+ " " + hour + ":" + minu + ":" + sec;

}

//表单序列化有转JSON格式
function convertArray(o) {
    var v = {};
    for (var i in o) {
        if (o[i].name != '__VIEWSTATE') {
            if (typeof (v[o[i].name]) == 'undefined')
                v[o[i].name] = o[i].value;
            else
                v[o[i].name] += "," + o[i].value;
        }
    }
    return v;
}

function setInnerText(obj, s) {
    if (typeof obj.innerText == 'string') {
        obj.innerText = s;
    }
    else {
        obj.textContent = s;
    }
}