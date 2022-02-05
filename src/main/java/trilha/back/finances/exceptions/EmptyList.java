package trilha.back.finances.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmptyList extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EmptyList(String exception) {
        super(exception);
    }
}
