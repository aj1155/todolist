package kr.or.connect.todo.exception;

/**
 * Created by Manki Kim on 2017-02-19.
 */
public class TodoDeleteFailException extends Exception {

    public TodoDeleteFailException() { super(); }
    public TodoDeleteFailException(String message) { super(message); }
    public TodoDeleteFailException(String message, Throwable cause) { super(message, cause); }
    public TodoDeleteFailException(Throwable cause) { super(cause); }
}
