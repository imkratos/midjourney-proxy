package com.github.novicezk.midjourney.dto;

import com.github.novicezk.midjourney.enums.TaskAction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Zoom提交参数")
public class SubmitZoomDTO extends BaseSubmitDTO{

    @ApiModelProperty(value = "任务ID", required = true, example = "\"1320098173412546\"")
    private String taskId;

    @ApiModelProperty(value = "ZOOM_1(缩放1.5X) ; ZOOM_2(缩放2)", required = true,
            allowableValues = "ZOOM_1,ZOOM_2", example = "ZOOM_1")
    private TaskAction action;




}
