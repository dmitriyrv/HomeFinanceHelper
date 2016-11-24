package com.helper.db.typehandlers;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by dvas on 21.11.2016.
 */
public class UuidTypeHandler implements TypeHandler<UUID> {
    @Override
    public void setParameter (PreparedStatement preparedStatement, int i, UUID token, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, token.toString());
    }
    
    @Override
    public UUID getResult (ResultSet resultSet, String s) throws SQLException {
        return UUID.fromString(resultSet.getString(s));
    }
    
    @Override
    public UUID getResult (ResultSet resultSet, int i) throws SQLException {
        return UUID.fromString(resultSet.getString(i));
    }
    
    @Override
    public UUID getResult (CallableStatement callableStatement, int i) throws SQLException {
        return UUID.fromString(callableStatement.getString(i));
    }
}
