package ru.beeper.wfm.router.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix="zup")
public class Servers {
      @Getter @Setter
      private ArrayList<HashMap<String, String>> servers = new ArrayList<>();

      @Getter @Setter
      private HashMap<String, Integer> employeeSourceId = new HashMap<>();

      @PostConstruct
      private void cacheData(){

      }

      public что-то getServerByEmployeeSourceId(int id){
            return что-то
      }

}


