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

package org.openscience.cdk;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openscience.cdk.interfaces.IAtom;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.interfaces.IBond;
import org.openscience.cdk.interfaces.IMolecule;
import org.openscience.cdk.interfaces.IMoleculeTest;

/**
 * Checks the functionality of the Molecule class.
 *
 * @cdk.module test-data
 *
 * @see org.openscience.cdk.Molecule
 */
public class MoleculeTest extends IMoleculeTest {

    @BeforeClass public static void setUp() {
        setChemObject(new Molecule());
    }

    // test constructors
    
    @Test public void testMolecule() {
        IMolecule m = getBuilder().newMolecule();
        Assert.assertTrue(m != null);
    }

    @Test public void testMolecule_int_int_int_int() {
        IMolecule m = getBuilder().newMolecule(5,5,1,1);
        Assert.assertTrue(m != null);
        Assert.assertEquals(0, m.getAtomCount());
        Assert.assertEquals(0, m.getBondCount());
        Assert.assertEquals(0, m.getLonePairCount());
        Assert.assertEquals(0, m.getSingleElectronCount());
    }

    @Test public void testMolecule_IAtomContainer() {
        IAtomContainer acetone = new org.openscience.cdk.AtomContainer();
        IAtom c1 = getBuilder().newAtom("C");
        IAtom c2 = getBuilder().newAtom("C");
        IAtom o = getBuilder().newAtom("O");
        IAtom c3 = getBuilder().newAtom("C");
        acetone.addAtom(c1);
        acetone.addAtom(c2);
        acetone.addAtom(c3);
        acetone.addAtom(o);
        IBond b1 = getBuilder().newBond(c1, c2, IBond.Order.SINGLE);
        IBond b2 = getBuilder().newBond(c1, o, IBond.Order.DOUBLE);
        IBond b3 = getBuilder().newBond(c1, c3, IBond.Order.SINGLE);
        acetone.addBond(b1);
        acetone.addBond(b2);
        acetone.addBond(b3);
        
        IMolecule m = getBuilder().newMolecule(acetone);
        Assert.assertTrue(m != null);
        Assert.assertEquals(4, m.getAtomCount());
        Assert.assertEquals(3, m.getBondCount());
    }

}
