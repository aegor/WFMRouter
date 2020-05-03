package ru.beeper.wfm.router.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpHeaders;

import java.util.HashMap;

@ConfigurationProperties(prefix="wfm")
public class Wfm {

    @Getter @Setter private HashMap<String, String> server = new HashMap<>();

    @Getter @Setter private HashMap<String, String> requestLogger = new HashMap<>();

    @Getter @Setter private HttpHeaders credentials;
}
