package com.hackerrank.stocktrade.repository.table;

public interface TradeTable {
  String NAME = "trade_tbl";

  interface Column {
    String ID        = "id";
    String TYPE      = "type";
    String USER_ID   = "user_id";
    String SYMBOL    = "symbol";
    String SHARES    = "shares";
    String PRICE     = "price";
    String TIMESTAMP = "timestamp";
  }
}
