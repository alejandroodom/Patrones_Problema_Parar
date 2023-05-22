# Patrones_Problema_Parar

# El problema de parar.

# Introducción
Se nos ha pedido realizar una implementación del problema de parar en código java. El problema consiste en determinar si es posible desarrollar un algoritmo o programa que pueda determinar si otro programa se detendrá o no para cualquier entrada dada.

En el ejemplo se crean dos máquinas; Haltchecker y Reverser. Haltchecker recibe un programa y un input y devuelve si el programa se ejecutará o se detendrá, en función de ese input. Reverser, contradice por su lado lo que devuelve Haltchecker. Si Haltchecker se detiene, Reverser se ejecuta infinitamente. En cambio, si Haltchecker no se detiene nunca, Reverser se detendrá. He implementado estas dos "máquinas" en java mediante clases y patrones.

# Desarrollo y explicación
Primero de todo, explicaré en que se basa la máquina Haltchecker, para determinar si un programa para o no para. Complementariamente a esta, he diseñado dos clases, Program e Input, para reutilizar código y que quede todo más limpio. La clase Input tiene un atributo entero y un método que lo devuelve. La clase Program, hará referencia al programa que recibirá la máquina, el cuál contendrá un método de tipo String, que devolverá una respuesta. "Para" si el programa se detiene, y "nunca" si el programa no se detiene nunca. También dispondrá de un contador que se irá incrementando hasta cumplir una condición o hasta detenerse.
Una vez explicado esto, vamos con el funcionamiento de Haltchecker. Haltchecker dispone de un método que comprueba si se detiene o no un programa que recibe junto a un input. Hace una llamada a Program, y si la respuesta de este es "para", devolverá "para", en caso contrario, devolverá "nunca".

Ahora que ya sabemos como funciona Haltchecker, vamos a explicar como funciona Reverser. Reverser es una "maquina" que contiene en su interior a Haltchecker, es decir, Reverser recibe un input y devuelve un resultado en función de lo que le diga Haltchecker. Su funcionamiento es sencillo. Este contradice lo que dice Haltchecker. Si Haltchecker devuelve "para" supuestamente debería de parar, pero Reverser no lo hace. En su lugar se ejecuta infinitamente. ¿Y que pasa si Haltchecker no se detiene y devuelve "nunca"? Pues en este caso, Reverser se detendrá. Esto es una contradicción, ya que una máquina contradice a la otra, y de aquí surge el problema de parar.

Ahora que hemos explicado ambas "maquinas", si ejecutamos el código (en este caso el input es 10.000), Haltchecker dice que no para (devuelve "nunca"), pero Reverser dice que termina (devuelve "para"), por tanto, el programa se detiene. En cambio, si el input fuera igual o menor que 0 (condición puesta) Haltchecker se detendría, pero Reverser se ejecutaría infinitamente, por lo que el programa no se detendría nunca.

Tras haber demostrado la funcionalidad del problema y del código, procederé a explicar los patrones utilizados, así como la función de las clases generadas.
Para este programa hemos hecho uso de los patrones "Observer", "Strategy" y "Singleton".

El patrón Observer se ha utilizado para "conectar" ambas máquinas (Haltchecker y Reverser). HaltChecker actúa como sujeto observado, mientras que Reverser actúa como observador. Haltchecker notifica cuando se produce un cambio de estado. Esto ha sido implementado con uso de la interfaz HaltObserver. 

El patrón Singleton ha sido aplicado a Haltchecker. Este patrón garantiza que una clase tenga una única instancia, proporcionando un punto de acceso global a esa instancia. Así nos aseguramos de que solo haya una única instancia de Haltchecker, para mantener la consistencia y la comunicación con los observadores. Para ello, hemos hecho uso de un método estático getInstance(), que devuelve la instancia de la clase declarada como atributo, y si no se ha creado anteriormente, la crea.

El patrón Strategy, se utiliza para encapsular diferentes algoritmos de parada, mediante la interfaz StopAlgorithm, aunque no he sabido implementarlo correctamente en Haltchecker.

# Conclusiones
Podemos concluir que el problema de parar es un problema fundamental en el campo de la computación. Este demuestra una contradicción, lo cual demuestra que los ordenadores tienen limitaciones. 
También existen algunas implicaciones de este problema en otros campos de estudio, como la verificación de programas o la seguridad informática. Además es aplicable a la vida real, esto se puede ver en matemáticas (teoría de recursión) o en situaciones cotidianas, como determinar si un algoritmo de búsqueda de rutas encontrará una solución.






