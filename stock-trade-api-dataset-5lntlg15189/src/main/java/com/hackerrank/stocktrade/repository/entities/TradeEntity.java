package com.hackerrank.stocktrade.repository.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.hackerrank.stocktrade.repository.table.TradeTable;

@Entity
@Table(name = TradeTable.NAME)
public class TradeEntity {

  @Id
  @Column(name = TradeTable.Column.ID)
  private Long       id;
  @Column(name = TradeTable.Column.TYPE)
  private String     type;
  @OneToOne
  @JoinColumn(name = TradeTable.Column.USER_ID)
  private UserEntity user;
  @Column(name = TradeTable.Column.SYMBOL)
  private String     symbol;
  @Column(name = TradeTable.Column.SHARES)
  private Integer    shares;
  @Column(name = TradeTable.Column.PRICE)
  private Float      price;
  @Column(name = TradeTable.Column.TIMESTAMP)
  private LocalDate  timestamp;

  public TradeEntity() {
  }

  public TradeEntity(Long id, String type, UserEntity user, String symbol, Integer shares, Float price, LocalDate timestamp) {
    this.id = id;
    this.type = type;
    this.user = user;
    this.symbol = symbol;
    this.shares = shares;
    this.price = price;
    this.timestamp = timestamp;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public Integer getShares() {
    return shares;
  }

  public void setShares(Integer shares) {
    this.shares = shares;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public LocalDate getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDate timestamp) {
    this.timestamp = timestamp;
  }
}
