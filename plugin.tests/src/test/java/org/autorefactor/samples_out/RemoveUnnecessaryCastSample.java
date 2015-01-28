/*
 * AutoRefactor - Eclipse plugin to automatically refactor Java code bases.
 *
 * Copyright (C) 2014-2015 Jean-Noël Rouvignac - initial API and implementation
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program under LICENSE-GNUGPL.  If not, see
 * <http://www.gnu.org/licenses/>.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution under LICENSE-ECLIPSE, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.autorefactor.samples_out;

public class RemoveUnnecessaryCastSample {

    private static final int ONE = 1;
    private byte b;
    private char c;
    private short s;

    public Object removeCastToSameType(Integer i) {
        return i;
    }

    public Object removeCastToIntegerWrapper(int i) {
        return i;
    }

    public Integer doNotRemoveNarrowingCast1(Object o) {
        return (Integer) o;
    }

    public int doNotRemoveNarrowingCast2(Object o) {
        return (Integer) o;
    }

    public long removeWideningPrimitiveCast(int i) {
        return i;
    }

    public int doNotRemovePrimitiveNarrowingCast(long l) {
        return (int) l;
    }

    public void removeAssignmentCasts(Integer oi, int pi, Object o) {
        Object o1;
        long l;
        int i;
        o1 = oi;
        o1 = pi;
        l = pi;
        i = pi;
    }

    public void doNotRemoveAssignmentCasts(Object o, long l) {
        Integer oi;
        int i;
        oi = (Integer) o;
        i = (Integer) o;
        i = (int) l;
    }

    public void removeVariableDeclarationFragmentCasts(Integer oi, int pi, Object o) {
        Object o1 = oi;
        Object o2 = pi;
        long l = pi;
    }

    public void doNotRemoveVariableDeclarationFragmentCasts(Object o, long l) {
        Integer oi1 = (Integer) o;
        int pi2 = (Integer) o;
        int pi3 = (int) l;
    }

    public boolean removeCasts(Integer oi, int pi, long l) {
        return oi != pi
            && pi != oi
            && oi != pi
            && pi != oi
            && l != pi
            && pi != l;
    }

    public boolean doNotRemoveCasts(Integer oi, int pi, long l, Object o) {
        return (int) l != pi
            && pi != (int) l
            && (Integer) o != pi // TODO test cast to (int) after moving to Java 7 builds
            && pi != (Integer) o // TODO test cast to (int) after moving to Java 7 builds
            && (Integer) o != oi // TODO test cast to (int) after moving to Java 7 builds
            && oi != (Integer) o; // TODO test cast to (int) after moving to Java 7 builds
    }

    public boolean doNotRemovePrimitiveNarrowingCastsWithComparison(int i) {
        return (byte) i == 0
            && 0 == (byte) i
            && (char) i == 0
            && 0 == (char) i
            && (short) i == 0
            && 0 == (short) i;
    }

    public long doNotRemoveWideningCast(int i, int j) {
        return (long) i + j;
    }

    public long doNotRemoveWideningCastsWithExtendedOperands(int i, int j, int k) {
        return (long) i + j + k;
    }

    public int doNotRemovePrimitiveNarrowingCasts(int i, int j) {
        return (byte) i + j;
    }

    public int doNotRemovePrimitiveNarrowingCastsWithExtendedOperands(int i, int j) {
        return (byte) i + j + (byte) i;
    }

    public String removeCastsFromStringAppend(Integer oi, int pi, Object o) {
        return "" + oi + oi + oi + pi + pi + o;
    }

    public String doNotRemoveCastsFromStringAppend(int pi, long l, float f) {
        return "" + (byte) pi + (int) f;
    }

    public double removeSomeCastsFromDivisionWithDifferentTypes(int i, long l) {
        return (double) i / l;
    }

    public double removeSomeCastsFromDivisionWithDifferentTypesWithExtendedOperands(int i, long l, short s) {
        return (double) i / l / s;
    }

    public double doNotRemoveCastsFromAdditionWhenResultIsWidened(Integer oi, int pi, long l) {
        return (long) oi + pi + (double) l;
    }

    public double doNotRemoveCastsFromSoustractionWhenResultIsWidened(Integer oi, int pi, long l) {
        return (long) oi - pi - (double) l;
    }

    public boolean removeCastsFromBooleanOperations(boolean b1, boolean b2) {
        return b1 && b2;
    }

    public double doNotRemoveCastInFloatingPointDivision(int i, int j) {
        return i / (double) j;
    }

    public double removeOneCastInFloatingPointDivision(int i, int j, int k) {
        return i / (double) j / k;
    }

    public long removeCastsInIntegralDivision(int i, int j, int k) {
        return i / j / k;
    }

    public int removeCastsFromAssignmentsToByte() {
        byte b1 = -1;
        byte b2 = 127;
        byte b3 = -128;
        byte b4 = ONE;
        Byte b5 = -1;
        Byte b6 = 127;
        Byte b7 = -128;
        Byte b8 = ONE;
        b = 1;
        return b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8 + b;
    }

    public int removeCastsFromAssignmentsToChar() {
        char c1 = 0;
        char c2 = 65535;
        char c3 = ONE;
        Character c4 = 0;
        Character c5 = 65535;
        Character c6 = ONE;
        c = 1;
        return c1 + c2 + c3 + c4 + c5 + c6 + c;
    }

    public int removeCastsFromAssignmentsToShort() {
        short s1 = -1;
        short s2 = 32767;
        short s3 = -32768;
        short s4 = ONE;
        Short s5 = -1;
        Short s6 = 32767;
        Short s7 = -32768;
        Short s8 = ONE;
        s = 1;
        return s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s;
    }

    public int doNotRemoveCastsFromPrimitiveAssignments() {
        byte b1 = (byte) 128;
        byte b2 = (byte) -129;
        char c1 = (char) -1;
        char c2 = (char) 65536;
        short s1 = (short) 32768;
        short s2 = (short) -32769;
        return b1 + b2 + c1 + c2 + s1 + s2;
    }
}
