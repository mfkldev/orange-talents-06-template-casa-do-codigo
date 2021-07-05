package br.com.zupacademy.marciosouza.casadocodigo.config.exceptions;

public  class ObjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException() {
        super();
    }

    public ObjectNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ObjectNotFoundException(final String message) {
        super(message);
    }

    public ObjectNotFoundException(final Throwable cause) {
        super(cause);
    }
}