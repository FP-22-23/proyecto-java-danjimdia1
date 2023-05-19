package fp.TvShow.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import fp.TvShow.FactoriaTvShow;
import fp.TvShow.TvShowImpl;
import fp.TvShow.TvShows;
import fp.common.AgeRestriction;

public class TestEntregaFinal {

	public static void main(String[] args) {
	
		String rutaFichero = "data/"; 
		TvShows showsDataSet = FactoriaTvShow.leerTvShows(rutaFichero, "Prime TV Shows Data set.csv");
		testEntregaFinal(showsDataSet);
	}
	
	private static void testEntregaFinal(TvShows showsDataSet) {
		Integer i = 0;
		System.out.println((i++)+": �Hay algun show en epa�ol?");
		System.out.println(showsDataSet.existShowInLanguage("English"));
		
		System.out.println((i++)+": �Hay algun show estrenado entre el 01/01/2016 y el 01/12/2016?");
		System.out.println(showsDataSet.existShowReleasedBetween2(LocalDate.of(2016, 1, 1), LocalDate.of(2016, 12, 1)));
		
		System.out.println((i++)+": �Que puntuaci�n media de Imdb tiene el dataset?");
		System.out.println(showsDataSet.ratingMean2());
		
		System.out.println((i++)+": �Que puntuaci�n total de Imdb tiene el dataset?");
		System.out.println(showsDataSet.totalRating2());
		
		System.out.println((i++)+": �Cuantos generos hay en el dataset?");
		System.out.println(showsDataSet.countGenres2());
		
		System.out.println((i++)+": �Que shows estan en lenguaje espa�ol o hind�?");
		System.out.println(showsDataSet.showsInLanguages2(List.of("Spanish","Hindi")));
		
		System.out.println((i++)+": �Que estreno mundial tiene la m�xima puntuaci�n?");
		System.out.println(showsDataSet.MaxWorldPremiereScoreShow());
		
		System.out.println((i++)+": �Que estreno mundial tiene la m�nima puntuaci�n?");
		System.out.println(showsDataSet.MinWorldPremiereScoreShow());
		
		Integer n = 3;
		System.out.println((i++)+": Top "+ n +" estrenos mundiales con mejor puntuaci�n" );
		System.out.println(showsDataSet.TopNWorldPremieresByRating(n));
		
		System.out.println((i++)+": Lista de Shows por restricci�n de edad");
		mostrarMapPorLinea(showsDataSet.listShowsByAgeRestriction2());
		
		System.out.println((i++)+": N�mero de estrenos mundiales por a�o");
		mostrarMapPorLinea(showsDataSet.numWorldPremiereShowsPorA�o2());
		
		System.out.println((i++)+": Shows mas recientes de cada restricci�n de edad");
		mostrarMapPorLinea(showsDataSet.mostRecentShowByAgeRestriction());
		
		System.out.println((i++)+": Top " + n + " shows con mas puntuaci�n por a�o");
		mostrarMapPorLinea(showsDataSet.TopNScoredShowsbyYear(n));
		
		System.out.println((i++)+": Top " + n + " shows con mas puntuaci�n por a�o");
		System.out.println(showsDataSet.AnyoMasRatingMedio());
		

		
	}
	
	private static <K,T> void mostrarMapPorLinea(Map<K, T> map) {
		map.entrySet().stream()
			.forEach(entry-> System.out.println(entry.getKey()+"-->"+entry.getValue()));
		
	}
	
	
	
}
