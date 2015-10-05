package com.helper.finance.model.mongodb;

import org.springframework.data.annotation.Id;

/**
 * Created by dvas on 01.10.2015.
 */
public class Account {

    @Id
    private String id;
    private String number;
    private String name;
    private String type;
    private String currency;
    private String userId;

    public Account(){}

    public Account(String number, String name, String type, String currency, String userId){
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        if (name != null ? !name.equals(account.name) : account.name != null) return false;
        if (type != null ? !type.equals(account.type) : account.type != null) return false;
        return !(currency != null ? !currency.equals(account.currency) : account.currency != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
