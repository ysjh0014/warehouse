package com.example.ys.Model;


import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data               /*注解在类上，为类提供读写属性*/
@ApiModel(value = "流转日志表")
public class user {
    /*@ApiModelProperty(value = "ID")
    private BigDecimal processinstid;

    @ApiModelProperty(value = "NAME")
    private String causeactdefname;

    @ApiModelProperty(value = "AGE")
    private BigDecimal processinstage;*/

    private Integer id;
    private String name;
    private Integer age;

}
