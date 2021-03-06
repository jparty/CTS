/*
 * Coordinate Transformations Suite (abridged CTS)  is a library developped to 
 * perform Coordinate Transformations using well known geodetic algorithms 
 * and parameter sets. 
 * Its main focus are simplicity, flexibility, interoperability, in this order.
 *
 * This library has been originally developed by Michaël Michaud under the JGeod
 * name. It has been renamed CTS in 2009 and shared to the community from 
 * the Atelier SIG code repository.
 * 
 * Since them, CTS is supported by the Atelier SIG team in collaboration with Michaël 
 * Michaud.
 * The new CTS has been funded  by the French Agence Nationale de la Recherche 
 * (ANR) under contract ANR-08-VILL-0005-01 and the regional council 
 * "Région Pays de La Loire" under the projet SOGVILLE (Système d'Orbservation 
 * Géographique de la Ville).
 *
 * CTS is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * CTS is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * CTS. If not, see <http://www.gnu.org/licenses/>.
 *
 * For more information, please consult: <https://github.com/irstv/cts/>
 */
package org.cts.op;

import org.cts.CTSTestCase;
import org.cts.IllegalCoordinateException;
import org.cts.crs.CoordinateReferenceSystem;
import org.cts.crs.GeodeticCRS;

import java.util.List;

/**
 *
 * @author Erwan Bocher
 */
public class BaseCoordinateTransformTest extends CTSTestCase {

    protected boolean verbose = false;

    /**
     * Transform a point from a CRS to another CRS
     *
     * @param sourceCRS
     * @param targetCRS
     * @param inputPoint
     * @return
     * @throws IllegalCoordinateException
     */
    public double[] transform(GeodeticCRS sourceCRS, GeodeticCRS targetCRS, double[] inputPoint) throws IllegalCoordinateException {
        List<CoordinateOperation> ops;
        ops = CoordinateOperationFactory.createCoordinateOperations(sourceCRS, targetCRS);
        if (!ops.isEmpty()) {
            if (verbose) {
                System.out.println(ops.get(0));
            }
            return ops.get(0).transform(new double[]{inputPoint[0], inputPoint[1], inputPoint[2]});
        } else {
            return new double[]{0.0d, 0.0d, 0.0d};
        }
    }

    /**
     * Display the CRS in a WKT representation
     *
     * @param crs
     */
    public void printCRStoWKT(CoordinateReferenceSystem crs) {
        System.out.println(crs.toWKT());
    }
}
