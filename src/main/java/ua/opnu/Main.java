package ua.opnu;

public class Main {
    public static void main(String[] args) {

        TimeSpan t1 = new TimeSpan(2, 30); // створюємо інтервал 2 години 30 хвилин
        t1.add(1, 45); // додаємо 1 годину 45 хвилин
        System.out.println("Hours: " + t1.getHours() + ", Minutes: " + t1.getMinutes());

        TimeSpan t2 = new TimeSpan(1, 20);
        t1.addTimeSpan(t2); // додаємо інший інтервал
        System.out.println("After adding t2 -> Hours: " + t1.getHours() + ", Minutes: " + t1.getMinutes());
        System.out.println("Total hours: " + t1.getTotalHours());
        System.out.println("Total minutes: " + t1.getTotalMinutes());

        BankAccount acc1 = new BankAccount("Alice", 1000); // створюємо рахунок Alice
        BankAccount acc2 = new BankAccount("Bob", 500);    // створюємо рахунок Bob
        acc1.setTransactionFee(10); // ставимо комісію

        acc1.withdraw(200); // знімаємо 200 грн
        acc1.transfer(acc2, 100); // переказуємо 100 грн Bob
        System.out.println("Alice balance: " + acc1.getBalance());
        System.out.println("Bob balance: " + acc2.getBalance());

    }
}