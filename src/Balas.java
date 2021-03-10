import processing.core.PApplet;
import processing.core.PImage;

public class Balas {

	int posX;
	int posY;
	int ancho;
	int alto;
	int tipo;
	int velocidad;
	PImage magiaRoja;
	PImage bruja;
	PImage veneno;
	PImage gema;
	PApplet app;

	public Balas(int posX, int posY, int ancho, int alto, int tipo, PApplet app) {
		
		// Variables de constructor
		this.posX = posX;
		this.posY = posY;
		this.ancho = ancho;
		this.alto = alto;
		this.tipo = tipo;
		this.app = app;
		this.velocidad = 10;
		
		this.magiaRoja= app.loadImage("./../APOYO GRÁFICO/MagiaRoja.png");
		this.bruja= app.loadImage("./../APOYO GRÁFICO/Bruja.png");
		this.veneno= app.loadImage("./../APOYO GRÁFICO/Gema.png");
		this.gema= app.loadImage("./../APOYO GRÁFICO/Veneno.png");
	}
	
	public void pintar () {
		
		switch (this.tipo) {
		
		case 0: 
			
		app.image(magiaRoja, posX, posY, ancho, alto);
		
		mover();
		
		break; 
		
		case 1: 
			
		app.image(bruja, posX, posY, ancho, alto);
		
		mover();
	
		break;
		
		case 2:
		
		app.image(veneno, posX, posY, ancho, alto);
		
		moverEnemigo();
			
		break;
			
		case 3:		
		
		app.image(gema, posX, posY, ancho, alto);
		
		moverEnemigo();
		
		break;
		
		}
		
	}
	
	public void mover () {
		
		this.posX += velocidad;
	}
	
	public void moverEnemigo() {
		this.posX -= velocidad;
	}
}
