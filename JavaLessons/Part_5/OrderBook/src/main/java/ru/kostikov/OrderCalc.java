package ru.kostikov;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;

public class OrderCalc {

    private Set<Order> orders;
    private Map<Float, Order> sortedOrders;
    private PrintStream out;

    public OrderCalc(Set<Order> orders, OutputStream out) {
        this.orders = orders;
        this.out = new PrintStream(new BufferedOutputStream(out), true);
    }

    public void printResult() {
        this.calc();
        this.print();
    }

    void print() {
        this.out.printf("%-10s|%-10s|%-10s%n", "BID", "PRICE","ASK");
        for (Map.Entry<Float, Order> pair : this.sortedOrders.entrySet()) {
            Order currentOrder = pair.getValue();
            if (currentOrder.getVolume() > 0) {
                this.out.printf("%-10s|%-10s|%-10s%n","", pair.getKey(), currentOrder.getVolume());
            } else if (currentOrder.getVolume() < 0) {
                this.out.printf("%-10s|%-10s|%-10s%n", -currentOrder.getVolume(), pair.getKey(), "");
            }
        }
    }

    /**
     * If order has operation "BUY" it has a negative volume.
     */
    void calc() {
        this.sortedOrders = new TreeMap<>(Collections.<Float>reverseOrder());
        for (Order currentOrder : this.orders) {
            float price = currentOrder.getPrice();

            if (this.sortedOrders.containsKey(price)) {
                Order oldOrder = this.sortedOrders.get(price);
                int oldVolume = oldOrder.getVolume();
                if ("BUY".equalsIgnoreCase(currentOrder.getOperation())) {
                    currentOrder.setVolume(-currentOrder.getVolume());
                }
                oldOrder.setVolume(oldVolume + currentOrder.getVolume());
            } else {
                if ("BUY".equalsIgnoreCase(currentOrder.getOperation())) {
                    currentOrder.setVolume(-currentOrder.getVolume());
                }
                this.sortedOrders.put(price, currentOrder);
            }
        }
    }

}