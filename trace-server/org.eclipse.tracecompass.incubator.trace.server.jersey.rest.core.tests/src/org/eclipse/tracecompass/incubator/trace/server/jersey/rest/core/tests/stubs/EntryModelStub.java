/**********************************************************************
 * Copyright (c) 2020, 2025 École Polytechnique de Montréal and others
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License 2.0 which
 * accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 **********************************************************************/
package org.eclipse.tracecompass.incubator.trace.server.jersey.rest.core.tests.stubs;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A Stub class for the entry model. It matches the trace server protocol's
 * <code>EntryModel</code> schema
 *
 * FIXME: Cannot remove the JsonIgnoreProperties because the method used to
 * custom serialize does not allow to serialize generic types, so we use the
 * default serialization which adds extra fields
 *
 * @author Geneviève Bastien
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntryModelStub implements Serializable {

    private static final long serialVersionUID = 6027193074532379770L;

    private final List<EntryStub> fEntries;
    private final List<EntryHeaderStub> fHeaders;
    private final int fAutoExpandLevel;

    /**
     * {@link JsonCreator} Constructor for final fields
     *
     * @param entries
     *            The set of entries for this model
     * @param headers
     *            The set of headers for this model
     * @param autoExpandLevel
     *            The auto-expand level for this model
     */
    @JsonCreator
    public EntryModelStub(@JsonProperty("entries") List<EntryStub> entries,
            @JsonProperty("headers") List<EntryHeaderStub> headers,
            @JsonProperty("autoExpandLevel") Integer autoExpandLevel) {
        fEntries = Objects.requireNonNull(entries, "The 'entries' json field was not set");
        fHeaders = headers == null ? Collections.emptyList() : headers;
        fAutoExpandLevel = autoExpandLevel == null ? -1 : autoExpandLevel;
    }

    /**
     * Get the entries described by this model
     *
     * @return The entries in this model
     */
    public List<EntryStub> getEntries() {
        return fEntries;
    }

    /**
     * Get the headers that describe this model
     *
     * @return The headers in this model
     */
    public List<EntryHeaderStub> getHeaders() {
        return fHeaders;
    }

    /**
     * Get the auto-expand level
     *
     * @return auto-expand level
     */
    public int getAutoExpandLevel() {
        return fAutoExpandLevel;
    }

}
