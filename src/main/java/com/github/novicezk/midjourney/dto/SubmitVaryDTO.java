package com.github.novicezk.midjourney.dto;

import com.github.novicezk.midjourney.enums.TaskAction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Zoom提交参数")
public class SubmitVaryDTO extends BaseSubmitDTO{

    @ApiModelProperty(value = "任务ID", required = true, example = "\"1320098173412546\"")
    private String taskId;

    @ApiModelProperty(value = "VARY_HIGH(强) ; VARY_LOW(弱)", required = true,
            allowableValues = "VARY_HIGH,VARY_LOW", example = "VARY_LOW")
    private TaskAction action;




}
