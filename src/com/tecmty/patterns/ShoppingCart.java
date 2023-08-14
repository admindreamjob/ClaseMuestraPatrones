package com.tecmty.patterns;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart  implements ShoppingCartBuilder{
    /** Articulos del carrito */
        private List<Item> items;

    public ShoppingCart() {
        this.items = items = new ArrayList<>();
    }

    @Override
    public void addItem(Item item){
        items.add(item);
    }

    @Override
    public void removeItem(Item item) {
         items.remove(item);
    }

    @Override
    public List<Item> getCartItems() {
         return items;
    }


    @Override
    public void emptyCar() {
        items.clear();
    }

    @Override
    public void checkout() {/*pay*/}

}
