package com.helper.resources;

import com.codahale.metrics.annotation.Timed;
import com.helper.core.Account;
import com.helper.service.AccountService;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by dvas on 08.11.2016.
 */
@Path("/acc")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class AccountResource {
    
    private final AccountService accountService;
    
    public AccountResource(AccountService accountService){
        this.accountService = accountService;
    }
    
    @GET
    @Path("/get/{id}")
    @Timed
    @UnitOfWork
    public Account getById(@PathParam("id") int id){
        return accountService.getAccount(id);
    }
    
    @POST
    @Path("/add")
    @Timed
    @UnitOfWork
    public Account createAccount(Account newAccount){
        return accountService.insertAccount(newAccount);
    }
}
