package com.novopay.repository.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.novopay.tables.TransactionPartyTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = TransactionPartyTable.NAME)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionPartyEntity {

  @Id
  @Column(name = TransactionPartyTable.Column.TRANSACTION_REFERENCE_ID)
  private String transactionReferenceId;
  @Column(name = TransactionPartyTable.Column.CREDITOR_ID)
  private Long creditorId;
  @Column(name = TransactionPartyTable.Column.DEBITOR_ID)
  private Long debitorId;

}
