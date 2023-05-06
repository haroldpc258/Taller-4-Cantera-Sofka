:: Comando que desactiva la impresión de los comandos en la consola de Windows,
:: por lo que los comandos que se ejecuten no se mostrarán en la pantalla.
@echo off

:: Este comando establece la variable de entorno CLASSPATH con el directorio actual donde se encuentra el script
:: y el CLASSPATH actual.
set "CLASSPATH=%~dp0;%CLASSPATH%"

:: Comando que utiliza el compilador de Java, "javac", para compilar los archivos de código fuente de las clases
:: MainClass1 y MainClass2, y generar los archivos ".class"
javac Main1.java Main2.java

:: Comando  cambia el directorio de trabajo actual de la consola a tres niveles por encima del directorio donde
:: se encuentra el script. y lo guarda en la pila de directorios para su posterior recuperación.
pushd ..\..\..

:: Se guarda la ruta actual en la variable de entorno "MYPATH".
set "MYPATH=%CD%"

:: Comando para recuperar el directorio actual de la pila de directorios.
popd

:: Se agrega la variable de entorno "MYPATH" al valor actual de la variable de entorno "CLASSPATH",
:: separados por un punto y coma.
set "CLASSPATH=%MYPATH%;%CLASSPATH%"

:: Se ejecuta la clase MainClass2 como punto de entrada del programa, con los argumentos pasados al archivo por lotes.
java object.modeling.exercise2.Main2 %*

:: Este comando establece la variable de entorno CLASSPATH con el directorio actual donde se encuentra el script
:: y el CLASSPATH actual.
set "CLASSPATH=%~dp0;%CLASSPATH%"

:: Se elimina todos los archivos de extensión ".class" del directorio actual.
:: Estos archivos son archivos compilados de Java y ya no son necesarios una vez que se ha ejecutado
:: el archivo por lotes.
del *.class

:: Se detiene la ejecución del archivo por lotes hasta que el usuario presione una tecla.
:: Se utiliza para evitar que la consola de Windows se cierre inmediatamente después de que se complete la ejecución
:: del archivo por lotes.
pause