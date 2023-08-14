package com.tecmty.patterns;

public class Customer {

    public static String PREMIUM = "PREMIUM";
    public static String REGULAR = "REGULAR";

    private String name;
    private Long id;
    private String type;

    public Customer() { }

    public Customer(String name, Long id, String type) {
        this.name = name;
        this.id = id;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
