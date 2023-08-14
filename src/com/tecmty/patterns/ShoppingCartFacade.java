package com.tecmty.patterns;

import java.util.List;

public class ShoppingCartFacade{
    private ShoppingCartBuilder cart;
    private Customer customer;

    public ShoppingCartFacade(Customer customer){
        this.customer = customer;
        cart = makeShoppingCart(customer);
    }

    /** We build the cart base on the customer type*/
    private ShoppingCartBuilder makeShoppingCart(Customer customer){
         if(customer.getType().equals(Customer.REGULAR)){
             return new ShoppingCart();
         }else if(customer.getType().equals(Customer.PREMIUM)){
             return new PremierShoppingCart();
         }else return null;
    }

    public void addItem(Item item){
        cart.addItem(item);
    }

    public void removeItem(Item item){
        cart.removeItem(item);
    }

    public List<Item> getItems(){
        return cart.getCartItems();
    }

}
