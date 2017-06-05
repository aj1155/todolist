(function (window) {
	'use strict';

	// Your starting point. Enjoy the ride!
    $(document).ready(function(){
        $('.todoapp').data('type','all');
		getTodoList(function(list) {
		    var type = $('.todoapp').data('type');
            renderTodoList(list,type);
            renderFooter(list,type);
		});

    });

    $(".new-todo").keyup(function (e) {
        if (e.keyCode === 13) {
            var newTodo = $(this);
            create(newTodo.val(), function () {
                getTodoList(function (list) {
                    var type = $('.todoapp').data('type');
                    renderTodoList(list,type);
                    renderFooter(list,type);
                    newTodo.val("");
                });
            });
        }
    });
})(window);
