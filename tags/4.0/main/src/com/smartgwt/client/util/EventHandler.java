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
 
package com.smartgwt.client.util;


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
 * The ISC system provides a predictable cross-browser event-handling mechanism for ISC widgets. Events can be handled both
 * at the page level (i.e., globally), and at the level of individual widgets. <p> With the exception of a few
 * page-specific events ('load', 'unload', 'idle' and 'resize'), events are processed in the following sequence: <p> 1. The
 * event is sent to any global (page-level) event handlers. These handlers can cancel further propagation of the event by
 * returning false.  You can register to listen for any of the events linked in the seeAlso section (below) by calling
 * {@link com.smartgwt.client.util.Page#setEvent Page.setEvent} method. <p> 2. If the event occurred on a form element or a
 * link, it is passed on to the browser so that the element will perform its default action. No widget receives the event.
 * <p> 3. If the event occurred on an enabled widget (but not on a form element or link inside the widget), it is sent to
 * that widget's event handler, if any. This handler can cancel further propagation of the event by returning false.  An
 * "enabled" widget is any widget that defines an event handler for one of the supported events.  Interceptable events are
 * defined in the  "widgetEvents" section of Canvas. <p> 4. The event is "bubbled" up to the widget's parent in the
 * containment hierarchy, if any. Again, the parent's handler for the event can cancel further propagation by returning
 * false. This step is repeated, with the event "bubbling" up through the containment hierarchy, until a top-level widget
 * is reached or the event is explicitly canceled. In brief, the ISC event model offers the best features of browser event
 * models: <ul> <li> Page-first event handling allows you to reliably process or cancel any event before it      affects
 * the objects on the page. <li> Event "bubbling" ensures that parent widgets receive events sent to their children,     
 * and allows you to create generalized parent-level handlers rather than duplicating      code in each child. </ul> Note:
 * Canceling propagation of an event may cancel its side effects as well, including the generation of other (synthetic)
 * events. For example, if a global mouseDown handler returns false, drag-and-drop events will not be generated. Specific
 * effects are discussed in the descriptions of the various events in the following sections. <p> Smart GWT libraries will
 * not interfere with native event handling when events occur outside of a target widget. You can therefore have HTML that
 * is not ISC-based on the same page as widget objects that will react to native events as you would expect. <p> You can
 * use isc.Event as an alias for isc.EventHandler.
 * @see com.smartgwt.client.types.PageEvent
 * @see com.smartgwt.client.util.Page#setEvent
 * @see com.smartgwt.client.util.Page#clearEvent
 */
public class EventHandler {


    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
	/**
     * Return true if the alt (option) key is being held down.   Note that this is only set reliably for keyboard events.
     *
     * @return true == alt key is down
     */
    public static native Boolean altKeyDown() /*-{
        var ret = $wnd.isc.EventHandler.altKeyDown();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;
	/**
     * Return true if the control key is being held down.   Note that this is only set reliably for keyboard events.
     *
     * @return true == control key is down
     */
    public static native Boolean ctrlKeyDown() /*-{
        var ret = $wnd.isc.EventHandler.ctrlKeyDown();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;
	/**
     * Returns the current dragTarget.  This is the component on which the drag and drop interaction was initiated.  This only
     * returns something meaningful during a drag and drop interaction.
     *
     * @return The dragTarget.
     * @see com.smartgwt.client.widgets.Canvas#getDragTarget
     */
    public static native Canvas getDragTarget() /*-{
        var ret = $wnd.isc.EventHandler.getDragTarget();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.Canvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Return the character for the current key being pressed.   Note that this is only set reliably for keyPress events on
     * character keys.
     *
     * @return Character the user entered. May be null for non-character keys.
     */
    public static native String getKeyEventCharacter() /*-{
        var ret = $wnd.isc.EventHandler.getKeyEventCharacter();
        return ret;
    }-*/;
	/**
     * Returns the numeric characterValue reported by the browser.          Only available on keyPress events, and only for
     * character (or ascii control) keys
     *
     * @return Numeric character value reported by the browser                   (ASCII value of the key pressed)
     */
    public static native int getKeyEventCharacterValue() /*-{
        var ret = $wnd.isc.EventHandler.getKeyEventCharacterValue();
        return ret;
    }-*/;
	/**
     * Returns the natively reported target (or source) DOM element for the current mouse event. <b>NOTE:</b> Smart GWT cannot
     * guarantee that the same element will be reported in all browser/platform configurations for all event types. If you wish
     * to make use of this value, we recommend testing your use case  in all target browser configurations.
     *
     * @return native DOM element over which the mouse event occurred
     */
    public static native Element getNativeMouseTarget() /*-{
        var ret = $wnd.isc.EventHandler.getNativeMouseTarget();
        return ret;
    }-*/;
	/**
     * Return the canvas that is the target of the mouse event. Returns null if no canvas found.
     *
     * @return event target canvas
     */
    public static native Canvas getTarget() /*-{
        var ret = $wnd.isc.EventHandler.getTarget();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.Canvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Applies to {@link com.smartgwt.client.widgets.Canvas#addMouseWheelHandler mouseWheel} events only. Returns a numeric
     * value indicating how far the mouse wheel was rotated. This value will be positive if the user scrolled the mousewheel
     * forward or up, or negative if scrolled in the other direction. For a standard wheel-mouse, an increment of 1 relates to
     * the smallest possible rotation of the mouse wheel. For other scrolling devices, such as scroll  gestures on a track pad,
     * wheel delta may be reported in finer grained increments  (causing this method to return a fractional value). Developers
     * should also be aware that some browsers and operating systems allow the user to configure the sensitivity of the mouse
     * wheel, which may change this value.
     *
     * @return numeric value indicating how far the mouse wheel was rotated.
     */
    public static native float getWheelDelta() /*-{
        var ret = $wnd.isc.EventHandler.getWheelDelta();
        return ret;
    }-*/;

	/**
     * Applies to {@link com.smartgwt.client.widgets.Canvas#addMouseWheelHandler mouseWheel} events only. Returns a numeric
     * value indicating how far the mouse wheel was rotated. This value will be positive if the user scrolled the mousewheel
     * forward or up, or negative if scrolled in the other direction. For a standard wheel-mouse, an increment of 1 relates to
     * the smallest possible rotation of the mouse wheel. For other scrolling devices, such as scroll  gestures on a track pad,
     * wheel delta may be reported in finer grained increments  (causing this method to return a fractional value). Developers
     * should also be aware that some browsers and operating systems allow the user to configure the sensitivity of the mouse
     * wheel, which may change this value.
     *
     * @return numeric value indicating how far the mouse wheel was rotated.
     */
    public static native double getWheelDeltaAsDouble() /*-{
        var ret = $wnd.isc.EventHandler.getWheelDelta();
        return ret;
    }-*/;

	/**
     * Return the page-relative X (horizontal) coordinate of an event.
     *
     * @return x-coordinate in page coordinate space
     */
    public static native int getX() /*-{
        var ret = $wnd.isc.EventHandler.getX();
        return ret;
    }-*/;
	/**
     * Return the page-relative Y (vertical) coordinate of an event.
     *
     * @return y-coordinate in page coordinate space
     */
    public static native int getY() /*-{
        var ret = $wnd.isc.EventHandler.getY();
        return ret;
    }-*/;
	/**
     * Returns true if the left mouse button is being pressed.
     *
     * @return true == left button is down, false == up
     */
    public static native Boolean leftButtonDown() /*-{
        var ret = $wnd.isc.EventHandler.leftButtonDown();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;
	/**
     * Returns true if the right mouse button is being pressed.
     *
     * @return true == right button is down, false == up
     */
    public static native Boolean rightButtonDown() /*-{
        var ret = $wnd.isc.EventHandler.rightButtonDown();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;
	/**
     * Return true if the shift key is being held down.   Note that this is only set reliably for keyboard events.
     *
     * @return true == shift key is down
     */
    public static native Boolean shiftKeyDown() /*-{
        var ret = $wnd.isc.EventHandler.shiftKeyDown();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;
	/**
     * Return whether this Canvas is masked by a clickMask (see {@link com.smartgwt.client.widgets.Canvas#showClickMask
     * Canvas.showClickMask}).
     * @param target widget to check
     *
     * @return true if masked, false if not masked.
     */
    public static native Boolean targetIsMasked(Canvas target) /*-{
        var ret = $wnd.isc.EventHandler.targetIsMasked(target.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

    // ***********************************************************


    /**
     * Set the HTML for the drag tracker that follows the mouse during a drag and drop interaction. <P> Your canvas
     * can use this routine to set the drag tracker to whatever HTML you want like so: <pre>    dragStart : function
     * () {        isc.EventHandler.setDragTracker('Your contents here');    } </pre>
     *
     * @param html HTML for the tracker
     */
    public static native void setDragTracker(String html) /*-{
            $wnd.isc.EventHandler.setDragTracker(html);
    }-*/;

    /**
     * Set the HTML for the drag tracker that follows the mouse during a drag and drop interaction. <P> Your canvas
     * can use this routine to set the drag tracker to whatever HTML you want like so: <pre>    dragStart : function
     * () {        isc.EventHandler.setDragTracker('Your contents here');    } </pre>
     *
     * @param html      HTML for the tracker
     * @param newWidth  new width for the tracker
     * @param newHeight new height for the tracker
     * @param offsetX   x-offset for the tracker
     * @param offsetY   y-offset for the tracker
     */
    public static native void setDragTracker(String html, int newWidth, int newHeight, int offsetX, int offsetY) /*-{
            $wnd.isc.EventHandler.setDragTracker(html, newWidth, newHeight, offsetX, offsetY);
    }-*/;

    /**
     * During a drag with dragAppearance of either "target" or "outline", returns the page-relative coordinates
     * of whatever element is being dragged.
     * Calling this method allows you to write drag and drop logic that works identically even if dragAppearance
     * is subsequently changed.
     *
     * @return lobal (page-relative) coordinates and size of the dragged element, as a 4-element array [left,top,width,height], or null if not dragging
     */
    public static native Rectangle getDragRect() /*-{
         var rectJS = $wnd.isc.EventHandler.getDragRect();
         if(rectJS == null || rectJS === undefined) return null;
         return @com.smartgwt.client.core.Rectangle::new(IIII)(rectJS[0], rectJS[1], rectJS[2], rectJS[3]);
     }-*/;

    /**
     * Return the page-relative X (horizontal) coordinate of an event.
     *
     * @return x-coordinate in page coordinate space
     */
    public static native Integer getMouseDownX() /*-{
            if($wnd.isc.EventHandler.mouseDownEvent) {
                var x = $wnd.isc.EventHandler.mouseDownEvent.x;
                return x == null || x === undefined ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(x);
            } else {
                return null;
            }
        }-*/;

    /**
     * Return the page-relative Y (vertical) coordinate of an event.
     *
     * @return y-coordinate in page coordinate space
     */
    public static native Integer getMouseDownY() /*-{
         if($wnd.isc.EventHandler.mouseDownEvent) {
            var y = $wnd.isc.EventHandler.mouseDownEvent.y;
            return y == null || y === undefined ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(y);
        } else {
            return null;
        }
    }-*/;

    /**
     * Return the name of the key for the event passed in. Note that this is only set reliably for keyboard events.
     *      <pre>
     * Strings to identify the various keys on the keyboard.
     *
     * For alpha keys, the single (uppercase) character value is used, such as "Q"
     * For Numeric keys, the number is used as in a single character string, like "1"
     * Function keys are identified as "f1" - "f12"
     * Non alpha-numeric character keys (such as the key for "[" / "{") are identified by their unmodified character value (the value obtained by hitting the key without holding shift down), by default - exceptions are listed below.
     * Additional key names:
     * - Space
     * - Tab
     * - Enter
     * - Escape
     * - Backspace
     * - Insert
     * - Delete
     * - Arrow_Up
     * - Arrow_Down
     * - Arrow_Left
     * - Arrow_Right
     * - Home
     * - End
     * - Page_Up
     * - Page_Down
     * - Shift
     * - Ctrl
     * - Alt
     * [Note: Some keys may not be available for capture on every platform]
     * </pre>
     * @return the key name
     * @see com.smartgwt.client.types.KeyNames
     */
    public static native String getKey() /*-{
        var keyName = $wnd.isc.EventHandler.getKey();
        return keyName == undefined ? null : keyName;
    }-*/;

}

