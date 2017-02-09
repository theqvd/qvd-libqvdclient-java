libqvdclient-java
=================

Qindel QVD Java Client library

For more information please see http://theqvd.com

Prerequisites
=============

These prerequistes are needed to build this package:

 - libqvdclient-c
 - Maven
 - openjdk

Testing
=======

export QVDTESTHOST=qvddemo.theqvd.com
export QVDTESTUSER=myuser
export QVDTESTPASS=mypass
export ARGS4J=$HOME/.m2/repository/args4j/args4j/2.0.16/args4j-2.0.16.jar

make test

Directly trying the JAR
-----------------------
export LD_LIBRARY_PATH=dir1:dir2:dir3
java -jar target/jqvdclient-1.0.0.jar --help

where:

 * dir1 is the location of the NX libXcomp.so library
 * dir2 is the location of the libqvdclientwrapper.so library
 * dir3 is the location of the libqvdclient.so

LICENSE
=======
Copyright (C) 2016  theqvd.com trade mark of Qindel Formacion y Servicios, SL 

libqvdclient is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation version 2 of the License.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
