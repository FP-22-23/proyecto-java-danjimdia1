Proyecto del Segundo Cuatrimestre Fundamentos de Programaci�n (Curso 2022/23)
Autor/a: Daniel Jim�nez D�az uvus:danjimdia1

Estructura de las carpetas del proyecto
/src: Directorio con el c�digo fuente.
fp.TvShow: Paquete que contiene los tipos del proyecto.
fp.TvShow.test: Paquete que contiene las clases de test del proyecto.
fp.common: Paquete que contiene los tipos auxiliares implementados.
fp.utils: Paquete que contiene las clases de utilidad.
/data: Contiene el dataset del proyecto.
Prime TV Shows Data set.csv: archivo csv con informaci�n sobre series de televisi�n de Amazon Prime actuales.
/doc: Contiene el archivo READ.md.

Estructura del dataset
El dataset original se puede obtener de la URL https://www.kaggle.com/datasets/nilimajauhari/amazon-prime-tv-shows. Originalmente tiene 8 columnas y cada fila de las 394 contiene datos sobre una serie de Amazon Prime's Website, estrenada a partir del a�o 2016. El dataset usado en este proyecto tiene 9 columna, 7 se han tomado del dataset original, y dos, la fecha de estreno y World Premiere (referida a si es un estreno mundial), se han generado de forma aleatoria. A continuaci�n se describen las 9 columnas del dataset:

id: N�mero identificador de la serie.
Name of the show: Nombre de la serie.
Release Date: Fecha en la que se estren� la serie en Amazon Prime.
No of seasons: N�mero de temporadas en Amazon Prime.
Language: Lenguaje en el que esta disponible. 
Genre: Lista de g�neros a los que pertenece la serie.
IMD rating: Puntuaci�n del p�blico en la plataforma IMBd, del 0.0 al 10.0.
Age of viewers: Edad m�nima recomendada para los espectadores, entre ALL, +7, +13, +16, +18. 
World Premiere: Es verdadera si es un estreno internacional.


Tipos implementados
Los tipos que se han implementado en el proyecto son los siguientes:

Tipo Base - TvShowImpl
Implementa la interfaz TvShow y representa un Show de televisi�n de Amazon Prime, estrenado en la plataforma a partir del a�o 2016.

Propiedades:
id: De tipo Integer, consultable. Numero identificador de la serie.
name: De tipo String, consultable. Nombre de la serie.
releaseDate: De tipo LocalDate, consultable. Fecha en la que se estren� la serie.
numSeasons: De tipo Integer, consultable y modificable. N�mero de temporadas en Amazon Prime.
language: De tipo String, consultable y modificable. Lenguaje en el que esta disponible. 
genres: De tipo List<String>, consultable y modificable. Lista de g�neros a los que pertenece la serie.
imbdRating: De tipo Double, consultable y modificable. Puntuaci�n del p�blico en la plataforma IMBd, del 0.0 al 10.0.
AgeRestriction: De tipo AgeRestriction (enum), consultable y modificable. Edad m�nima recomendada para los espectadores. 
World Premiere: De tipo Boolean, consultable y modificable. Es verdadera si es un estreno internacional.

Constructores:

C1: Tiene un par�metro por cada propiedad b�sica del tipo.
C2: Crea un objeto de tipo TvShowImpl a partir de los siguientes par�metros: Integer id, String name, LocalDate releaseDate, Integer numSeasons. La lista de g�neros la inicializa vac�a, y los otros atributos de tipo null.
Restricciones:

R1: El n�mero de temporadas debe ser mayor que cero.
R2: La lista generos no puede ser null, ni los generos al a�adirlos a la lista.
R3: No se puede a�adir un genero a la lista que ya este en esta, ni eliminar uno que no exista.

Criterio de igualdad: Por id, nombre (name), y fecha de estreno en la plataforma (releaseDate).

Criterio de orden: Por id, nombre y pot �ltimo fecha de estreno. 

Otras operaciones:

�public String getShortFormat(): Devuelve una cadena representativa del show cone el formato: nombre[dia/mes/a�o] --> nota.

----

Tipo Contenedor - TvShows
Contiene objetos TvShowImpl dentro, en concreto una lista de estos, representada por el atributo shows. 

Propiedades:
shows: De tipo List<TvShowImpl>, consultable y modificable. Lista de shows que estan incluidos.

Constructores:

C1: No recibe ning�n par�metro y construye un objeto de tipo TvShows, inicializando el atributo shows como una lista vac�a de objetos TvShowImpl
C2: Crea un objeto TvShows a partir de un par�metro shows, el cual es una lista de objetos TvShowImpl, los cuales contendra el atributo shows de la clase.
C3: Crea un objeto TvShows a partir de un par�metro shows, el cual es una lista de objetos TvShowImpl, los cuales contendra el atributo shows de la clase.

Criterio de igualdad: Por el atributo shows, las listas deben ser id�nticas.

Criterio de orden: No est� definido un criterio de orden, ya que no es necesario. 

Otras operaciones:

�numShows(): Este m�todo devuelve el n�mero de programas de televisi�n en la lista.
�addShow(TvShowImpl show): Este m�todo agrega un programa de televisi�n a la lista.
�addShows(Collection<TvShowImpl> shows): Este m�todo agrega una colecci�n de programas de televisi�n a la lista.
�delShow(TvShowImpl show): Este m�todo elimina un programa de televisi�n de la lista.
�containsShow(TvShowImpl show): Este m�todo devuelve un valor booleano que indica si el programa de televisi�n especificado est� en la lista o no.
�existShowReleasedBetween(LocalDate f1, LocalDate f2): Este m�todo devuelve un valor booleano que indica si hay un programa de televisi�n en la lista con una fecha de lanzamiento entre f1 y f2.
�totalRating(): Este m�todo devuelve la suma de las calificaciones IMDB de todos los programas de televisi�n en la lista.
�ratingMean(): Este m�todo devuelve la calificaci�n promedio IMDB de todos los programas de televisi�n en la lista.
�genreSet(): Este m�todo devuelve un conjunto de todos los g�neros de todos los programas de televisi�n en la lista.
�countGenres(): Este m�todo devuelve el n�mero de g�neros diferentes en todos los programas de televisi�n en la lista.
�showsInLanguages(Collection<String> languages): Este m�todo devuelve una nueva instancia de TvShows que contiene todos los programas de televisi�n de la lista que est�n en los idiomas especificados en la colecci�n de cadenas.
�showsByAgeRestriction(): Este m�todo devuelve un mapa que asigna cada programa de televisi�n en la lista a su restricci�n de edad correspondiente.
�listShowsByAgeRestriction(): Este m�todo devuelve un mapa que asigna cada restricci�n de edad en la lista de programas de televisi�n a una lista de los programas de televisi�n que tienen esa restricci�n de edad.
�numWorldPremiereShowsPorA�o(): Este m�todo devuelve un mapa que asigna cada a�o en el que se lanz� un programa de televisi�n con un estreno mundial en la lista a la cantidad de programas de televisi�n con un estreno mundial que se lanzaron ese a�o.
�toString(): Este m�todo devuelve una representaci�n en cadena de la lista de programas de televisi�n.

----
Tipo FactoriaTvShow.

La clase FactoriaTvShow es una f�brica que se encarga de leer y analizar ficheros CSV que contienen informaci�n sobre series de televisi�n y crear objetos TvShowImpl a partir de ellos.

M�todos:

�leerTvShows(String rutaFichero): Este m�todo est�tico se encarga de leer un fichero CSV y devuelve un objeto TvShows que contiene una lista de objetos TvShowImpl. Para leer el fichero se utiliza un BufferedReader y se hace uso de streams para parsear cada l�nea del fichero y crear los objetos TvShowImpl. Si no se encuentra el fichero, se muestra un mensaje por consola y se devuelve null.
�parseaTvShow(String lineaCsv): Este m�todo est�tico recibe una l�nea del fichero CSV y devuelve un objeto TvShowImpl. El m�todo se encarga de parsear cada uno de los campos de la l�nea y crear un objeto TvShowImpl con ellos. Para hacer esto, se utilizan otros m�todos auxiliares que se encargan de parsear cada tipo de campo, como el rating, el g�nero o la restricci�n de edad.
�parseGenres(String campos): Este m�todo est�tico recibe una cadena con los g�neros de una serie de televisi�n separados por comas y devuelve una lista de cadenas con cada uno de los g�neros. Para hacer esto, se divide la cadena en subcadenas separadas por comas y se eliminan los espacios en blanco de cada una de ellas.
�parseAgeRestriction(String campos): Este m�todo est�tico recibe una cadena con la restricci�n de edad de una serie de televisi�n y devuelve un objeto AgeRestriction. Para hacer esto, se comprueba el valor num�rico de la cadena y se asigna el valor correspondiente a la restricci�n de edad.
�parseRating(String campos): Este m�todo est�tico recibe una cadena con el rating de una serie de televisi�n y devuelve un valor Double. Si la cadena est� vac�a, devuelve 0.0.
�parseWorldPremiere(String campos): Este m�todo est�tico recibe una cadena que indica si una serie de televisi�n se estren� mundialmente y devuelve un valor Boolean. Si la cadena se corresponde con "TRUE", devuelve true, en caso contrario, devuelve false.


----

Tipos auxiliares - AgeRestriction, enumerado. Puede tomar los valores ALL,SIETE,TRECE,DIECISEIS,DIECIOCHO.
