package com.example.register_loginapp.db;

import org.litepal.crud.LitePalSupport;
public class Data extends LitePalSupport{
    private String name;
    private String mima;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMima(String mima) {
        this.mima = mima;
    }

    public String getMima() {
        return mima;
    }
}