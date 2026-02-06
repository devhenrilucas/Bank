package model.entities;

import model.exceptions.InsufficientBalanceException;
import model.exceptions.InvalidAmountException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SavingsAccount extends Account {

    private Double tax;
    private LocalDate lastInterestDate;

    public SavingsAccount() {
    }

    public SavingsAccount(String clientId, Double balance) {
        super(clientId, balance);
        this.lastInterestDate = LocalDate.now();
        this.tax = 0.005;
    }

    public LocalDate getLastInterestDate() {
        return lastInterestDate;
    }

    public void setLastInterestDate(LocalDate lastInterestDate) {
        this.lastInterestDate = lastInterestDate;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    @Override
    public void withdraw(double valor) {

        if (valor <= 0) {
            throw new InvalidAmountException();
        }

        if (getBalance() < valor) {
            throw new InsufficientBalanceException();
        }

        setBalance(getBalance() - valor);
    }

    @Override
    public void monthlyUpdate() {

        LocalDate now = LocalDate.now();

        long monthsPassed = ChronoUnit.MONTHS.between(lastInterestDate, now);

        if (monthsPassed > 0) {
            double factor = Math.pow(1 + tax, monthsPassed);

            setBalance(getBalance() * factor);

            lastInterestDate = now;

        }

    }
}
