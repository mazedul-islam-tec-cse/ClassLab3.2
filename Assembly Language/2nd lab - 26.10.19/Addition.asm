
; You may customize this and other start-up templates; 
; The location of this template is c:\emu8086\inc\0_com_template.txt

org 100h

.MODEL SMALL
.STACK 100H
.DATA
a db 2
b db 3
sum db ? 
.CODE

MAIN PROC
    
    
    mov ax,@data
    mov ds,ax
    
    mov al,a
    mov bl,b
    
    add al,bl   
    add al,30h
    mov sum,al 
  
    
    mov ah,02   
    mov dl,al
    int 21h
    
    mov ax,4CH
    int 21h
    
    
    
   MAIN ENDP
END MAIN

ret




