package ru.beeper.wfm.router.service;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;
import ru.beeper.wfm.router.configuration.Servers;
import ru.beeper.wfm.router.model.onec.PlanCreateOrUpdate;
import ru.beeper.wfm.router.model.onec.PlanDelete;
import ru.beeper.wfm.router.model.onec.TimeSheetCreateOrUpdate;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;


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



    public void planCreateOrUpdate(PlanCreateOrUpdate obj){
        HashMap<String,String> server = servers.getServerByEmployeeSourceId(obj.EmployeeSourceId);
        System.out.println();
//        http.exchange
//                (uri, HttpMethod.POST, new HttpEntity<String>(getCredentials(props.login, password)), obj);
    };
    public void planDelete(PlanDelete obj){

    };
    public void timesheetCreateOrUpdate(TimeSheetCreateOrUpdate obj){

    };


}
