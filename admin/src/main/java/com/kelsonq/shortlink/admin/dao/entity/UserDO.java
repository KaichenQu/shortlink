package com.kelsonq.shortlink.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * User Entity
 */
@Data
@TableName("t_user")
public class UserDO {

  /**
   * ID
   */
  private Long id;

  /**
   * Username
   */
  private String username;

  /**
   * Password
   */
  private String password;

  /**
   * Real Name
   */
  private String realName;

  /**
   * Mobile Phone
   */
  private String phone;

  /**
   * Mail
   */
  private String mail;

  /**
   * Delete Time Stamp
   */
  private Long deletionTime;

  /**
   * Create Time
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;

  /**
   * Update Time
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)

  private Date updateTime;

  /**
   * Delete Flag 0: Exist 1: Delete
   */
  @TableField(fill = FieldFill.INSERT)
  private Integer delFlag;
}
