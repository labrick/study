public class Circ implements Calculate, GeometryShape{
    public float getArea(float r){
        float area = Calculate.PI * r * r;
        return area;
    }
    public float getCircumference(float r){
        float circumference = 2 * Calculate.PI * r;
        return circumference;
    }
    public void draw(){
        System.out.println("draw a circle");
    }
    public static void main(String[] args){
        Circ circ = new Circ();
        float r = 7;
        float area = circ.getArea(r);
        System.out.println("area of circle is " + area);
        float circumference = circ.getCircumference(r);
        System.out.println("circumference of circle is " + circumference);
        circ.draw();
    }
}
