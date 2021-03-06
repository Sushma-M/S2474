/*\/**
 * Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 * This software is the confidential and proprietary information of wavemaker-com * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the source code license agreement you entered into with wavemaker.com *\/*/
package com.s2474.classicmodels;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Employees generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`employees`")
public class Employees implements Serializable {

    private Integer employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String officeCode;
    private Integer reportsTo;
    private String jobTitle;
    private Offices offices;
    private Employees employeesByReportsTo;
    private List<Customers> customerses = new ArrayList<>();
    private List<Employees> employeesesForReportsTo = new ArrayList<>();

    @Id
    @Column(name = "`employeeNumber`", nullable = false, scale = 0, precision = 10)
    public Integer getEmployeeNumber() {
        return this.employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Column(name = "`lastName`", nullable = false, length = 50)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "`firstName`", nullable = false, length = 50)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "`extension`", nullable = false, length = 10)
    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Column(name = "`email`", nullable = false, length = 100)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "`officeCode`", nullable = false, length = 10)
    public String getOfficeCode() {
        return this.officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    @Column(name = "`reportsTo`", nullable = true, scale = 0, precision = 10)
    public Integer getReportsTo() {
        return this.reportsTo;
    }

    public void setReportsTo(Integer reportsTo) {
        this.reportsTo = reportsTo;
    }

    @Column(name = "`jobTitle`", nullable = false, length = 50)
    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`officeCode`", referencedColumnName = "`officeCode`", insertable = false, updatable = false)
    public Offices getOffices() {
        return this.offices;
    }

    public void setOffices(Offices offices) {
        if(offices != null) {
            this.officeCode = offices.getOfficeCode();
        }

        this.offices = offices;
    }

    // ignoring self relation properties to avoid circular loops.
    @JsonIgnoreProperties({"employeesByReportsTo", "employeesesForReportsTo"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`reportsTo`", referencedColumnName = "`employeeNumber`", insertable = false, updatable = false)
    public Employees getEmployeesByReportsTo() {
        return this.employeesByReportsTo;
    }

    public void setEmployeesByReportsTo(Employees employeesByReportsTo) {
        if(employeesByReportsTo != null) {
            this.reportsTo = employeesByReportsTo.getEmployeeNumber();
        }

        this.employeesByReportsTo = employeesByReportsTo;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "employees")
    public List<Customers> getCustomerses() {
        return this.customerses;
    }

    public void setCustomerses(List<Customers> customerses) {
        this.customerses = customerses;
    }

    // ignoring self relation properties to avoid circular loops.
    @JsonIgnoreProperties({"employeesByReportsTo", "employeesesForReportsTo"})
    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "employeesByReportsTo")
    public List<Employees> getEmployeesesForReportsTo() {
        return this.employeesesForReportsTo;
    }

    public void setEmployeesesForReportsTo(List<Employees> employeesesForReportsTo) {
        this.employeesesForReportsTo = employeesesForReportsTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employees)) return false;
        final Employees employees = (Employees) o;
        return Objects.equals(getEmployeeNumber(), employees.getEmployeeNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeNumber());
    }
}

