package Low_Level_Design.DesignPatterns.CreationalPattern.FactoryPattern.Example1;



public class FactoryDemo {
    public static void main(String [] args){
        Shape s = ShapeFactory.createShape("circle");
        s.draw();
    }
}