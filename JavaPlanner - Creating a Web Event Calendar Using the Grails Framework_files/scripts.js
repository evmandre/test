window.carousel_header = {
    links: [],
    _position: 0,
    prev: function () {
        if (this._position == 0) {
            this._position = this.links.length;
        }
        this._position--;
        this.go();
    },
    next: function () {
        if (this._position == this.links.length - 1) {
            this._position = -1;
        }
        this._position++;
        this.go();
    },
    _initImages: function (imgHolder) {
        var imgHolder = document.getElementById("carousel_active_href");
        var controls = document.getElementById("carousel_controls");
        controls.style.width = 19 * this.links.length + "px";
        for (var i = 0; i < this.links.length; i++) {
            var img = document.createElement("img");
            img.src = this.links[i].src;
            img.alt = this.links[i].alt || "";
            img.title = this.links[i].alt || "";
            img.style.display = "none";
            imgHolder.appendChild(img);

            var button = document.createElement("div");
            button.className = "control";
            controls.appendChild(button);
        }


    },
    autoswitch: function () {
        if (this._timeout)
            clearTimeout(this._timeout);
        var self = this;
        this._timeout = setTimeout(function () {
            self.next();
        }, 15 * 1000);
    },
    init: function (config) {
        if (config) {
            this.links = config;
        }
        this.go();
    },
    go: function (index) {
        if (index === undefined) {
            index = this._position;
        } else {
            this._position = index;
        }

        var link = this.links[index];
        var imgHolder = document.getElementById("carousel_active_href");
        imgHolder.href = link.href;

        var items = imgHolder.getElementsByTagName("img");
        if (items.length < this.links.length) {
            this._initImages();
        }

        for (var i = 0; i < items.length; i++) {
            if (i != index) {
                items[i].style.display = "none";
            } else {
                items[i].style.display = "";
            }
        }
        var self = this;
        setTimeout(function () {
            self._updatePointers(index)
        }, 1);
        this.autoswitch();

    },
    _updatePointers: function (index) {
        if (index === undefined) {
            index = this._position;
        }
        var cts = document.getElementById("carousel_controls").getElementsByTagName("div");
        for (var i = 0; i < cts.length; i++) {
            if (i != index) {
                cts[i].className = cts[i].className.replace(/ active/g, "");

                (function (temp) {
                    cts[temp].onclick = function () { carousel_header.go(temp) };
                })(i)

            } else {
                cts[i].className += " active";
                cts[i].onclick = null;
            }
        }

    }

};

window.popupTypes = { bug: 0, request: 1, feedback:2 };
function getFeedback(type) {

    var options = [
        { value:"bug_report", label:"Report a bug" },
        { value:"feature_request", label:"Request a feature" },
        { value:"feedback", label:"Leave a feedback"}];
    var opts = "";
    for (var i = 0; i < options.length; i++) {
        opts += ["<option value=\"",  options[i].value ,"\"", (i===type ? " selected " : ""), ">", options[i].label, "</option>"].join('');
    }


    var box = window.temp_box = dhtmlx.modalbox({
        title: "Contact Us",
        text: "<div id='form_in_box'>" +
                "<div class=\"box_line\"><div class=\"box_label\"> Email </div><div class=\"box_input\"><input title=\"Enter your name or email address\" name=\"author\" type='text'></div></div>" +
                "<div class=\"box_line\"><div class=\"box_label\"> Subject </div><div class=\"box_input\"><select name=\"type\" type='text'>" + opts + "</select></div></div>" +
                "<div class=\"box_line\"><div class=\"box_label\"> Summary </div><div class=\"box_input\"><textarea rows=\"4\"></textarea></div></div>" +
                "<div class=\"box_line box_controls\"><span class=\"dhtmlx_button\"><input type=\"button\" onclick=\"hideBox(this, true)\" value=\"Send\"/></span><span class=\"dhtmlx_button\"><input type=\"button\"  onclick=\"hideBox(this, false)\" value=\"Cancel\"/></span></div>",
        width: "450px",
        ok: "Send",
        type:"contact_us_form",
        cancel: "Cancel"
    });

    if (document.attachEvent)
        document.attachEvent("onkeydown", contact_mod_key);
    else
        document.addEventListener("keydown", contact_mod_key, true);

    
    setTimeout(function () {
        box.getElementsByTagName("input")[0].focus();
    }, 1);
}
function contact_mod_key(e) {
        e = e || event;
        var code = e.which || event.keyCode;
        if (code == 27) {
            hideBox(window.temp_box);
        }
    }
    
function hideBox(box, result) {
    if (result) {
        

        while (box.parentNode && box.id != "form_in_box") {
            box = box.parentNode;
        }
        if (box) {
            var authBox = box.getElementsByTagName("input")[0];
            var contentBox = box.getElementsByTagName("textarea")[0];

            var author = authBox.value;
            var type = box.getElementsByTagName("select")[0].value;
            var content = contentBox.value;

            var error_color = "#FBDBDB";

            if (!(author && content)) {
                if (!author) {
                    authBox.style.backgroundColor = error_color;
                }
                if (!content) {
                    contentBox.style.backgroundColor = error_color;
                }
                return;
            }

            contentBox.style.backgroundColor = "";
            authBox.style.backgroundColor = "";

            var params = ["author=" + author, "type=" + type, "content=" + content, "location=" + window.location.href].join("&");
            sendRequest("/common/contact.ashx", params, "POST");
        }
        dhtmlx.message("Thank you for your feedback!");
    }
    
    if (document.attachEvent)
        document.detachEvent("onkeydown", contact_mod_key);
    else
        document.removeEventListener("keydown", contact_mod_key, true);
    window.temp_box = null;
    dhtmlx.modalbox.hide(box);
    

}


function sendRequest(url, params, type) {
	var req;
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	} else {
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
	req.onreadystatechange = function () { }
	req.open(type, url, true);
	if (type == "POST") {
		req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	}
	req.send(params || null);
}


function ajax(url,params,call,method) {
	var x = getXmlHttp();
	//add extra params to the url
	if (typeof params == "object"){
		var t=[];
		for (var a in params){
			var value = params[a];
			if (value === null || typeof(value) == "undefined")
				value = "";
			t.push(a+"="+encodeURIComponent(value));
	 	}
		params=t.join("&");
	}
	if (params && method==='GET'){
		url=url+(url.indexOf("?")!=-1 ? "&" : "?")+params;
		params=null;
	}
	x.open(method,url,true);

	if (method.toUpperCase() === 'POST')
		x.setRequestHeader('Content-type','application/x-www-form-urlencoded');

	 x.onreadystatechange= function(){
		if (!x.readyState || x.readyState == 4){
			if (call){
				var is_error = x.status >= 400 || (!x.status && !x.responseText);
				var text = x.responseText||"";
				call.call(is_error,text,x);
			}
		}
	 };

	x.send(params||null);
	return x;
};

function subscribe(email, name) {
	email = encodeURIComponent(email || "");
	name = encodeURIComponent(name || "");
	ajax("subscribe.html", { name:name, email:email}, function(text) {
        var tmp = { result:"error", message:"Unknown subscribing problem. Contact us, please"};
        try {
            eval("tmp = " + text);
        } catch (e) {}

        var error = document.getElementById("signup_error");
        error.innerHTML = tmp.message;
        if (tmp.result == "error") {
            error.className = "invalid";
        } else {
        	var form = document.getElementById("email_form_inputs");
        	form.className = "invisible";
            error.className = "valid";
        }
    }, "post");
}

function getXmlHttp(){
	var xmlhttp;
	try {
		xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		try {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (E) {
			xmlhttp = false;
		}
	}
	if (!xmlhttp && typeof XMLHttpRequest!='undefined') {
		xmlhttp = new XMLHttpRequest();
	}
	return xmlhttp;
}


function sublist(e) {
	e = e || window.event;
	var target = e.target || e.srcElement;
	var parent = target.parentNode;
	var data = null;
	for (var i = 0; i < parent.childNodes.length; i++) {
		var node = parent.childNodes[i];
		if (node.nodeType == 1 && node.className.indexOf("data ") != -1) {
			data = node;
			break;
		}
	}
	if (data)
		data.className = (data.className == "data visible") ? "data hidden" : "data visible";
}


function getXmlHttp(){
    var xmlhttp;
    try {
        xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (e) {
        try {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (E) {
            xmlhttp = false;
        }
    }
    if (!xmlhttp && typeof XMLHttpRequest!='undefined') {
        xmlhttp = new XMLHttpRequest();
    }
    return xmlhttp;
}



function signup_init() {
    var name = document.getElementById("name");
    name.onfocus = function() {
        name.className = "";
        if (name.value == "Enter name...") name.value = "";
    };
    name.onblur = function() {
        if (name.value == "") {
            name.className = "email_gray";
            name.value = "Enter name...";
        }
    };

    var email = document.getElementById("email");
    email.onfocus = function() {
        email.className = "";
        if (email.value == "Enter email...") email.value = "";
    };
    email.onblur = function() {
        if (email.value == "") {
            email.className = "email_gray";
            email.value = "Enter email...";
        }
    };

    var button = document.getElementById("signup_save");
    button.onclick = function() {
        var em = email.value;
        if (em == "Enter email...") em = "";
        var n = name.value;
        if (n == "Enter name...") n = "";
        subscribe(em, n, button.getAttribute("url"));
    };
}



function _redirectToThankYou() {
	window.setTimeout(function() {
		window.location.href = "thank_you.html";
	}, 3000);
}

function _redirectDownloads() {
	window.setTimeout(function() {
		window.location.href = "download.html";
	}, 3000);
}



var d = document;
function back_to_features() {
	var ttl = d.getElementById('to_features');
	if (ttl) {
		var doc = document.documentElement, body = document.body;
		var top = (doc && doc.scrollTop  || body && body.scrollTop  || 0);
		if (top > 760)
			ttl.className = '';
	    else {
	    	ttl.className = 'invisible_';
	    	window.setTimeout(function() {
	    		ttl.className += ' block';
	    	}, 3000);
	    }
	}
};