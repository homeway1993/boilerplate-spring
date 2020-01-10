package boilerplate.spring.web.exception;

import boilerplate.spring.web.controller.GlobalExceptionController;

/**
 * An exception class used to respond to "404 NotFound".
 * Will handle by {@link GlobalExceptionController#handleNotFoundException}
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("Data not found.");
    }
}
