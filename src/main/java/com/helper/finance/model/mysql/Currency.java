package com.helper.finance.model.mysql;

import javax.persistence.*;

/**
 * Created by Dmitriy Vasiliev on 13.10.2015.
 */

@Entity
@Table(name = "currencies", catalog = "financehelper", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")})
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    //@OneToMany(cascade = CascadeType.ALL)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "primary_curr_id")
    private Integer primaryCurrencyId;

    @Column(name = "rate_to_primary")
    private Float rateToPrimary;

    public Currency(){}

    public Currency(Integer id, Integer userId, String shortName, String fullName, Integer primaryCurrencyId, Float rateToPrimary) {
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
