set path=C:\Program Files\Java\jdk1.6.0\bin;
set classpath=.;
javac *.java
rmic ECImpl
start rmiregistry
pause