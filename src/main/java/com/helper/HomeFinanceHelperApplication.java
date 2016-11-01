package com.helper;

import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.helper.resources.CurrencyResource;
import com.helper.service.CurrencyService;
import io.dropwizard.Application;
import io.dropwizard.jdbi.bundles.DBIExceptionsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HomeFinanceHelperApplication extends Application<HomeFinanceHelperConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HomeFinanceHelperApplication().run(args);
    }

    @Override
    public String getName() {
        return "HomeFinanceHelper";
    }

    @Override
    public void initialize(final Bootstrap<HomeFinanceHelperConfiguration> bootstrap) {
        
        bootstrap.addBundle(new DBIExceptionsBundle());
        bootstrap.getObjectMapper().registerModule(new GuavaModule());
        
    }

    @Override
    public void run(final HomeFinanceHelperConfiguration configuration,
                    final Environment environment) throws ClassNotFoundException {
        
        
        final CurrencyService currencyService = new CurrencyService();
        
        /*
        *Add resources
         */
        environment.jersey().register(new CurrencyResource(currencyService));
    
    }

}
