# Currency Conversion Program

Este programa permite convertir entre diferentes tipos de monedas mediante una API externa. Siga los pasos a continuación para realizar una conversión.

## Instrucciones de Uso

### Paso 1: Selección del Tipo de Conversión

El programa proporciona una lista de conversiones disponibles. Ingrese un número del **1 al 30** para seleccionar el tipo de conversión deseado. Cada número representa una conversión específica (por ejemplo, de USD a EUR, de GBP a JPY, etc.).

```plaintext
Ejemplo:
Ingrese el número correspondiente al tipo de conversión:
1. ARS - BOB
2. ARS - BRL
3. ARS - CLP
4. ARS - COP
5. ARS - USD
...
30: USD a COP
```

### Paso 2: Ingreso de la Cantidad

Una vez que haya seleccionado el tipo de conversión, el programa le confirmara que conversion de divisas ha seleccionado y le pedirá que ingrese la **cantidad de la moneda** que desea convertir.
```plaintext
Ejemplo:
Las monedas para el número 30 son: USD y COP
Ingrese el valor que desea convertir:
100
```

### Salida

Después de ingresar el número de la conversión y la cantidad, el programa calculará y mostrará el valor convertido en la moneda de destino.
```plaintext
Ejemplo de salida:
El valor de: 100[USD] corresponde al valor final de =>>>423696.59[COP]
```

## Manejo de Errores

Si se presenta un error durante la conversión, como problemas de conexión a la API, el programa notificará del error e intentará realizar la conversión nuevamente. Si ingresa un valor no válido en cualquier paso, el programa le solicitará que lo ingrese de nuevo.

```plaintext
Errores posibles:
Falla en conexion al servidor
Falla en conexion API
Ingreso de caracteres especiales
Ingreso de numeros fuera del rango solicitado en el menu
```

## Requisitos

- [Java](https://www.java.com/download/)
- Conexión a Internet para acceder a la API de conversión
- Biblioteca gson de google.

## Notas Adicionales
Asegúrese de introducir valores válidos en cada paso para evitar errores.
Las tasas de conversión son proporcionadas por una API externa y pueden cambiar en cualquier momento.
