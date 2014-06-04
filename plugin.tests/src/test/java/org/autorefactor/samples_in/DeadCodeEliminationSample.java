/*
 * AutoRefactor - Eclipse plugin to automatically refactor Java code bases.
 *
 * Copyright (C) 2013 Jean-Noël Rouvignac - initial API and implementation
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
package org.autorefactor.samples_in;

public class DeadCodeEliminationSample {

	private int removeEmptyElseClause(boolean b) {
		int i = 0;
		if (b) {
			i++;
		} else {
		}
		return i;
	}

	private int doesNotKnowHowToRemoveEmptyThenClause(boolean b) {
		int i = 0;
		if (b) {
		} else {
			i++;
		}
		return i;
	}

	private int removeImpossibleIfClauses() {
		int i = 0;
		int j = 0;
		if (true) {
			i++;
		} else {
			j++;
		}

		if (true)
			i++;
		else
			j++;

		if (false) {
			i++;
		} else {
			j++;
		}

		if (false)
			i++;
		else
			j++;

		return i + j;
	}

	private int removeWhileWithoutIterations() {
		int i = 0;
		while (false) {
			i++;
		}
		while (false)
			i++;
		return i;
	}

	private int removeEmptyTry() {
		int i = 0;
		try {
		} catch (Exception e) {
			i++;
		} finally {
			i++;
		}
		return i;
	}

}