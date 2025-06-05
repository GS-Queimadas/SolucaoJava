package br.com.fiap.VIAF.Exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resource, Object id) {
        super(String.format("%s com id %s não foi encontrado", resource, id));
    }
}