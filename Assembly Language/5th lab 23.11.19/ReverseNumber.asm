.MODEL SMAL
.STACK 100H
.CODE
MAIN PROC
    
    MOV AH,2        ; prepare to display
    MOV DL  ,'?'    ; char to display
    INT 21H         ; display '?'
    
    XOR CX,CX       ; COUNT = 0
    
    MOV AH,1        ; PREPARE TO READ
    INT 21H         ; read a char    
    
WHILE_:   
                    
    CMP AL,0DH      ; CR  
    JE END_WHILE
    PUSH AX
    INC CX
    
    INT 21H
    JMP WHILE_
    
END_WHILE:     
     
    MOV AH,2        ; display char fcn
    MOV DL,0DH      ; CR
    INT 21H
    MOV DL,0AH
    INT 21H
    JCXZ EXIT       ; exit no char read

TOP:
    
    POP DX
    INT 21H
    LOOP TOP

EXIT:
     
    MOV AH,4CH
    INT 21H

MAIN ENDP 

     END MAIN
    
    
    
    
    