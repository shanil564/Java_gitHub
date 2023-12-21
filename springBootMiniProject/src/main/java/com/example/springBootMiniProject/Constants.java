package com.example.springBootMiniProject;

public class Constants {
    public static final String JWT_TOKEN_PREFIX_FOR_AUTHENTICATION = "Bearer ";
    public static final String JWT_HEADER_FOR_AUTHENTICATION = "Authorization";
    public static final String JWT_SECRET_KEY = "${jwt.secret}";
    public static final String USER_PATH= "/users";

    public static final String BOOK= "book";
    public static final String USER_ID= "userId";
    public static final String BORROW= "borrow";

    public static final String PATH_VARIABLE_ID = "/{id}";

    public static final String ID = "id";

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String PATH = "/";
    public static final String SWAGGER = "/swagger**";
    public static final String PERMIT_ALL_PATH = "/**";
    public static final String ROLES = "/roles";
    public static final String AUTHORITIES_PATH = "/authorities";
    public static final String AUTHORITY = "authority";
    public static final String LOGIN = "/login";
    public static final String BORROW_BOOK_PATH = "/borrowBook";
    public static final String RETURN_BOOK_PATH = "/returnBook";
    public static final String CHECKBOOK_PATH = "/checkbook";
    public static final String MSG_BORROW = "book borrowed";
    public static final String MSG_RETURNED = "returned";
    public static final String MSG_ADDED = "added";
    public static final String MSG_DELETED = "deleted";
    public static final String MSG_UPDATED = "updated";

    public static final String MSG_NOT_EXISTS = "it doesn't exist";
    public static final String ROLE_NAME = "roleName";
    public static final String ROLE = "role";
    public static final String AUTHORITY_LIST = "authorityList";
    public static final String APPLICATION_USER = "applicationUser";
    public static final String BOOK_PATH = "/book";
    public static final String ROLE_ID = "role_id";
    public static final String HAS_AUTHORITY_READ = "hasAuthority('READ')";
    public static final String HAS_AUTHORITY_WRITE = "hasAuthority('WRITE')";
    public static final String HAS_AUTHORITY_DELETE = "hasAuthority('DELETE')";
    public static final String HAS_AUTHORITY_UPDATE = "hasAuthority('UPDATE')";
    public static final int SEVEN = 7;
    public static final String DUPLICATE_EXCEPTION_MSG = "User name already exists";
    public static final String BOOK_NOT_FOUND_EXCEPTION_MSG = "book already borrowed";
    public static final String RECORD_NOT_FOUND_EXCEPTION_MSG = "No Such user existing";
    public static final String BOOK_RETURNED_EXCEPTION_MSG = "you already returned";
    public static final String INVALID_USER_EXCEPTION_MSG = "Invalid credentials";
    public static final String INVALID_DATE_EXCEPTION_MSG = "Invalid Date";
    public static final String INVALID_USER_USERNAME_EXCEPTION_MSG = "Username not found";
    public static final int TOKEN_VALIDITY = 1000 * 60 * 60 * 10;
    public static final int ONE = 1;
    public static final int ZERO = 0;
}

