package com.ordering.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  //ユーザーID
  private String id;

  //  ユーザー名
  private String name;

  //ユーザーの生年月日
  private String birthday;

  //  ユーザーの生年月日
  private char gender;

  //ユーザーのパスワード
  private String pass;

  //  作成者
  private String createdBy;

  //  作成日時
  private String createdAt;

  //  更新者
  private String updatedBy;

  //  更新日時
  private String updatedAt;

  //  削除者
  private String deletedBy;

  //  削除日時
  private String deletedAt;

}
