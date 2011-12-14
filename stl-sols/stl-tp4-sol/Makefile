#--------------------------------------------------------
# la grammaire (voir src)
XLANG=BLOC
#--------------------------------------------------------
# repertoires contenant egg
#EDIR=/usr/local/gen6/egg502
EDIR=.
# les jars associes
GJAR=$(EDIR)/eggc.jar:.
#--------------------------------------------------------
# java, javac, jar
#JDIR=/usr/local/jdk1.6/bin
JDIR=/usr/bin
#--------------------------------------------------------
all : src att class

src :
	(cd bloc ; $(JDIR)/java -cp ../$(GJAR) mg.egg.eggc.internal.compiler.builder.EGGC $(XLANG).egg)

att :
	$(JDIR)/javac -classpath $(GJAR) bloc/lib/*.java
	$(JDIR)/javac -classpath $(GJAR) bloc/compiler/*.java

class :
	$(JDIR)/javac -classpath $(GJAR) bloc/egg/*.java

clean :
	rm -rf $(PACKAGE)
	rm -f bloc/lib/*.class
	rm -f bloc/compiler/*.class
	rm -rf bloc/egg

