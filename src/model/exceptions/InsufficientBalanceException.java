package model.exceptions;

public class InsufficientBalanceException extends RuntimeException
{
    public InsufficientBalanceException() {
        super("Saldo insuficinete!");
    }

}
