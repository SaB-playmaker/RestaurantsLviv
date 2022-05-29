package com.restaurants.lviv.restLvivApplication;

import java.io.Serializable;

public class Comment implements Serializable
{

    private String key;
    private String description;
    private String rate;
    public Comment(){}
    public Comment(String description, String rate)
    {
        this.description = description;
        this.rate = rate;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getRate()
    {
        return rate;
    }

    public void setRate(String position)
    {
        this.rate = rate;
    }
    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }
}
