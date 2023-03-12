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
Implementa la interfaz TvShow y representa un Show de televisi�n de Amazon Prime, estrenado en la plataforma a partir del a�o 2016. Propiedades:

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

Criterio de igualdad:

Otras operaciones:

public String getShortFormat(): Devuelve una cadena representativa del show cone el formato: 

Tipos auxiliares
Tipo AgeRestriction, enumerado. Puede tomar los valores ALL,SIETE,TRECE,DIECISEIS,DIECIOCHO.
