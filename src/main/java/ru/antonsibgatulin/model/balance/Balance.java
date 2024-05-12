package ru.antonsibgatulin.model.balance;

import java.math.BigDecimal;

public class Balance {
    private BigDecimal balance;

    public Balance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setBalaceZero() {
        this.balance = BigDecimal.ZERO;
    }

    public void subtractMoneyFromBalance(BigDecimal money) {
        this.balance = balance.subtract(money);
    }

    public void addMoneyToBalance(BigDecimal add) {
        this.balance = this.balance.add(add);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Balance{");
        sb.append("balance=").append(balance);
        sb.append('}');
        return sb.toString();
    }
}
