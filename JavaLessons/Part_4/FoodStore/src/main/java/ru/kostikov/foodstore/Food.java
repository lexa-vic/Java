package ru.kostikov.foodstore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class describes a food. It's name, price, discount and, dates
 * Created by Алексей on 07.09.2016.
 */
public class Food {
    /** Product name */
    private String Name;
    /** Expire date in format yyyy-MM-dd*/
    private Date expireDate;
    /** Create date in format yyyy-MM-dd*/
    private Date createDate;
    /** Current price */
    private double price;
    /** Discount */
    private double discount;

    /**
     * Constructor
     * @param Name Product name
     */
    public Food(String Name){
        this.Name = Name;
    }

    /**
     * ExpireDate getter
     * @return
     */
    public Date getExpireDate() {
        return expireDate;
    }

    /**
     * ExpireDate setter
     * @param expireDate
     * @throws ParseException
     */
    public Food setExpireDate(String expireDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.expireDate = format.parse(expireDate);
        return this;
    }

    /**
     * CreateDate getter
     * @return
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     * @throws ParseException
     */
    public Food setCreateDate(String createDate) throws ParseException  {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.createDate = format.parse(createDate);
        return this;
    }

    /** Price setter
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Price getter
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * Discount getter
     * @return
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Discount setter
     * @param discount
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
