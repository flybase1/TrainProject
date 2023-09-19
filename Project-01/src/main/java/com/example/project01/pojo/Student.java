package com.example.project01.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel( "学生实体类" )
public class Student {
    @ApiModelProperty( "学生id" )
    @TableId( "id" )
    private Integer id;
    @ApiModelProperty( "学生姓名" )
    private String name;
}
