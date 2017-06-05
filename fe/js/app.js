(function (window) {
	'use strict';

	// Your starting point. Enjoy the ride!
    $(document).ready(function(){
        $('.todoapp').data('type','all');
		getTodoList(function(list) {
            renderTodoList(list,$('.todoapp').data('type'));
		});

    });
})(window);
