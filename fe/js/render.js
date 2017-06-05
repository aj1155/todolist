function renderTodoList(list,type) {

    if(type === "active") {
        list = list.filter(function (todo) {
            return !todo.completed
        });
    } else if(type === "completed") {
        list = list.filter(function (todo) {
            return todo.completed
        });
    }

    var todoDom = "";
    list.forEach(
        function renderDom(todo) { todoDom += makeTodoDom(todo.id,todo.todo,todo.completed); }
    );

    var mainSectionHtml = '<input class="toggle-all" type="checkbox"><label for="toggle-all">Mark all as complete</label><ul class="todo-list">' + todoDom + '</ul>';
    $('.main').html(mainSectionHtml);
}

function makeTodoDom(id,todo,completed) {
    var dom = '<li class="' + (completed ? "completed" : "") + '"><div class="view"><input data-id=' + id + ' class="toggle" type="checkbox" ' + (completed ? "checked" : "") + '><label>' + todo + '</label><button data-id=' + id + ' class="destroy"></button></div> <input class="edit" value="Create a TodoMVC template"></li>';
    return dom;
}