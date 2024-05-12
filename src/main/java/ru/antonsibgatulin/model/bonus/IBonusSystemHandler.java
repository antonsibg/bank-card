package ru.antonsibgatulin.model.bonus;

import ru.antonsibgatulin.model.card.BankCard;

import java.math.BigDecimal;

public interface IBonusSystemHandler {

    void handleBonusOnRecharge(BankCard bankCard, BigDecimal replenishment);
    void handleBonusOnPayment(BankCard bankCard, BigDecimal withdrawal);

}
