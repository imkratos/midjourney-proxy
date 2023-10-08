package com.github.novicezk.midjourney.dto;

import com.github.novicezk.midjourney.enums.SettingsEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel("设置属性")
public class SettingsDTO extends BaseSubmitDTO{


    @ApiModelProperty(value = "REMIX", required = true,
            allowableValues = "REMIX", example = "REMIX")
    private SettingsEnum attr;



}
