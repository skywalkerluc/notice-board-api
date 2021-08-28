package tech.cers.noticeboard.exceptions;

public class NoticeNotFoundException extends RuntimeException {
  public NoticeNotFoundException(String message) {
    super(message);
  }
}
