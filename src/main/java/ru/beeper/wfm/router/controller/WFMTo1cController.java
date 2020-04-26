package ru.beeper.wfm.router.controller;

import org.springframework.web.bind.annotation.*;
import ru.beeper.wfm.router.configuration.Servers;
import ru.beeper.wfm.router.model.onec.BaseRest;
import ru.beeper.wfm.router.model.onec.PlanCreateOrUpdate;
import ru.beeper.wfm.router.model.onec.PlanDelete;
import ru.beeper.wfm.router.model.onec.TimeSheetCreateOrUpdate;
import ru.beeper.wfm.router.service.To1c;


@RestController
@RequestMapping("/")
public class WFMTo1cController {

    To1c service;
    Servers servers;

    WFMTo1cController(To1c service, Servers servers){
        this.service = service;
        this.servers = servers;
    }


//    authenticator // basic auth

    @PostMapping("/PlanCreateOrUpdate")
    public String planCreateOrUpdate
        (@RequestBody PlanCreateOrUpdate planCreateOrUpdate) {
        service.planCreateOrUpdate(planCreateOrUpdate);
        return "";
    };

    @PostMapping("/PlanDelete")
    public String planDelete
        (@RequestBody PlanDelete planDelete) {
        return "";
    }

    @PostMapping("/TimeSheetCreateOrUpdate")
    public String timeSheetCreateOrUpdate
        (@RequestBody TimeSheetCreateOrUpdate timeSheetCreateOrUpdate) {
        return "";
    }



}
