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
 * dataProtocol affects how the data in the DSRequest (${isc.DocUtils.linkForRef('attr:DSRequest.data')}) is&#010 sent
 * to the ${isc.DocUtils.linkForRef('attr:DataSource.dataURL')}.  Note that, when using the SmartClient server,
 * data&#010 is automatically translated from JavaScript to Java according to the rules described&#010
 * ${isc.DocUtils.linkForRef('attr:RPCRequest.data','here')}; dataProtocol does not apply.
 */

public enum DSProtocol implements ValueEnum {
    /**
     * Data is added to the dataURL, with each property in the data becoming an HTTP parameter,&#010   eg
     * http://service.com/search?keyword=foo
     */
    GETPARAMS("getParams"),
    /**
     * Data is POST'd to the dataURL, with each property becoming an HTTP parameter, &#010   exactly as an HTML form
     * would submit them if it had one input field per property in the&#010   data.
     */
    POSTPARAMS("postParams"),
    /**
     * Data is serialized as XML via ${isc.DocUtils.linkForRef('method:DataSource.xmlSerialize')} and POST'd as the&#010
     * HTTP request body with contentType text/xml
     */
    POSTXML("postXML"),
    /**
     * Data is serialized as XML via ${isc.DocUtils.linkForRef('method:DataSource.xmlSerialize')}, wrapped in a
     * SOAP&#010   envelope, and POST'd as the HTTP request body with contentType "text/xml".  Generally&#010 only used
     * in connection with a ${isc.DocUtils.linkForRef('group:wsdlBinding','WSDL web service')}.
     */
    SOAP("soap"),
    /**
     * dsRequest.data is assumed to be a String set up by ${isc.DocUtils.linkForRef('method:DataSource.transformRequest')}&#010
     * and is POST'd as the HTTP request body.
     */
    POSTMESSAGE("postMessage");
    private String value;

    DSProtocol(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

