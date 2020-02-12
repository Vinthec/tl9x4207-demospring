package fr.cesi.poealtran.demospring.values;

import javax.persistence.Embeddable;

@Embeddable
public class Couleur {
	private int R;
	private int V;
	private int B;
	public Couleur(int r, int v, int b) {
		super();
		R = r;
		V = v;
		B = b;
	}
	public int getR() {
		return R;
	}
	public int getV() {
		return V;
	}
	public int getB() {
		return B;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + B;
		result = prime * result + R;
		result = prime * result + V;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Couleur other = (Couleur) obj;
		if (B != other.B)
			return false;
		if (R != other.R)
			return false;
		if (V != other.V)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.format("(%s, %s, %s)", R, V, B);
	}
	
	
	
	
	
}
