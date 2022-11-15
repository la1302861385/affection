package com.li.affection.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  @TableId(type = IdType.AUTO)
  private Long id;
  private String userName;
  private String password;
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date modifyTime;
  @Version
  private long version;
  @TableLogic
  private long deleted;
  private String jurisdiction;
  @TableField(exist = false)
  private String VerificationCode;

}
