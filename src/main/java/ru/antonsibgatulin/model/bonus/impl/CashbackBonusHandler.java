package ru.antonsibgatulin.model.bonus.impl;

import ru.antonsibgatulin.model.card.BankCard;
import ru.antonsibgatulin.model.bonus.IBonusSystemHandler;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CashbackBonusHandler implements IBonusSystemHandler {
    @Override
    public void handleBonusOnRecharge(BankCard bankCard, BigDecimal replenishment) {
    }

    @Override
    public void handleBonusOnPayment(BankCard bankCard, BigDecimal withdrawal) {
        if (withdrawal.compareTo(new BigDecimal(5000)) >= 0) {
            var cashback = withdrawal.multiply(new BigDecimal(0.05)).setScale(2, RoundingMode.HALF_UP);
            bankCard.addMoney(cashback);
        }
    }
}
