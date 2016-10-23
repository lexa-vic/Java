package ru.kostikov;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

public class SaxHandler extends DefaultHandler {

    private Map<String, Set<Order>> stacks = new TreeMap<>();

    public Map<String, Set<Order>> getStacks() {
        return stacks;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        String name;
        String operation;
        float price;
        int volume;
        int id;

        if ("AddOrder".equalsIgnoreCase(qName)) {
            name = attributes.getValue(0);
            operation = attributes.getValue(1);
            price = Float.parseFloat(attributes.getValue(2));
            volume = Integer.parseInt(attributes.getValue(3));
            id = Integer.parseInt(attributes.getValue(4));

            Order order = new Order(operation, price, volume, id);
            this.checkStack(name);
            Set<Order> orders = this.stacks.get(name);
            orders.add(order);
        } else if ("DeleteOrder".equalsIgnoreCase(qName)) {
            name = attributes.getValue(0);
            id = Integer.parseInt(attributes.getValue(1));

            Set<Order> orders = this.stacks.get(name);
            orders.remove(new Order(id));
        }
    }

    private void checkStack(String name) {
        if (!this.stacks.containsKey(name)) {
            this.stacks.put(name, new HashSet<Order>());
        }
    }

}