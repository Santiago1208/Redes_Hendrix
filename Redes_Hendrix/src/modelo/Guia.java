package modelo;

import java.awt.Point;
import java.awt.geom.Rectangle2D;

public class Guia {

	public final static int LADO_CUADRADO = 15;

	private Rectangle2D[] rectangulos;

	private Figura huesped;

	public Guia(Rectangle2D[] rectangulos, Figura figura) {
		rectangulos = new Rectangle2D[3];
		huesped = figura;
		int auxX = figura.posicionX;
		int auxY = figura.posicionY;
		int auxAncho = figura.ancho;
		int auxAlto = figura.alto;
		;

		rectangulos[0] = new Rectangle2D.Double(auxX - (LADO_CUADRADO / 2), auxY - (LADO_CUADRADO / 2), LADO_CUADRADO,
				LADO_CUADRADO);
		rectangulos[1] = new Rectangle2D.Double(auxX + auxAncho - (LADO_CUADRADO / 2),
				auxY + auxAlto - (LADO_CUADRADO / 2), LADO_CUADRADO, LADO_CUADRADO);
		rectangulos[2] = new Rectangle2D.Double(auxX + (auxAncho / 2) - (LADO_CUADRADO / 2),
				auxY + (auxAlto / 2) - (LADO_CUADRADO / 2), LADO_CUADRADO, LADO_CUADRADO);

	}
	
	public void ampliar(Rectangle2D subGuiaActual, Point nuevaCoordenada) {
		 //Caso subguia1
		int auxX = huesped.posicionX;
		int auxY = huesped.posicionY;
		int auxAncho = huesped.ancho;
		int auxAlto = huesped.alto;
		if(auxX+auxAncho<nuevaCoordenada.getX()) {
			huesped.modificarPosicionX((int) nuevaCoordenada.getX()-auxX);
			
		}
		if (auxX+auxAncho>nuevaCoordenada.getX()) {
			huesped.modificarPosicionX((int)nuevaCoordenada.getX()-auxX);
		}

		//NOTA: HACER LOS MISMOS METODOS PERO PARA Y 
		
	}
	
	
	
	public void mover() {
		
	}

	public Rectangle2D estaEnLaGuia(Point p) {
		for (int i = 0; i < rectangulos.length; i++) {
			if (rectangulos[i].contains(p)) 
				return rectangulos[i];
		}
		return null;
	}

	public Figura darHuesped() {
		return huesped;
	}
	
	public void modificarHuesped(Figura huesped) {
		this.huesped = huesped;
	}

	public Rectangle2D[] darRectangulos() {
		return rectangulos;
	}

}
