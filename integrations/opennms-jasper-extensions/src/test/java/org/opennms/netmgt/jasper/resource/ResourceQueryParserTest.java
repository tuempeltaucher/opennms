/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2012 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2012 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

package org.opennms.netmgt.jasper.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ResourceQueryParserTest {
    
    
    @Test
    public void testCommandParsing() {
        ResourceQueryCommandParser parser = new ResourceQueryCommandParser();
        ResourceQuery rQuery = parser.parseQueryCommand(getResourceQuery());
        
        assertNotNull(rQuery);
        assertTrue(rQuery.getRrdDir().matches(".*src/test/resources/share/rrd/snmp"));
        assertEquals("10", rQuery.getNodeId());
        assertEquals("nsVpnMonitor", rQuery.getResourceName());
    }
    
    @Test
    public void testCommandParsingWithFilter() {
        ResourceQueryCommandParser parser = new ResourceQueryCommandParser();
        ResourceQuery rQuery = parser.parseQueryCommand(getResourceQueryWithFilter());
        
        assertNotNull(rQuery);
        assertTrue(rQuery.getRrdDir().matches(".*src/test/resources/share/rrd/snmp"));
        assertEquals("10", rQuery.getNodeId());
        assertEquals("nsVpnMonitor", rQuery.getResourceName());
        
        String[] filters = rQuery.getFilters();
        assertEquals(2, filters.length);
        assertEquals("http.dump", filters[0]);
        assertEquals("icmp.jrb", filters[1]);
        
    }
    
    @Test
    public void testCommandParsingWithStringProperty() {
        ResourceQueryCommandParser parser = new ResourceQueryCommandParser();
        ResourceQuery rQuery = parser.parseQueryCommand(getResourceQueryWithStringProperty());
        
        assertNotNull(rQuery);
        assertTrue(rQuery.getRrdDir().matches(".*src/test/resources/share/rrd/snmp"));
        assertEquals("10", rQuery.getNodeId());
        assertEquals("nsVpnMonitor", rQuery.getResourceName());
        
        String[] filters = rQuery.getFilters();
        assertEquals(2, filters.length);
        assertEquals("http.dump", filters[0]);
        assertEquals("icmp.jrb", filters[1]);
        
        String[] properties = rQuery.getStringProperties();
        assertNotNull(properties);
        assertEquals(2, properties.length);
        assertEquals("nsVpnMonVpnName", properties[0]);
        assertEquals("name2", properties[1]);
        
    }
    
    private String getResourceQuery() {
        return "--rrdDir /Users/thedesloge/git/opennms/integrations/opennms-jasper-extensions/src/test/resources/share/rrd/snmp  --nodeid 10 --resourceType nsVpnMonitor";
    }
    
    private String getResourceQueryWithFilter() {
        return "--rrdDir /Users/thedesloge/git/opennms/integrations/opennms-jasper-extensions/src/test/resources/share/rrd/snmp --nodeid 10 --resourceType nsVpnMonitor --dsName http.dump,icmp.jrb";
    }
    
    private String getResourceQueryWithStringProperty() {
        return "--rrdDir /Users/thedesloge/git/opennms/integrations/opennms-jasper-extensions/src/test/resources/share/rrd/snmp --nodeid 10 --resourceType nsVpnMonitor --dsName http.dump,icmp.jrb --string nsVpnMonVpnName,name2";
    }

}
