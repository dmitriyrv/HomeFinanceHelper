package com.helper.core;

/**
 * Created by dvas on 07.11.2016.
 */
public class Account {
    private int accountId;
    private Currency currency;
    private int typeId;
    private String name;
    
    public Account (int accountId, Currency currency, int typeId, String name) {
        this.accountId = accountId;
        this.currency = currency;
        this.typeId = typeId;
        this.name = name;
    }
    
    public Account () {
    }
    
    public int getAccountId () {
        return accountId;
    }
    
    public void setAccountId (int accountId) {
        this.accountId = accountId;
    }
    
    public Currency getCurrency () {
        return currency;
    }
    
    public void setCurrency (Currency currency) {
        this.currency = currency;
    }
    
    public int getTypeId () {
        return typeId;
    }
    
    public void setTypeId (int typeId) {
        this.typeId = typeId;
    }
    
    public String getName () {
        return name;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Account account = (Account) o;
        
        if (accountId != account.accountId) return false;
        if (typeId != account.typeId) return false;
        if (!currency.equals(account.currency)) return false;
        return name.equals(account.name);
    
    }
    
    @Override
    public int hashCode () {
        int result = accountId;
        result = 31 * result + currency.hashCode();
        result = 31 * result + typeId;
        result = 31 * result + name.hashCode();
        return result;
    }
}
