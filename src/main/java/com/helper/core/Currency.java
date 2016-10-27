package com.helper.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by dvas on 27.10.2016.
 */
public class Currency {
    @JsonProperty
    private int id;
    
    @JsonProperty
    private int userId;
    
    @JsonProperty
    @NotEmpty
    private String shortName;
    
    @JsonProperty
    @NotEmpty
    private String fullName;
    
    @JsonProperty
    private int primaryCurrencyId;
    
    @JsonProperty
    private float rateToPrimary;
    
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
