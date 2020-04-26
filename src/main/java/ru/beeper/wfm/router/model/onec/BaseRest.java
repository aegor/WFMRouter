package ru.beeper.wfm.router.model.onec;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public abstract class BaseRest {
    public int RequestId;
    public String EmployeeId1C;
    @JsonGetter("${onec.org.prefix}:Org")
    public String getOrg() {
        return org;
    }
    @JsonSetter("${onec.org.prefix}:Org")
    public void setOrg(String org) {
        this.org = org;
    }
    // TODO Может конфликтовать с сеттером Lombok
    private String org;
    public int Year;
    public int Month;
}
