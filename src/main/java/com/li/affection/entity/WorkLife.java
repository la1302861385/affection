package com.li.affection.entity;


import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkLife {
  @TableId(type = IdType.AUTO)
  private Long id;
  @JsonIgnore
  private Long userId;
  private String occupation;
  private String houseSituation;
  private String isSmoking;
  private String isDrinking;
  @JsonIgnore
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  @JsonIgnore
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date modifyTime;
  @JsonIgnore
  @Version
  private Long version;
  @JsonIgnore
  @TableLogic
  private Long deleted;

}
