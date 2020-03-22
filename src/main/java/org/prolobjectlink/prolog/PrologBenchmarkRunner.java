/*-
 * #%L
 * prolobjectlink-pib-suite
 * %%
 * Copyright (C) 2012 - 2020 Prolobjectlink Project
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */
package org.prolobjectlink.prolog;

import java.io.IOException;

/**
 * PrologBenchmarkRunner entry point
 * 
 * @author Jose Zalacain
 * @since 1.0
 */
public class PrologBenchmarkRunner {

	public static void main(String[] args) throws IOException {
		System.console().writer().println("Press Enter to exit");
		System.in.read();
		System.exit(0);
	}

}