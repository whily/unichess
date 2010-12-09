UniChess
========

UniChess is the all-in-one tool for chess playing, training and
database management. It has following features:

* Play chess either vs. computer or online.
* Provides both internal [UCI engine](http://en.wikipedia.org/wiki/Universal_Chess_Interface)
  and can use external UCI engine as well.
* Integrated database managment and opening repertoire preparation.
* Training for opening, tactics and endgame.
* Run on virtualy every platform (if Java supports).
* ...

UniChess is written in [Scala](http://www.scala-lang.org).

For more information about UniChess, please go to
  <https://github.com/whily/unichess>

Wiki pages can be found at
  <https://wiki.github.com/whily/unichess>

Installation
------------

One needs to install JRE or JDK version 6 from <http://www.java.com>
if Java is not available. Note that JDK is preinstalled on Mac OS X
and available via package manager on many Linux systems.

Put following jars in your classpath:

* scala-library.jar (Scala standard library). Please make sure the 
  version is at least 2.8.1.
* SWT (The Standard Widget Toolkit). Please get the latest version 
  from [here](http://www.eclipse.org/swt)

Development
-----------

UniChess is built using
[sbt](http://code.google.com/p/simple-build-tool). Therefore to
compile, test, and run UniChess from a developer's point of view, one
needs to install JDK, Scala, and sbt, then use sbt commands like
<code>sbt update</code> to pull all the dependencies. For further
information on usage of sbt, please consult relevant pages.

Acknowledgement
---------------

The author got lots of help from open source Chess software like
[Stockfish](http://www.stockfishchess.com),
[Crafty](http://www.craftychess.com), and
[Scid](http://scid.sourceforge.net). For opening repertoire
preparation, [Chess Position
Trainer](http://www.chesspositiontrainer.com) teaches the author a
lots about how such task could be handled by software. Last but not
the least, [Shannon's seminal
paper](http://vision.unipv.it/IA1/ProgrammingaComputerforPlayingChess.pdf),
[Chess Programming Wiki](http://chessprogramming.wikispaces.com) and
[Wikipedia](http://en.wikipedia.org/wiki/Computer_chess) are
invaluable sources to understand chess programming.

License
-------

UniChess is released under GNU General Public License v2, whose information
is available at:
  <http://www.gnu.org/licenses/gpl-2.0.html>

