package ru.beeper.wfm.router.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import ru.beeper.wfm.router.configuration.Servers;
import ru.beeper.wfm.router.service.From1C;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class OneCToWfmController {

    private From1C service;
    private Servers servers;

    public OneCToWfmController(From1C service, Servers servers) {
        this.service = service; this.servers = servers;
    }
// GetRequestFrom1C GetRequestResultFrom1C
    @PostMapping("/{wfmId}/{wfmReq}")
    public HttpEntity<String> getRequestFrom1C(@RequestBody String json, HttpServletRequest request, @PathVariable String wfmId, @PathVariable String wfmReq) throws JsonProcessingException {
        return service.getRequestFrom1C(json, request.getRemoteAddr(), wfmId, wfmReq);
    }

/*    @PostMapping("/GetRequestResultFrom1C")
    public HttpEntity<String> getRequestResultFrom1C(@RequestBody String json, HttpServletRequest request) throws JsonProcessingException {
        return service.getRequestFrom1C(json, request.getRemoteAddr(), "GetRequestResultFrom1C");
    }*/
}
