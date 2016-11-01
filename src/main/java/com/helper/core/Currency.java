package com.helper.core;

/**
 * Created by dvas on 27.10.2016.
 */
public class Currency {
    
    private int id;
    private int userId;
    private String shortName;
    private String fullName;
    private int primaryCurrencyId;
    private float rateToPrimary;
    
    public Currency (int id, int userId, String shortName, String fullName, int primaryCurrencyId, float rateToPrimary) {
        this.id = id;
        this.userId = userId;
        this.shortName = shortName;
        this.fullName = fullName;
        this.primaryCurrencyId = primaryCurrencyId;
        this.rateToPrimary = rateToPrimary;
    }
    
    public Currency () {
    }
    
    public int getId () {
        return id;
    }
    
    public void setId (int id) {
        this.id = id;
    }
    
    public int getUserId () {
        return userId;
    }
    
    public void setUserId (int userId) {
        this.userId = userId;
    }
    
    public String getShortName () {
        return shortName;
    }
    
    public void setShortName (String shortName) {
        this.shortName = shortName;
    }
    
    public String getFullName () {
        return fullName;
    }
    
    public void setFullName (String fullName) {
        this.fullName = fullName;
    }
    
    public int getPrimaryCurrencyId () {
        return primaryCurrencyId;
    }
    
    public void setPrimaryCurrencyId (int primaryCurrencyId) {
        this.primaryCurrencyId = primaryCurrencyId;
    }
    
    public float getRateToPrimary () {
        return rateToPrimary;
    }
    
    public void setRateToPrimary (float rateToPrimary) {
        this.rateToPrimary = rateToPrimary;
    }
}
