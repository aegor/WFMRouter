package ru.beeper.wfm.router.model.onec;

import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class TimeSheetCreateOrUpdate extends BaseRest implements Serializable {

    @Getter @Setter private List<timesheet> Timesheet;
    @Getter @Setter private overtime OverTime;
}
