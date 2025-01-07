package com.kelsonq.shortlink.admin.dao.entity;

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
  private Date createTime;

  /**
   * Update Time
   */
  private Date updateTime;

  /**
   * Delete Flag 0: Exist 1: Delete
   */
  private Integer delFlag;
}
