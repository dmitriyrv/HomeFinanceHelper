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
    
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Currency currency = (Currency) o;
        
        if (id != currency.id) return false;
        if (userId != currency.userId) return false;
        if (primaryCurrencyId != currency.primaryCurrencyId) return false;
        if (Float.compare(currency.rateToPrimary, rateToPrimary) != 0) return false;
        if (!shortName.equals(currency.shortName)) return false;
        return fullName.equals(currency.fullName);
    
    }
    
    @Override
    public int hashCode () {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + shortName.hashCode();
        result = 31 * result + fullName.hashCode();
        result = 31 * result + primaryCurrencyId;
        result = 31 * result + (rateToPrimary != +0.0f ? Float.floatToIntBits(rateToPrimary) : 0);
        return result;
    }
}
