package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int companyId;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String companyTickerSymbol;

    @Column(nullable = false)
    private long stockPrice;

    @Column(nullable = false)
    private long shares;

    @Column(nullable = false)
    private long marketCapitalization;

    public Stock(int companyId) {
        super();
        this.companyId = companyId;
    }
}
