package com.hackerrank.stocktrade.repository.table;

public interface UserTable {
  String NAME = "user_tbl";

  interface Column {
    String ID   = "id";
    String NAME = "name";
  }
}
