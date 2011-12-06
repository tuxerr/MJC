#--------------------------------------------------------
# la grammaire (voir src)
XLANG=MJAVA
#--------------------------------------------------------
# repertoires contenant egg
EDIR= .
# les jars associes
GJAR=$(EDIR)/eggc.jar:.
#--------------------------------------------------------
# java, javac, jar
#JDIR=/usr/local/jdk1.6/bin/
#--------------------------------------------------------
all : src att class

src :
	(cd mjc ; $(JDIR)java -cp ../$(GJAR) mg.egg.eggc.internal.compiler.builder.EGGC $(XLANG).egg)

att :
	$(JDIR)javac -classpath $(GJAR) mjc/gc/*.java
#	$(JDIR)javac -classpath $(GJAR) mjc/tds/*.java
#	$(JDIR)javac -classpath $(GJAR) mjc/type/*.java
	$(JDIR)javac -classpath $(GJAR) mjc/compiler/*.java

class :
	$(JDIR)javac -classpath $(GJAR) mjc/egg/*.java

clean :
	rm -rf $(PACKAGE)
	rm -f mjc/compiler/*.class
	rm -f mjc/gc/*.class
	rm -f mjc/tds/*.class
	rm -f mjc/type/*.class
	rm -f mjc/egg/*.java
	rm -f mjc/egg/*.class
	rm -f mjc/egg/*.tds

