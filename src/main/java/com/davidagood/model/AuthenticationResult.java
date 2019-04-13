package com.davidagood.model;

public class AuthenticationResult {
    private boolean success;
    private AuthenticatedUser authenticatedUser;

    public AuthenticationResult(boolean success, AuthenticatedUser authenticatedUser) {
        this.success = success;
        this.authenticatedUser = authenticatedUser;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public AuthenticatedUser getAuthenticatedUser() {
        return authenticatedUser;
    }

    public void setAuthenticatedUser(AuthenticatedUser authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
    }
}
