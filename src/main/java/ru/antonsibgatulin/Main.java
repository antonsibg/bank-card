package ru.antonsibgatulin;

import ru.antonsibgatulin.model.bonus.impl.PointsBonusHandler;
import ru.antonsibgatulin.model.bonus.impl.CashbackBonusHandler;
import ru.antonsibgatulin.model.card.BankCard;
import ru.antonsibgatulin.model.card.credit.CreditCard;
import ru.antonsibgatulin.model.card.debit.DebitCard;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        var cashbackManageSystem = new CashbackBonusHandler();
        var bonusesManagementSystem = new PointsBonusHandler();

        BankCard creditCard = new CreditCard(cashbackManageSystem, new BigDecimal(0), new BigDecimal(0), new BigDecimal(10000));
        BankCard debitCard = new DebitCard(bonusesManagementSystem, new BigDecimal(0), new BigDecimal(5000));

        System.out.println("=======================================================================");

        System.out.println(debitCard);
        debitCard.addMoney(new BigDecimal(1000));
        System.out.println(debitCard);

        debitCard.subtractMoney(new BigDecimal(1000));
        System.out.println(debitCard);

        debitCard.addMoney(new BigDecimal(1000));
        System.out.println(debitCard);

        debitCard.subtractMoney(new BigDecimal(5000));
        System.out.println(debitCard);

        System.out.println("=======================================================================");

        System.out.println(creditCard);

        creditCard.addMoney(new BigDecimal(5000));
        System.out.println(creditCard);


        creditCard.subtractMoney(new BigDecimal(5000));
        System.out.println(creditCard);


        creditCard.subtractMoney(new BigDecimal(3000));
        System.out.println(creditCard);


    }
}