/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.types;

/**
 * Event that will trigger inline editing.
 */

public enum ListGridEditEvent implements ValueEnum {
    /**
     * A single mouse click triggers inline editing
     */
    CLICK("click"),
    /**
     * A double click triggers inline editing
     */
    DOUBLECLICK("doubleClick"),
    /**
     * No mouse event will trigger editing.  Editing must be                      programmatically started via
     * ${isc.DocUtils.linkForRef('method:ListGrid.startEditing')}&#010                      (perhaps from an external
     * button) or may be triggered by &#010                      keyboard navigation if
     * ${isc.DocUtils.linkForRef('attr:ListGrid.editOnFocus')} is set.
     */
    NONE("none");
    private String value;

    ListGridEditEvent(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

