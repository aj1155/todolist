package kr.or.connect.todo.api;

import kr.or.connect.todo.domain.Todo;
import kr.or.connect.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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

    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo todo) {
        Todo created = this.todoService.save(todo);
        return new ResponseEntity<Todo>(created,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Collection<Todo>> findAll() {
        Collection<Todo> todos = this.todoService.findAll();
        return new ResponseEntity<Collection<Todo>>(todos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findOne(@PathVariable Integer id) {
        Todo one = this.todoService.findById(id);
        return new ResponseEntity<Todo>(one,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody Todo todo) {
        this.todoService.update(todo);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        this.todoService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
