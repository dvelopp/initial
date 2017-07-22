var stompClient = null;
var smileUrl = "https://image.flaticon.com/icons/png/128/42/42829.png";
var smileId = Math.random().toString(36).substring(7);
function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        console.log(smileId);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            console.log(smileId);
            var content = JSON.parse(greeting.body);
            if(!$("#" + content.targetId).length){
                $("body").append("<img style='display: none' id='" + content.targetId + "' src=\"" + smileUrl + "\"/>");
            }
            $("#" + content.targetId + ":hidden").show(1000);
            $("#" + content.targetId).css({
                top: content.y,
                left: content.x,
                position: 'absolute'
            });
        });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}

$(document).keypress(function (event) {
    stompClient.send("/app/hello", {}, JSON.stringify({
        'character': String.fromCharCode(event.charCode),
        'targetId': smileId
    }));
});

connect();