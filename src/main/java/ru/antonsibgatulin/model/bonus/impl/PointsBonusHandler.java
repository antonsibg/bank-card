package ru.antonsibgatulin.model.bonus.impl;

import ru.antonsibgatulin.model.card.BankCard;
import ru.antonsibgatulin.model.bonus.IBonusSystemHandler;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PointsBonusHandler implements IBonusSystemHandler {
    @Override
    public void handleBonusOnRecharge(BankCard bankCard, BigDecimal replenishment) {
        var bonus = replenishment.multiply(new BigDecimal(0.01)).setScale(2, RoundingMode.HALF_UP);
        bankCard.addBonuses(bonus);
    }

    @Override
    public void handleBonusOnPayment(BankCard bankCard, BigDecimal withdrawal) {

    }
}
