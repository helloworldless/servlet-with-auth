package com.davidagood.service;

import com.davidagood.model.AuthenticatedUser;
import com.davidagood.model.AuthenticationResult;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Objects.nonNull;

public class AuthService {

    private static final List<AuthenticatedUser> authenticatedUsers = Arrays.asList(new AuthenticatedUser("loretta", "111222333"));

    private static AuthenticationResult buildAuthenticationResult(Predicate<AuthenticatedUser> predicate) {
        AuthenticatedUser authenticatedUser = authenticatedUsers.stream()
                .filter(predicate)
                .findAny()
                .orElse(null);

        return new AuthenticationResult(nonNull(authenticatedUser), authenticatedUser);
    }

    public AuthenticationResult authenticate(final String userName) {
        return buildAuthenticationResult(user -> user.getUserName().equals(userName));
    }

    public AuthenticationResult checkAuthenticated(final String token) {
        return buildAuthenticationResult(user -> user.getToken().equals(token));
    }
}
