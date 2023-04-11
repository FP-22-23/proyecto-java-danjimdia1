package fp.TvShow.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fp.TvShow.TvShowImpl;
import fp.TvShow.TvShows;
import fp.common.AgeRestriction;

public class TestTvShows {

	public static void main(String[] args) {
		
		List<String> generos1 = new ArrayList<String>();
		List<String> generos2 = new ArrayList<String>();
		
		generos1.add("Comedy");
		generos2.add("Medieval");
		
		TvShowImpl t1 = new TvShowImpl(1, "El Show de Truman", LocalDate.of(2020, 2, 13), 9, "Ingles", generos1, 8.4, AgeRestriction.DIECIOCHO, true);
		TvShowImpl t2 = new TvShowImpl(2, "Juego de Tronos", LocalDate.of(2017, 2, 13), 9, "Español", generos2, 8.4, AgeRestriction.SIETE, true);
		TvShowImpl t3 = new TvShowImpl(3, "Torrente 1", LocalDate.of(2016, 2, 13), 9, "Frances", generos1, 8.4, AgeRestriction.DIECIOCHO, true);
		TvShowImpl t4 = new TvShowImpl(4, "Torrente 2", LocalDate.of(2017, 2, 13), 9, "Frances", generos1, 8.4, AgeRestriction.DIECIOCHO, true);
		
		TvShows shows1 = new TvShows();
		
		shows1.addShow(t1);
		shows1.addShow(t2);
		shows1.addShow(t3);
		
		System.out.println(shows1.containsShow2(t3));
		System.out.println(shows1.containsShow2(t4));
		
		System.out.println(shows1.countGenres());
		System.out.println(shows1.genreSet());
		System.out.println(shows1.totalRating());
		System.out.println(shows1.ratingMean());
		
		List<String> idiomas = new ArrayList<>();
		idiomas.add("Español");
		idiomas.add("Frances");
		System.out.println(shows1.showsInLanguages(idiomas));
		
		for (Map.Entry<AgeRestriction, List<TvShowImpl>> entry : shows1.listShowsByAgeRestriction().entrySet()) {
			System.out.println(entry);
		}

	}

}
