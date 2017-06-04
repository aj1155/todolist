package kr.or.connect.todo.service;

import kr.or.connect.todo.domain.Todo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by Manki Kim on 2017-06-03.
 * email : aj1155@naver.com
 * @프로그램 설명 : TodoService Test 로직 구현
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TodoServiceTest {

    @Autowired
    private TodoService todoService;

    @Test
    public void saveTest() {
        Calendar c = Calendar.getInstance();
        Todo todo = new Todo("부스트캠프좋아요",0,c.getTime());
        Todo saveInfo = this.todoService.save(todo);
        assertThat(saveInfo,is(notNullValue()));
    }

    @Test
    public void findAllTest() {
        Collection<Todo> todos = this.todoService.findAll();
        assertThat(todos,is(notNullValue()));
    }

    @Test
    public void findByIdTest() {
        Todo todo = this.todoService.findById(143);
        assertThat(todo,is(notNullValue()));
    }

    @Test
    public void updateTest() {
        Calendar c = Calendar.getInstance();
        Todo todo = new Todo("부스트캠프가고싶어요",1,c.getTime());
        todo.setId(143);
        boolean result = this.todoService.update(todo);
        assertThat(result,is(true));
    }

    @Test
    public void updateFailTest() {
        Calendar c = Calendar.getInstance();
        Todo todo = new Todo("부스트캠프가고싶어요",1,c.getTime());
        todo.setId(1432);
        boolean result = this.todoService.update(todo);
        assertThat(result,is(false));
    }

    @Test
    public void deleteTest() {
        boolean result = this.todoService.deleteById(1);
        assertThat(result,is(true));
    }

    @Test
    public void deleteFailTest() {
        boolean result = this.todoService.deleteById(1582);
        assertThat(result,is(false));
    }

}
