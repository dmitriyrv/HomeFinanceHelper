package com.helper.mappers;

import com.helper.core.Currency;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dvas on 27.10.2016.
 */
public class CurrencyMapper implements ResultSetMapper<Currency>{
    @Override
    public Currency map (int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        
        Currency currency = new Currency();
        currency.setId(resultSet.getInt("id"));
        currency.setUserId(resultSet.getInt("user_id"));
        currency.setShortName(resultSet.getString("short_name"));
        currency.setFullName(resultSet.getString("full_name"));
        currency.setPrimaryCurrencyId(resultSet.getInt("primary_curr_id"));
        currency.setRateToPrimary(resultSet.getInt("rate_to_primary"));
        
        return currency;
        
    }
}
