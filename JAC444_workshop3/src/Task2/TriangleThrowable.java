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

package Task2;

import Task1.GeometricObject;

public class TriangleThrowable extends GeometricObject{
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	
	public TriangleThrowable(){}
	
	public TriangleThrowable(double side1, double side2, double side3) throws TriangleException {
		if((side1 + side2) > side3 && (side1 + side3) > side2 && (side2 + side3) > side1) {
			this.side1 = side1;
			this.side2 = side2;
			this.side3 = side3;
		} else {
			throw new TriangleException();
		}
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
		return "Triangle with sides of: " + side1 + ", " + side2 + ", " + side3 + ", parameter of: " + getPerimeter() + ", area of: " + getArea();
	}
}
