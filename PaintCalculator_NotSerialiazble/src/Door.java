import java.io.Serializable;

public class Door implements Paintable, Serializable {
    private double width;
    private double length;
    private static int doorCount;
    public Door(double Length,double Width){
       width=Width;
       length=Length;
       doorCount++;
    }
    @Override
    public double getPremiumCost() {
        return width*length*PREMIUM_PAINT_COST_PER_GALLON*2;
    }

    @Override
    public double getStandardCost() {
        return width*length*STANDARD_PAINT_COST_PER_GALLON*2;
    }
    public double getArea(){
        return length*width;
    }
    @Override
    public String toString(){
        return "Door Number "+doorCount+" has a paint-required surface area of "+getArea();
    }
}
