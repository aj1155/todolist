(function (window) {
	'use strict';

	// Your starting point. Enjoy the ride!
    $(document).ready(function(){
        $('.todoapp').data('type','all');
		getTodoList(function(list) {
		   renderAll(list);
		});


        $('.new-todo').keyup(function (event) {
            if (event.keyCode === 13) {
                var newTodo = $(this);
                create(newTodo.val(), function () {
                    getTodoList(function (list) {
                        renderAll(list);
                        newTodo.val("");
                    });
                });
            }
        });

    });



})(window);
