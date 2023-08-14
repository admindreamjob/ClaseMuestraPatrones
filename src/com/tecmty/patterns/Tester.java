package com.tecmty.patterns;

import java.util.List;
import java.util.Scanner;

public class Tester {

    public static void main(String[] args){
        //Obtenermos la fuente de las variables de ambiente
        System.out.println("Por favor indica la fuente de las variables de ambiente: ");
        System.out.println("Opciones: FILE|DB_MYSQL|DB_POSTGRESQL|MEMORY");
        //Cambiar descuento
        Scanner in = new Scanner(System.in);
        EnvironmentVariables variables = EnvironmentVariables.getInstance(in.next());
        Customer premium = new Customer("John",1l,Customer.PREMIUM);
        ShoppingCartFacade cart = new ShoppingCartFacade(premium);
        Item item = new Item(1l,"Design Patterns Book", "Aprende patrones de diseño", 900f);
        System.out.println("Articulo antes del descuento: "+ item.getName()+ " : " + "Precio = "+ item.getPrice());
        cart.addItem(item);
        List<Item> items = cart.getItems();
        for( Item itm : items){
            System.out.println("Articulo: "+ itm.getName()+ " : " + "Precio = "+ itm.getPrice());
        }
        //Crear publisher
        VariablesPublisher publisher = new VariablesPublisher();
        VariableHandlerSuscriber variableHandlerSuscriber = new VariableHandlerSuscriber(variables.getVariableHandler());
        //Obtenermos la fuente de las variables de ambiente
         in = new Scanner(System.in);
        //Suscribimos al EnvironmentVariables
        publisher.suscribe(variables);
        publisher.suscribe(variableHandlerSuscriber);
        Variable discount = new Variable("Discount", Float.valueOf(in.nextFloat()),"FLOAT");
        publisher.updateVariable(discount);
        //Imprimir nuevo precio
        item = new Item(2l,"Design Patterns Book 2nd Edition", "Aprende patrones de diseño", 900f);
        cart.addItem(item);
        for( Item art : cart.getItems()){
            System.out.println("Articulo: "+ art.getName()+ " : " + "Precio = "+ art.getPrice());
        }
        //CLIENTE REGULAR
        Customer regular = new Customer("Maria",1l,Customer.REGULAR);
        cart = new ShoppingCartFacade(regular);
        item = new Item(1l,"Design Patterns Book", "Aprende patrones de diseño", 900f);
        cart.addItem(item);
        //Imprimir nuevo precio
        item = new Item(2l,"Design Patterns Book 2nd Edition", "Aprende patrones de diseño", 950f);
        cart.addItem(item);
        for( Item art : cart.getItems()){
            System.out.println("Articulo: "+ art.getName()+ " : " + "Precio = "+ art.getPrice());
        }
        VariableHandler handler = variables.getVariableHandler();
        //handler.clear(new Variable("Regular",1.0f,"FLOAT"));
    }
}
