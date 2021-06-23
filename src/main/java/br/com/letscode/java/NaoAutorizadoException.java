package br.com.letscode.java;

public class NaoAutorizadoException extends RuntimeException {

    public NaoAutorizadoException() {
        super("Funcionalidade não permitida");
    }
}
