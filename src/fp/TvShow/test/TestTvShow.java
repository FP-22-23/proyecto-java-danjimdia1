package fp.TvShow.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fp.TvShow.TvShowImpl;
import fp.common.AgeRestriction;

public class TestTvShow {

	public static void main(String[] args) {
		
		//Probamos los constructores
		
		List<String> generos = new ArrayList<String>();
		generos.add("Medieval");
		TvShowImpl t1 = new TvShowImpl(1, "Juego de Tronos", LocalDate.of(2016, 2, 13), 9, "Ingles", generos, 8.4, AgeRestriction.DIECIOCHO, true);
		TvShowImpl t2 = new TvShowImpl(1, "Juego de Tronos", LocalDate.of(2016, 2, 13), 9);
		System.out.println("Constructor 1 --> " + t1);
		System.out.println("Constructor 2 --> " + t2 + "\n");
		
		//Formato corto
		System.out.println("Formato corto de t1: " + t1.getShortFormat() + "\n");
		
		//Getters
		System.out.println("Probamos los getters en t1:");
		System.out.println("___________________\n" + t1.getId());
		System.out.println(t1.getName());
		System.out.println(t1.getReleaseDate());
		System.out.println(t1.getLanguage());
		System.out.println(t1.getNumSeasons());
		System.out.println(t1.getGenres());
		System.out.println(t1.getImdbRating());
		System.out.println(t1.getAgeRestriction());
		System.out.println(t1.getWorldPremiere() + "\n___________________" );
		
		//Setters
		
		List<String> generos2 = new ArrayList<String>();
		generos2.add("Guerra");
		generos2.add("Comedia");
		
		System.out.println("Probamos los setters en t1:");
		t1.setLanguage("Español");
		t1.setNumSeasons(11);
		t1.setWorldPremiere(false);
		t1.setImdbRating(6.0);
		t1.setAgeRestriction(AgeRestriction.DIECISEIS);
		t1.setGenres(generos2);
		t1.addGenre("Tragedia");
		t1.delGenre("Comedia");
		System.out.println(t1);
		
		
		
		//CRITERIO DE IGUALDAD y HASHCODE
		
		System.out.println( "\nVemos como actua equals, ya que t1 y t2 son iguales, al tener el mismo id, nombre y fecha de estreno:\nt1.equals(t2) ===> " + t1.equals(t2));
		System.out.println( "Hashcode de t1 ===> " + t1.hashCode());
		
		//COMPARE TO
		
		System.out.println("\nYa que t1 y 2 son iguales, al compararlos vemos que nos devuelve 0, lo que es correcto:\nt1.compareTo(t2) ===> " + t1.compareTo(t2));
		
		
	}
	
	

}
