Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2022/23)
Autor/a: Daniel Jiménez Díaz uvus:danjimdia1

Estructura de las carpetas del proyecto
/src: Directorio con el código fuente.
fp.TvShow: Paquete que contiene los tipos del proyecto.
fp.TvShow.test: Paquete que contiene las clases de test del proyecto.
fp.common: Paquete que contiene los tipos auxiliares implementados.
fp.utils: Paquete que contiene las clases de utilidad.
/data: Contiene el dataset del proyecto.
Prime TV Shows Data set.csv: archivo csv con información sobre series de televisión de Amazon Prime actuales.
/doc: Contiene el archivo READ.md.

Estructura del dataset
El dataset original se puede obtener de la URL https://www.kaggle.com/datasets/nilimajauhari/amazon-prime-tv-shows. Originalmente tiene 8 columnas y cada fila de las 394 contiene datos sobre una serie de Amazon Prime's Website, estrenada a partir del año 2016. El dataset usado en este proyecto tiene 9 columna, 7 se han tomado del dataset original, y dos, la fecha de estreno y World Premiere (referida a si es un estreno mundial), se han generado de forma aleatoria. A continuación se describen las 9 columnas del dataset:

id: Número identificador de la serie.
Name of the show: Nombre de la serie.
Release Date: Fecha en la que se estrenó la serie en Amazon Prime.
No of seasons: Número de temporadas en Amazon Prime.
Language: Lenguaje en el que esta disponible. 
Genre: Lista de géneros a los que pertenece la serie.
IMD rating: Puntuación del público en la plataforma IMBd, del 0.0 al 10.0.
Age of viewers: Edad mínima recomendada para los espectadores, entre ALL, +7, +13, +16, +18. 
World Premiere: Es verdadera si es un estreno internacional.


Tipos implementados
Los tipos que se han implementado en el proyecto son los siguientes:

Tipo Base - TvShowImpl
Implementa la interfaz TvShow y representa un Show de televisión de Amazon Prime, estrenado en la plataforma a partir del año 2016.

Propiedades:
id: De tipo Integer, consultable. Numero identificador de la serie.
name: De tipo String, consultable. Nombre de la serie.
releaseDate: De tipo LocalDate, consultable. Fecha en la que se estrenó la serie.
numSeasons: De tipo Integer, consultable y modificable. Número de temporadas en Amazon Prime.
language: De tipo String, consultable y modificable. Lenguaje en el que esta disponible. 
genres: De tipo List<String>, consultable y modificable. Lista de géneros a los que pertenece la serie.
imbdRating: De tipo Double, consultable y modificable. Puntuación del público en la plataforma IMBd, del 0.0 al 10.0.
AgeRestriction: De tipo AgeRestriction (enum), consultable y modificable. Edad mínima recomendada para los espectadores. 
World Premiere: De tipo Boolean, consultable y modificable. Es verdadera si es un estreno internacional.

Constructores:

C1: Tiene un parámetro por cada propiedad básica del tipo.
C2: Crea un objeto de tipo TvShowImpl a partir de los siguientes parámetros: Integer id, String name, LocalDate releaseDate, Integer numSeasons. La lista de géneros la inicializa vacía, y los otros atributos de tipo null.
Restricciones:

R1: El número de temporadas debe ser mayor que cero.
R2: La lista generos no puede ser null, ni los generos al añadirlos a la lista.
R3: No se puede añadir un genero a la lista que ya este en esta, ni eliminar uno que no exista.

Criterio de igualdad: Por id, nombre (name), y fecha de estreno en la plataforma (releaseDate).

Criterio de orden: Por id, nombre y pot último fecha de estreno. 

Otras operaciones:

·public String getShortFormat(): Devuelve una cadena representativa del show cone el formato: nombre[dia/mes/año] --> nota.

----

Tipo Contenedor - TvShows
Contiene objetos TvShowImpl dentro, en concreto una lista de estos, representada por el atributo shows. 

Propiedades:
shows: De tipo List<TvShowImpl>, consultable y modificable. Lista de shows que estan incluidos.

Constructores:

C1: No recibe ningún parámetro y construye un objeto de tipo TvShows, inicializando el atributo shows como una lista vacía de objetos TvShowImpl
C2: Crea un objeto TvShows a partir de un parámetro shows, el cual es una lista de objetos TvShowImpl, los cuales contendra el atributo shows de la clase.
C3: Crea un objeto TvShows a partir de un parámetro shows, el cual es una lista de objetos TvShowImpl, los cuales contendra el atributo shows de la clase.

Criterio de igualdad: Por el atributo shows, las listas deben ser idénticas.

Criterio de orden: No está definido un criterio de orden, ya que no es necesario. 

Otras operaciones:

·numShows(): Este método devuelve el número de programas de televisión en la lista.
·addShow(TvShowImpl show): Este método agrega un programa de televisión a la lista.
·addShows(Collection<TvShowImpl> shows): Este método agrega una colección de programas de televisión a la lista.
·delShow(TvShowImpl show): Este método elimina un programa de televisión de la lista.
·containsShow(TvShowImpl show): Este método devuelve un valor booleano que indica si el programa de televisión especificado está en la lista o no.
·existShowReleasedBetween(LocalDate f1, LocalDate f2): Este método devuelve un valor booleano que indica si hay un programa de televisión en la lista con una fecha de lanzamiento entre f1 y f2.
·totalRating(): Este método devuelve la suma de las calificaciones IMDB de todos los programas de televisión en la lista.
·ratingMean(): Este método devuelve la calificación promedio IMDB de todos los programas de televisión en la lista.
·genreSet(): Este método devuelve un conjunto de todos los géneros de todos los programas de televisión en la lista.
·countGenres(): Este método devuelve el número de géneros diferentes en todos los programas de televisión en la lista.
·showsInLanguages(Collection<String> languages): Este método devuelve una nueva instancia de TvShows que contiene todos los programas de televisión de la lista que están en los idiomas especificados en la colección de cadenas.
·showsByAgeRestriction(): Este método devuelve un mapa que asigna cada programa de televisión en la lista a su restricción de edad correspondiente.
·listShowsByAgeRestriction(): Este método devuelve un mapa que asigna cada restricción de edad en la lista de programas de televisión a una lista de los programas de televisión que tienen esa restricción de edad.
·numWorldPremiereShowsPorAño(): Este método devuelve un mapa que asigna cada año en el que se lanzó un programa de televisión con un estreno mundial en la lista a la cantidad de programas de televisión con un estreno mundial que se lanzaron ese año.
·toString(): Este método devuelve una representación en cadena de la lista de programas de televisión.

----
Tipo FactoriaTvShow.

La clase FactoriaTvShow es una fábrica que se encarga de leer y analizar ficheros CSV que contienen información sobre series de televisión y crear objetos TvShowImpl a partir de ellos.

Métodos:

·leerTvShows(String rutaFichero): Este método estático se encarga de leer un fichero CSV y devuelve un objeto TvShows que contiene una lista de objetos TvShowImpl. Para leer el fichero se utiliza un BufferedReader y se hace uso de streams para parsear cada línea del fichero y crear los objetos TvShowImpl. Si no se encuentra el fichero, se muestra un mensaje por consola y se devuelve null.
·parseaTvShow(String lineaCsv): Este método estático recibe una línea del fichero CSV y devuelve un objeto TvShowImpl. El método se encarga de parsear cada uno de los campos de la línea y crear un objeto TvShowImpl con ellos. Para hacer esto, se utilizan otros métodos auxiliares que se encargan de parsear cada tipo de campo, como el rating, el género o la restricción de edad.
·parseGenres(String campos): Este método estático recibe una cadena con los géneros de una serie de televisión separados por comas y devuelve una lista de cadenas con cada uno de los géneros. Para hacer esto, se divide la cadena en subcadenas separadas por comas y se eliminan los espacios en blanco de cada una de ellas.
·parseAgeRestriction(String campos): Este método estático recibe una cadena con la restricción de edad de una serie de televisión y devuelve un objeto AgeRestriction. Para hacer esto, se comprueba el valor numérico de la cadena y se asigna el valor correspondiente a la restricción de edad.
·parseRating(String campos): Este método estático recibe una cadena con el rating de una serie de televisión y devuelve un valor Double. Si la cadena está vacía, devuelve 0.0.
·parseWorldPremiere(String campos): Este método estático recibe una cadena que indica si una serie de televisión se estrenó mundialmente y devuelve un valor Boolean. Si la cadena se corresponde con "TRUE", devuelve true, en caso contrario, devuelve false.


----

Tipos auxiliares - AgeRestriction, enumerado. Puede tomar los valores ALL,SIETE,TRECE,DIECISEIS,DIECIOCHO.
