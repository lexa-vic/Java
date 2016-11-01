package ru.kostikov;

/**
 * Created by Алексей on 01.11.2016.
 */
public class Account {
    private long balance;

    public Account(long balance) {
        this.balance = balance;
    }

    public void withdraw(long amount){
        if (balance >= amount){
            balance -= amount;
        }
    }

    public void deposit(long amount){
        if (amount >= 0){
            balance += amount;
        }
    }

    public void printBalance(){
        System.out.printf(" Balance %d\n", balance);
    }

    public static void main(String[] args) {
        Account account = new Account(10_000);

        account.printBalance();

        WithdrawThread wdt = new WithdrawThread(account);
        DepositThread dt = new DepositThread(account);

        wdt.start();
        dt.start();

        try {
            wdt.join();
            dt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        account.printBalance();
    }

    private static class WithdrawThread extends Thread{
        private Account account;

        public WithdrawThread(Account account){
            super();
            this.account = account;
        }

        /**
         * If this thread was constructed using a separate
         * <code>Runnable</code> run object, then that
         * <code>Runnable</code> object's <code>run</code> method is called;
         * otherwise, this method does nothing and returns.
         * <p>
         * Subclasses of <code>Thread</code> should override this method.
         *
         * @see #start()
         * @see #stop()
         */
        @Override
        public void run() {
            for (int i = 0; i < 100_000; i++ ){
                account.withdraw(1);
                System.out.printf("Balance -1\n");
            }
        }
    }

    private static class DepositThread extends Thread{
        private Account account;

        public DepositThread(Account account){
            super();
            this.account = account;
        }

        /**
         * If this thread was constructed using a separate
         * <code>Runnable</code> run object, then that
         * <code>Runnable</code> object's <code>run</code> method is called;
         * otherwise, this method does nothing and returns.
         * <p>
         * Subclasses of <code>Thread</code> should override this method.
         *
         * @see #start()
         * @see #stop()
         */
        @Override
        public void run() {
            for (int i = 0; i < 100_000; i++ ){
                account.deposit(1);
                System.out.printf("Balance +1\n");
            }
        }
    }


}
