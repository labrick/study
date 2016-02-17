public class Cire implements Calculate{
    public float getArea(float r){
        float area = PI * r * r;
        return area;
    }
    public float getCircumference(float r){
        float circumference = 2 * PI * r;
        return circumference;
    }
}
