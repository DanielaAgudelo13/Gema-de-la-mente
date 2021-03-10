import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;

public class Principal extends PApplet {

	public static void main(String[] args) {
		PApplet.main("Principal");
	}

	@Override
	public void settings() {
		size(1200, 700);
	}

	PImage[] pantalla;

	int estado;

	// X y Y del Boton de inicio
	int xBotonInicio;
	int yBotonInicio;

	// X y Y del Boton de instrucciones
	int xBotonInstrucciones;
	int yBotonInstrucciones;

	// X y Y del Boton de jugar
	int xBotonJugar;
	int yBotonJugar;

	// Wanda Jugador
	Jugador wanda;
	int puntaje;
	int vida;

	// Variables para el tiempo
	int segundos;
	int segundosD;
	int minutos;

	int[][] mapa;

	ArrayList<Enemigos> enemigos;

	@Override
	public void setup() {

		pantalla = new PImage[34];
		pantalla[0] = loadImage("./../APOYO GRÁFICO/PantallaInicio.jpg");
		pantalla[1] = loadImage("./../APOYO GRÁFICO/BotonInicio.png");
		pantalla[2] = loadImage("./../APOYO GRÁFICO/BotonInstrucciones.png");
		pantalla[3] = loadImage("./../APOYO GRÁFICO/PantallaInstrucciones.jpg");
		pantalla[4] = loadImage("./../APOYO GRÁFICO/BotonJugar.png");
		pantalla[5] = loadImage("./../APOYO GRÁFICO/Escenario.jpg");
		pantalla[6] = loadImage("./../APOYO GRÁFICO/NuevaPartida.png");
		pantalla[7] = loadImage("./../APOYO GRÁFICO/Vida.png");
		pantalla[8] = loadImage("./../APOYO GRÁFICO/Vida1.png");
		pantalla[9] = loadImage("./../APOYO GRÁFICO/Vida2.png");
		pantalla[10] = loadImage("./../APOYO GRÁFICO/Vida3.png");
		pantalla[11] = loadImage("./../APOYO GRÁFICO/Vida4.png");
		pantalla[12] = loadImage("./../APOYO GRÁFICO/Vida5.png");
		pantalla[13] = loadImage("./../APOYO GRÁFICO/Vida6.png");
		pantalla[14] = loadImage("./../APOYO GRÁFICO/Vida7.png");
		pantalla[15] = loadImage("./../APOYO GRÁFICO/Vida8.png");
		pantalla[16] = loadImage("./../APOYO GRÁFICO/Vida9.png");
		pantalla[17] = loadImage("./../APOYO GRÁFICO/Vida10.png");
		pantalla[18] = loadImage("./../APOYO GRÁFICO/Vida11.png");
		pantalla[19] = loadImage("./../APOYO GRÁFICO/Vida12.png");
		pantalla[20] = loadImage("./../APOYO GRÁFICO/Vida13.png");
		pantalla[21] = loadImage("./../APOYO GRÁFICO/Vida14.png");
		pantalla[22] = loadImage("./../APOYO GRÁFICO/Vida15.png");
		pantalla[23] = loadImage("./../APOYO GRÁFICO/Vida16.png");
		pantalla[24] = loadImage("./../APOYO GRÁFICO/Vida17.png");
		pantalla[25] = loadImage("./../APOYO GRÁFICO/Vida18.png");
		pantalla[26] = loadImage("./../APOYO GRÁFICO/Resumen.png");
		pantalla[27] = loadImage("./../APOYO GRÁFICO/Wanda.png");
		pantalla[28] = loadImage("./../APOYO GRÁFICO/Thanos.png");
		pantalla[29] = loadImage("./../APOYO GRÁFICO/Zombie.png");
		pantalla[30] = loadImage("./../APOYO GRÁFICO/MagiaRoja.png");
		pantalla[31] = loadImage("./../APOYO GRÁFICO/Bruja.png");
		pantalla[32] = loadImage("./../APOYO GRÁFICO/Gema.png");
		pantalla[33] = loadImage("./../APOYO GRÁFICO/Veneno.png");

		estado = 0;
		puntaje = 0;
		vida = 25;

		// X y Y de Boton Inicio (moverlos en el lienzo)
		xBotonInicio = 320;
		yBotonInicio = 500;

		// X y Y de Boton Instrucciones
		xBotonInstrucciones = 650;
		yBotonInstrucciones = 500;

		// X y Y de Boton Jugar
		xBotonJugar = 950;
		yBotonJugar = 570;

		// WANDA
		wanda = new Jugador(48, 70, pantalla[27], pantalla[30], pantalla[31], pantalla[32], pantalla[33], this);

		// ENEMIGOS

		enemigos = new ArrayList<Enemigos>();

		// INICIALIZAR TIEMPO
		minutos = 0;
		segundos = 0;
		segundosD = 0;

		mapa = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				mapa[i][j] = 0;
			}
		}
	}

	@Override
	public void draw() {
		// System.out.println(mouseX + "," + mouseY);

		int num;
		switch (estado) {

		case 0:

			// INICIO
			// Imagen inicio
			imageMode(CORNER);
			image(pantalla[0], 0, 0, 1200, 700);

			// BOTON INICIO
			// Imagen Boton Inicio
			image(pantalla[1], xBotonInicio, yBotonInicio, 250, 100);

			// BOTON INSTRUCCIONES
			// Imagen Boton Instrucciones
			image(pantalla[2], xBotonInstrucciones, yBotonInstrucciones, 250, 100);

			break;

		case 1:

			// INSTRUCCIONES
			// Imagen instrucciones
			imageMode(CORNER);
			image(pantalla[3], 0, 0, 1200, 700);

			// BOTON JUGAR
			// Imagen Boton Jugar
			image(pantalla[4], xBotonJugar, yBotonJugar, 220, 100);

			break;

		case 2:

			// PANTALLA DE ESCENARIO
			// Imagen escenario
			imageMode(CORNER);
			image(pantalla[5], 0, 0, 1200, 700);

			// Vida
			image(pantalla[vida], 40, 0, 300, 125);
			// WANDA
			wanda.pintar();

			// ENEMIGOS

			int randomY = (int) random(0, 7);
			int random = (int) random(0, 2);

			// Aparacion de enemigos
			if (frameCount % 120 == 0) {
				if (random == 0) {
					enemigos.add(new Enemigos(1200 - 100, 70 + 70 * randomY, 2, random, pantalla[28], pantalla[29],
							pantalla[33], pantalla[32], this));
				}

				else {

					enemigos.add(new Enemigos(1200 - 100, 70 + 70 * randomY, 1, random, pantalla[28], pantalla[29],
							pantalla[33], pantalla[32], this));

				}

			}

			for (int i = 0; i < enemigos.size(); i++) {

				enemigos.get(i).pintar();
			}

			for (int i = 0; i < enemigos.size(); i++) {

				if (enemigos.get(i).posX < 0) {
					enemigos.remove(i);
				}

				if (enemigos.get(i).vida <= 0) {

					if (enemigos.get(i).tipo == 0) {
						puntaje += 10;

					} else {
						puntaje += 5;
					}

					enemigos.remove(i);
				}
			}

			// TIEMPO
			if (frameCount % 60 == 0) {
				segundos++;

			}
			if (segundos > 9) {
				segundos = 0;
				segundosD++;
			}

			if (segundosD > 5) {
				segundosD = 0;
				minutos++;
			}

			// TIEMPO DE JUEGO
			textSize(40);
			fill(255);
			text(minutos + ":" + segundosD + segundos, 750, 75);
			text(puntaje, 1030, 75);

			if (minutos >= 2 && minutos < 4) {
				num = 120;
			}

			if (minutos >= 4 && minutos < 6) {
				num = 45;
			}

			if (minutos == 6) {
			}

			// Impacto enemigos balas

			for (int i = 0; i < wanda.balas.size(); i++) {
				for (int j = 0; j < enemigos.size(); j++) {

					Balas b = wanda.balas.get(i);
					Enemigos e = enemigos.get(j);

					if (dist(b.posX + b.ancho / 2, b.posY + b.alto / 2, e.posX + e.ancho / 2,
							e.posY + e.alto / 2) < e.ancho / 2) {
						e.vida--;
						wanda.balas.remove(i);
					}
				}
			}

			// Impacto enemigos con Wanda

			for (int i = 0; i < enemigos.size(); i++) {
				Enemigos e = enemigos.get(i);

				for (int j = 0; j < e.balas.size(); j++) {

					Balas b = e.balas.get(j);

					if (dist(b.posX + b.ancho / 2, b.posY + b.alto / 2, wanda.posX + wanda.ancho / 2,
							wanda.posY + wanda.alto / 2) < wanda.ancho / 2) {
						vida--;
						e.balas.remove(j);
					}
				}

			}

			// Perder el juego
			if (vida <= 7) {
				estado = 3;
			}

			break;

		case 3:

			fill(0, 20);
			rect(0, 0, 1200, 700);

			// PANTALLA FINAL
			image(pantalla[26], 300, 180, 600, 350);

			textSize(30);
			fill(255);
			text(minutos + ":" + segundosD + segundos, 600, 400);
			text(puntaje, 600, 355);

			break;

		}
	}

	public void mousePressed() {

		System.out.println(mouseX + " : " + mouseY);

		switch (estado) {

		case 0:

			if (mouseX > xBotonInicio && mouseX < xBotonInicio + 250 && mouseY > yBotonInicio
					&& mouseY < yBotonInicio + 100) {
				estado = 2;
			}

			if (mouseX > xBotonInstrucciones && mouseX < xBotonInstrucciones + 250 && mouseY > yBotonInstrucciones
					&& mouseY < yBotonInstrucciones + 100) {
				estado = 1;
			}

			break;

		case 1:

			if (mouseX > xBotonJugar && mouseX < xBotonJugar + 220 && mouseY > yBotonJugar
					&& mouseY < yBotonJugar + 100) {
				System.out.println("QUEMAS");
				estado = 2;
			}

			break;

		case 3:
			if (mouseX > 528 && mouseX < 696 && mouseY > 441 && mouseY < 494) {
				puntaje = 0;
				vida = 25;

				// WANDA
				wanda = new Jugador(48, 70, pantalla[27], pantalla[30], pantalla[31], pantalla[32], pantalla[33], this);

				// ENEMIGOS
				enemigos = new ArrayList<Enemigos>();

				// INICIALIZAR TIEMPO
				minutos = 0;
				segundos = 0;
				segundosD = 0;
				estado = 2;
			}
			break;
		}

	}

	public void keyPressed() {
		wanda.mover();
		wanda.disparar();
	}
}
