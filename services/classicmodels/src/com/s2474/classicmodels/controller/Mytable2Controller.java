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
import com.s2474.classicmodels.Mytable2;
import com.s2474.classicmodels.Mytable2Id;
import com.s2474.classicmodels.service.Mytable2Service;

/**
 * Controller object for domain model class Mytable2.
 * @see Mytable2
 */
@RestController("classicmodels.Mytable2Controller")
@Api(value = "Mytable2Controller", description = "Exposes APIs to work with Mytable2 resource.")
@RequestMapping("/classicmodels/Mytable2")
public class Mytable2Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Mytable2Controller.class);

    @Autowired
    @Qualifier("classicmodels.Mytable2Service")
    private Mytable2Service mytable2Service;

    @ApiOperation(value = "Creates a new Mytable2 instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Mytable2 createMytable2(@RequestBody Mytable2 mytable2) {
        LOGGER.debug("Create Mytable2 with information: {}", mytable2);
        mytable2 = mytable2Service.create(mytable2);
        LOGGER.debug("Created Mytable2 with information: {}", mytable2);
        return mytable2;
    }

    @ApiOperation(value = "Returns the Mytable2 instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Mytable2 getMytable2(@RequestParam("id") Integer id, @RequestParam("col1") Integer col1) throws EntityNotFoundException {
        Mytable2Id mytable2Id = new Mytable2Id();
        mytable2Id.setId(id);
        mytable2Id.setCol1(col1);
        LOGGER.debug("Getting Mytable2 with id: {}", mytable2Id);
        Mytable2 mytable2 = mytable2Service.getById(mytable2Id);
        LOGGER.debug("Mytable2 details with id: {}", mytable2);
        return mytable2;
    }

    @ApiOperation(value = "Updates the Mytable2 instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Mytable2 editMytable2(@RequestParam("id") Integer id, @RequestParam("col1") Integer col1, @RequestBody Mytable2 mytable2) throws EntityNotFoundException {
        mytable2.setId(id);
        mytable2.setCol1(col1);
        LOGGER.debug("Mytable2 details with id is updated with: {}", mytable2);
        return mytable2Service.update(mytable2);
    }

    @ApiOperation(value = "Deletes the Mytable2 instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteMytable2(@RequestParam("id") Integer id, @RequestParam("col1") Integer col1) throws EntityNotFoundException {
        Mytable2Id mytable2Id = new Mytable2Id();
        mytable2Id.setId(id);
        mytable2Id.setCol1(col1);
        LOGGER.debug("Deleting Mytable2 with id: {}", mytable2Id);
        Mytable2 mytable2 = mytable2Service.delete(mytable2Id);
        return mytable2 != null;
    }

    /**
     * @deprecated Use {@link #findMytable2s(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Mytable2 instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Mytable2> searchMytable2sByQueryFilters(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Mytable2s list");
        return mytable2Service.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of Mytable2 instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Mytable2> findMytable2s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Mytable2s list");
        return mytable2Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportMytable2s(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return mytable2Service.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of Mytable2 instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countMytable2s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting Mytable2s");
        return mytable2Service.count(query);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Mytable2Service instance
	 */
    protected void setMytable2Service(Mytable2Service service) {
        this.mytable2Service = service;
    }
}
