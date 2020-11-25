package com.hackerrank.stocktrade.repository.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.hackerrank.stocktrade.repository.table.UserTable;

@Entity
@Table(name = UserTable.NAME)
public class UserEntity {

  @Id
  @Column(name = UserTable.Column.ID)
  private Long userId;

  @Column(name = UserTable.Column.NAME)
  private String userName;

  @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
  private TradeEntity tradeEntity;

  public UserEntity() {
  }

  public UserEntity(Long userId, String userName) {
    this.userId = userId;
    this.userName = userName;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}
