package pro.sky.java.course2.newhw.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeBadNameException extends RuntimeException {
    public EmployeeBadNameException() {
        super("The username you entered is incorrect");
    }
}