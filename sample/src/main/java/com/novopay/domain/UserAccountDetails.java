package com.novopay.domain;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserAccountDetails {

  private Long      userId;
  private String    userName;
  private String    userLoggedIn;
  private Double    balance;
  private LocalDate accountCreationDate;
  private LocalDate accountUpdateDate;

}
