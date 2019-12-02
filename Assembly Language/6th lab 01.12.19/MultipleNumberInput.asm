.model small
.stack 100h 
.code

main proc
    mov bh,0
    mov bl,10d
    
    input:
          mov ah,1
          int 21h
          cmp al,13d
          jne number
          jmp exit
          
    number:
          sub al,30h
          mov cl,al
          mov al,bh
          mul bl
          add al,cl
          mov bh,al
          jmp input
    exit:
        
       main endp

end main
           
          

