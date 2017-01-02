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

import com.s2474.classicmodels.Productlines;
import com.s2474.classicmodels.Products;

/**
 * Service object for domain model class {@link Productlines}.
 */
public interface ProductlinesService {

    /**
     * Creates a new Productlines. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Productlines if any.
     *
     * @param productlines Details of the Productlines to be created; value cannot be null.
     * @return The newly created Productlines.
     */
	Productlines create(Productlines productlines);


	/**
	 * Returns Productlines by given id if exists.
	 *
	 * @param productlinesId The id of the Productlines to get; value cannot be null.
	 * @return Productlines associated with the given productlinesId.
     * @throws EntityNotFoundException If no Productlines is found.
	 */
	Productlines getById(String productlinesId) throws EntityNotFoundException;

    /**
	 * Find and return the Productlines by given id if exists, returns null otherwise.
	 *
	 * @param productlinesId The id of the Productlines to get; value cannot be null.
	 * @return Productlines associated with the given productlinesId.
	 */
	Productlines findById(String productlinesId);


	/**
	 * Updates the details of an existing Productlines. It replaces all fields of the existing Productlines with the given productlines.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Productlines if any.
     *
	 * @param productlines The details of the Productlines to be updated; value cannot be null.
	 * @return The updated Productlines.
	 * @throws EntityNotFoundException if no Productlines is found with given input.
	 */
	Productlines update(Productlines productlines) throws EntityNotFoundException;

    /**
	 * Deletes an existing Productlines with the given id.
	 *
	 * @param productlinesId The id of the Productlines to be deleted; value cannot be null.
	 * @return The deleted Productlines.
	 * @throws EntityNotFoundException if no Productlines found with the given id.
	 */
	Productlines delete(String productlinesId) throws EntityNotFoundException;

	/**
	 * Find all Productlines matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Productlines.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Productlines> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Productlines matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Productlines.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Productlines> findAll(String query, Pageable pageable);

    /**
	 * Exports all Productlines matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Productlines in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Productlines.
	 */
	long count(String query);

    /*
     * Returns the associated productses for given Productlines id.
     *
     * @param productLine value of productLine; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Products instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Products> findAssociatedProductses(String productLine, Pageable pageable);

}
