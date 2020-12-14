package com.example.callingnsmsapplication;

public class chat {
    String username;
    String message;
    String ad;
    public chat(){
    }

    public chat(String username,String message, String ad){
        this.username=username;
        this.message=message;
        this.ad=ad;
    }
    public String getMessage()
    {
        return message;
    }
    public void setMessage(String message)
    {
        this.message=message;
    }
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username=username;
    }
    public String getAd()
    {
        return ad;
    }
    public void setAd(String ad)
    {
        this.ad=ad;
    }
}
