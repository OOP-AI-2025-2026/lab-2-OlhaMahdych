package ua.opnu;

public class BankAccount {
    //поля класу
    String name;
    double balance;
    double transactionFee;
    //конструктор


    public BankAccount() {
        this.name = "";
        this.balance = 0;
        this.transactionFee = 0;
    }

    public BankAccount(String name, double balance) {
        this.name = name;       // задаємо ім'я
        this.balance = balance; // задаємо початковий баланс
        this.transactionFee = 0; // за замовчуванням комісія = 0
    }

    void deposit(double amount) {
        // якщо сума більше 0, то додаємо її до балансу
        if (amount > 0) {
            balance += amount;
        }
    }

    double getBalance() {

        return balance;//повертаємо баланс; рахунку
    }

    boolean withdraw(double amount) {
        // перевіряємо, щоб сума і комісія не перевищували баланс
        if (amount > 0 && balance >= amount + transactionFee) {
            balance = balance - amount - transactionFee; // віднімаємо суму і комісію
            return true; // операція успішна
        }
        return false; // якщо недостатньо коштів або сума некоректна
    }

    boolean transfer(BankAccount receiver, double amount) {
        // якщо зняття пройшло успішно, додаємо гроші на інший рахунок
        if (amount > 0 && withdraw(amount)) {
            receiver.deposit(amount);
            return true;
        }
        return false;
    }

    //встановлення комісії
    public void setTransactionFee(double fee) {
        if (fee >= 0) {
            this.transactionFee = fee; // встановлюємо нову комісію
        }
    }

    //метод для отримання імені власника
    public String getName() {
        return name;
    }
}