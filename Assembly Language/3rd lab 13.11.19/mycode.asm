.model small
.stack 100h

.data 

   CR EQU 0DH
   LE EQU 0AH  
   
msg1 db 'Enter an upper case letter : $'
msg2 db 0DH,0AH,'In Lower case it is : '
char db ?,'$'
.CODE

MAIN PROC
    
    mov ax,@data
    mov ds,ax
    
    LEA dx,msg1
    mov ah,9
    int 21h
    
    mov ah,1
    int 21h
    add al,20h
    mov char,al
    
    LEA dx,msg2
    mov ah,9
    int 21h
    
    mov ah,4ch
    int 21h
    
    MAIN ENDP
END MAIN