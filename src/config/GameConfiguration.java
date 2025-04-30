package config;

public class GameConfiguration {
	//Classe qui définit nos variables par défaut
	
	//taille par defaut pour que la map soit bien integrer dans la LeftJPanel W:1000 H:800
	public static int WIDTH = 1000;
	public static int HEIGHT = 800;
	
	//taille d'une case
	public static final int BLOCK_SIZE = 40;
	
	//Compteur de nos acteurs
	public static int INTRU_COUNT = 5;
	public static int GARDIEN_COUNT = 3;
	
	//rayon du champ de vision
	public static int SIZE_VISION = 2;
	
	//valeur des timer
	public static int TIMER_SPAWN_INTRU = 25;
	public static int TIMER_COMMUNICATION_GARDIEN = 3;

	
	//20 en ligne et 25 en colonne
	public static  int LINE_COUNT = 19; //Hauteur
	public static  int COLUMN_COUNT = 23; //Largeur
	
	//Modifie la vitesse du jeu 
	public static final int GAME_SPEED = 900;
	
	//pourcentage de l'occupation des obstacles
	public static double CHANCE_FOR_WATER_BLOCK = 0.05;
	public static double CHANCE_FOR_TREE_BLOCK = 0.02;
	public static double CHANCE_FOR_ROCK_BLOCK = 0.05;
	
}
