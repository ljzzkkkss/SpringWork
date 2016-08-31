var chat = function () {
    var init = function () {
        $("#send").click(function () {
            chat.send($("#text").val());
            $("#text").val("")
        });
    }

    var websocket;
    var open = function () {
        websocket = new WebSocket("ws://localhost:8081/websocket");
        websocket.onopen = function (evt) { onOpen(evt) };
        websocket.onclose = function (evt) { onClose(evt) };
        websocket.onmessage = function (evt) { onMessage(evt) };
        websocket.onerror = function (evt) { onError(evt) };

        function onOpen(evt) {
            console.log("Connected to WebSocket server.");
        }

        function onClose(evt) {
            console.log("Disconnected");
        }

        function onMessage(evt) {
            console.log('Retrieved data from server: ' + evt.data);
            $("#text").before("<div><label>" + $("#username").val() + "：</label><label>" + evt.data + "</label></div>");
        }

        function onError(evt) {
            console.log('Error occured: ' + evt.data);
        }
    }

    var send = function(text){
        websocket.send(text);
    }

    var close = function(text){
        websocket.close();
    }

    return{
        init:function () {
            init();
        },
        open:function () {
            open();
        },
        send:function (text) {
            send(text);
        },
        close:function () {
            close();
        }

    }
}();