package com.example.colorcodes;

public class ColorModel {
    private String name;
    private String hexCode;

    public ColorModel(String name, String hexCode) {
        this.name = name;
        this.hexCode = hexCode;
    }

    public String getName() { return name; }
    public String getHexCode() { return hexCode; }
}
