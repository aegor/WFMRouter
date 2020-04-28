package ru.beeper.wfm.router.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import ru.beeper.wfm.router.util.Auth;
import ru.beeper.wfm.router.util.BasicAuth;

@ConfigurationProperties(prefix="zup")
public class Servers {

      Auth auth = new BasicAuth();

      private HashMap<Integer, HashMap<String, String>> serverMap = new HashMap<>();
      private HashMap<Integer, HttpHeaders> credentials = new HashMap<>();

      @Getter @Setter private ArrayList<HashMap<String, String>> servers = new ArrayList<>();

      @Getter @Setter private HashMap<String, Integer> employeeSourceId = new HashMap<>();

      @PostConstruct private void cachingVerifyingData(){
            // TODO config validation
            servers.forEach(s -> {
                  int index = employeeSourceId.get(s.get("employee-source-id"));
                  credentials.put(index, auth.makeCredentials(s.get("login"), s.get("password")));
                  serverMap.put(index, s);
            });
      }

      public HashMap<String, String> getServerByEmployeeSourceId(int id){
            return serverMap.get(id);
      }

      public HttpHeaders getCredentialsByEmployeeSourceId(int id){
            return credentials.get(id);
      }
}


