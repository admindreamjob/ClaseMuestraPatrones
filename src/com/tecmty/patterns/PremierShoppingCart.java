package com.tecmty.patterns;

import java.util.Map;

public class PremierShoppingCart extends ShoppingCart{

    public PremierShoppingCart() {
        super();
    }

    @Override
    public void addItem(Item item){
         calculateDiscount(item);
         super.addItem(item);
     }

    /** Calcula el descuento para un cliente premier*/
    private void calculateDiscount(Item item){
        EnvironmentVariables variables = EnvironmentVariables.getInstance();
        Map variablesMap = variables.getVariableMap();
        Variable varDiscount =  (Variable)variablesMap.get("Discount");
        Float discount = (Float)varDiscount.getValue();
        item.setPrice(item.getPrice()*(1-discount));
    }
}
