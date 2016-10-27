package com.helper;

import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.helper.db.CurrencyDao;
import com.helper.resources.CurrencyResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.jdbi.bundles.DBIExceptionsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

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
        /*bootstrap.addBundle(new MigrationsBundle<HomeFinanceHelperConfiguration>() {
            @Override
            public PooledDataSourceFactory getDataSourceFactory (HomeFinanceHelperConfiguration homeFinanceHelperConfiguration) {
                return homeFinanceHelperConfiguration.getDataSourceFactory();
            }
        });*/
        
        bootstrap.getObjectMapper().registerModule(new GuavaModule());
        
    }

    @Override
    public void run(final HomeFinanceHelperConfiguration configuration,
                    final Environment environment) throws ClassNotFoundException {
        
        /*
        *JDBI
         */
        final DBIFactory dbiFactory = new DBIFactory();
        final DBI dbi = dbiFactory.build(environment, configuration.getDataSourceFactory(), "mysql");
    
        /*
         *DAOs
         */
        final CurrencyDao currencyDao = dbi.onDemand(CurrencyDao.class);
        
        /*
        *Add resources
         */
        environment.jersey().register(new CurrencyResource(currencyDao));
    
    }

}
