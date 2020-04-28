package ru.beeper.wfm.router.util;

import org.springframework.http.HttpHeaders;

public interface Auth {
    public HttpHeaders makeCredentials(String login, String password);
}
