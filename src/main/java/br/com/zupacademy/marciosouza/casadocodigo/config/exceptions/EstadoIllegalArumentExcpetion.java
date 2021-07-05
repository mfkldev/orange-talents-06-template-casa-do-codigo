package br.com.zupacademy.marciosouza.casadocodigo.config.exceptions;

public  class EstadoIllegalArumentExcpetion extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EstadoIllegalArumentExcpetion() {
        super();
    }

    public EstadoIllegalArumentExcpetion(final String message, final Throwable cause) {
        super(message, cause);
    }

    public EstadoIllegalArumentExcpetion(final String message) {
        super(message);
    }

    public EstadoIllegalArumentExcpetion(final Throwable cause) {
        super(cause);
    }
}