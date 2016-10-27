package com.helper.resources;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.helper.core.Currency;
import com.helper.db.CurrencyDao;
import com.helper.exceptions.ResponseException;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by dvas on 27.10.2016.
 */
@Path("/curr")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CurrencyResource {
    
    private final CurrencyDao currencyDao;
    
    public CurrencyResource (CurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }
    
    @GET
    @Path("/{id}")
    @Timed
    @UnitOfWork
    @ExceptionMetered
    public Currency getCurrency(@PathParam("id") String id){
        
        Currency existingCurrency =currencyDao.retrieve(id);
        
        if (existingCurrency == null){
            ResponseException.formatAndThrow(Response.Status.NOT_FOUND, "Currency with id " + id + " does not exist");
        }
        
        return existingCurrency;
    }
    
}
