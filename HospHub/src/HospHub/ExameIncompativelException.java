package HospHub;

public class ExameIncompativelException extends Exception {
    public ExameIncompativelException() {
        super("Exame inconpatível com o paciente");
    }

    public ExameIncompativelException(String message) {
        super(message);
    }

    public ExameIncompativelException(Throwable cause) {
        super(cause);
    }

    public ExameIncompativelException(String message, Throwable cause) {
        super(message, cause);
    }
}
