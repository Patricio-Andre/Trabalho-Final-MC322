package HospHub;

public class RemedioIncompativelException extends Exception {
    public RemedioIncompativelException() {
        super("Remédio incnpatível");
    }

    public RemedioIncompativelException(String message) {
        super(message);
    }

    public RemedioIncompativelException(Throwable cause) {
        super(cause);
    }

    public RemedioIncompativelException(String message, Throwable cause) {
        super(message, cause);
    }
}
