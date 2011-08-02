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
 
package com.smartgwt.client.widgets.layout;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.EnumUtil;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Simple SectionHeader class based on a Label with an icon, skinnable via CSS.
 */
public class SectionHeader extends Label {

    public static SectionHeader getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (SectionHeader) obj;
        } else {
            return new SectionHeader(jsObj);
        }
    }

    public SectionHeader(){
        scClassName = "SectionHeader";
    }

    public SectionHeader(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.SectionHeader.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Base filename of the icon that represents open and closed states. The default settings also change the icon for disabled
     * sections, so a total of four images are required (opened, closed, Disabled_opened, Disabled_closed). <P> Not shown if
     * {@link com.smartgwt.client.widgets.layout.SectionStackSection#getCanCollapse canCollapse} is false.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param icon icon Default value is "[SKIN]SectionHeader/opener.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setIcon(String icon)  throws IllegalStateException {
        setAttribute("icon", icon, false);
    }

    /**
     * Base filename of the icon that represents open and closed states. The default settings also change the icon for disabled
     * sections, so a total of four images are required (opened, closed, Disabled_opened, Disabled_closed). <P> Not shown if
     * {@link com.smartgwt.client.widgets.layout.SectionStackSection#getCanCollapse canCollapse} is false.
     *
     *
     * @return String
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }

    /**
     * CSS class for the section header.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param baseStyle baseStyle Default value is "sectionHeader"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setBaseStyle(String baseStyle)  throws IllegalStateException {
        setAttribute("baseStyle", baseStyle, false);
    }

    /**
     * CSS class for the section header.
     *
     *
     * @return String
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************




    /**
     * Set the controls.
     *
     * @param controls the controls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setControls(Canvas... controls) throws IllegalStateException {
        setAttribute("controls", controls, false);
    }

}


