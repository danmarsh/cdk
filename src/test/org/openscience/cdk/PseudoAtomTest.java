/* $RCSfile$
 * $Author$    
 * $Date$    
 * $Revision$
 * 
 * Copyright (C) 2003-2007  The Chemistry Development Kit (CDK) project
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
package org.openscience.cdk;

import javax.vecmath.Point2d;
import javax.vecmath.Point3d;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openscience.cdk.interfaces.IElement;
import org.openscience.cdk.interfaces.IPseudoAtom;
import org.openscience.cdk.interfaces.IPseudoAtomTest;

/**
 * Checks the functionality of the AtomTypeFactory
 *
 * @cdk.module test-data
 */
public class PseudoAtomTest extends IPseudoAtomTest {

    @BeforeClass public static void setUp() {
       	setChemObject(new PseudoAtom());
    }

    @Test public void testPseudoAtom() {
        IPseudoAtom a = getBuilder().newPseudoAtom();
        Assert.assertEquals("R", a.getSymbol());
        Assert.assertNull(a.getPoint3d());
        Assert.assertNull(a.getPoint2d());
        Assert.assertNull(a.getFractionalPoint3d());
    }
    
    @Test public void testPseudoAtom_IElement() {
    	IElement element = getBuilder().newElement();
        IPseudoAtom a = getBuilder().newPseudoAtom(element);
        Assert.assertEquals("R", a.getSymbol());
        Assert.assertNull(a.getPoint3d());
        Assert.assertNull(a.getPoint2d());
        Assert.assertNull(a.getFractionalPoint3d());
    }
    
    @Test public void testPseudoAtom_String() {
        String label = "Arg255";
        IPseudoAtom a = getBuilder().newPseudoAtom(label);
        Assert.assertEquals("R", a.getSymbol());
        Assert.assertEquals(label, a.getLabel());
        Assert.assertNull(a.getPoint3d());
        Assert.assertNull(a.getPoint2d());
        Assert.assertNull(a.getFractionalPoint3d());
    }

    @Test public void testPseudoAtom_String_Point2d() {
        Point2d point = new Point2d(1.0, 2.0);
        String label = "Arg255";
        IPseudoAtom a = getBuilder().newPseudoAtom(label, point);
        Assert.assertEquals("R", a.getSymbol());
        Assert.assertEquals(label, a.getLabel());
        Assert.assertEquals(point, a.getPoint2d());
        Assert.assertNull(a.getPoint3d());
        Assert.assertNull(a.getFractionalPoint3d());
    }

    @Test public void testPseudoAtom_String_Point3d() {
        Point3d point = new Point3d(1.0, 2.0, 3.0);
        String label = "Arg255";
        IPseudoAtom a = getBuilder().newPseudoAtom(label, point);
        Assert.assertEquals("R", a.getSymbol());
        Assert.assertEquals(label, a.getLabel());
        Assert.assertEquals(point, a.getPoint3d());
        Assert.assertNull(a.getPoint2d());
        Assert.assertNull(a.getFractionalPoint3d());
    }
}
