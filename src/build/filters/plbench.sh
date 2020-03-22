#!/usr/bin/bash
java -classpath "$(dirname "$(pwd)")/lib/*" org.prolobjectlink.prolog.jlog.JLogBenchmarkRunner ${1+"$@"}
java -classpath "$(dirname "$(pwd)")/lib/*" org.prolobjectlink.prolog.jtrolog.JTrologBenchmarkRunner ${1+"$@"}
java -classpath "$(dirname "$(pwd)")/lib/*" org.prolobjectlink.prolog.tuprolog.TuPrologBenchmarkRunner ${1+"$@"}
java -classpath "$(dirname "$(pwd)")/lib/*" org.prolobjectlink.prolog.jiprolog.JiPrologBenchmarkRunner ${1+"$@"}
java -classpath "$(dirname "$(pwd)")/lib/*" org.prolobjectlink.prolog.jpl.swi.SwiBenchmarkRunner ${1+"$@"}
java -classpath "$(dirname "$(pwd)")/lib/*" org.prolobjectlink.prolog.jpl.yap.YapBenchmarkRunner ${1+"$@"}
java -classpath "$(dirname "$(pwd)")/lib/*" org.prolobjectlink.prolog.jpl.swi7.Swi7BenchmarkRunner ${1+"$@"}
java -classpath "$(dirname "$(pwd)")/lib/*" org.prolobjectlink.prolog.PrologBenchmarkRunner ${1+"$@"}