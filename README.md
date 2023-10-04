# Árvore AVL

CPU usado: AMD Ryzen 7 4800H with Radeon Graphics (16) @ 2.900GHz

Memória RAM: 16 GB @ 32000 MHz

## Testes de performance

Os resultados dos testes de performance foram obtidos atraves do comando
de linux `/usr/bin/time`. Exemplo de output:

    0.08user 0.01system 0:00.07elapsed 125%CPU (0avgtext+0avgdata 33348maxresident)k
    0inputs+0outputs (0major+2643minor)pagefaults 0swaps

_Notas: memória usada leva em conta todo o processo do java_

### Resultados para [Árvore Binária](https://github.com/luizgdr/ArvoreBinariaBusca)

- Inserção de 100 elementos gerados aleatoriamente:

        Tempo elapsado: 0:00.05s
        Porcentagem máxima da CPU: 141%
        Máximo de memória usada: 33.15 MB

- Inserção de 500 elementos gerados aleatoriamente:

        Tempo elapsado: 0:00.09s
        Porcentagem máxima da CPU: 105%
        Máximo de memória usada: 32.13MB

- Inserção de 1000 elementos gerados aleatoriamente:

        Tempo elapsado: 0:00.07s
        Porcentagem máxima da CPU: 144%
        Máximo de memória usada: 33.35MB

- Inserção de 10000 elementos gerados aleatoriamente:

        Tempo elapsado: 0:00.05s
        Porcentagem máxima da CPU: 141%
        Máximo de memória usada: 32.95MB

- Inserção de 20000 elementos gerados aleatoriamente:

        Tempo elapsado: 0:00.07s
        Porcentagem máxima da CPU: 136%
        Máximo de memória usada: 32.45MB

- Busca com inserção de 20000 elementos aleatórios:

        Tempo elapsado: 0ms

- Remoção com inserção de 20000 elementos aleatórios:

        Tempo elapsado: 1ms

- 50000 elementos aleatórios:

        Inserção demorou 8 ms
        Busca demorou 0 ms
        Remoção demorou 0 ms

### Resultados para Árvore AVL

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

## Análise dos resultados


Agora, ao observarmos os resultados, podemos perceber que a variação não
parece seguir uma lógica, pois, mesmo aumentando a quantidade de números
inseridos, nem sempre ocorre um aumento na quantidade de CPU utilizada ou no
máximo de memória. O único aumento visível ocorre durante a inserção de 10.000
elementos e 20.000 elementos na árvore AVL.

Por que isso acontece? Isso ocorre devido ao fato de que a máquina na qual
foram realizados os testes tinha capacidade suficiente para realizar todas as
operações de forma "fácil", sem ser sobrecarregada. Agora, se observarmos as
últimas inserções na AVL, podemos notar que ela é a estrutura que, em caso de
testes mais extensos, se mostraria mais custosa para o sistema. Isso se deve à
sua implementação que envolve o balanceamento da árvore, fazendo assim mais
operações no sistema.

### Busca e Remoção

Como podemos observar mais uma vez, a capacidade do computador em realizar os
testes tornou mais difícil uma análise de forma visualmente satisfatória. Em
nenhum dos casos a busca ultrapassou 01ms, nem mesmo no teste realizado com
50.000 elementos. No entanto, assim como na inserção, podemos perceber que a
remoção da árvore AVL também levou um pouco mais de tempo devido ao método de
balanceamento, uma vez que, ao realizar a remoção, a árvore provavelmente
precisa ser rebalanceada, exigindo mais do sistema.

## Conclusão

Em cenários com um grande número de elementos, a árvore AVL tende a ser mais
custosa em termos de uso de CPU e memória devido ao balanceamento necessário.
No entanto, em cenários com um número menor de elementos a diferença de
desempenho entre as duas estruturas de dados é insignificante e pode não ser
uma consideração crítica. A escolha entre uma árvore AVL e uma árvore binária
de busca deve ser feita considerando o equilíbrio entre o desempenho e a
complexidade da implementação, dependendo dos requisitos específicos do sistema
e do tamanho esperado dos dados.
