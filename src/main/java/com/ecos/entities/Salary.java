package com.ecos.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.Bidi;

@Entity
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(scale = 2)
    private BigDecimal grossAmount;
    private String currency;

    public Salary(SalaryBuilder salaryBuilder) {
        this.grossAmount = salaryBuilder.grossAmount;
        this.currency = salaryBuilder.currency;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(BigDecimal grossAmount) {
        this.grossAmount = grossAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public static class SalaryBuilder {
        private BigDecimal grossAmount;
        private String currency;

        public SalaryBuilder grossAmount (BigDecimal grossAmount) {
            this.grossAmount = grossAmount;
            return this;
        }

        public SalaryBuilder currency (String currency) {
            this.currency = currency;
            return this;
        }

        public Salary build() {
            return new Salary(this);
        }
    }
}
