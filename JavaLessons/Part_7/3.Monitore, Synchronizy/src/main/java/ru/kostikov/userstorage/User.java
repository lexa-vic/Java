package ru.kostikov.userstorage;

/**
 * Created by Алексей on 03.11.2016.
 */
public class User {

    private String name;
    private int amount;

    public User(String name) {
        this.name = name;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized int getAmount() {
        return amount;
    }

    public synchronized void setAmount(int account) {
        this.amount = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (amount != user.amount) return false;
        return name.equals(user.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
