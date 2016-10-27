package com.helper.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Created by dvas on 27.10.2016.
 */
public class ResponseException {
    
    public static void formatAndThrow(Response.Status status, String message){
        throw new WebApplicationException(Response.status(status).entity("{\"error\":\"" + message + "\"}").build());
    }
    
}
