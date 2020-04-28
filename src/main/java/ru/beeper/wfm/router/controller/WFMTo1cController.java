package ru.beeper.wfm.router.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.beeper.wfm.router.configuration.Servers;
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


//  TODO  authenticator basic auth


    @PostMapping("/PlanCreateOrUpdate")
    public ResponseEntity<PlanCreateOrUpdate> planCreateOrUpdate
        (@RequestBody PlanCreateOrUpdate planCreateOrUpdate) {
        return service.planCreateOrUpdate(planCreateOrUpdate);
    };


    @PostMapping("/PlanDelete")
    public ResponseEntity<PlanDelete> planDelete
        (@RequestBody PlanDelete planDelete) {
        return service.planDelete(planDelete);
    }


    @PostMapping("/TimeSheetCreateOrUpdate")
    public ResponseEntity<TimeSheetCreateOrUpdate> timeSheetCreateOrUpdate
        (@RequestBody TimeSheetCreateOrUpdate timeSheetCreateOrUpdate) {
        return service.timeSheetCreateOrUpdate(timeSheetCreateOrUpdate);
    }
}
