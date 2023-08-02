package exceptions.model.exception;

public class DomainException extends Exception {

    // Versão da classe 
    private static final long serialVersionUID = 1L;

    public DomainException (String msg){
        super(msg);
    }
}
