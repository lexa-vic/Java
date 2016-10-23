package ru.kostikov;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class OrderBook {
    private static final File XML = new File(OrderBook.class.getClassLoader().getResource("orders.xml").getFile());
    private SaxHandler handler;
    private Map<String, Set<Order>> stacks;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try {
            new OrderBook().parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long finish = System.currentTimeMillis();
        System.out.printf("Time: %s мс", (finish - start));
    }

    private void parse() throws IOException, SAXException, ParserConfigurationException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        this.handler = new SaxHandler();
        parser.parse(XML, this.handler);
        this.initResult();
        this.printResult();
    }

    private void initResult() {
        this.stacks = this.handler.getStacks();
    }

    private void printResult() {
        for (Map.Entry<String, Set<Order>> pair : this.stacks.entrySet()) {
            System.out.printf("%s:%n", pair.getKey());
            OrderCalc orderCalc = new OrderCalc(pair.getValue(), System.out);
            orderCalc.printResult();
            System.out.println();
        }
    }

}