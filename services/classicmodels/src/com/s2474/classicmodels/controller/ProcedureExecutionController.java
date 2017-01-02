/*\/**
 * Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 * This software is the confidential and proprietary information of wavemaker-com * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the source code license agreement you entered into with wavemaker.com *\/*/
package com.s2474.classicmodels.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Qualifier;
import com.s2474.classicmodels.service.ClassicmodelsProcedureExecutorService;
import com.wavemaker.runtime.data.model.CustomProcedure;
import com.wavemaker.runtime.data.exception.QueryParameterMismatchException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

@RestController(value = "Classicmodels.ProcedureExecutionController")
@Api(value = "ProcedureExecutionController", description = "Controller class for procedure execution")
@RequestMapping("/classicmodels/procedureExecutor")
public class ProcedureExecutionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcedureExecutionController.class);

    @Autowired
    private ClassicmodelsProcedureExecutorService procedureService;

    @ApiOperation(value = "Process request to execute Procedure")
    @RequestMapping(value = "/procedure/execute/getProc", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public List<Object> executeGetProc(@RequestParam(value = "men1", required = false) java.lang.Integer men1, @RequestParam(value = "men2", required = false) java.lang.Integer men2) throws QueryParameterMismatchException {
        LOGGER.debug("Executing named procedure getProc");
        List<Object> resultGetProc = procedureService.executeGetProc(men1, men2);
        LOGGER.debug("got the result of named procedure {}", resultGetProc);
        return resultGetProc;
    }

    @ApiOperation(value = "Process request to execute custom Procedure")
    @RequestMapping(value = "/procedure/execute/wm_custom", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public List<Object> executeWMCustomProcedure(@RequestBody CustomProcedure procedure) {
        List<Object> result = procedureService.executeWMCustomProcedure(procedure);
        LOGGER.debug("got the result {}" + result);
        return result;
    }
}