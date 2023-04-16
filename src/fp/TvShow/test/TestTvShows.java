package fp.TvShow.test;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fp.TvShow.TvShowImpl;
import fp.TvShow.TvShows;
import fp.common.AgeRestriction;
import fp.TvShow.FactoriaTvShow;

public class TestTvShows {

	public static void main(String[] args) {
		
		List<String> generos1 = new ArrayList<String>();
		List<String> generos2 = new ArrayList<String>();
		
		generos1.add("Comedy");
		generos2.add("Medieval");
		
		TvShowImpl t1 = new TvShowImpl(1, "El Show de Truman", LocalDate.of(2020, 2, 13), 9, "Ingles", generos1, 8.4, AgeRestriction.DIECIOCHO, true);
		TvShowImpl t2 = new TvShowImpl(2, "Juego de Tronos", LocalDate.of(2017, 2, 13), 9, "Español", generos2, 8.4, AgeRestriction.SIETE, true);
		TvShowImpl t3 = new TvShowImpl(3, "Torrente 1", LocalDate.of(2016, 2, 13), 9, "Frances", generos1, 8.4, AgeRestriction.DIECIOCHO, false);
		TvShowImpl t4 = new TvShowImpl(4, "Torrente 2", LocalDate.of(2017, 2, 13), 9, "Frances", generos1, 8.4, AgeRestriction.DIECIOCHO, true);
		
		TvShows shows1 = new TvShows();
		
		shows1.addShow(t1);
		shows1.addShow(t2);
		shows1.addShow(t3);
		
		System.out.println("\nEl test se divide en dos partes, la primera en pruebas a objetos fuera del dataset y la segunda con pruebas basadas en la lectura del dataset del csv. \n");
		System.out.println("\n--------------- PRUEBAS CON OBJETOS t1,t2,t3,t3 ------------------- \n");
		
		System.out.println("t1 ===> " + t1);
		System.out.println("t2 ===> " + t2);
		System.out.println("t3 ===> " + t3);
		System.out.println("t4 ===> " + t4);
		System.out.println("shows1 ===> " + shows1 + "\n");
		
		
		System.out.println("¿shows1 contiene a t3? " + shows1.containsShow(t3));
		System.out.println("¿shows1 contiene a t4? " + shows1.containsShow(t4) + "\n");
		
		System.out.println("¿shows1 contiene algun show cuya fecha de lanzamiento se encuentra entre LocalDate.of(2017, 2, 10) y  LocalDate.of(2017, 2, 20)? " + shows1.existShowReleasedBetween(LocalDate.of(2017, 2, 10),  LocalDate.of(2017, 2, 20)) + "\n");
		
		System.out.println("¿Cuantos géneros hay en shows1? " + shows1.countGenres() + "\n");
		System.out.println("¿Cual es el conjunto de estos ?" + shows1.genreSet() + "\n");
		System.out.println("¿Cual es la puntuación total de shows1? " + shows1.totalRating() + "\n");
		System.out.println("¿Cual es la media de esta por show? " + shows1.ratingMean() + "\n");
		

		List<String> idiomas = new ArrayList<>();
		idiomas.add("Español");
		idiomas.add("Frances");
		System.out.println("Muestra los shows de shows1 que están en español o en frances " + shows1.showsInLanguages(idiomas) + "\n");
	
		System.out.println("Muestra los shows por restricción de edad\n");
		for (Map.Entry<AgeRestriction, List<TvShowImpl>> entry : shows1.listShowsByAgeRestriction().entrySet()) {
			System.out.println(entry);
		}
		System.out.println("\n");
		
		System.out.println("Muestra el número de estrenos mundiales por año\n");
		for (Map.Entry<Integer, Integer> entry : shows1.numWorldPremiereShowsPorAño().entrySet()) {
			System.out.println(entry);
		}
		System.out.println("\n");
		System.out.println("\n--------------- PRUEBAS CON EL DATASET ------------------- \n");
		
		String rutaFichero = "data/Prime TV Shows Data set.csv"; 
		TvShows showsDataSet = FactoriaTvShow.leerTvShows(rutaFichero);
		System.out.println("Primero la lectura del csv y despues los test con map sobre esta");
		
		System.out.println("\nLECTURA:\n");	
		for(Map.Entry<AgeRestriction, List<TvShowImpl>> entry:showsDataSet.listShowsByAgeRestriction().entrySet()) {
			System.out.println(entry);
		}
		
		System.out.println("Muestra los shows por restricción de edad\n");
		for (Map.Entry<Integer, Integer> entry : showsDataSet.numWorldPremiereShowsPorAño().entrySet()) {
			System.out.println(entry);
		}
		System.out.println("\n");
		
		System.out.println("Muestra el número de estrenos mundiales por año\n");
		for (Map.Entry<AgeRestriction, List<TvShowImpl>> entry : showsDataSet.listShowsByAgeRestriction().entrySet()) {
			System.out.println(entry);
		}
		
	}

}
