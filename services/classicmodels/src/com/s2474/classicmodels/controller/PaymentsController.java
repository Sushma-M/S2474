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
import com.s2474.classicmodels.Payments;
import com.s2474.classicmodels.PaymentsId;
import com.s2474.classicmodels.service.PaymentsService;

/**
 * Controller object for domain model class Payments.
 * @see Payments
 */
@RestController("classicmodels.PaymentsController")
@Api(value = "PaymentsController", description = "Exposes APIs to work with Payments resource.")
@RequestMapping("/classicmodels/Payments")
public class PaymentsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentsController.class);

    @Autowired
    @Qualifier("classicmodels.PaymentsService")
    private PaymentsService paymentsService;

    @ApiOperation(value = "Creates a new Payments instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Payments createPayments(@RequestBody Payments payments) {
        LOGGER.debug("Create Payments with information: {}", payments);
        payments = paymentsService.create(payments);
        LOGGER.debug("Created Payments with information: {}", payments);
        return payments;
    }

    @ApiOperation(value = "Returns the Payments instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Payments getPayments(@RequestParam("customerNumber") Integer customerNumber, @RequestParam("checkNumber") String checkNumber) throws EntityNotFoundException {
        PaymentsId paymentsId = new PaymentsId();
        paymentsId.setCustomerNumber(customerNumber);
        paymentsId.setCheckNumber(checkNumber);
        LOGGER.debug("Getting Payments with id: {}", paymentsId);
        Payments payments = paymentsService.getById(paymentsId);
        LOGGER.debug("Payments details with id: {}", payments);
        return payments;
    }

    @ApiOperation(value = "Updates the Payments instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Payments editPayments(@RequestParam("customerNumber") Integer customerNumber, @RequestParam("checkNumber") String checkNumber, @RequestBody Payments payments) throws EntityNotFoundException {
        payments.setCustomerNumber(customerNumber);
        payments.setCheckNumber(checkNumber);
        LOGGER.debug("Payments details with id is updated with: {}", payments);
        return paymentsService.update(payments);
    }

    @ApiOperation(value = "Deletes the Payments instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deletePayments(@RequestParam("customerNumber") Integer customerNumber, @RequestParam("checkNumber") String checkNumber) throws EntityNotFoundException {
        PaymentsId paymentsId = new PaymentsId();
        paymentsId.setCustomerNumber(customerNumber);
        paymentsId.setCheckNumber(checkNumber);
        LOGGER.debug("Deleting Payments with id: {}", paymentsId);
        Payments payments = paymentsService.delete(paymentsId);
        return payments != null;
    }

    /**
     * @deprecated Use {@link #findPayments(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Payments instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Payments> searchPaymentsByQueryFilters(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Payments list");
        return paymentsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of Payments instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Payments> findPayments(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Payments list");
        return paymentsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportPayments(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return paymentsService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of Payments instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countPayments(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting Payments");
        return paymentsService.count(query);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PaymentsService instance
	 */
    protected void setPaymentsService(PaymentsService service) {
        this.paymentsService = service;
    }
}
