/* $RCSfile$
 * $Author$    
 * $Date$    
 * $Revision$
 * 
 * Copyright (C) 1997-2007  The Chemistry Development Kit (CDK) project
 * 
 * Contact: cdk-devel@lists.sourceforge.net
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA. 
 * 
 */
package org.openscience.cdk.debug;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openscience.cdk.interfaces.IAtom;
import org.openscience.cdk.interfaces.ILonePair;
import org.openscience.cdk.interfaces.ILonePairTest;

/**
 * Checks the functionality of the {@link DebugLonePair}.
 *
 * @cdk.module test-datadebug
 */
public class DebugLonePairTest extends ILonePairTest {

    @BeforeClass public static void setUp() {
        setChemObject(new DebugLonePair());
    }

    @Test public void testDebugLonePair() {
        ILonePair lp = new DebugLonePair();
        Assert.assertTrue(lp.getAtom() == null);
        Assert.assertEquals(2, lp.getElectronCount().intValue());
    }
    
    @Test public void testDebugLonePair_IAtom() {
        IAtom atom = getBuilder().newAtom("N");
        ILonePair lp = new DebugLonePair(atom);
        Assert.assertEquals(2, lp.getElectronCount().intValue());
        Assert.assertEquals(atom, lp.getAtom());
        Assert.assertTrue(lp.contains(atom));
    }
}
