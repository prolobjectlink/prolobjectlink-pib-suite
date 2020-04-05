@echo off

SET CURRENT_DIRECTORY=%~dp0
for %%B in (%CURRENT_DIRECTORY%.) do set PROLOBJECTLINK_HOME=%%~dpB
SET CLASSPATH=%PROLOBJECTLINK_HOME%lib\*

: default jdk
java -classpath %CLASSPATH% io.github.prolobjectlink.prolog.jlog.JLogBenchmarkRunner %*
java -classpath %CLASSPATH% io.github.prolobjectlink.prolog.jtrolog.JTrologBenchmarkRunner %*
java -classpath %CLASSPATH% io.github.prolobjectlink.prolog.tuprolog.TuPrologBenchmarkRunner %*
java -classpath %CLASSPATH% io.github.prolobjectlink.prolog.jiprolog.JiPrologBenchmarkRunner %*
java -classpath %CLASSPATH% io.github.prolobjectlink.prolog.jpl.swi.SwiBenchmarkRunner %*
java -classpath %CLASSPATH% io.github.prolobjectlink.prolog.jpl.yap.YapBenchmarkRunner %*
java -classpath %CLASSPATH% io.github.prolobjectlink.prolog.ip.xsb.XsbBenchmarkRunner %*
java -classpath %CLASSPATH% io.github.prolobjectlink.prolog.jpl.swi7.Swi7BenchmarkRunner %*
java -classpath %CLASSPATH% io.github.prolobjectlink.prolog.PrologBenchmarkRunner %*