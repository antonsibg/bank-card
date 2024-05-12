package ru.antonsibgatulin.model.card.debit;

import ru.antonsibgatulin.model.bonus.IBonusSystemHandler;
import ru.antonsibgatulin.model.card.BalanceEntity;
import ru.antonsibgatulin.model.card.BankCard;
import ru.antonsibgatulin.model.card.CardType;

import java.math.BigDecimal;

public class DebitCard extends BankCard {

    public DebitCard(IBonusSystemHandler iBonusSystemHandler, BigDecimal bonuses, BigDecimal balance) {
        super(iBonusSystemHandler, bonuses, balance);
    }

    @Override
    public void addMoney(BigDecimal money) {
        balance.addMoneyToBalance(money);
        super.addMoney(money);

    }

    @Override
    public void subtractMoney(BigDecimal money) {
        if (balance.getBalance().compareTo(money) >= 0) {
            balance.subtractMoneyFromBalance(money);
        } else {
            System.out.println("Insufficient funds to subtract.");
        }

        super.subtractMoney(money);
    }

    @Override
    public CardType getCardType() {
        return CardType.DEBIT;
    }

    @Override
    public BalanceEntity getBalanceEntity() {
        return new BalanceEntity(balance.getBalance(), null, null, bonuses.getBalance(), getCardType());
    }

    /*
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DebitCard{");
        sb.append("balance=").append(balance);
        sb.append(", bonuses=").append(bonuses);
        sb.append('}');
        return sb.toString();
    }

     */
    @Override
    public String toString() {
        return "[DEBIT] Собственные средства: " + balance.getBalance();
    }
}
