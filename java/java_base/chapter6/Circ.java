package com.labrick;

public class Circ{
    final float PI = 3.14159f;
    public float r = 0.0f;
    public float getArea(){
        float area = PI * r * r;
        return area;
    }
    public float getCircumference(float r){
        float circumference = 2 * PI * r;
        return circumference;
    }
    public static void main(String[] args){
        Circ circ = new Circ();
        circ.r = 20;
        float r = 20;
        float area = circ.getArea();
        System.out.println("area of the circ is " + area);
        float circumference = circ.getCircumference(r);
        System.out.println("circumference of the circ is " + circumference);
    }
}
