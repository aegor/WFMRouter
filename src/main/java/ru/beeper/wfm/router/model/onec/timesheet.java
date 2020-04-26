package ru.beeper.wfm.router.model.onec;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class timesheet implements Serializable {
    @Getter @Setter private int TimePinTypeId;
    @Getter @Setter private int Day;
    @Getter @Setter private int Minutes;
    @Getter @Setter private int NightMinutes;
}
