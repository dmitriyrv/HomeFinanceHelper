package com.helper.resources;

import com.codahale.metrics.annotation.Timed;
import com.helper.core.Currency;
import com.helper.service.CurrencyService;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by dvas on 27.10.2016.
 */
@Path("/curr")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CurrencyResource {
    
    
    private final CurrencyService currencyService;
    
    public CurrencyResource (CurrencyService currencyService) {
        
        this.currencyService = currencyService;
    }
    
    @POST
    @Path("/add")
    @Timed
    @UnitOfWork
    public void addCurrency(Currency currency){
        
        currencyService.insertCurrency(currency);
        
    }
    
    @GET
    @Path("/get/{id}")
    @Timed
    @UnitOfWork
    public Currency getById(@PathParam("id") int id){
        return currencyService.getCurrency(id);
    }
    
    @GET
    @Path("/get/all")
    @Timed
    @UnitOfWork
    public List<Currency> getCurrencies(){
        return currencyService.getAllCurrencies();
    }
    
}
