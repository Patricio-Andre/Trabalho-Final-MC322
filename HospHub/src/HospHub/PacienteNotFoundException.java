package HospHub;

public class PacienteNotFoundException extends Exception {
    public PacienteNotFoundException() {
        super("Paciente não encontrado");
    }

    public PacienteNotFoundException(String message) {
        super(message);
    }

    public PacienteNotFoundException(Throwable cause) {
        super(cause);
    }

    public PacienteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
