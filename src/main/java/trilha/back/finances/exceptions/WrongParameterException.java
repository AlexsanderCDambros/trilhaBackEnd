package trilha.back.finances.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WrongParameterException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public WrongParameterException(String exception) {
        super(exception);
    }
}
