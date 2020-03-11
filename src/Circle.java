import java.awt.Color;

public class Circle {

	private double radius;
	private double centerX;
	private double centerY;
	private Color color;
	
	
	public Circle(double radius, double centerX, double centerY, Color color) {
		super();
		
		if(radius > 0) this.radius = radius;
		else this.radius = 1;
		this.centerX = centerX;
		this.centerY = centerY;
		
		this.color = color;
	}
	
	public Circle(double radius, double centerX, double centerY) {
		super();

		if(radius > 0) this.radius = radius;
		else this.radius = 1;
		this.centerX = centerX;
		this.centerY = centerY;
		
		this.color = Color.BLUE;
	}
	
	public Circle() {
		super();
		
		this.radius = 1;
		this.centerX = 0;
		this.centerY = 0;
		this.color = Color.BLUE;
		
	}
	
	public double getDimension() {
		
		return this.radius * 2;
	}
	
	public double getWzor() {
		
		return 2137;
	}
	
	public double getArea() {
		
		return Math.PI * radius * radius;
	}
	
	public double circleLength() {
		
		return 2 * Math.PI * radius;
	}
	
	public double arcLength(double angle) {
		
		if(angle > 0 &&  angle <= 360) return angle/360 * circleLength();
		else return 1;
	}
	
	public double arcArea(double angle) {
		
		if(angle > 0 &&  angle <= 360) return (Math.PI * radius * radius * angle) / 360;
		else return 1;
	}
	
	public double getMaxY() {
		
		return centerY + radius;
	}
	
	public double getMaxX() {
		
		return centerX + radius;
	}
	
	public double getMinY() {
	
	return centerY - radius;
	}
	
	public double getMinX() {
	
	return centerX - radius;
	}
	
	public double getTriangleArea(double angle) {
		
		if(angle > 0 && angle < 180 ) return 0.5 * (radius * radius) * ((Math.PI * angle)/180 - Math.sin(angle));
		else return 0;
		
	}
}
