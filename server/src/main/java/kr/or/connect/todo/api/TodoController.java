package kr.or.connect.todo.api;

import kr.or.connect.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Manki Kim on 2017-06-02.
 * email : aj1155@naver.com
 * @프로그램 설명 : Todo 컨트롤러 생성
 */

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
}
