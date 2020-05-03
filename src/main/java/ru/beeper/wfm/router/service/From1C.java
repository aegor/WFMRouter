package ru.beeper.wfm.router.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;
import ru.beeper.wfm.router.configuration.Servers;
import ru.beeper.wfm.router.configuration.Wfm;

@Service
@RequestScope
public class From1C {

    ObjectMapper mapper;
    Servers servers;
    RestTemplate http;

    public From1C(ObjectMapper mapper, Servers servers, RestTemplate http) {
        this.mapper = mapper;
        this.servers = servers;
        this.http = http;
    }

    public ResponseEntity<String> getRequestFrom1C(String json, String reqIpAddr, String endpoint) throws JsonProcessingException {
        Wfm wfm = servers.getWfmServer();
        final ObjectNode node = mapper.readValue(json, ObjectNode.class);
        if (node.isEmpty()) return new ResponseEntity("{\"error\": \"Empty JSON\"}", HttpStatus.NOT_FOUND);
        if (!node.has("EmployeeSourceId")) node.set("EmployeeSourceId",
                new IntNode(servers.getEmployeeSourceIdByIp(reqIpAddr)));
        HttpEntity<String> request = new HttpEntity<>(mapper.writeValueAsString(node), wfm.getCredentials());

        return http.exchange(wfm.getServer().get("url")+endpoint, HttpMethod.POST, request, String.class);
    }
}
