package com.github.novicezk.midjourney.enums;

import java.util.EnumSet;

public class EnumConstant {

    public static EnumSet<TaskAction> ACTION_RANGE = EnumSet.of(TaskAction.IMAGINE, TaskAction.VARIATION, TaskAction.REROLL, TaskAction.BLEND,

            TaskAction.ZOOM_1,TaskAction.ZOOM_2,TaskAction.MOVE_UP,TaskAction.MOVE_DOWN,TaskAction.MOVE_LEFT,TaskAction.MOVE_RIGHT,
            TaskAction.VARY_HIGH,TaskAction.VARY_LOW
            );
    public static EnumSet<TaskAction> MOVE_RANGE = EnumSet.of(TaskAction.MOVE_UP,TaskAction.MOVE_DOWN,TaskAction.MOVE_LEFT,TaskAction.MOVE_RIGHT);
}
