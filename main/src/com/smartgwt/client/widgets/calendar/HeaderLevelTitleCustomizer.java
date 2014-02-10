package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Called to determine the Title text for a given span in a HeaderLevel in Timeline views
 */
public abstract class HeaderLevelTitleCustomizer {
    
    private Calendar calendar;

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }    

    /**
     * Returns the Calendar over which the hover occurred
     * @return Calendar over which the hover occurred
     */
    public Calendar getCalendar() {
        return this.calendar;
    }
    
    /**
     * getTitle() should be implemented and return the string of HTML to display in the header for a given span in the HeaderLevel
     * @param headerLevel HeaderLevel a reference to this headerLevel
     * @param startDate Date the start of the date-range covered by this span in this level
     * @param endDate Date the end of the date-range covered by this span in this level - may be null
     * @param defaultValue String the default title as generated by the Timeline
     * @param calendar Calendar a reference to the Calendar or Timeline
     * @return String The formatted title for the values passed in
     */
    public abstract String getTitle(HeaderLevel headerLevel, Date startDate, Date endDate, String defaultValue, Calendar calendar);
}
