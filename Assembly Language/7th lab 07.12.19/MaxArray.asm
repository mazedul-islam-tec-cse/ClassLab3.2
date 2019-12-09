.model small
.stack   100h
.data

array db 1,2,3,4,5 
sum db 0

a db ?

.code

main proc
    mov ax,@data
    mov ds,ax
    
    mov cx,5
    mov di,0
    mov al,0    
    
    compare:
       cmp al, array[di]
       ja next
       mov al,array[di]   
       
    next:
    
       inc di
       loop compare
       mov ah,2
       add al,48
       mov dl,al
       int 21h
       
     end main 
main endp    
    
    