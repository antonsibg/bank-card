import org.junit.jupiter.api.Test;
import ru.antonsibgatulin.model.bonus.impl.CashbackBonusHandler;
import ru.antonsibgatulin.model.bonus.impl.PointsBonusHandler;
import ru.antonsibgatulin.model.card.BankCard;
import ru.antonsibgatulin.model.card.credit.CreditCard;
import ru.antonsibgatulin.model.card.debit.DebitCard;

import java.math.BigDecimal;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CardMultiThreadingTest {
    @Test
    public void threadPoolCardTest() throws InterruptedException {
        var cashbackManageSystem = new CashbackBonusHandler();

        DebitCard debitCard = new DebitCard(cashbackManageSystem, new BigDecimal(0), new BigDecimal(0));

        Executor executor = Executors.newScheduledThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    synchronized (debitCard) {
                        debitCard.addMoney(new BigDecimal(1000));
                        System.out.println(debitCard);
                    }
                }
            });
        }
        Thread.sleep(2000L);
        assert debitCard.getBalanceEntity().getBalance().compareTo(new BigDecimal(10000)) == 0;

    }
}
