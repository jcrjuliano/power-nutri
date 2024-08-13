package com.powershot.power_nutri.domain.enums;

import java.util.List;

public enum DaysOfWeekEnum {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public static DaysOfWeekEnum getValue(String day) {
        for (DaysOfWeekEnum d : DaysOfWeekEnum.values()) {
            if (d.toString().equalsIgnoreCase(day)) {
                return d;
            }
        }
        return null;
    }

}
