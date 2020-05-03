package ru.beeper.wfm.router.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.beeper.wfm.router.model.onec.PlanCreateOrUpdate;
import ru.beeper.wfm.router.service.From1C;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class OneCToWfmController {

    private From1C service;

    public OneCToWfmController(From1C service) {
        this.service = service;
    }

    @PostMapping("/GetRequestFrom1C")
    public HttpEntity<String> getRequestFrom1C(@RequestBody String json, HttpServletRequest request) throws JsonProcessingException {
        return service.getRequestFrom1C(json, request.getRemoteAddr());
    }

    @PostMapping("/GetRequestResultFrom1C")
    public HttpEntity<String> getRequestResultFrom1C(@RequestBody String json, HttpServletRequest request) throws JsonProcessingException {
        return service.getRequestFrom1C(json, request.getRemoteAddr());
    }
}
