# AccesoADatos

_Programa con un formulario de registro en donde se muestren controles
para lo diferentes campos de información, una tabla en la parte inferior de la ventana y los
apartados para agregar, borrar y modificar la información tanto en la tabla (JTable) como en
la base de datos._

## Introducción 

_Usted ha sido contratado para desarrollar un Software para gestionar el ingreso de personas a un edificio comercial. Dicho Software estará en capacidad de realizar las acciones básicas para la manipulación de la base de datos (CRUD) de cada persona que ingrese al establecimiento se deberá recolectar:_
* ID.
* Tipo Documento.
* Nombres.
* Fecha y hora de Ingreso.
* A quien Visita.
* Motivo.

_El programa se conecta al servicio de ["FreeMySQLHosting"](https://www.freemysqlhosting.net/) para conectarnos a una base de datos remota, aunque puede ser un poco lenta, cumple con su funcionamiento_

### Características
_Se Conectarse al servidor de la base de datos. (Base de datos en red, remota). Tiene una interfaz para poder cambiar los valores de conexión a la base de datos en el apartado de Opciones del Menú. Agregando un archivo de configuración en la carpeta "Log/" con las siguientes datos:_
* Server=*SERVIDOR AL QUE SE CONECTA*
* Name=*NOMBRE DE LA BASE DE DATOS*
* Username=*USUARIO DE LA BASE DE DATOS*
* Password=*CONTRASEÑA DE LA BASE DE DATOS*

_Se puede Registrar, Modificar, Eliminar y Buscar un registro en la base de datos, fue creado con un Administrador de esquemas GridBagLayout para armar esta interfaz, este elemento se encuentra en el apartado Acciones del Menú._

_Se muestra el listado de todas las personas que ingresaron (Usar un JTable, debe de permitir realizar
scroll en caso de que la lista sobrepase el área visible):_
* Tiene la posibilidad de actualizar los datos en caso de errores al momento del registro.
* Se pueden eliminar registros de personas registradas.

_Se utiliza una interfaz de múltiples documentos (MDI): una ventana principal (a la que se le conoce  comúnmente como la ventana padre) que contiene otras ventanas (a las que se les conoce comúnmente como ventanas hijas), para administrar varios documentos abiertos que se procesan  en paralelo. Utilizar un menú para abrir las diferentes interfaces._


### Pre-requisitos 

_Para la ejecución de este programa es necesario la libreria ["mysql-connector-java-5.1.8-bin.jar"](https://dev.mysql.com/downloads/connector/j/5.1.html). Que tambien se puede enontrar en la carpeta de "src/Librerias/JDBC.jar"_

Para compilar el programa con Libreria desde CMD utilizar este comando desues de estar en la carpeta de las clases y haber corrido la maquina virtual de Java en la terminal
```
javac -cp src/Libreria/JDBC.jar *.java
```
Para ejecutar el progrma 
```
java -cp .;src/Libreria/JDBC.jar exe
```

## Construido con 

* [SublimeText 3](https://www.sublimetext.com/) - Editor de Texto
* [Adobe Illustrator](https://www.adobe.com/mx/products/illustrator.html) - Creador de Iconos


## Referencias
* [Java Swing JTable Simple Example](https://www.codejava.net/java-se/swing/a-simple-jtable-example-for-display)


## Version
Version 0.2 AccesoADatos

## Autor 
* **Daniel Escobar Araujo** [DanielEscobar21](https://github.com/DanielEscobar21)

## Licencia 
Copyright (c) 2020-Daniel Escobar Araujo (DanielEscobar21)

Por la presente se concede permiso, sin cargo, a cualquier persona que obtenga una copia de este software y los archivos de documentación asociados (el "Software"), para utilizar el Software sin restricciones, incluidos, entre otros, los derechos de uso, copia, modificación, fusión , publicar, distribuir, sublicenciar y / o vender copias del Software, y permitir que las personas a las que se les proporcione el Software lo hagan, sujeto a las siguientes condiciones:

El aviso de copyright anterior y este aviso de permiso se incluirán en todas las copias o partes sustanciales del Software.

EL SOFTWARE SE PROPORCIONA "TAL CUAL", SIN GARANTÍA DE NINGÚN TIPO, EXPRESA O IMPLÍCITA, INCLUYENDO PERO NO LIMITADO A LAS GARANTÍAS DE COMERCIABILIDAD, ADECUACIÓN PARA UN PROPÓSITO PARTICULAR Y NO INFRACCIÓN. EN NINGÚN CASO LOS AUTORES O TITULARES DE LOS DERECHOS DE AUTOR SERÁN RESPONSABLES DE CUALQUIER RECLAMO, DAÑOS U OTRAS RESPONSABILIDADES, YA SEA EN UNA ACCIÓN DE CONTRATO, AGRAVIO O DE OTRO MODO, QUE SURJA DE, FUERA DE O EN RELACIÓN CON EL SOFTWARE O EL USO U OTRAS NEGOCIACIONES EN EL SOFTWA

## Datos 

* Este Proyecto se hizo en Base a la materia de Tópicos Avanzados de Programación.


