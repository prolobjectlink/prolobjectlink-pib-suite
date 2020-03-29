#!/usr/bin/bash
java -classpath "$(dirname "$(pwd)")/lib/*" io.github.prolobjectlink.prolog.jlog.JLogBenchmarkRunner ${1+"$@"}
java -classpath "$(dirname "$(pwd)")/lib/*" io.github.prolobjectlink.prolog.jtrolog.JTrologBenchmarkRunner ${1+"$@"}
java -classpath "$(dirname "$(pwd)")/lib/*" io.github.prolobjectlink.prolog.tuprolog.TuPrologBenchmarkRunner ${1+"$@"}
java -classpath "$(dirname "$(pwd)")/lib/*" io.github.prolobjectlink.prolog.jiprolog.JiPrologBenchmarkRunner ${1+"$@"}
java -classpath "$(dirname "$(pwd)")/lib/*" io.github.prolobjectlink.prolog.jpl.swi.SwiBenchmarkRunner ${1+"$@"}
java -classpath "$(dirname "$(pwd)")/lib/*" io.github.prolobjectlink.prolog.jpl.yap.YapBenchmarkRunner ${1+"$@"}
java -classpath "$(dirname "$(pwd)")/lib/*" io.github.prolobjectlink.prolog.jpl.swi7.Swi7BenchmarkRunner ${1+"$@"}
java -classpath "$(dirname "$(pwd)")/lib/*" io.github.prolobjectlink.prolog.PrologBenchmarkRunner ${1+"$@"}