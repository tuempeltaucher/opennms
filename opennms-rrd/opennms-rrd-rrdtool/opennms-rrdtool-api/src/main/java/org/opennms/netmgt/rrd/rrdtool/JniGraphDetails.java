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

package org.opennms.netmgt.rrd.rrdtool;

import java.io.InputStream;

import org.opennms.netmgt.rrd.RrdException;
import org.opennms.netmgt.rrd.RrdGraphDetails;

/**
 * 
 * @author <a href="mailto:alejandro@opennms.org">Alejandro Galue</a>
 */
public class JniGraphDetails implements RrdGraphDetails {

	private int m_height;
	private int m_width;
	private String[] m_printLines;
	private InputStream m_inputStream;

	public JniGraphDetails(int height, int width, String[] lines, InputStream stream) {
		m_height = height;
		m_width = width;
		m_printLines = lines;
		m_inputStream = stream;
	}

	public int getHeight() throws RrdException {
		return m_height;
	}

	public InputStream getInputStream() throws RrdException {
		return m_inputStream;
	}

	public String[] getPrintLines() throws RrdException {
		return m_printLines;
	}

	public int getWidth() throws RrdException {
		return m_width;
	}

}
