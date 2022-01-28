package pro.sky.java.course2.newhw.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeBookOverFlowException extends RuntimeException {
    private static final String DEFAULT_MASSAGE = "Employee is full";

    public EmployeeBookOverFlowException() {
        super(DEFAULT_MASSAGE);
    }

}
