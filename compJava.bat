javac %1.java 
javah %1

ml /c /coff /Cp %2.asm
link /DLL /NOENTRY /subsystem:windows /DEF:%2.def %2.obj

java %1