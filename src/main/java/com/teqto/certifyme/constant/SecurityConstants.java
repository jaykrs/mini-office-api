package com.teqto.certifyme.constant;

public class SecurityConstants {
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/user/signup";
    public static final String SWAGGER_UI = "/swagger-ui";
    
    public static final String DEFAULT_USERROLE = "GUEST";
}
