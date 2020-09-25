package ru.beeper.wfm.router.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import ru.beeper.wfm.router.util.Auth;
import ru.beeper.wfm.router.util.BasicAuth;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
* Facade for all WFMRouter configuration properties
* */
@ConfigurationProperties(prefix="zup")
public class Servers {

      Servers(Wfm wfm){
            this.wfm = wfm;
      }

      Auth auth = new BasicAuth();

      @Autowired
      private Environment e;
      private Wfm wfm;
      private HashMap<Integer, HashMap<String, String>> serverMap = new HashMap<>();
      private HashMap<Integer, HttpHeaders> credentials = new HashMap<>();

      @Getter @Setter private ArrayList<HashMap<String, String>> servers = new ArrayList<>();

      @Getter @Setter private HashMap<String, Integer> employeeSourceId = new HashMap<>();

      private Map<String, Integer> ipAddrMap = new HashMap<>();
      private Map<String, Integer> virtualWfmUrlMap = new HashMap<>();

      @PostConstruct private void cachingVerifyingData(){
            // TODO config validation
            if (servers.isEmpty()) throw new IllegalArgumentException("Bad config file");
            for (HashMap<String, String> s : servers) {
                  int index = employeeSourceId.get(s.get("employee-source-id"));
                  credentials.put(index, auth.makeCredentials(s.get("login"), s.get("password")));
                  serverMap.put(index, s);
                  try {
                        virtualWfmUrlMap.put(s.get("backurl"),index);
                        ipAddrMap.put(
                                InetAddress.getByName(new URL(s.get("url")).getHost()).getHostAddress(),
                                index);
                  } catch (UnknownHostException | MalformedURLException e){
                        e.printStackTrace();
                  }
                  this.wfm.setCredentials(auth.makeCredentials(this.wfm.getServer().get("login"), this.wfm.getServer().get("password")));
            }
      }

      public HashMap<String, String> getServerByEmployeeSourceId(int id){
            return serverMap.get(id);
      }

      public HttpHeaders getCredentialsByEmployeeSourceId(int id){
            return credentials.get(id);
      }

      public int getEmployeeSourceIdByIp(String iP){
            return ipAddrMap.get(iP);
      }

      public int getEmployeeSourceIdByUrl(String url){
            return virtualWfmUrlMap.get(url);
      }

      public Wfm getWfmServer(){
            return this.wfm;
      }
}


