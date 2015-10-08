package com.helper.finance.dto;

import java.util.Objects;

/**
 * Created by Dmitriy Vasiliev on 01.10.2015.
 */
public class AccountDto {

    private String id;
    private String number;
    private String name;
    private String type;
    private String currency;
    private String description;
    private String userId;

    public AccountDto(){}

    public AccountDto(String number, String name, String type, String currency, String userId){
        this.number = number;
        this.name = name;
        this.type = type;
        this.currency = currency;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountDto)) return false;
        AccountDto that = (AccountDto) o;
        return Objects.equals(number, that.number) &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(description, that.description) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, type, currency, description, userId);
    }

}
