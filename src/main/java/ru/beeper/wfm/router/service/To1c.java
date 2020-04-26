package ru.beeper.wfm.router.service;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;
import ru.beeper.wfm.router.configuration.Servers;
import ru.beeper.wfm.router.model.onec.BaseRest;
import ru.beeper.wfm.router.model.onec.PlanCreateOrUpdate;
import ru.beeper.wfm.router.model.onec.PlanDelete;
import ru.beeper.wfm.router.model.onec.TimeSheetCreateOrUpdate;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import static org.springframework.http.ResponseEntity.badRequest;


@Service
@RequestScope
public class To1c {

    Servers servers;
    RestTemplate http;

    public To1c(Servers servers, RestTemplate http){
        this.servers = servers;
        this.http = http;
    }

    HttpHeaders getCredentials(String login, String password){
        return new HttpHeaders(){{
            String auth = login + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(StandardCharsets.UTF_8) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
        }};
    }

    public boolean serverConfigVerificator(BaseRest obj){
        HashMap<String,String> server = servers.getServerByEmployeeSourceId(obj.EmployeeSourceId);
        if (server == null || server.get("url") == null || server.get("login") == null || server.get("password") == null) {
            // TODO feedback to http response, submitted by Alexander Ubiyvovk
            // ("Мы не нашли сервера с EmployeeSourceId = %s", obj.EmployeeSourceId)
        return false;
        }
        else return true;
    }

    public ResponseEntity<PlanCreateOrUpdate> planCreateOrUpdate(PlanCreateOrUpdate obj){

        HashMap<String,String> server = servers.getServerByEmployeeSourceId(obj.EmployeeSourceId);
        if (serverConfigVerificator(obj)) {
            HttpEntity<PlanCreateOrUpdate> request =
                    new HttpEntity<PlanCreateOrUpdate>(obj, getCredentials(server.get("login"), server.get("password")));
            ResponseEntity<PlanCreateOrUpdate> response = http.exchange(server.get("url"), HttpMethod.POST, request, PlanCreateOrUpdate.class);
            return response;
        }
        else {
            return new ResponseEntity<PlanCreateOrUpdate>(HttpStatus.NOT_FOUND);
        }
    };
    public ResponseEntity<PlanDelete> planDelete(PlanDelete obj){
        HashMap<String,String> server = servers.getServerByEmployeeSourceId(obj.EmployeeSourceId);
        if (serverConfigVerificator(obj)) {
            HttpEntity<PlanDelete> request =
                    new HttpEntity<PlanDelete>(obj, getCredentials(server.get("login"), server.get("password")));
            ResponseEntity<PlanDelete> response = http.exchange(server.get("url"), HttpMethod.POST, request, PlanDelete.class);
            return response;
        }
        else {
            return new ResponseEntity<PlanDelete>(HttpStatus.NOT_FOUND);
        }

    };
    public ResponseEntity<TimeSheetCreateOrUpdate> timeSheetCreateOrUpdate(TimeSheetCreateOrUpdate obj){
        HashMap<String,String> server = servers.getServerByEmployeeSourceId(obj.EmployeeSourceId);
        if (serverConfigVerificator(obj)) {
            HttpEntity<TimeSheetCreateOrUpdate> request =
                    new HttpEntity<TimeSheetCreateOrUpdate>(obj, getCredentials(server.get("login"), server.get("password")));
            ResponseEntity<TimeSheetCreateOrUpdate> response = http.exchange(server.get("url"), HttpMethod.POST, request, TimeSheetCreateOrUpdate.class);
            return response;
        }
        else {
            return new ResponseEntity<TimeSheetCreateOrUpdate>(HttpStatus.NOT_FOUND);
        }
    };


}
