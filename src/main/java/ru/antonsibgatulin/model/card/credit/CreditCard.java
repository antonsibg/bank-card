package ru.antonsibgatulin.model.card.credit;

import ru.antonsibgatulin.model.balance.Balance;
import ru.antonsibgatulin.model.bonus.IBonusSystemHandler;
import ru.antonsibgatulin.model.card.BalanceEntity;
import ru.antonsibgatulin.model.card.BankCard;
import ru.antonsibgatulin.model.card.CardType;

import java.math.BigDecimal;

public class CreditCard extends BankCard {

    private final BigDecimal creditLimit;


    protected Balance creditBalance;

    public CreditCard(IBonusSystemHandler iBonusSystemHandler, BigDecimal bonuses, BigDecimal balance, BigDecimal creditLimit) {
        super(iBonusSystemHandler, bonuses, balance);
        this.creditLimit = creditLimit;
        this.creditBalance = new Balance(creditLimit);
    }

    public void addMoney(BigDecimal money) {
        // проверяем, если кредитный баланс < кредитного лимита
        if (creditBalance.getBalance().compareTo(creditLimit) < 0) {
            BigDecimal remainingCredit = creditLimit.subtract(creditBalance.getBalance());

            if (money.compareTo(remainingCredit) <= 0) {
                creditBalance.addMoneyToBalance(money);
            } else {

                BigDecimal remainingMoney = money.subtract(remainingCredit);

                creditBalance.addMoneyToBalance(remainingCredit);

                balance.addMoneyToBalance(remainingMoney);
            }
        } else {
            balance.addMoneyToBalance(money);
        }
        super.addMoney(money);
    }


    public void subtractMoney(BigDecimal money) {
        if (balance.getBalance().compareTo(money) >= 0) {
            balance.subtractMoneyFromBalance(money);
        } else {
            BigDecimal remainingMoney = money.subtract(balance.getBalance());

            balance.setBalaceZero();

            if (creditBalance.getBalance().compareTo(remainingMoney) >= 0) {
                creditBalance.subtractMoneyFromBalance(remainingMoney);
            } else {
                System.out.println("Insufficient funds to subtract.");
            }
        }
        super.subtractMoney(money);
    }


    @Override
    public CardType getCardType() {
        return CardType.CREDIT;
    }

    @Override
    public BalanceEntity getBalanceEntity() {
        return new BalanceEntity(balance.getBalance(), creditBalance.getBalance(), creditLimit, bonuses.getBalance(), getCardType());
    }

/*
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CreditCard{");
        sb.append("creditLimit=").append(creditLimit);
        sb.append(", creditBalance=").append(creditBalance);
        sb.append(", balance=").append(balance);
        sb.append(", bonuses=").append(bonuses);
        sb.append('}');
        return sb.toString();
    }

 */

    @Override
    public String toString() {
        return "[CREDIT] Кредитные средства: " + creditBalance.getBalance() + "\n" +
                "Собственные средства: " + balance.getBalance();
    }
}
