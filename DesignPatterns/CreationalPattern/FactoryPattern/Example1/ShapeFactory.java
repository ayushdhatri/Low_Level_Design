

public class ShapeFactory{
    public static Shape createShape(String type){
        if(type.equalsIgnoreCase("circle")){
            return new Circle();
        }
        else if(type.equalsIgnoreCase("rectangle")){
            return new Rectangle();
        }
        else
            throw new IllegalArgumentException("Unknown Shape");
    }
}