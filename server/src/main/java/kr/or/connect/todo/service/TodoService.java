package kr.or.connect.todo.service;

import kr.or.connect.todo.domain.Todo;
import kr.or.connect.todo.persistence.TodoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Manki Kim on 2017-06-02.
 * email : aj1155@naver.com
 * @프로그램설명 : Todo CRUD 서비스 로직 구현
 */
@Service
public class TodoService {

    private final TodoDao todoDao;

    @Autowired
    public TodoService(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public Collection<Todo> findAll() {
        return this.todoDao.selectAll();
    }
}
