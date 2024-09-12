package ir.stdev.reception.api.exception;

public class DoctorNotValidException extends DoctorReceptionRunTimeException{
    public DoctorNotValidException(String message) {
        super(message);
    }
}
