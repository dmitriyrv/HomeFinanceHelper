package com.helper.db.typehandlers;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by dvas on 22.11.2016.
 */
public class LocalDateTimeTypeHandler implements TypeHandler<LocalDateTime> {
    
    private final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    
    @Override
    public void setParameter (PreparedStatement preparedStatement, int i, LocalDateTime localDateTime, JdbcType jdbcType) throws SQLException {
        String dateTimeString = localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        
        preparedStatement.setString(i, dateTimeString);
    }
    
    @Override
    public LocalDateTime getResult (ResultSet resultSet, String s) throws SQLException {
        
        return LocalDateTime.parse(resultSet.getString(s), DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
    }
    
    @Override
    public LocalDateTime getResult (ResultSet resultSet, int i) throws SQLException {
        return LocalDateTime.parse(resultSet.getString(i), DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
    }
    
    @Override
    public LocalDateTime getResult (CallableStatement callableStatement, int i) throws SQLException {
        return LocalDateTime.parse(callableStatement.getString(i), DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
    }
}
