package com.helper.db;

import com.helper.core.Currency;
import com.helper.mappers.CurrencyMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Created by dvas on 27.10.2016.
 */
@RegisterMapper(CurrencyMapper.class)
public interface CurrencyDao {
    
    @SqlUpdate("")
    void create(@BindBean Currency currency);
    
    @SqlQuery("SELECT id, user_id, short_name, full_name, primary_curr_id, rate_to_primary FROM currencies where id = :id;")
    Currency retrieve(@Bind("id") String id);
}
