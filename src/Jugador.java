import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Jugador {

	int posX;
	int posY;
	int ancho;
	int alto;
	PImage wanda;
	PImage bruja;
	PImage magiaRoja;
	PImage veneno;
	PImage gema;
	PApplet app;

	ArrayList<Balas> balas = new ArrayList<Balas>();

	public Jugador(int posX, int posY, PImage wanda, PImage magiaRoja, PImage bruja, PImage veneno, PImage gema, PApplet app) {

		// Variables de constructor
		this.posX = posX;
		this.posY = posY;
		this.wanda = wanda;
		this.magiaRoja = magiaRoja;
		this.bruja = bruja;
		this.veneno = veneno;
		this.gema = gema;
		this.app = app;
		this.ancho = 90;
		this.alto = 100;
	}

	public void pintar() {

		app.image(wanda, posX, posY, ancho, alto);

		for (int i = 0; i < balas.size(); i++) {

			balas.get(i).pintar();
		}
		
		for (int i = 0; i < balas.size(); i++) {

			if(balas.get(i).posX > 1200) {
				balas.remove(i);
			}
		}
	}

	public void mover() {

		if (app.keyCode == app.UP && this.posY > 70) {
			posY -= 70;
		}

		if (app.keyCode == app.DOWN && this.posY < 70 + 70 * 6) {
			posY += 70;
		}

		if (app.keyCode == app.LEFT && this.posX > 48) {
			posX -= 90;
		}

		if (app.keyCode == app.RIGHT && this.posX < 48 + 90 * 6) {
			posX += 90;
		}

	}

	public void disparar() {
		
		int random = (int) app.random(0, 2);
		// System.out.println(random);
		
		if (app.key == 100 || app.key == 68) {

			balas.add(new Balas(this.posX, this.posY + 20, 80, 80, random, this.app));

		}
	}
}
