package kr.or.connect.todo.exception;

/**
 * Created by Manki Kim on 2017-02-19.
 */
public class TodoNotFoundException extends Exception {

    public TodoNotFoundException() { super(); }
    public TodoNotFoundException(String message) { super(message); }
    public TodoNotFoundException(String message, Throwable cause) { super(message, cause); }
    public TodoNotFoundException(Throwable cause) { super(cause); }
}
