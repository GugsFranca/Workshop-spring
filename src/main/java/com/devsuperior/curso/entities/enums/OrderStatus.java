package com.devsuperior.curso.entities.enums;

public enum OrderStatus {
    WAITING_PAYMENT("Waiting payment", 1),
    PAID("Paid", 2),
    SHIPPED("Shipped", 3),
    DELIVERED("Delivered", 4),
    CANCELED("Canceled", 5);

    private String name;
    private int num;


    private OrderStatus(String name, int num){
        this.name = name;
        this.num = num;
    }
    public String getName(){
        return name;
    }
    public int getNum(){
        return num;
    }
    public static OrderStatus valueOF(String name){
        for(OrderStatus value : OrderStatus.values()){
            if(value.getName().equals(name) ){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }

}
