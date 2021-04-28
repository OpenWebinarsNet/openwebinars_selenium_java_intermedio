En esta carpeta encontramos los proyectos:

SeleniumMavenIniciados -> Proyecto Maven (importar como tal en eclipse)

Por un lado, en src/main/java, encontramos el Main para toda la sección
de elementos intermedios.

Por otro, en src/test/java, encontramos las implementaciones
de las clases Page Object + un paquete con la clase test que podemos
ejecutar con JUnit.

Para este segundo caso, podemos ejecutar la orden "mvn test" para que
JUnit se encargue de ejecutar dicha clase.



SeleniumMavenIniciadosCucumber -> Proyecto Maven (importar como tal en eclipse)

Encontramos el proyecto (similar al anterior) pero donde ejecutamos JUnit
indicándole que queremos ejecutarlo a través de Cucumber.
La prueba sería la misma, pero esta vez descrita a través del BDD en el feature
que podemos encontrar en src/test/resources/features.


