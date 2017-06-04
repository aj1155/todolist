package kr.or.connect.todo.service;

import kr.or.connect.todo.domain.Todo;
import kr.or.connect.todo.persistence.TodoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Manki Kim on 2017-06-02.
 * email : aj1155@naver.com
 * @프로그램설명 : Todo CRUD 서비스 로직 구현
 */
@Service
public class TodoService {

    private final TodoDao todoDao;
    private final Calendar calendar;

    @Autowired
    public TodoService(TodoDao todoDao) {
        this.todoDao = todoDao;
        calendar = Calendar.getInstance();
    }

    public Todo save(Todo todo){
        todo.setDate(calendar.getTime());
        Integer id = this.todoDao.insert(todo);
        todo.setId(id);
        return todo;
    }

    public Collection<Todo> findAll() {
        List<Todo> todos = this.todoDao.selectAll();
        return todos.stream().sorted((t1,t2) -> t1.getDate().compareTo(t2.getDate())).collect(Collectors.toList());
    }

    public Todo findById(Integer id) {
        return this.todoDao.selectById(id);
    }

    public int getTodosCount() {
        return this.todoDao.count();
    }

    public boolean update(Todo todo) {
        int result = this.todoDao.update(todo);
        return result == 1;
    }

    public boolean deleteById (Integer id) {
        int result = this.todoDao.deleteById(id);
        return result == 1;
    }


}
