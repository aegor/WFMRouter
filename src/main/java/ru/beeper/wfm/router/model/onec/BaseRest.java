package ru.beeper.wfm.router.model.onec;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

//@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
//@AllArgsConstructor
public abstract class BaseRest {

    @Getter @Setter private int RequestId;
    @Getter @Setter private String EmployeeId1C;
    @Getter @Setter private int EmployeeSourceId;
    @Getter @Setter private int Year;
    @Getter @Setter private int Month;
}
