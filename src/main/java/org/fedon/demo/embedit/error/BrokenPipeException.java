package org.fedon.demo.embedit.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Dmytro Fedonin
 */
@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class BrokenPipeException extends RuntimeException {
    public BrokenPipeException(String message) {
        super(message);
    }

    private static final long serialVersionUID = 1L;
}
