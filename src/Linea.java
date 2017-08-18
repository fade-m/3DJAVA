

public class Linea {
	private Punto a;
	private Punto b;
	
	public Linea() {
		this(new Punto(), new Punto());
	}
	
	public Linea(Punto a, Punto b) {
		this.a = a;
		this.b = b;
	}
	
	public Linea(double x1, double y1, double x2, double y2) {
		this(new Punto(x1, y1), new Punto(x2, y2));
	}

	public Punto getA() {
		return a;
	}

	public void setA(Punto a) {
		this.a = a;
	}

	public Punto getB() {
		return b;
	}

	public void setB(Punto b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return String.format("A = {%s}, B = {%s}", a.toString(), b.toString());
	}
}