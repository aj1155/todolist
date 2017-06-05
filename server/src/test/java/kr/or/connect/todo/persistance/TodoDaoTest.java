package kr.or.connect.todo.persistance;

import kr.or.connect.todo.domain.Todo;
import kr.or.connect.todo.persistence.TodoDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by Manki Kim on 2017-06-03.
 * email : aj1155@naver.com
 * @프로그램 설명 : TodoDao Test 코드
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TodoDaoTest {

    @Autowired
    private TodoDao todoDao;

    @Test
    public void shouldInsertAndSelect() throws ParseException {
        Calendar c = Calendar.getInstance();
        Todo todo = new Todo("부스트 캠프 과제",0,c.getTime());
        Integer id = this.todoDao.insert(todo);
        Todo selected = this.todoDao.selectById(id);
        assertThat(selected.getTodo(),is("부스트 캠프 과제"));
    }

    @Test
    public void selectAllTest() {
        List<Todo> todoList = this.todoDao.selectAll();
        assertThat(todoList,is(notNullValue()));
    }

    @Test
    public void selectByIdTest() {
        Todo todo = this.todoDao.selectById(143);
        assertThat(todo.getTodo(),containsString("부스트캠프"));
    }

    @Test
    public void updateTest() {
        Calendar c = Calendar.getInstance();
        Todo todo = new Todo("부스트캠프가고싶어요",1,c.getTime());
        todo.setId(143);
        int result = this.todoDao.update(todo);
        assertThat(result,is(1));
    }

    @Test
    public void completeTest() {
        int result = this.todoDao.complete(1);
        assertThat(result,is(1));
    }

    @Test
    public void deleteByIdTest() {
        int result = this.todoDao.deleteById(143);
        assertThat(result,is(1));
    }

    @Test
    public void deleteFailById() {
        int result = this.todoDao.deleteById(1443);
        assertThat(result,is(0));
    }

}
