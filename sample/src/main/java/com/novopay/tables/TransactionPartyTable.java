package com.novopay.tables;

public interface TransactionPartyTable {
  String NAME = "TRANSACTION_PARTY_TBL";

  interface Column {
    String TRANSACTION_REFERENCE_ID = "TRANSACTION_REFERENCE_ID";
    String CREDITOR_ID              = "CREDITOR_ID";
    String DEBITOR_ID               = "DEBITOR_ID";
  }
}
