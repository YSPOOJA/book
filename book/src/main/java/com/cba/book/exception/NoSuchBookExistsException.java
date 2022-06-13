package com.cba.book.exception;

    public class NoSuchBookExistsException extends  RuntimeException{
        public NoSuchBookExistsException() {
        }

        public NoSuchBookExistsException(String message) {
            super(message);
        }

        public NoSuchBookExistsException(String message, Throwable cause) {
            super(message, cause);
        }

        public NoSuchBookExistsException(Throwable cause) {
            super(cause);
        }

}
