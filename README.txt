- Para ejecutar en visual Studio Code
1. Instalar Extension Pack for Java
2. Instalar JDK (si es que no lo tiene)
3. presionar F5 para ejecutar el programa (una vez precionado espere a que se levante)
4. una vez ejecutado el programa vera cuadros para ingresar datos:
    1.  a:__    c:__    m:__    x0:__   n:__    Generar
    donde: x_(i+1)=(a(x_i)+c)mod m; x_0= x0, generador congruencial mixto
    n= numero de iteraciones a realizar.

    2.  a:__    m:__    exp:__   x0:__  n:__    Generar
    donde: x_(i+1)=a(x_i)  mod m^exp; x_0=x2, generador congruencial múltiple
    n= numero de iteraciones a realizar.
    exp= valor del exponente.
5. una vez ingresado los datos, solo podra ejecutar un tipo de generador a la vez y se mostrar
en la tabla de alado el resultado.
- La primera opción es para el generador congruencial mixto
- La segunda opción es para el generador congruencial múltiple
- El programa tambien calcula U = aleatorio
- El programa tambien calcula el ciclo de vida