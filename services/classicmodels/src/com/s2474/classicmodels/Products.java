/*\/**
 * Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 * This software is the confidential and proprietary information of wavemaker-com * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the source code license agreement you entered into with wavemaker.com *\/*/
package com.s2474.classicmodels;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Products generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`products`")
public class Products implements Serializable {

    private String productCode;
    private String productName;
    private String productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private short quantityInStock;
    private BigDecimal buyPrice;
    private BigDecimal msrp;
    private Productlines productlines;
    private List<Orderdetails> orderdetailses = new ArrayList<>();

    @Id
    @Column(name = "`productCode`", nullable = false, length = 15)
    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Column(name = "`productName`", nullable = false, length = 70)
    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column(name = "`productLine`", nullable = false, length = 50)
    public String getProductLine() {
        return this.productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    @Column(name = "`productScale`", nullable = false, length = 10)
    public String getProductScale() {
        return this.productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    @Column(name = "`productVendor`", nullable = false, length = 50)
    public String getProductVendor() {
        return this.productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    @Column(name = "`productDescription`", nullable = false, length = 65535)
    public String getProductDescription() {
        return this.productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Column(name = "`quantityInStock`", nullable = false, scale = 0, precision = 5)
    public short getQuantityInStock() {
        return this.quantityInStock;
    }

    public void setQuantityInStock(short quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Column(name = "`buyPrice`", nullable = false, scale = 9, precision = 22)
    public BigDecimal getBuyPrice() {
        return this.buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    @Column(name = "`MSRP`", nullable = false, scale = 9, precision = 22)
    public BigDecimal getMsrp() {
        return this.msrp;
    }

    public void setMsrp(BigDecimal msrp) {
        this.msrp = msrp;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`productLine`", referencedColumnName = "`productLine`", insertable = false, updatable = false)
    public Productlines getProductlines() {
        return this.productlines;
    }

    public void setProductlines(Productlines productlines) {
        if(productlines != null) {
            this.productLine = productlines.getProductLine();
        }

        this.productlines = productlines;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "products")
    public List<Orderdetails> getOrderdetailses() {
        return this.orderdetailses;
    }

    public void setOrderdetailses(List<Orderdetails> orderdetailses) {
        this.orderdetailses = orderdetailses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Products)) return false;
        final Products products = (Products) o;
        return Objects.equals(getProductCode(), products.getProductCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductCode());
    }
}
