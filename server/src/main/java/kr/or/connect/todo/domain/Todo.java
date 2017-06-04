package kr.or.connect.todo.domain;


import java.util.Date;

/**
 * Created by Manki Kim on 2017-06-02
 * email : aj1155@naver.com
 * @프로그램 설명 : Todo 도메인 생성.
 */
public class Todo {

    private Integer id;
    private String todo;
    private Integer completed;
    private Date date;

    public Todo() {

    }

    public Todo(String todo,Integer completed,Date date) {
        this.todo = todo;
        this.completed = completed;
        this.date = date;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTodo() {
        return this.todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public Integer getCompleted() {
        return this.completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", todo='" + todo + '\'' +
                ", completed=" + completed +
                ", date=" + date +
                '}';
    }
}
