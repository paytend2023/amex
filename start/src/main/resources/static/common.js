function getFormData(form) {
    var formData = form.serializeArray()
    var jsonData = {}
    $.each(formData, function () {
        if (jsonData[this.name]) {
            if (!jsonData[this.name].push) {
                jsonData[this.name] = [jsonData[this.name]]
            } else {
                jsonData[this.name].push(this.value || "")
            }
        } else {
            jsonData[this.name] = this.value || ""
        }
    })
    return jsonData
}

function requestByHeader(form, url, header, callback) {
    let formData = getFormData(form)
    console.log(formData)
    $.ajax({
        method: "POST",
        headers: header,
        url: url,
        contentType: 'application/json',
        data: JSON.stringify(formData),
        dataType: "JSON"
    }).done(function (r) {
        console.log(r)
        if (callback) {
            callback(r)
        }
    });
}

function request(form, url, callback) {
    requestByHeader(form, url, {}, callback)
}

const formatter = new Intl.DateTimeFormat('zh-CN', {
    year: 'numeric',
    month: '2-digit',
    day: '2-digit',
    hour: '2-digit',
    minute: '2-digit',
    second: '2-digit'
});


/**
 * yyyyMMddHHmmss
 * @param date
 * @returns {string}
 */
function formatDateTime(date) {
    const year = date.getFullYear();
    const month = date.getMonth() + 1;
    const day = date.getDate();
    const hour = date.getHours();
    const minute = date.getMinutes();
    const second = date.getSeconds();
    return `${year}${pad(month)}${pad(day)}${pad(hour)}${pad(minute)}${pad(second)}`;
}

/**
 * yyyyMMdd
 * @param date
 * @returns {string}
 */
function formatDate(date) {
    const year = date.getFullYear();
    const month = date.getMonth() + 1;
    const day = date.getDate();
    const hour = date.getHours();
    const minute = date.getMinutes();
    const second = date.getSeconds();
    return `${year}${pad(month)}${pad(day)}`;
}

function pad(num) {
    return num.toString().padStart(2, '0');
}

