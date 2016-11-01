package com.helper.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by dvas on 31.10.2016.
 */
public class MyBatisUtil {
    private static SqlSessionFactory factory;
    
    private MyBatisUtil(){}
    
    static {
        Reader reader = null;
        try{
            reader = Resources.getResourceAsReader("MyBatisConfig.xml");
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        factory = new SqlSessionFactoryBuilder().build(reader);
    }
    
    public static SqlSessionFactory getSqlSessionFactory(){
        return factory;
    }
}
