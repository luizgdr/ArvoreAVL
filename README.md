# Árvore AVL

Alunos:
- Luiz Guilherme Durau Rodrigues
- Fabrício Guite Pereira

## Explicação

Ambas as árvores tanto a AVL quanto a [binária](https://github.com/luizgdr/ArvoreBinariaBusca)
compartilham boa parte dos métodos, com a exceção do método balancear, exclusiva
da AVL, e outros métodos que o método balancear chama para conseguir fazer sua
execução de forma correta.

As árvores consideram o primeiro elemento inserido como sua raiz, após isso é
feito a verificação se o próximo elemento é maior ou menor que a raiz, caso ele
seja maior é colocado à direita, se for menor é posto a esquerda. Assim
sucessivamente aumentando a árvore a vontade do usuário.

A busca é feita comparando o nodo atual com o número que desejamos encontrar,
caso esse número seja maior vamos para a direita do nodo, caso contrario para a
esquerda, assim até chegar ao número desejado.

Quando o método remoção é chamado ele faz a chamada da função pop passando como
parâmetros: `int n, Node atual, Node pai, Node pai2`. Quando o elemento a ser
removido é encontrado, a função pop realiza as seguintes ações com base no
número de filhos do nó a ser removido:

* Se o nó for uma folha, ele é removido simplesmente atualizando as
referências do pai.

* Se o nó tiver um filho à esquerda ou à direita, o pai do nó é atualizado
para apontar para o único filho.

* Se o nó tiver ambos os filhos, é necessário encontrar o maior elemento
na subárvore esquerda e substituir o nó a ser removido por esse valor.

Durante a impressão é impresso para a visualização o nó atual e seus filhos,
caso existam, a impressão é feita em pré-ordem isso é começa pela raiz, imprime
o nó atual, depois a subárvore esquerda e, finalmente, a subárvore direita.
Isso resulta em uma impressão da árvore seguindo a ordem de
raiz-esquerda-direita.

Partindo agora para a parte exclusiva da Árvore AVL, o balanceamento é sempre
chamado após a inserção e remoção caso o fator de balanceamento da árvore ou do
pai do nó inserido/removido for maior que 1 ou menor que -1.

O balanceamento faz a rotação da árvore, podendo ser simples ou dupla, também
pode ser feita a partir da raiz. Segue abaixo como é feita as rotações simples
e duplas.

Como exemplo será usado a rotação simples a direita, o mesmo ocorre para o
caso contrario.

Rotação Simples à Direita

A rotação à direita é usada quando o desequilíbrio ocorre na subárvore esquerda
de um nó e a subárvore esquerda é mais alta do que a subárvore direita. Para
corrigir isso, o nó desequilibrado é "puxado" para a direita, tornando o antigo
filho esquerdo do nó desequilibrado o novo pai desse nó. A antiga subárvore
direita do novo pai se torna a nova subárvore esquerda do nó desequilibrado.

Passos da Rotação:
  1. O nó desequilibrado (A) é rotacionado para a direita, tornando-se o novo
pai.
  2. O antigo filho direito do novo pai (B) torna-se o novo filho esquerdo do nó
desequilibrado.
  3. A subárvore esquerda de B permanece inalterada.

A rotação dupla é necessária quando o desequilíbrio ocorre em um nó, mas uma
simples rotação não é suficiente para restaurar o equilíbrio. Existem duas
situações em que uma rotação dupla pode ser usada:

  * rotação à direita seguida de rotação à esquerda
  * rotação à esquerda seguida de rotação à direita

Por fim segue abaixo um exemplo de saída para a árvore AVL (lembrando que no
código fornecido os números são inseridos aleatoriamente, o exemplo abaixo serve
apenas para demonstração.)

Entrada:

        arvore.inserir(100);
        arvore.inserir(56);
        arvore.inserir(32);
        arvore.inserir(80);
        arvore.inserir(127);
        arvore.inserir(115);
        arvore.remover(32);
        arvore.inserir(85);
        arvore.inserir(130);
        arvore.inserir(82);
        arvore.inserir(90);
        arvore.inserir(120);
        arvore.remover(80);
        arvore.inserir(95);
        arvore.remover(127);
        arvore.inserir(40);
        arvore.inserir(68);
        arvore.remover(56);
        arvore.remover(40);
        arvore.remover(82);

Saída:

        Arvore:
        Valor: 100 arvoreavl.Node@3feba861
        Esquerda: 85
        Direita: 120

        Valor: 85 arvoreavl.Node@30dae81
        Esquerda: 68
        Direita: 90

        Valor: 68 arvoreavl.Node@1b2c6ec2
        Esquerda: null
        Direita: null

        Valor: 90 arvoreavl.Node@65b3120a
        Esquerda: null
        Direita: 95

        Valor: 95 arvoreavl.Node@6f539caf
        Esquerda: null
        Direita: null

        Valor: 120 arvoreavl.Node@79fc0f2f
        Esquerda: 115
        Direita: 130

        Valor: 115 arvoreavl.Node@50040f0c
        Esquerda: null
        Direita: null

        Valor: 130 arvoreavl.Node@2dda6444
        Esquerda: null
        Direita: null


## Testes de performance

CPU usado: AMD Ryzen 7 4800H with Radeon Graphics (16) @ 2.900GHz

Memória RAM: 16 GB @ 32000 MHz

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
