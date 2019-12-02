    .model small
.stack 100h

.data

msg1 db "Enter First Decimal Number : $"
msg2 db ,0dh,0ah,"Enter Second Decimal : $"
msg3 db ,0dh,0ah,"Sum of Entered Numbers = $"
num1 db ?
num2 db ?
ans db ?,"$"

.code
main proc
    
    mov ax,@data        ;initialize ds
    mov ds,ax
    
    mov dx,offset msg1  ;load and display msg1
    mov ah,09
    int 21h
    
    mov ah,1h           ;read first initial
    int 21h
    sub al,30h
    
    mov num1,al
    mov dx,offset msg2  ;load and display msg2
    mov ah,9
    int 21h
    
    mov ah,1h           ;read second initial
    int 21h
    sub al,30h
    mov num2,al
    
    mov dx,offset msg3
    mov ah,9            ;load and display msg3
    int 21h
    
    mov al,num1         ;add num1 and num2
    add al,num2
    add al,30h          ;moves value into ans
    mov ans,al
    
    mov dx,offset ans   ;load and display msg3
    mov ah,9
    int 21h
    
                        ;returns control to dos
    mov ah,4ch
    int 21h
    main endp
end main