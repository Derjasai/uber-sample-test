# Laboratorio Lambda + API Gateway

Aplicativo para simular real time de UBER con una arquitectura enfocada en la nube, haciendo uso de funciones Lambdas y Api Gatway

## Tecnologias

- Apache Maven: 3.9.1
- GIT
- Java: 17
- Node
- React

## Arquitectura
La arquitectura realizada para este proyecto se puede ver descrita en el siguiente diagrama

![image](https://github.com/user-attachments/assets/fd1f318b-0433-477c-8414-58354623cc4a)

Como se ve en la imagen en este caso tenemos:
1. Cliente asincrono realizado en React
2. Un API Gateway de AWS levantado
3. Dos funciones lambda conectadas mediante el API Gateway

El usuario puede comunicarse con nuestro aplicativo mediante un cliente asincrono realizado en TS y React, este cliente hace de puente para comunicarse con nuestro Api Gateway que a la vez esta configurado para recibir peticiones HTTP que a su vez cada cada peticion es re dirigida a una función lambda previamente configurada para ejecturar una función específica en el código. Estos métodos ejecutados son:
1. RideService::startRide (Sirve para iniciar el viaje, haciendo la creación del un viaje de forma mockeada)
2. RideService::updateLocationDriver (Su principal objetivo es actualizar la úbicación del conductor y retornar el estado del viaje)

## Diagrama de modelos
En la siguiente imagen se puede apreciar el diagrama de modelos que se escogió para este proyecto
![image](https://github.com/user-attachments/assets/67c88fc8-9b67-47ea-bce5-bd4d0947a0a7)

Como se puede notar en la imagén principalmente tenemos el Modelo Ride que será nuestra entidad principal, que contendra un Driver, un User, una Position de inicio y una Position de destino, y finalmente un Payment.

Una cosa importante a resaltar es la entidad Generic User, puesto que de esta heredan tanto User como Driver, puesto que es una super clase la cual contiene información en común de los usuarios de la aplicación (tal como nombre, apellido, celular, etc..)

El Ride contiene la ubicación o Positon desde donde se inicia el viaje, la coordenadas de destino y la ubicación del Driver y del User mediante estas entidades.

La entidad Position hace referencia a un punto X y Y en el mapa, esto puede ser tomado así mismo como Latitud y Longitud, pero para efectos prácticos solo se trabajará con números enteros en este caso.


## Correr el proyecto

Previamente a la instalacion del repositorio asegurarse de tener tanto GIT, MVN como Java instalados con las versiones que se indicaron previamente

Descargar o clonar el proyecto y entrar a la carpeta Root.
`git clone https://github.com/Derjasai/uber-sample-test.git`

### Compilación y empaquetado del Backend
En este caso el proyecto no tiene una clase Main que se pueda correr, por lo que solo podemos realizar la compilación de mismo para generar el .jar que posteriormente subiremos a AWS

Realizar el empaquetamiento del proyecto:
`mvn clean instal`
`mvn package`

Esto generará una carpeta llamada target, donde dentro de esta podrás encontrar el .jar del proyecto
![image](https://github.com/user-attachments/assets/21f03471-f655-46c1-9a9d-ab4ecd8e2e64)


### Inicializar el Frontend
Entrar al modulo de frontend corriendo el comando

`cd uber-frontend`

Posteriormente instalar los paquetes/dependencias del front con

`npm install`

Finalmente una vez termine de instalar los paquetes de node, inciar el proyecto con

`npm start`

## Explicación Proyecto
Habiendo seguido los pasos anteriores ya tendrémos listo nuestro .jar para subir a AWS, para esto tendremos que configurar nuesta función lambda
1. Una vez creada la lambda se puede subir el .jar en esta misma
2. En la sección de running settings agregar este handler `escuelaing.edu.co.service.RideService::updateLocationDriver`
3. Guardar la lambda y testearla

Con esto ya tendremos una lamda para nuestro proyecto, seguimos el procedimiento para cualquier función que queramos usar del proyecto.

Despues se realizaría la conexión con el API Gateway
1. Se crea el API Gateway
2. Se Genera el recurso a usar
3. Se genera los métodos que se quieran usar mediante HTTP
4. Se seleccina la lambda a usar
5. Se configura el request body para que sea propagado a la lambda
6. Se configura el cors para permitir el tráfico
7. Se guarda los cambios realizados
8. Se despliega el API Gateway escogiendo el state

Finalmente esto nos dejaría una URL desde donde podríamos usar y probar nuestro API Gateway

## Evidencias
Como evidencias del despliegue se tienen las siguientes imagenes
1. Lambda para actualizar posicion del conductor

![image](https://github.com/user-attachments/assets/2c96aef4-e591-4373-b6b9-94bdea849d17)

2. Lambda para generar un nuevo Viaje

![image](https://github.com/user-attachments/assets/6507bdee-e647-4fb1-b1f2-78e6ab9de233)

3. El API Gateway configurado para redirigir a la lambda las peticiones HTTP

![image](https://github.com/user-attachments/assets/046ee6f6-f058-4282-88f8-a7cf995c83c6)

4. Despliegue de API Gateway

![image](https://github.com/user-attachments/assets/9439d595-6210-47df-9b18-874635d19afd)
Como se puede apreciar se tiene dos Stages, uno representando un ambiente de test (o QA) y otro representando un posible ambiente Productivo (o prod)
Mediante este link se puede acceder a los endopoints del Api Gateway [API GATEWAY](https://uaeyswgs70.execute-api.us-east-1.amazonaws.com/prod)

5. Peticiones desde postman con su respectiva respuesta

PUT

![image](https://github.com/user-attachments/assets/dfdbb239-f9ea-4b92-b14f-ddc758c777c5)

POST

![image](https://github.com/user-attachments/assets/256d404a-6649-4e28-9863-5a1508337234)


## Video Demo Del Despliegue
Como prueba del despliegue realizado se grabó el siguiente video para demostrar el funcionamiento.

[Video-demostrativo](https://youtu.be/-UGuQUT0LxU)


# Version
1.0

# Author
Daniel Esteban Ramos Jimenez
