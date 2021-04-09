package com.example.parcial;

public class Product {
    private int code;
    private String name;
    private  double value;
    private String iva;
    private String description;

    public Product(int code, String name, double value, String iva, String description) {
        this.code = code;
        this.name = name;
        this.value = value;
        this.iva = iva;
        this.description = description;
    }

    public Product() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
