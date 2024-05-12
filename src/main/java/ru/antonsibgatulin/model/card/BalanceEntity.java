package ru.antonsibgatulin.model.card;

import java.math.BigDecimal;

public class BalanceEntity {
    private BigDecimal balance;
    private BigDecimal creditBalance;
    private BigDecimal creditLimit;
    private BigDecimal bonuses;
    private CardType cardType;

    public BalanceEntity(BigDecimal balance, BigDecimal creditBalance, BigDecimal creditLimit, BigDecimal bonuses, CardType cardType) {
        this.balance = balance;
        this.creditBalance = creditBalance;
        this.creditLimit = creditLimit;
        this.bonuses = bonuses;
        this.cardType = cardType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(BigDecimal creditBalance) {
        this.creditBalance = creditBalance;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getBonuses() {
        return bonuses;
    }

    public void setBonuses(BigDecimal bonuses) {
        this.bonuses = bonuses;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BalanceData{");
        sb.append("balance=").append(balance);
        sb.append(", creditBalance=").append(creditBalance);
        sb.append(", creditLimit=").append(creditLimit);
        sb.append(", bonuses=").append(bonuses);
        sb.append('}');
        return sb.toString();
    }
}
