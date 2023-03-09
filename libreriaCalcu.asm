.386
.model flat, stdcall

.code

Java_Calculadora_sumar proc JNIEnv:Dword, jobject:Dword, a:QWord, b:Qword
    fld a ;carga a la pila de punto flotante
    fld b 
    
    faddp st(1), st(0) ;por defecto hace la suma y quita el ultimo valor de la pila, en este caso b
    
    ret ;por default se retorna el valor de la pila
Java_Calculadora_sumar endp

Java_Calculadora_restar proc JNIEnv:Dword, jobject:Dword, a:QWord, b:QWord
    fld a 
    fld b 

    fsubp st(1), st(0) 

    ret 
Java_Calculadora_restar endp

Java_Calculadora_multiplicar proc JNIEnv:Dword, jobject:Dword, a:QWord, b:QWord
    fld a 
    fld b 

    fmulp st(1), st(0) 

    ret 
Java_Calculadora_multiplicar endp

Java_Calculadora_dividir proc JNIEnv:Dword, jobject:Dword, a:QWord, b:QWord
    fld a 
    fld b 

    fdivp st(1), st(0) 

    ret 
Java_Calculadora_dividir endp

end




