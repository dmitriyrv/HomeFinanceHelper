package com.helper.finance.model.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

/**
 * Created by Dmitriy Vasiliev on 01.10.2015. 
 */
@Document(collection = "account")
public class Account {

    @Id
    private String id;
    private String number;
    private String name;
    private String type;
    private String currency;
    private String description;
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
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(number, account.number) &&
                Objects.equals(name, account.name) &&
                Objects.equals(type, account.type) &&
                Objects.equals(currency, account.currency) &&
                Objects.equals(description, account.description) &&
                Objects.equals(userId, account.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, type, currency, description, userId);
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
