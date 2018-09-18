function getRootURL() {
    //获取当前网址，如：
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录如：/Tmall/exam.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如：//localhost:8080
    var localhostPath=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/Tmall
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return localhostPath+projectName ;
}


/*
* @url: url link
* @action: "get", "post"
* @json: {'key1':'value2', 'key2':'value2'}
*/
function doFormRequest(url, action, json)
{
    var form = document.createElement("form");
    form.action = url;
    form.method = action;

    // append input attribute and valus
    for (var key in json) {
        if (json.hasOwnProperty(key))
        {
            var val = json[key];
            input = document.createElement("input");
            input.type = "hidden";
            input.name = key;
            input.value = val;
            // append key-value to form
            form.appendChild(input)
        }
    }

    // send post request
    document.body.appendChild(form);
    form.submit();

    // remove form from document
    document.body.removeChild(form);
}
