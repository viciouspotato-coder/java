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

public abstract class GeometricObject {
	private String color = "white";
	private boolean filled;
	
	protected GeometricObject() {}
	
	protected GeometricObject(String color, boolean filled) {
		setColor(color);
		setFilled(filled);
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean getFilled() {
		return filled;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public abstract double getArea();
	
	public abstract double getPerimeter();
}
