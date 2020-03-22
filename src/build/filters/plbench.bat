@echo off

SET CURRENT_DIRECTORY=%~dp0
for %%B in (%CURRENT_DIRECTORY%.) do set PROLOBJECTLINK_HOME=%%~dpB
SET CLASSPATH=%PROLOBJECTLINK_HOME%lib\*

: default jdk
java -classpath %CLASSPATH% org.prolobjectlink.prolog.jlog.JLogBenchmarkRunner %*
java -classpath %CLASSPATH% org.prolobjectlink.prolog.jtrolog.JTrologBenchmarkRunner %*
java -classpath %CLASSPATH% org.prolobjectlink.prolog.tuprolog.TuPrologBenchmarkRunner %*
java -classpath %CLASSPATH% org.prolobjectlink.prolog.jiprolog.JiPrologBenchmarkRunner %*
java -classpath %CLASSPATH% org.prolobjectlink.prolog.jpl.swi.SwiBenchmarkRunner %*
java -classpath %CLASSPATH% org.prolobjectlink.prolog.jpl.yap.YapBenchmarkRunner %*
java -classpath %CLASSPATH% org.prolobjectlink.prolog.jpl.swi7.Swi7BenchmarkRunner %*
java -classpath %CLASSPATH% org.prolobjectlink.prolog.PrologBenchmarkRunner %*