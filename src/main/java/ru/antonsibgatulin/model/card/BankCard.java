package ru.antonsibgatulin.model.card;

import ru.antonsibgatulin.model.balance.Balance;
import ru.antonsibgatulin.model.bonus.IBonusSystemHandler;

import java.math.BigDecimal;

public abstract class BankCard {
    private final IBonusSystemHandler iBonusSystemHandler;

    protected Balance balance;

    protected Balance bonuses;

    public BankCard(IBonusSystemHandler iBonusSystemHandler, BigDecimal bonuses, BigDecimal balance) {

        this.iBonusSystemHandler = iBonusSystemHandler;
        this.bonuses = new Balance(bonuses);
        this.balance = new Balance(balance);
    }


    public void addMoney(BigDecimal money) {
        System.out.println("После пополнения на " + money);
        if (iBonusSystemHandler != null) {
            iBonusSystemHandler.handleBonusOnRecharge(this, money);
        }

    }


    public void subtractMoney(BigDecimal money) {
        System.out.println("После оплаты на " + money);
        if (iBonusSystemHandler != null) {
            iBonusSystemHandler.handleBonusOnPayment(this, money);
        }
    }


    public void addBonuses(BigDecimal bonus) {
        this.bonuses.addMoneyToBalance(bonus);
    }

    public abstract CardType getCardType();

    public abstract BalanceEntity getBalanceEntity();

}
