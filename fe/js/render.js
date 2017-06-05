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

function renderFooter(list,type) {
    var notCompletedTodos = list.filter(function(todo) {
        return !todo.completed
    });

    var todoCount = '<span class="todo-count"><strong>' + notCompletedTodos.length + '</strong> item left</span>';
    var filter = '<ul class="filters"><li><a ' + (type === "all" ? "class=selected" : "") + ' href="#/">All</a></li><li><a href="#/active" ' + (type === "active" ? "class=selected" : "") + '>Active</a></li><li><a href="#/completed" ' + (type === "completed" ? "class=selected" : "") + '>Completed</a></li></ul>';
    var complete = '<!-- This should be `0 items left` by default -->' + todoCount + '<!-- Remove this if you dont implement routing -->' + filter + '</ul> <!-- Hidden if no completed items are left ↓ --> <button class="clear-completed">Clear completed</button>';

    $('.footer').html(complete);
}

function makeTodoDom(id,todo,completed) {
    var dom = '<li class="' + (completed ? "completed" : "") + '"><div class="view"><input data-id=' + id + ' class="toggle" type="checkbox" ' + (completed ? "checked" : "") + '><label>' + todo + '</label><button data-id=' + id + ' class="destroy"></button></div> <input class="edit" value="Create a TodoMVC template"></li>';
    return dom;
}