/**********************************************
Workshop 3
Course: JAC444 - 2022 Winter
Last Name: Tao
First Name: Henry
ID: 118375203
Section: NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature: Henry
Date: Date: 02/13/2022
**********************************************/

package Task1;

public class Triangle extends GeometricObject{
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	
	public Triangle() {}
	
	public Triangle(double side1, double side2, double side3){
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	public double getSide1() {
		return side1;
	}
	
	public double getSide2() {
		return side2;
	}
	
	public double getSide3() {
		return side3;
	}
	
	@Override
	public double getArea(){
		double s = (side1 + side2 + side3) / 2;
		return Math.pow((s * (s - side1) * (s - side2) * (s - side3)), 0.5);
	}
	
	@Override
	public double getPerimeter() {
		return (side1 + side2 + side3);
	}
	
	public String toString() {
		String result = "Triangle with sides of: " + side1 + ", " + side2 + ", " + side3 + ", parameter of: " + getPerimeter() + ", area of: " + getArea() + ", color: " + getColor();
		if (getFilled()) {
			result += ", is filled";
		} else {
			result += ", is not filled";
		}
		return result;
	}
}
