/*\/**
 * Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 * This software is the confidential and proprietary information of wavemaker-com * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the source code license agreement you entered into with wavemaker.com *\/*/
package com.s2474.classicmodels.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.s2474.classicmodels.Orderdetails;
import com.s2474.classicmodels.Orders;

/**
 * Service object for domain model class {@link Orders}.
 */
public interface OrdersService {

    /**
     * Creates a new Orders. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Orders if any.
     *
     * @param orders Details of the Orders to be created; value cannot be null.
     * @return The newly created Orders.
     */
	Orders create(Orders orders);


	/**
	 * Returns Orders by given id if exists.
	 *
	 * @param ordersId The id of the Orders to get; value cannot be null.
	 * @return Orders associated with the given ordersId.
     * @throws EntityNotFoundException If no Orders is found.
	 */
	Orders getById(Integer ordersId) throws EntityNotFoundException;

    /**
	 * Find and return the Orders by given id if exists, returns null otherwise.
	 *
	 * @param ordersId The id of the Orders to get; value cannot be null.
	 * @return Orders associated with the given ordersId.
	 */
	Orders findById(Integer ordersId);


	/**
	 * Updates the details of an existing Orders. It replaces all fields of the existing Orders with the given orders.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Orders if any.
     *
	 * @param orders The details of the Orders to be updated; value cannot be null.
	 * @return The updated Orders.
	 * @throws EntityNotFoundException if no Orders is found with given input.
	 */
	Orders update(Orders orders) throws EntityNotFoundException;

    /**
	 * Deletes an existing Orders with the given id.
	 *
	 * @param ordersId The id of the Orders to be deleted; value cannot be null.
	 * @return The deleted Orders.
	 * @throws EntityNotFoundException if no Orders found with the given id.
	 */
	Orders delete(Integer ordersId) throws EntityNotFoundException;

	/**
	 * Find all Orders matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Orders.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Orders> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Orders matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Orders.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Orders> findAll(String query, Pageable pageable);

    /**
	 * Exports all Orders matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Orders in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Orders.
	 */
	long count(String query);

    /*
     * Returns the associated orderdetailses for given Orders id.
     *
     * @param orderNumber value of orderNumber; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Orderdetails instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Orderdetails> findAssociatedOrderdetailses(Integer orderNumber, Pageable pageable);

}
