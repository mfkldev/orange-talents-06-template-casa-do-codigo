package br.com.zupacademy.marciosouza.casadocodigo.config.exceptions;

public  class EstadoCadastradoNoPaisException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EstadoCadastradoNoPaisException() {
        super();
    }

    public EstadoCadastradoNoPaisException(final String message, final Throwable cause) {
        super(message, cause);
    }


    public EstadoCadastradoNoPaisException(final String message) {
        super(message);
    }

    public EstadoCadastradoNoPaisException(final Throwable cause) {
        super(cause);
    }
}