package com.helper.auth;

import com.helper.core.User;
import io.dropwizard.auth.Authorizer;

/**
 * Created by dvas on 18.11.2016.
 */
public class HelperAuthorizer implements Authorizer<User> {
    @Override
    public boolean authorize (User user, String s) {
        return false;
    }
}
