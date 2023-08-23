package com.github.novicezk.midjourney.dto;

import com.github.novicezk.midjourney.enums.TaskAction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Zoom提交参数")
public class SubmitMoveDTO extends BaseSubmitDTO{

    @ApiModelProperty(value = "任务ID", required = true, example = "\"1320098173412546\"")
    private String taskId;

    @ApiModelProperty(value = "MOVE_UP(上) ; MOVE_DOWN(下);MOVE_LEFT(左);MOVE_RIGHT(右)", required = true,
            allowableValues = "MOVE_UP,MOVE_DOWN,MOVE_LEFT,MOVE_RIGHT", example = "MOVE_RIGHT")
    private TaskAction action;




}
