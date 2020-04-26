package ru.beeper.wfm.router.model.onec;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public abstract class BaseRest {

    public int RequestId;
    public String EmployeeId1C;
    public int EmployeeSourceId;
    public int Year;
    public int Month;
}
