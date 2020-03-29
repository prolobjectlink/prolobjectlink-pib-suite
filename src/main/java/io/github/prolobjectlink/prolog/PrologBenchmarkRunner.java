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
package io.github.prolobjectlink.prolog;

import static java.util.logging.Level.SEVERE;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.logging.Logger;

import io.github.prolobjectlink.prolog.AbstractBenchmarkRunner;
import io.github.prolobjectlink.prolog.BenchmarkResultEntry;

/**
 * PrologBenchmarkRunner entry point
 * 
 * @author Jose Zalacain
 * @since 1.0
 */
public class PrologBenchmarkRunner {

	public static void main(String[] args) throws IOException {

		Map<String, Set<BenchmarkResultEntry>> map = new HashMap<String, Set<BenchmarkResultEntry>>();

		Class<?> c = AbstractBenchmarkRunner.class;
		ProtectionDomain d = c.getProtectionDomain();
		CodeSource s = d.getCodeSource();

		File out = null;
		File outfile = null;
		FileReader reader = null;
		PrintWriter writer = null;
		BufferedReader buffer = null;
		File jar = new File(s.getLocation().getPath());
		File lib = jar.getParentFile();
		File dist = lib.getParentFile();

		out = new File(dist.getCanonicalPath() + File.separator + "out");
		outfile = new File(dist.getCanonicalPath() + File.separator + "BenchmarkResult.txt");

		try {

			if (out != null && outfile.createNewFile()) {
				writer = new PrintWriter(outfile);
				File[] files = out.listFiles();
				if (files != null) {
					for (File file : files) {

						reader = new FileReader(file);
						buffer = new BufferedReader(reader);
						String line = buffer.readLine();
						while (line != null) {
							StringTokenizer tokenizer = new StringTokenizer(line);
							String label = tokenizer.nextToken();
							String mode = tokenizer.nextToken();
							String count = tokenizer.nextToken();
							String min = tokenizer.nextToken();
							String score = tokenizer.nextToken();
							String max = tokenizer.nextToken();
							String scoreerr = tokenizer.nextToken();
							String stdev = tokenizer.nextToken();
							String unit = tokenizer.nextToken();

							BenchmarkResultEntry e = new BenchmarkResultEntry();
							e.setLabel(label);
							e.setMode(mode);
							e.setCount(Double.parseDouble(count));
							e.setMin(Double.parseDouble(min));
							e.setScore(Double.parseDouble(score));
							e.setMax(Double.parseDouble(max));
							e.setScoreerr(Double.parseDouble(scoreerr));
							e.setStdev(Double.parseDouble(stdev));
							e.setUnit(unit);

							int index = label.indexOf('.');
							String key = label.substring(index + 1);
							Set<BenchmarkResultEntry> x = map.get(key);
							if (x == null) {
								x = new TreeSet<BenchmarkResultEntry>();
								map.put(key, x);
							}
							x.add(e);

							line = buffer.readLine();
						}

					}
				}
			}

			PrintWriter console = System.console().writer();
			for (Entry<String, Set<BenchmarkResultEntry>> entry : map.entrySet()) {
				for (BenchmarkResultEntry result : entry.getValue()) {

					// to console
					console.print(result.getLabel());
					console.print("(min, avg, max) = (");
					console.print(result.getMin());
					console.print(", ");
					console.print(result.getScore());
					console.print(", ");
					console.print(result.getMax());
					console.print(") ");
					console.print(result.getUnit());
					console.print(", ");
					console.print("error = ");
					console.print(result.getScoreerr());
					console.print(", ");
					console.print("stdev = ");
					console.println(result.getStdev());

					// to file
					writer.print(result.getLabel());
					writer.print("(min, avg, max) = (");
					writer.print(result.getMin());
					writer.print(", ");
					writer.print(result.getScore());
					writer.print(", ");
					writer.print(result.getMax());
					writer.print(") ");
					writer.print(result.getUnit());
					writer.print(", ");
					writer.print("error = ");
					writer.print(result.getScoreerr());
					writer.print(", ");
					writer.print("stdev = ");
					writer.println(result.getStdev());

				}

				// to console
				console.println();
				console.println();

				// to file
				writer.println();
				writer.println();

			}

			writer.close();

		} catch (FileNotFoundException e) {
			Logger.getLogger(PrologBenchmarkRunner.class.getName()).log(SEVERE, null, e);
		} catch (IOException e) {
			Logger.getLogger(PrologBenchmarkRunner.class.getName()).log(SEVERE, null, e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					Logger.getLogger(PrologBenchmarkRunner.class.getName()).log(SEVERE, null, e);
				}
			}
			if (buffer != null) {
				try {
					buffer.close();
				} catch (IOException e) {
					Logger.getLogger(PrologBenchmarkRunner.class.getName()).log(SEVERE, null, e);
				}
			}
		}

		System.console().writer().println("Press Enter to exit");
		System.in.read();
		System.exit(0);

	}

}
