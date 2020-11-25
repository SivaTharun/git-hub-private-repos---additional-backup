package com.novopay.repository.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.novopay.tables.TransactionPartyTable;
import com.novopay.tables.TransactionTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = TransactionTable.NAME)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {

  @Id
  @Column(name = TransactionTable.Column.transactionId)
  private Long transactionId;
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = TransactionPartyTable.Column.TRANSACTION_REFERENCE_ID, nullable = false)
  private TransactionPartyEntity transactionPartyEntity;
  @Column(name = TransactionTable.Column.transactionSum)
  private Double transactionSum;
  @Column(name = TransactionTable.Column.transactionCharges)
  private Double transactionCharges;
  @Column(name = TransactionTable.Column.transactionDate)
  private LocalDate transactionDate;

}
