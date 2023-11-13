package com.demo.healthservice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "balance_records")
public class BalanceRecord {
    @Id
    private Long id;


    @Column(name = "year",nullable = false)
    private String year;
    @Column(name = "month",nullable = false)
    private String month;
    @Column(name = "asset_amount",nullable = false)
    private Double assetAmount;
    @Column(name = "debt_amount",nullable = false)
    private Double debtAmount;
    @Column(name = "income_amount",nullable = false)
    private Double incomeAmount;
    @Column(name = "expense_amount",nullable = false)
    private String expenseAmount;


}
