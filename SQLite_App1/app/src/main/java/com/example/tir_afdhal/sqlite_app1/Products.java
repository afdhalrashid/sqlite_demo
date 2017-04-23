package com.example.tir_afdhal.sqlite_app1;

/**
 * Created by TIR-afdhal on 19/4/2017.
 */

public class Products {

    private int product_id;
    private String product_name;
    private int product_colour;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_colour() {
        return product_colour;
    }

    public void setProduct_colour(int product_colour) {

        this.product_colour = product_colour;
    }

    public Products(int product_id, String product_name, int product_colour) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_colour = product_colour;
    }

    public Products(String product_name, int product_colour) {
        this.product_name = product_name;
        this.product_colour = product_colour;
    }

    public Products() {
    }
}
