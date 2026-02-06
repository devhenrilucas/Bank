package model.exceptions;

public class InvalidAmountException extends RuntimeException {

    public InvalidAmountException() {
        super("Quantia deve ser maior que zero!");
    }

}
