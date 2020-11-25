package com.novopay.repository.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.novopay.tables.TransactionTable;
import com.novopay.tables.UserTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = UserTable.NAME)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

  @Id
  @Column(name = UserTable.Column.USER_ID)
  private Long      userId;
  @Column(name = UserTable.Column.USER_NAME)
  private String    userName;
  @Column(name = UserTable.Column.USER_LOGGED_IN)
  private String    userLoggedIn;
  @Column(name = UserTable.Column.BALANCE)
  private Double    accountBalance;
  @Column(name = UserTable.Column.ACCOUNT_CREATION_DATE)
  private LocalDate accountCreationDate;
  @Column(name = UserTable.Column.ACCOUNT_UPDATE_DATE)
  private LocalDate accountUpdateDate;

}
