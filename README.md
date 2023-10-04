# Árvore AVL

CPU usado: AMD Ryzen 7 4800H with Radeon Graphics (16) @ 2.900GHz

Memória RAM: 16 GB @ 32000 MHz

## Testes de performance

Os resultados dos testes de performance foram obtidos atraves do comando
de linux `/usr/bin/time`. Exemplo de output:

    0.08user 0.01system 0:00.07elapsed 125%CPU (0avgtext+0avgdata 33348maxresident)k
    0inputs+0outputs (0major+2643minor)pagefaults 0swaps

_Notas: memória usada leva em conta todo o processo do java_

- Inserção de 100 elementos gerados aleatoriamente:

        Tempo elapsado: 0:00.08s
        Porcentagem máxima da CPU: 105%
        Máximo de memória usada: 32.72 MB

- Inserção de 500 elementos gerados aleatoriamente:

        Tempo elapsado: 0:00.07s
        Porcentagem máxima da CPU: 136%
        Máximo de memória usada: 31.84MB

- Inserção de 1000 elementos gerados aleatoriamente:

        Tempo elapsado: 0:00.05s
        Porcentagem máxima da CPU: 142%
        Máximo de memória usada: 33.63MB

- Inserção de 10000 elementos gerados aleatoriamente:

        Tempo elapsado: 0:00.28s
        Porcentagem máxima da CPU: 114%
        Máximo de memória usada: 34.33MB

- Inserção de 20000 elementos gerados aleatoriamente:

        Tempo elapsado: 0:01.05s
        Porcentagem máxima da CPU: 102%
        Máximo de memória usada: 32.50MB

- Busca com inserção de 20000 elementos aleatórios:

        Tempo elapsado: 0ms

- Remoção com inserção de 20000 elementos aleatórios:

        Tempo elapsado: 2ms

- 50000 elementos aleatórios:

        Inserção demorou 9060 ms
        Busca demorou 0 ms
        Remoção demorou 3 ms
