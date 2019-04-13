# Servlet with Auth

App protected by simple authentication scheme (for learning purposes only!)

## About

1. Initially, the user browses to [/servlet-with-auth/app](http://localhost:8080/servlet-with-auth/)
1. The the app servlet checks for the existence of the a cookie named `simple_access_token`
1. If the cookie exists, it checks with `AuthService` if the cookie's value is valid
1. If the cookie is valid the user is forwarded to the app's homepage
1. If the cookie does exist but the `AuthService` tells us that it's invalid, we display and authorization error
1. Finally, if a cookie named `simple_access_token` does not exist, the user is redirect to the authentication form/page
1. The `AuthService` is configured with one username: `loretta`
1. Upon providing this username, a cookie named `simple_access_token` is added with the value `111222333` and an age of 60 seconds, and the servlet redirects the user to the app
1. If any other username is provided, the user is forwarded to an authentication failed page and offered the chance to try again

## Run Locally

1. Run `mvn tomcat7:run`
1. App starts at [http://localhost:8080/servlet-with-auth/](http://localhost:8080/servlet-with-auth/)