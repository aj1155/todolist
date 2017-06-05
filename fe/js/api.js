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

function complete(id,callback) {
    $.ajax({
        type: "PUT",
        url : "/api/todos/complete/" + id,
        contentType: "application/json; charset=UTF-8",
        success: function (data) {
            callback();
        },
        error: function (error) {
            alert(error.responseText);
        }
    });
}

function removeOne(id,callback) {
    $.ajax({
        type: "DELETE",
        url : "/api/todos/" + id,
        contentType: "application/json; charset=UTF-8",
        success: function (data) {
            callback();
        },
        error: function (error) {
            alert(error.responseText);
        }
    });
}

function remove(ids,callback) {
    if(ids.length === 0) {
        alert("삭제할 할일이 없습니다. 확인 해주세요");
    }else {
        ids.forEach(function (id) {
            removeOne(id,callback);
        });
    }
}