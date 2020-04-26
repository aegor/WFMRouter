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
    Servers props;

    WFMTo1cController(To1c service, Servers props){
        this.service = service;
        this.props = props;
    }
    // Тут произойдёт одно из двух исключений: либо поля org в JSON вообще нет, либо его значение не совпадает со значением, указанным в конфигурации
    // Возможно ещё одно исключение при сериализации объекта, если имя поля org не совпадёт с именем, указанным в конфигурации в onec.org.prefix
    void validate(BaseRest obj){
/*        if((obj.org != props.orgNameIk) || (obj.org != props.orgNameKt))
            throw new IllegalArgumentException(String.format("Invalid org value, %s != %s", obj.org, props.orgPrefix))*/;
    }


//    authenticator // basic auth

    @PostMapping("/PlanCreateOrUpdate")
    public String planCreateOrUpdate
        (@RequestBody PlanCreateOrUpdate planCreateOrUpdate) {
        validate(planCreateOrUpdate);
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
