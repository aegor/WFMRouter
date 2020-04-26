package ru.beeper.wfm.router.model.onec;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class plan implements Serializable {
    @Getter @Setter private int Day;
    @Getter @Setter private int Minutes;
    @Getter @Setter private int NightMinutes;
}
