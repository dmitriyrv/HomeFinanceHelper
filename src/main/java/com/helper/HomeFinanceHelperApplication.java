package com.helper;

import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.helper.auth.HelperAuthorizer;
import com.helper.auth.HelperOAuthAuthenticator;
import com.helper.core.User;
import com.helper.resources.AccountResource;
import com.helper.resources.CurrencyResource;
import com.helper.service.AccountService;
import com.helper.service.CurrencyService;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.oauth.OAuthCredentialAuthFilter;
import io.dropwizard.jdbi.bundles.DBIExceptionsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import java.io.IOException;
import java.io.Reader;

public class HomeFinanceHelperApplication extends Application<HomeFinanceHelperConfiguration> {
    
    public static void main (final String[] args) throws Exception {
        new HomeFinanceHelperApplication().run(args);
    }
    
    @Override
    public String getName () {
        return "HomeFinanceHelper";
    }
    
    @Override
    public void initialize (final Bootstrap<HomeFinanceHelperConfiguration> bootstrap) {
        
        bootstrap.addBundle(new DBIExceptionsBundle());
        bootstrap.getObjectMapper().registerModule(new GuavaModule());
        
    }
    
    @Override
    public void run (final HomeFinanceHelperConfiguration configuration,
                     final Environment environment) throws ClassNotFoundException {
        
        final SqlSessionFactory sessionFactory = getSqlSessionFactory();
        final CurrencyService currencyService = new CurrencyService(sessionFactory);
        final AccountService accountService = new AccountService(sessionFactory);
        
        /*
        *Add resources
         */
        environment.jersey().register(new CurrencyResource(currencyService));
        environment.jersey().register(new AccountResource(accountService));
        /*environment.jersey().register(new AuthDynamicFeature(
                new OAuthCredentialAuthFilter.Builder<User>()
                        .setAuthenticator(new HelperOAuthAuthenticator())
                        .setAuthorizer(new HelperAuthorizer())
                        .setPrefix("Bearer")
                        .buildAuthFilter()));
        
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));*/
        
    }
    
    private SqlSessionFactory getSqlSessionFactory () {
        Reader reader;
        try {
            reader = Resources.getResourceAsReader("MyBatisConfig.xml");
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return new SqlSessionFactoryBuilder().build(reader);
    }
    
}
