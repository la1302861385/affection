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
public class UserDetail {
  @TableId(type = IdType.AUTO)
  private Long id;
  @JsonIgnore
  private Long userId;
  private String nickName;
  private String workPlace;
  private Long income;
  private Long height;
  private String education;
  private String sex;
  private String isMarry;
  private Date birthday;
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
  private String profilePicture;

}
