/*******************************************************************************
 * This file is part of the OpenNMS(R) Application.
 *
 * Copyright (C) 2007-2008 The OpenNMS Group, Inc.  All rights reserved.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc.:
 *
 *      51 Franklin Street
 *      5th Floor
 *      Boston, MA 02110-1301
 *      USA
 *
 * For more information contact:
 *
 *      OpenNMS Licensing <license@opennms.org>
 *      http://www.opennms.org/
 *      http://www.opennms.com/
 *
 *******************************************************************************/

package org.opennms.netmgt.rrd;

import java.io.InputStream;

/**
 * Simple RrdGraphDetails implementation.
 * 
 * @author <a href="mailto:dj@opennms.org">DJ Gregor</a>
 */
public class DefaultRrdGraphDetails implements RrdGraphDetails {
    private InputStream m_inputStream;
    private String[] m_printLines;
    private int m_width;
    private int m_height;
    
    public int getHeight() {
        return m_height;
    }
    
    public void setHeight(int height) {
        m_height = height;
    }
    
    public InputStream getInputStream() {
        return m_inputStream;
    }
    
    public void setInputStream(InputStream inputStream) {
        m_inputStream = inputStream;
    }
    
    public String[] getPrintLines() {
        return m_printLines;
    }
    
    public void setPrintLines(String[] printLines) {
        m_printLines = printLines;
    }
    
    public int getWidth() {
        return m_width;
    }
    
    public void setWidth(int width) {
        m_width = width;
    }
}
