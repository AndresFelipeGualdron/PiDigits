# Laboratorio 1

## ANDRES GUALDRON - NATALIA PALACIOS

### Part I - Introduction to Java Threads
![](https://github.com/AndresFelipeGualdron/PiDigits/master/imp/1.PNG "Thread de números entre A y B")

Esta es la forma en la que se completó la clase que define el ciclo de vida del hilo que imprime los números entre un A y B determinado.

![](https://raw.githubusercontent.com/AndresFelipeGualdron/PiDigits/master/imp/2.PNG)

Se crearon los hilos asignando los intervalos dados y se ejecutó el programa, primero con run() y luego con start(). Se pudo observar que al ejecutarlo con run() los números se imprimían en total orden y cuando se ejecutaba con start(), la impresión no tenía un orden determinado.

![](https://raw.githubusercontent.com/AndresFelipeGualdron/PiDigits/master/imp/3.PNG "ejecución con start()")

![](https://raw.githubusercontent.com/AndresFelipeGualdron/PiDigits/master/imp/4.PNG "ejecución con run()")

Esta diferencia se debe a que cuando usamos run() el programa se va a ejecutar en orden, hilo por hilo, y cuando usamos start() los tres hilos comienzan a ejecutarse al mismo tiempo, el proceso lo hacen en paralelo y por lo tanto, la impresión no va a tener un orden específico, éste puede variar.

### Part II BBP

![](https://raw.githubusercontent.com/AndresFelipeGualdron/PiDigits/master/imp/5.PNG "Clase Thread de PiDigits")

![](https://raw.githubusercontent.com/AndresFelipeGualdron/PiDigits/master/imp/6.PNG "Método donde creado para obtener los dítgitos con hilos")

### Part III

![](https://raw.githubusercontent.com/AndresFelipeGualdron/PiDigits/master/imp/7.PNG "Obteniendo 1000000 digitos con un hilo")

![](https://raw.githubusercontent.com/AndresFelipeGualdron/PiDigits/master/imp/8.PNG "Obteniendo 1000000 digitos con 200 hilos")

![](https://raw.githubusercontent.com/AndresFelipeGualdron/PiDigits/master/imp/9.PNG "Obteniendo 1000000 digitos con 500 hilos")

### Why is the best performance not achieved with the 500 threads?
Ya que la sección paralela al algoritmo aumenta cuando el número de hilos aumentan

### How does this performance compare when 200 are used?.
con 200 hilos hay un mejor rendimiento ya que es un mejor equilibrio con la sección paralela

### How does the solution behave using as many processing threads as cores compared to the result of using twice as much?
Mejora el procesamiento ya que cada core puede encargarse de cada subproceso, dependiendo de cuanto debe procesar cada core

### According to the above, if for this problem instead of 500 threads on a single CPU, 1 wire could be used on each of 500 hypothetical machines, would Amdahls's law be better applied? If, instead, c threads were used in 500 / c distributed machines (where c is the number of cores of said machines), would it be improved? Explain your answer.
Si en ves de subprocesos se usaran nuevas máquinas el procesamiento sería mucho más rápido ya que cada máquina tiene sus propios cores para llevar a cabo cada subproceso que se le asigne.


