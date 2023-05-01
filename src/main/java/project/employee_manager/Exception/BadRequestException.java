package project.employee_manager.Exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }

}
