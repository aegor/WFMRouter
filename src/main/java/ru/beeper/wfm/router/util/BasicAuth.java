package ru.beeper.wfm.router.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpHeaders;

import java.nio.charset.StandardCharsets;

public class BasicAuth implements Auth{

    public HttpHeaders makeCredentials(String login, String password) {
        return new HttpHeaders(){{
            String auth = login + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(StandardCharsets.UTF_8) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
            set("Content-type", "application/json");
        }};
    }
}
