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

    $('.toggle').click(function (event) {
        var id = $(this).data('id');
        complete(id,function() {
            getTodoList(function(list){
                renderAll(list);
            })
        });
    });

    $('.destroy').click(function(event) {
        var id = $(this).data('id');
        removeOne(id,function() {
            getTodoList(function (list) {
                $('.todoapp').data('type','all');
                renderAll(list);
            });
        });
    });
}

function renderFooter(list,type) {

    var notCompletedTodos = list.filter(function(todo) {
        return !todo.completed
    });

    var todoCount = '<span class="todo-count"><strong>' + notCompletedTodos.length + '</strong> item left</span>';
    var filter = '<ul class="filters"><li><a ' + (type === "all" ? "class=selected" : "") + ' filter="all" >All</a></li><li><a filter="active" ' + (type === "active" ? "class=selected" : "") + '>Active</a></li><li><a filter="completed" ' + (type === "completed" ? "class=selected" : "") + '>Completed</a></li></ul>';
    console.log(filter);
    var complete = '<!-- This should be `0 items left` by default -->' + todoCount + '<!-- Remove this if you dont implement routing -->' + filter + '</ul> <!-- Hidden if no completed items are left ↓ --> <button class="clear-completed">Clear completed</button>';

    $('.footer').html(complete);

    $('[filter=all]').click(function (event) {
        event.preventDefault();
        getTodoList(function (list) {
            $('.todoapp').data('type','all');
            renderAll(list);
        });
    });

    $('[filter=active]').click(function (event) {
        event.preventDefault();
        getTodoList(function (list) {
            $('.todoapp').data('type','active');
            renderAll(list);
        });
    });

    $('[filter=completed]').click(function (event) {
        event.preventDefault();
        getTodoList(function (list) {
            $('.todoapp').data('type','completed');
            renderAll(list);
        });
    });

    $('.clear-completed').click(function (event) {
        var completeTodosId = list.filter(function (todo) {
            return todo.completed;
        }).map(function (completeTodo) {
            return completeTodo.id;
        });

        remove(completeTodosId, function() {
            getTodoList(function (list) {
                renderAll(list);
            });
        });
    });
}

function makeTodoDom(id,todo,completed) {
    var dom = '<li class="' + (completed ? "completed" : "") + '"><div class="view"><input data-id=' + id + ' class="toggle" type="checkbox" ' + (completed ? "checked" : "") + '><label>' + todo + '</label><button data-id=' + id + ' class="destroy"></button></div> <input class="edit" value="Create a TodoMVC template"></li>';
    return dom;
}

function renderAll(list) {
    var type = $('.todoapp').data('type');
    console.log(type);
    renderTodoList(list,type);
    renderFooter(list,type);
}