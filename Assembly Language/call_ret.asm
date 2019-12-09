.model small
.stack 100h
.data

.code
main proc  
    
    mov ax,@data
    mov ds,ax
    
    call p1
    jmp exit
    
    
    p1 proc
        call p2
        mov ah,2
        mov dl,'2'
        int 21h
        ret
        
    p2 proc
        mov ah,2
        mov dl,'1'
        int 21h 
        ret
             
    exit:
        mov ah,4ch
        int 21h 
        
