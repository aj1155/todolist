package kr.or.connect.todo.exception;

/**
 * Created by Manki Kim on 2017-02-19.
 */
public class TodoUpdateFailException extends Exception {

    public TodoUpdateFailException() { super(); }
    public TodoUpdateFailException(String message) { super(message); }
    public TodoUpdateFailException(String message, Throwable cause) { super(message, cause); }
    public TodoUpdateFailException(Throwable cause) { super(cause); }
}
