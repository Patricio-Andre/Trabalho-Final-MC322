package hospitaleservicos;

public interface Cadastrable {
    boolean cadastrar(Object partedalista) throws Exception;
    boolean remover(String id) throws Exception;

}

