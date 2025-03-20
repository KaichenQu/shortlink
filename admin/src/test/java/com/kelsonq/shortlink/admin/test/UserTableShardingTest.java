package com.kelsonq.shortlink.admin.test;

public class UserTableShardingTest {
  public static final String SQL = "CREATE TABLE `t_user%d` (\n"
      + "  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',\n"
      + "  `username` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'Username',\n"
      + "  `password` varchar(511) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'Password',\n"
      + "  `real_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'Real Name',\n"
      + "  `phone` varchar(127) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'Mobile Phone',\n"
      + "  `mail` varchar(511) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'Mail',\n"
      + "  `deletion_time` bigint DEFAULT NULL COMMENT 'Delete Time Stamp',\n"
      + "  `create_time` datetime DEFAULT NULL COMMENT 'Create Time',\n"
      + "  `update_time` datetime DEFAULT NULL COMMENT 'Update Time',\n"
      + "  `del_flag` tinyint(1) DEFAULT NULL COMMENT 'Delete Flag 0: Exist 1: Delete',\n"
      + "  PRIMARY KEY (`id`),\n"
      + "  UNIQUE KEY `idx_unique_username` (`username`) USING BTREE\n"
      + ") ENGINE=InnoDB AUTO_INCREMENT=1902645443272896514 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;";

  public static void main(String[] args) {
    for (int i = 0; i < 16; i++) {
      System.out.printf((SQL) + "%n", i);
    }
  }
}
