/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.DAO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PhongNha
 */
public class Cart {
    private List<Item> items;
    private int count;
    private float sumPrice;

    public Cart() {
        items = new ArrayList<>();
        count = 0;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getCount() {
        return items.size();
    }

    public float getSumPrice() {
        float sum = 0;
        for (Item items : items) {
            sum += items.getPrice();
        }
        return sum;
    }

}
