import java.util.Scanner;
class coordinate{
    int x;
    int y;
    coordinate(){
        this.x = 0;
        this.y = 0;
    }
    coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Base{
    private int x;
    private int y;
    // default constructor
    Base(){
        x = 0;
        y = 0;
    }
    // To initialize the value of x and y.
    Base(int x, int y){
        this.x = x;
        this.y = y;
    }
    // find the distance between self and other point.
    double distance(int x, int y){
        return Math.sqrt(((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y)));
    }

    coordinate translate(int x, int y){
        return new coordinate((x + this.x), (y + this.y));  // coordinate is a new object.
    }
}

class Shape extends Base{
    double area(double pi, int radius){
        return (pi * radius * radius);
    }
    double area(int side){
        return (side * side);
    }
}

class Circle extends Shape{
    double area;
    Circle(double pi, int radius){
        area = area(pi, radius);
    }
}

class Sqare extends Shape{
    double area;
    Sqare(int side){
        area = area(side);
    }
}

public class Assignementquestion7{
    // take coordinate as input.
    Scanner userInput = new Scanner(System.in);
    public coordinate inputPoint(){
        int x = userInput.nextInt();
        int y = userInput.nextInt();
        return new coordinate(x, y);
    }
    public static void main(String args[]){
        Scanner userInput = new Scanner(System.in);
        try{
            int operation = 1;
            double result;
            coordinate coordinates = new coordinate();
            Base point = new Base();
            Assignementquestion7 otherPoint = new Assignementquestion7();
            String text = """
                             0. If not perform any operation.
                             1. Find distance between two points.
                             2. Transfer point.
                             3. Find the area of a circle.
                             4. Find the area of a square.""";
            System.out.println(text);
            while(operation != 0){
                System.out.print("Enter operation : ");
                operation = userInput.nextInt();
                if(operation == 0) return;
                if(operation == 1 || operation == 2){
                    System.out.print("Enter base point coordinate : ");
                    coordinates = otherPoint.inputPoint();
                    point = new Base(coordinates.x, coordinates.y);
                    System.out.print("Enter coordinate of point : ");
                    coordinates = otherPoint.inputPoint();
                }

                // select operation.
                switch(operation){
                    case 1 : result = point.distance(coordinates.x, coordinates.y);
                        System.out.println("distance btw points : " + result);
                        break;
                    case 2 : coordinates = point.translate(coordinates.x, coordinates.y);
                        System.out.println("transferred points : (" + coordinates.x + ", " + coordinates.y +")");
                        break;
                    case 3 : Circle circle = new Circle(3.1415, 5);
                        System.out.printf("Area of circle is : %.2f%n", circle.area);
                        break;
                    case 4 : Sqare square = new Sqare(2);
                        System.out.println("Area of circle is : " + square.area);
                        break;
                    default : System.out.print("Invalid input.");
                }
            }
        }
        catch(Exception e){
            System.out.println("Invalid input");
        }
    }
}