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
        ResponseEntity<PlanCreateOrUpdate> response = service.planCreateOrUpdate(planCreateOrUpdate);
        return response;
    };


    @PostMapping("/PlanDelete")
    public ResponseEntity<PlanDelete> planDelete
        (@RequestBody PlanDelete planDelete) {
        ResponseEntity<PlanDelete> response = service.planDelete(planDelete);
        return response;
    }


    @PostMapping("/TimeSheetCreateOrUpdate")
    public ResponseEntity<TimeSheetCreateOrUpdate> timeSheetCreateOrUpdate
        (@RequestBody TimeSheetCreateOrUpdate timeSheetCreateOrUpdate) {
        ResponseEntity<TimeSheetCreateOrUpdate> response = service.timeSheetCreateOrUpdate(timeSheetCreateOrUpdate);
        return response;
    }
}
