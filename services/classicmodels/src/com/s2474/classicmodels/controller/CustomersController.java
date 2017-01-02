/*\/**
 * Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 * This software is the confidential and proprietary information of wavemaker-com * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the source code license agreement you entered into with wavemaker.com *\/*/
package com.s2474.classicmodels.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.s2474.classicmodels.Customers;
import com.s2474.classicmodels.Orders;
import com.s2474.classicmodels.Payments;
import com.s2474.classicmodels.service.CustomersService;

/**
 * Controller object for domain model class Customers.
 * @see Customers
 */
@RestController("classicmodels.CustomersController")
@Api(value = "CustomersController", description = "Exposes APIs to work with Customers resource.")
@RequestMapping("/classicmodels/Customers")
public class CustomersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomersController.class);

    @Autowired
    @Qualifier("classicmodels.CustomersService")
    private CustomersService customersService;

    @ApiOperation(value = "Creates a new Customers instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Customers createCustomers(@RequestBody Customers customers) {
        LOGGER.debug("Create Customers with information: {}", customers);
        customers = customersService.create(customers);
        LOGGER.debug("Created Customers with information: {}", customers);
        return customers;
    }

    @ApiOperation(value = "Returns the Customers instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Customers getCustomers(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Customers with id: {}", id);
        Customers foundCustomers = customersService.getById(id);
        LOGGER.debug("Customers details with id: {}", foundCustomers);
        return foundCustomers;
    }

    @ApiOperation(value = "Updates the Customers instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Customers editCustomers(@PathVariable("id") Integer id, @RequestBody Customers customers) throws EntityNotFoundException {
        LOGGER.debug("Editing Customers with id: {}", customers.getCustomerNumber());
        customers.setCustomerNumber(id);
        customers = customersService.update(customers);
        LOGGER.debug("Customers details with id: {}", customers);
        return customers;
    }

    @ApiOperation(value = "Deletes the Customers instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteCustomers(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Customers with id: {}", id);
        Customers deletedCustomers = customersService.delete(id);
        return deletedCustomers != null;
    }

    /**
     * @deprecated Use {@link #findCustomers(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Customers instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Customers> searchCustomersByQueryFilters(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Customers list");
        return customersService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of Customers instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Customers> findCustomers(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Customers list");
        return customersService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportCustomers(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return customersService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of Customers instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countCustomers(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting Customers");
        return customersService.count(query);
    }

    @RequestMapping(value = "/{id:.+}/orderses", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the orderses instance associated with the given id.")
    public Page<Orders> findAssociatedOrderses(@PathVariable("id") Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated orderses");
        return customersService.findAssociatedOrderses(id, pageable);
    }

    @RequestMapping(value = "/{id:.+}/paymentses", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the paymentses instance associated with the given id.")
    public Page<Payments> findAssociatedPaymentses(@PathVariable("id") Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated paymentses");
        return customersService.findAssociatedPaymentses(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service CustomersService instance
	 */
    protected void setCustomersService(CustomersService service) {
        this.customersService = service;
    }
}
