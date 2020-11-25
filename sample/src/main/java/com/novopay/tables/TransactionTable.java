package com.novopay.tables;

public interface TransactionTable {

  String NAME = "TRANSACTION_TBL";

  interface Column {
    String transactionId      = "TRANSACTION_ID";
    String transactionRefId   = "TRANSACTION_REF_ID";
    String transactionSum     = "TRANSACTION_SUM";
    String transactionCharges = "TRANSACTION_CHARGES";
    String transactionDate    = "TRANSACTION_DATE";
  }
}
