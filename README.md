# Email verification 

## Dependencies used:

* ### Spring Mail
* ### Spring Security
* ### Spring Data JPA
* ### MYSQL

## Process :
    1. User will send a registeration body at "/register" URI 
    2. Server will store the user in the database
    3. Server will send a verification link to the registered email address of the user
    4. When user clicks on the link from the email sent, user will look up and set verified to true.
