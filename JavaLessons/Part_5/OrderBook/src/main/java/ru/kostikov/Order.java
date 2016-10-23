package ru.kostikov;

public class Order {

    private String operation;
    private float price;
    private int volume;
    private int id;

    public Order(String operation, float price, int volume, int id) {
        this.operation = operation;
        this.price = price;
        this.volume = volume;
        this.id = id;
    }

    public Order(int id) {
        this.id = id;
    }

    public String getOperation() {
        return this.operation;
    }

    public float getPrice() {
        return this.price;
    }

    public int getVolume() {
        return this.volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return id == order.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "operation=" + operation +
                ", price=" + price +
                ", volume=" + volume +
                ", id=" + id +
                '}';
    }

}