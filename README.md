# Atividade Somativa em Equipe 3

Atividade Somativa em Equipe 3 (ASE3) da disciplina de Resolução de Problemas Estruturados em Computação
do curso de Engenharia de Software da PUCPR, campus Londrina, com prazo de entrega para o dia 23/06/2021.

**Organização do projeto:**

src/main:
* br.pucpr.ed.ase3.list: pacote contendo a implementação de listas não ordenada, ordenada e ordenável,
  baseado no projeto AFI8, além da implementação dos algoritmos de ordenação.
* br.pucpr.ed.ase3.map: pacote contendo a implementação de hash map da AFI7
* br.pucpr.ed.ase3.tree: pacote contendo a implementação de árvore binária da AFI6
* br.pucpr.ed.ase3.util: pacote contendo as classes utilitárias `StringUtil` e `Timer`.

srv/test:
* br.pucpr.ed.ase3: Classe com testes unitários que devem ser executados para validar o funcionamento
  dos algoritmos de ordenação.

**Requisitos:**

1) Adicionar a implementação dos algoritmos de busca bubble-sort, merge-sort, shell-sort e quick-sort 
   na classe `ListSort`, pedidos como entrega na AFI8.
   
2.1) Adicionar a implementação do método UnorderedArrayList.find, 
   pedido como entrega na AFI7 (exercício 4).

2.2) Adicionar a implementação do método put na classe UnorderedMap, 
   pedido como entrega na AFI7 (exercício 6).

3) Implementar na classe `MainApp` a alocação de listas, árvores e hash maps com quantidade variada de 
   elementos e de buscas. A tabela abaixo indica todas as combinações que deverão ser testadas:

Quantidade de elementos | Quantidade de buscas
------------ | -------------
10000 | 10000
10000 | 35000
10000 | 60000
10000 | 85000
10000 | 110000
20000 | 10000
20000 | 35000
20000 | 60000
20000 | 85000
20000 | 110000
30000 | 10000
30000 | 35000
30000 | 60000
30000 | 85000
30000 | 110000
   
Cada iteração marcará a duração em milissegundos da alocação, ordenação, busca de elementos e a duração total nas seguintes
estruturas de dados e algoritmos:  
* Lista não ordenada com busca sequencial (já implementado)
* Lista ordenada com busca binária (já implementado)
* Lista não ordenada com ordenação por bubble-sort e busca binária
* Lista não ordenada com ordenação por merge-sort e busca binária
* Lista não ordenada com ordenação por shell-sort e busca binária
* Lista não ordenada com ordenação por quick-sort e busca binária
* Árvore binária
* Hash map

**Como obter a duração de cada etapa de execução**

Foi criada a classe `Timer`, que facilita o registro do início e marcação da conclusão de cada etapa.
Anter de utilizar o timer é necessário instancia-lo:

    Timer timer = new Timer();

Todos os métodos (`startTimer`, `stopTimer`, `getResult` e `getTotal` esperam o identificador do timer
como parâmetro. Permitindo o registro de tempo de execução para cada algoritmo separadamente.

Para iniciar o timer logo antes da alocação execute (nos exemplos a seguir, usamos "merge-sort" como 
identificador do timer):

    timer.startTimer("merge-sort");

Após a conclusão de cada etapa, execute:

    timer.addStop("merge-sort");

Para obter os resultados, execute:

    List<Long> result = timer.getResult("merge-sort");

O método acima retornará uma lista com a duração de cada etapa, sendo que `result.get(0)` indicará
a duração da primeira etapa (alocação), `result.get(1)` indicará a duração da segunda etapa (ordenação),
e assim por diante.

Para obter a duração total execute:

    Long total = timer.getTotal("merge-sort")

Nos casos em que a ordenação não é necessária (lista ordenada, árvore binária e hash map), execute
o método `addStop` 2 vezes seguidas, fazendo com que a etapa de ordenação seja registrada com duração 0.
Por exemplo:

    timer.addStop("arvore-binária");
    timer.addStop("arvore-binária");

**Formatação do resultado**

Ao final deste arquivo há um exemplo de resultado que deverá ser gerado por este programa. Para
melhor formatar o resultado, foi incluída neste projeto a classe `StringUtil`, que possui o método
`lpad` (left pad), que recebe como parâmetro a palavra/valor que será exibido e a quantidade de caracteres
que ela deverá ocupar na tela. 

Se a palavra passada como parâmetro for "Algoritmo" (possui 9 caracteres) e o parâmetro `pad` for 20,
o método completará a string com 11 espaços a esquerda, permitindo que os dados fiquem alinhados, como
em uma tabela. 

Exemplo:

    StringUtil.lpad("Algoritmo", 20)

**Critérios de Avaliação**

1) (0,8 ponto) Execução dos testes unitários com sucesso (0,2 por teste).

2) (0,8 ponto) Execução correta da classe MainApp com os 8 algoritmos indicados na seção de requisitos se o 
trabalho for feito em grupo, ou 6 algoritmos a escolha do estudante caso seja feito individual.

3) (0,4 ponto) Inspeção do código-fonte. Adequação a boas práticas de programação e orientação a objetos.  
   Dica: utilize ferramentas de inspeção de código. Por exemplo Analyze->Inspect Code no IntelliJ IDEA,
   ou o SonarLint, que está disponível em diversas IDEs.

*Exemplo de saída da execução do programa*

    QUANTIDADE NÚMEROS: 10000	 QUANTIDADE BUSCAS: 10000
               Algoritmo            Alocação           Ordenação               Busca               Total
              sequencial                   2                   0                   1                   3
                 binária                  92                   0                   5                  97
             bubble-sort                   4                 492                   4                 500
              merge-sort                   0                  44                   2                  46
              shell-sort                   0                  16                   2                  18
              quick-sort                   1                   7                   2                  10
          arvore-binária                   6                   0                   3                   9
                hash-map                   4                   0                   1                   5
    
    QUANTIDADE NÚMEROS: 10000	 QUANTIDADE BUSCAS: 35000
               Algoritmo            Alocação           Ordenação               Busca               Total
              sequencial                   1                   0                   2                   3
                 binária                 108                   0                   6                 114
             bubble-sort                   1                 407                   5                 413
              merge-sort                   1                  15                   4                  20
              shell-sort                   1                   3                   4                   8
              quick-sort                   0                   3                   4                   7
          arvore-binária                   2                   0                   7                   9
                hash-map                   2                   0                   3                   5
    
    QUANTIDADE NÚMEROS: 10000	 QUANTIDADE BUSCAS: 60000
               Algoritmo            Alocação           Ordenação               Busca               Total
              sequencial                   1                   0                   4                   5
                 binária                  80                   0                   8                  88
             bubble-sort                   0                 445                   7                 452
              merge-sort                   0                   4                   7                  11
              shell-sort                   0                   3                   6                   9
              quick-sort                   0                   2                   6                   8
          arvore-binária                   2                   0                  10                  12
                hash-map                   1                   0                   4                   5
    
    QUANTIDADE NÚMEROS: 10000	 QUANTIDADE BUSCAS: 85000
               Algoritmo            Alocação           Ordenação               Busca               Total
              sequencial                   1                   0                   1                   2
                 binária                  79                   0                  11                  90
             bubble-sort                   0                 442                  11                 453
              merge-sort                   0                   6                  10                  16
              shell-sort                   0                   2                  10                  12
              quick-sort                   0                   1                  10                  11
          arvore-binária                   2                   0                  11                  13
                hash-map                   2                   0                   1                   3
    
    QUANTIDADE NÚMEROS: 10000	 QUANTIDADE BUSCAS: 110000
               Algoritmo            Alocação           Ordenação               Busca               Total
              sequencial                   1                   0                   1                   2
                 binária                  78                   0                  14                  92
             bubble-sort                   0                 444                  13                 457
              merge-sort                   0                   9                  12                  21
              shell-sort                   0                   2                  12                  14
              quick-sort                   0                   5                  12                  17
          arvore-binária                   2                   0                  14                  16
                hash-map                   2                   0                   1                   3
    
    QUANTIDADE NÚMEROS: 20000	 QUANTIDADE BUSCAS: 10000
               Algoritmo            Alocação           Ordenação               Busca               Total
              sequencial                   1                   0                   0                   1
                 binária                 463                   0                   2                 465
             bubble-sort                   0                1940                   1                1941
              merge-sort                   0                   8                   2                  10
              shell-sort                   0                   5                   1                   6
              quick-sort                   0                   3                   1                   4
          arvore-binária                   4                   0                   2                   6
                hash-map                   2                   1                   0                   3
    
    QUANTIDADE NÚMEROS: 20000	 QUANTIDADE BUSCAS: 35000
               Algoritmo            Alocação           Ordenação               Busca               Total
              sequencial                   0                   0                   0                   0
                 binária                 367                   0                   5                 372
             bubble-sort                   0                1990                   5                1995
              merge-sort                   0                   7                   5                  12
              shell-sort                   0                   5                   5                  10
              quick-sort                   0                   2                   5                   7
          arvore-binária                   3                   0                   5                   8
                hash-map                   1                   0                   0                   1
    
    QUANTIDADE NÚMEROS: 20000	 QUANTIDADE BUSCAS: 60000
               Algoritmo            Alocação           Ordenação               Busca               Total
              sequencial                   0                   0                   0                   0
                 binária                 370                   0                   9                 379
             bubble-sort                   0                1922                   8                1930
              merge-sort                   0                  12                   8                  20
              shell-sort                   1                   5                   8                  14
              quick-sort                   0                   3                   8                  11
          arvore-binária                   3                   0                   9                  12
                hash-map                   1                   0                   1                   2
    
    QUANTIDADE NÚMEROS: 20000	 QUANTIDADE BUSCAS: 85000
               Algoritmo            Alocação           Ordenação               Busca               Total
              sequencial                   0                   0                   1                   1
                 binária                 418                   0                  13                 431
             bubble-sort                   1                1921                  12                1934
              merge-sort                   0                  12                  12                  24
              shell-sort                   0                   5                  12                  17
              quick-sort                   0                   2                  12                  14
          arvore-binária                   3                   0                  13                  16
                hash-map                   1                   0                   1                   2
    
    QUANTIDADE NÚMEROS: 20000	 QUANTIDADE BUSCAS: 110000
               Algoritmo            Alocação           Ordenação               Busca               Total
              sequencial                   1                   0                   1                   2
                 binária                 366                   0                  17                 383
             bubble-sort                   0                1918                  15                1933
              merge-sort                   1                  11                  16                  28
              shell-sort                   0                   5                  15                  20
              quick-sort                   0                   3                  15                  18
          arvore-binária                   3                   0                  17                  20
                hash-map                   0                   0                   2                   2
    
    QUANTIDADE NÚMEROS: 30000	 QUANTIDADE BUSCAS: 10000
               Algoritmo            Alocação           Ordenação               Busca               Total
              sequencial                   0                   0                   0                   0
                 binária                 882                   0                   2                 884
             bubble-sort                   1                4591                   2                4594
              merge-sort                   1                  19                   2                  22
              shell-sort                   0                   9                   1                  10
              quick-sort                   1                   4                   1                   6
          arvore-binária                   5                   0                   2                   7
                hash-map                   1                   0                   0                   1
    
    QUANTIDADE NÚMEROS: 30000	 QUANTIDADE BUSCAS: 35000
               Algoritmo            Alocação           Ordenação               Busca               Total
              sequencial                   1                   0                   0                   1
                 binária                 925                   0                   6                 931
             bubble-sort                   0                4754                   6                4760
              merge-sort                   0                  19                   5                  24
              shell-sort                   1                  10                   5                  16
              quick-sort                   1                   3                   6                  10
          arvore-binária                   5                   0                   6                  11
                hash-map                   1                   0                   0                   1
    
    QUANTIDADE NÚMEROS: 30000	 QUANTIDADE BUSCAS: 60000
               Algoritmo            Alocação           Ordenação               Busca               Total
              sequencial                   1                   0                   0                   1
                 binária                 985                   0                  10                 995
             bubble-sort                   1                4594                  10                4605
              merge-sort                   0                  19                   9                  28
              shell-sort                   1                   9                  10                  20
              quick-sort                   0                   4                   9                  13
          arvore-binária                   5                   0                  10                  15
                hash-map                   1                   0                   1                   2
    
    QUANTIDADE NÚMEROS: 30000	 QUANTIDADE BUSCAS: 85000
               Algoritmo            Alocação           Ordenação               Busca               Total
              sequencial                   1                   0                   1                   2
                 binária                1242                   0                  14                1256
             bubble-sort                   1                4591                  13                4605
              merge-sort                   1                  19                  13                  33
              shell-sort                   1                   8                  12                  21
              quick-sort                   1                   4                  12                  17
          arvore-binária                   5                   0                  15                  20
                hash-map                   1                   0                   1                   2
    
    QUANTIDADE NÚMEROS: 30000	 QUANTIDADE BUSCAS: 110000
               Algoritmo            Alocação           Ordenação               Busca               Total
              sequencial                   1                   0                   0                   1
                 binária                 889                   0                  18                 907
             bubble-sort                   0                4618                  17                4635
              merge-sort                   0                  11                  16                  27
              shell-sort                   1                   8                  16                  25
              quick-sort                   0                   4                  16                  20
          arvore-binária                   5                   0                  18                  23
                hash-map                   1                   0                   1                   2

