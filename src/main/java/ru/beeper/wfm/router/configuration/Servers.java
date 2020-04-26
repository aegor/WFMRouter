package ru.beeper.wfm.router.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@ConfigurationProperties(prefix="zup")
public class Servers {

      HashMap<Integer, HashMap<String, String>> serverMap = new HashMap<>();

      @Getter @Setter private ArrayList<HashMap<String, String>> servers = new ArrayList<>();

      @Getter @Setter private HashMap<String, Integer> employeeSourceId = new HashMap<>();

      @PostConstruct private void cachingData(){
            // TODO config validation
            servers.forEach(s -> serverMap.put(employeeSourceId.get(s.get("employee-source-id")), s));
      }

      public HashMap<String, String> getServerByEmployeeSourceId(int id){
            return serverMap.get(id);
      }
}


