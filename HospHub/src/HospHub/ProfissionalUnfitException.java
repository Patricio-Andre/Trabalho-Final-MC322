package HospHub;

public class ProfissionalUnfitException extends Exception {
    public ProfissionalUnfitException() {
        super("Profissional indisponível");
    }

    public ProfissionalUnfitException(String message) {
        super(message);
    }

    public ProfissionalUnfitException(Throwable cause) {
        super(cause);
    }

    public ProfissionalUnfitException(String message, Throwable cause) {
        super(message, cause);
    }
}