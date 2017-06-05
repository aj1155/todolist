function getTodoList(callback) {
    $.ajax({
            type: "GET",
            url: "/api/todos",
            contentType: "application/json; charset=UTF-8",
            success: function (data) {
                console.log(data);
                callback(data);
            },
        error: function (e) {
            alert(e.responseText);
        }
    });
}

function create(todo,callback) {
    if(todo.length === 0) {
        alert('내용을 적어주세요');
    } else {
        $.ajax({
            type: "POST",
            url : "/api/todos",
            contentType: "application/json; charset=UTF-8",
            data : JSON.stringify({
                todo : todo
            }),
            success: function (data) {
                callback(data);
            },
            error: function (error) {
                alert(error.responseText);
            }
        });
    }
}