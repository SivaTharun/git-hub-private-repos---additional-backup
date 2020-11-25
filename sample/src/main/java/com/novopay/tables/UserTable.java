package com.novopay.tables;

public interface UserTable {

  String NAME = "USER_DET";

  interface Column {
    String USER_ID               = "USER_ID";
    String USER_NAME             = "USER_NAME";
    String USER_LOGGED_IN        = "USER_LOGGED_IN";
    String BALANCE               = "BALANCE";
    String ACCOUNT_CREATION_DATE = "ACCOUNT_CREATION_DATE";
    String ACCOUNT_UPDATE_DATE   = "ACCOUNT_UPDATE_DATE";
  }
}
