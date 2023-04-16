package fp.TvShow;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import fp.common.AgeRestriction;
import fp.utils.Checkers;


public class FactoriaTvShow {
	
	public static TvShows leerTvShows(String rutaFichero) {
		 TvShows res = null;
		 Charset charset = Charset.forName("ISO-8859-1"); 
		    try (BufferedReader reader = Files.newBufferedReader(Paths.get(rutaFichero), charset)) {
		        Stream<TvShowImpl> st = reader
		            .lines()
		            .skip(1)
		            .map(FactoriaTvShow::parseaTvShow);
		        res = new TvShows(st);
		    } catch(IOException e) {
		        System.out.println("No se ha encontrado el fichero " + rutaFichero);
		    }
		    return res;
	}
	
	public static TvShowImpl parseaTvShow(String lineaCsv) {
		
		String[] campos = lineaCsv.split(";");
		Checkers.check("Error en el número de campos", campos.length == 9);
		
		Integer id = Integer.valueOf(campos[0].trim());
		String name = campos[1].trim();
		LocalDate releaseDate = LocalDate.parse(campos[2].trim(), DateTimeFormatter.ofPattern("M/d/y"));
		Integer numSeasons = Integer.valueOf(campos[3].trim());
		String language = campos[4].trim();
		List<String> genres = parseGenres(campos[5]);
		Double imdbRating = parseRating(campos[6]);
		AgeRestriction  ageRestriction = parseAgeRestriction(campos[7]);
		Boolean worldPremiere = parseWorldPremiere(campos[8]);
		
		return new TvShowImpl(id, name, releaseDate, numSeasons, language, genres, imdbRating, ageRestriction, worldPremiere);
		
	}

	private static List<String> parseGenres(String campos) {
		List<String> res = new ArrayList<>();
		for(String trozo:campos.trim().split(",")) {
			res.add(trozo.trim());
		}
		return res;
	}
	
	private static AgeRestriction parseAgeRestriction(String campos) {
		AgeRestriction res = AgeRestriction.ALL;
		String limpia= campos.trim().replace("+", "");
		if(limpia.equals("7")) {
			res =AgeRestriction.SIETE;
		}
		if(limpia.equals("13")){
			res =AgeRestriction.TRECE;
		}
		if(limpia.equals("16")) {
			res =AgeRestriction.DIECISEIS;
		}
		if(limpia.equals("18")) {
			res =AgeRestriction.DIECIOCHO;
		}
		return res;
	}
	
	private static Double parseRating(String campos) {
		Double res = 0.0;
		if(campos.trim() != "") {
			res = Double.valueOf(campos.trim());
		}
		return res;
	}
	
	private static Boolean parseWorldPremiere(String campos) {
		Checkers.checkNoNull(campos);
		Boolean res = false;
		if(campos.toUpperCase().trim().equals("TRUE")){
			res = true;
			}
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
}

