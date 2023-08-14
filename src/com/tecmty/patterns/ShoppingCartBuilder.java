package com.tecmty.patterns;

import java.util.List;

public interface ShoppingCartBuilder{
    public void addItem(Item item);
    public void removeItem(Item item);
    public List<Item> getCartItems();
    public void emptyCar();
    public void checkout();
}