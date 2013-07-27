/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
 
package com.smartgwt.client.widgets.drawing;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.chart.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.layout.events.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.logicalstructure.core.*;
import com.smartgwt.logicalstructure.widgets.*;
import com.smartgwt.logicalstructure.widgets.drawing.*;
import com.smartgwt.logicalstructure.widgets.plugins.*;
import com.smartgwt.logicalstructure.widgets.form.*;
import com.smartgwt.logicalstructure.widgets.tile.*;
import com.smartgwt.logicalstructure.widgets.grid.*;
import com.smartgwt.logicalstructure.widgets.chart.*;
import com.smartgwt.logicalstructure.widgets.layout.*;
import com.smartgwt.logicalstructure.widgets.menu.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;

/**
 * Represents a sector on the gauge.
 */
public class GaugeSector extends RefDataClass {

    public static GaugeSector getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new GaugeSector(jsObj);
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }



    public GaugeSector(){
        
    }

    public GaugeSector(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
        
    }

    public GaugeSector(float value) {
        setValue(value);
        
    }

    public GaugeSector(float value, String fillColor) {
        setValue(value);
		setFillColor(fillColor);
        
    }


    // ********************* Properties / Attributes ***********************


    /**
     * 
     *
     * @param endAngle endAngle Default value is 0
     */
    public void setEndAngle(float endAngle) {
        setAttribute("endAngle", endAngle);
    }

    /**
     * 
     *
     * @return float
     */
    public float getEndAngle()  {
        return getAttributeAsFloat("endAngle");
    }


    /**
     * 
     *
     * @param fillColor . See {@link com.smartgwt.client.docs.CSSColor CSSColor}. Default value is null
     */
    public void setFillColor(String fillColor) {
        setAttribute("fillColor", fillColor);
    }

    /**
     * 
     *
     * @return . See {@link com.smartgwt.client.docs.CSSColor CSSColor}
     */
    public String getFillColor()  {
        return getAttributeAsString("fillColor");
    }


    /**
     * 
     *
     * @param startAngle startAngle Default value is 0
     */
    public void setStartAngle(float startAngle) {
        setAttribute("startAngle", startAngle);
    }

    /**
     * 
     *
     * @return float
     */
    public float getStartAngle()  {
        return getAttributeAsFloat("startAngle");
    }


    /**
     * 
     *
     * @param value value Default value is 0
     */
    public void setValue(float value) {
        setAttribute("value", value);
    }

    /**
     * 
     *
     * @return float
     */
    public float getValue()  {
        return getAttributeAsFloat("value");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}

