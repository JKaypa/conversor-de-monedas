# Convertidor de Divisas - Proyecto en Java 17

## 📝 Descripción

¡Bienvenido al proyecto **Convertidor de Divisas**! Esta aplicación, desarrollada en **Java 17**, permite a los usuarios convertir fácilmente entre varias monedas. El usuario selecciona una moneda de una lista y la aplicación realiza la conversión basada en tasas de cambio (predefinidas o en tiempo real).

Además, cada conversión realizada se guarda en un archivo **JSON**, permitiendo que el usuario pueda revisar su historial de conversiones en cualquier momento.

## 📜 Funcionalidades

- **10 Monedas Soportadas**: Convierte entre algunas de las monedas más populares del mundo.
- **Historial de Conversión**: Cada conversión se guarda y puede ser consultada en cualquier momento.
- **Interfaz Sencilla**: Navega por las opciones con números (1-10) para las monedas, `H` para ver el historial, y `0` para salir.

## 🏦 Monedas Disponibles

Las siguientes opciones están disponibles en el menú principal:

1. **USD** - Dólar Estadounidense
2. **EUR** - Euro
3. **JPY** - Yen Japonés
4. **INR** - Rupia India
5. **COP** - Peso Colombiano
6. **ARS** - Peso Argentino
7. **MXN** - Peso Mexicano
8. **CLP** - Peso Chileno
9. **BRL** - Real Brasileño
10. **PEN** - Sol Peruano

Opciones adicionales:

- `H` - **Historial**: Ver las conversiones anteriores.
- `0` - **Salir**: Cerrar la aplicación.

## ⚙️ ¿Cómo Funciona?

1. **Iniciar la Aplicación**: Al ejecutar el programa, se mostrará el menú principal.
2. **Seleccionar una Moneda**: Elige la moneda desde la cual y hacia la cual deseas convertir seleccionando el número correspondiente.
3. **Realizar una Conversión**: Ingresa la cantidad que deseas convertir y la aplicación mostrará el resultado.
4. **Ver Historial**: En cualquier momento, presiona `H` para ver todas las conversiones anteriores almacenadas en un archivo **JSON**.
5. **Salir**: Presiona `0` para salir del programa.

### Ejemplo de Menú:

```bash
Selecciona una opción:
1. USD Dólar Estadounidense
2. EUR Euro
3. JPY Yen Japonés
4. INR Rupia India
5. COP Peso Colombiano
6. ARS Peso Argentino
7. MXN Peso Mexicano
8. CLP Peso Chileno
9. BRL Real Brasileño
10. PEN Sol Peruano
H. Historial
0. Salir
