

public class Punto {
	
	private double x;
	private double y;
	
	public Punto() {
		this(0.0, 0.0);
	}
	
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public static Punto sumar(Punto a, Punto b) {
		return new Punto(a.getX() + b.getX(), a.getY() - b.getY());
	}
	
	public static Punto multiplicar(Punto a, Punto b) {
		return new Punto(a.getX() * b.getX(), a.getY() * b.getY());
	}
	
	@Override
	public String toString() {
		return String.format("[x = %f, y = %f]", x, y);
	}
	
}