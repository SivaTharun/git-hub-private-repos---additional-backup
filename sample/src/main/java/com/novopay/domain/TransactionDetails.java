package com.novopay.domain;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TransactionDetails {

  private Long      transactionId;
  private Long      creditorId;
  private Long      debitorId;
  private Double    transactionSum;
  private Double    transactionCharges;
  private LocalDate transactionDate;

}
