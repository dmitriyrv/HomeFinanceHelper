package com.helper.finance.dto;

/**
 * Created by Dmitriy Vasiliev on 13.10.2015.
 */
public class CurrencyDto {

    private Integer id;
    private Integer userId;
    private String shortName;
    private String fullName;
    private Integer primaryCurrencyId;
    private Float rateToPrimary;

    public CurrencyDto(){}

    public CurrencyDto(Integer id, Integer userId, String shortName, String fullName, Integer primaryCurrencyId, Float rateToPrimary) {
        this.id = id;
        this.userId = userId;
        this.shortName = shortName;
        this.fullName = fullName;
        this.primaryCurrencyId = primaryCurrencyId;
        this.rateToPrimary = rateToPrimary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getPrimaryCurrencyId() {
        return primaryCurrencyId;
    }

    public void setPrimaryCurrencyId(Integer primaryCurrencyId) {
        this.primaryCurrencyId = primaryCurrencyId;
    }

    public Float getRateToPrimary() {
        return rateToPrimary;
    }

    public void setRateToPrimary(Float rateToPrimary) {
        this.rateToPrimary = rateToPrimary;
    }
}
