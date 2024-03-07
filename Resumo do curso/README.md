# Curso Java completo

# **Programação orientada a objeto**

Instanciação de objeto

Classes

Atributos, métodos e encapsulamento (public, private, protected)

toString

Tipo final, é constante → Regras de boas práticas é escrever constante com tudo maiúsculo → PI, NET_CONST,....

**Não é possível chamar um método não estático dentro de outros métodos que sejam estáticos**

membros estáticos e não-estático - 

por exemplo a calculadora é estática pq os cálculos não mudam, e o PI tb é estático, pq independente do objeto ele vai dar 3.14, não muda.

metodo é estático quando independe do objeto, não precisa instanciar, e pode chamar sem ter um objeto.

classes utilitárias pode ser static

var estática quer dizer que independente da instância eles compartilham o mesmo número

o método estático

`Exemplo.metodoEstatico();  // Chama o método estático diretamente pela classe`

`Exemplo objeto = new Exemplo();
objeto.metodoNaoEstatico();  // Chama o método não estático através de uma instância`

## **This**.

Chama o atributo da classe atual

acessar os campos do objeto

outro uso é: passar o próprio objeto como argumento na chamada de um método ou construtor

## **Construtor**

Executa no momento da instanciação do objeto, iniciar valores, permitir ou obrigar que receba dados e injeção de dependência.

Pode criar várias versões customizadas dele.

## **Sobrecarga**

Disponibilizar mais de uma versão da mesma operação, a diferença são os parâmetros, o nome do método é igual..

## **Encapsulamento**

é um princípio que consiste em esconder os detalhes implementação de uma classe, expor apenas operações seguras que mantem o objeto em um estado consistente.

Os atributos não deve ser exposto, e só acessados por getters e setters

- **Public:**  é possível ver as informações fora da classe e é possível que eles sejam acessados sem qualquer tipo de restrição estabelecida
- **Private:** a informação não pode ser vista fora da própria classe e, também, não pode ser acessado
- **Protected:** só pode ser acessado no mesmo pacote, bem como subclasses de pacotes diferentes.
- **(nada)**: só pode ser acessado nas classes do mesmo package

![Untitled](Curso%20Java%20completo%2017f21959a45c4c5f9369aaacabde1abd/Untitled.png)

Encapsular um ponto de alteração das variáveis de regra de negocio é importante, para que quando essa regra mude, a alteração será em apenas um método.

Ao invés de usar a variável, use um método para essa variável.

# Comportamento de memória, arrays e lists

```java
Product p1, p2;
```

Ao declarar as variáveis elas são alocadas no **Stack**

```java
p1 = new Product(”TV”, 900.00, 0);
```

Quando passa valores, eles serão alocadas em outra área de memoria chamado Heap → é onde são alocados os objetos em tempo de execução, que chama alocação dinâmica de memoria

a variável p1 guarda o endereço de memoria correspondente ao endereço de onde esta o objeto que foi alocado

![Untitled](Curso%20Java%20completo%2017f21959a45c4c5f9369aaacabde1abd/Untitled%201.png)

### **Tipos primitivos**

São caixas e não ponteiro

![Untitled](Curso%20Java%20completo%2017f21959a45c4c5f9369aaacabde1abd/Untitled%202.png)

| Garbage collector | escopo local |
| --- | --- |
| Quando não possuem mais referência para ele, serão deslocados pelo garbage collector | Variáveis locais são deslocadas imediatamente assim que seu escopo local sai de execução |

## Vetores

### Arrays

Homogênea → mesmo tipo de dados

Ordenada → acessados por meio de posições

Alocados de uma vez só

| Vantagem | Desvantagem |
| --- | --- |
| Acesso imediato aos elementos pela sua posição | Tamanho fixo |
|  | Dificuldade para se realizar inserções e deleções |

## **Boxing**

É o processo de conversão de um objeto tipo valor para um objeto tipo referência compatível 

Ou seja, de variável para atributo de classe

Encaixotamento

![Untitled](Curso%20Java%20completo%2017f21959a45c4c5f9369aaacabde1abd/Untitled%203.png)

## **Unboxing**

É um processo de conversão de um objeto tipo referência para um objeto tipo valor compatível

Desencaixotar 

![Untitled](Curso%20Java%20completo%2017f21959a45c4c5f9369aaacabde1abd/Untitled%204.png)

## **Wrapper**

São classes equivalentes aos tipos primitivos

Cada tipo primitivo te um tipo classe, por exemplo Integer e int, Lon e long

Mas por quê? Os tipos referência aceitam valores null e usufruem dos recursos de OO.

## Laço for each

Sintaxe simplificada para percorrer coleções

for (tipo apelido : colecao){

```java
for (tipo apelido : colecao){
	<comando 1>
	<comando 2>
}
```

## Listas

| Listas |
| --- |
| Homogenia→ dados do mesmo tipo |
| Ordenada → acessados por meio de posição |
| Inicia vazia→ alocados sob demanda |
| Cada elemento ocupa um nó |

Tipo (interface): List

Uma interface é um tipo que define apenas as especificações das operações, para trabalhar com um objeto desse tipo, precisa instanciar, porém a interface não pode ser instanciado, precisa-se de uma classe que implemente essa interface.

- ArrayList
- LinkedList

Desvantagens → Acesso sequencial aos elementos (Pois cada nó é um ponteiro do outro, porém depende ta implementação da lista, por exemplo o ArrayList se comporta como um vetor então nao tem esse problema)

Vantagens → Tamanho variável e facilidade para realizar inserção e deleções

# 📚 Exemplos

**Tamnho da lista:** 

```java
size()
```

**Inserir elemento na lista:**

```java
 add(obj), add(int, obj)
//int -> para posição
```

**Remover elementos da lista:**

```java
 remove(obj), remove(int), removeIf(Predicate)
```

**Encontrar posição de elemento:**

```java
indexOf(obj), lastIndexOf(obj)
```

**Filtrar lista com base em predicado:** 

```java
List<Integer> result = list.stream().filter(x → x > 4).collect(Collectors.toList());
```

**Encontrar primeiro ocorrência com base em predicado:** 

```java
Integer result = list.stream().filter(x → x>4).findFirst()orElse(null)
```

### Função Lambda

```java
System.out.println("Imprime todos os elementos pares da lista!");
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
list.forEach(n -> {
       if (n % 2 == 0) {
             System.out.println(n);
       }
});
```

```java
System.out.println("Imprime o quadrado de todos os elementos da lista!");
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
list.forEach(n -> System.out.println(n * n));
```

.stream

O objetivo principal de usar **`stream()`** é permitir operações funcionais e de processamento de dados em coleções. Um fluxo é uma sequência de elementos que pode ser processada em paralelo ou sequencialmente. Streams oferecem uma maneira mais concisa e expressiva de manipular coleções em comparação com os loops tradicionais.

.charAt

O método **`charAt(int index)`** é usado para obter o caractere em uma determinada posição (índice) dentro de uma string.

.collect()

O método **`.collect()`** em Java é uma operação terminal em um fluxo (stream) que é usada para transformar os elementos do fluxo em uma coleção ou outro tipo de objeto. Ele faz parte do pacote **`java.util.stream.Collectors`**.

O método **`.collect()`** geralmente é usado em conjunto com o método **`.stream()`** para realizar operações em coleções de maneira funcional. Um exemplo comum de uso do **`.collect()`** é transformar os elementos de um fluxo em uma lista, conjunto ou mapa.

```java
List<Integer> numerosPares = numeros.stream()
.filter(numero -> numero % 2 == 0)
.collect(Collectors.toList());

public static Integer position(List<Employee> list, int id) {
		for(int i = 0; i <list.size(); i++) {
			if(list.get(i).getId() == id) {
				return i;
			}
		}
	}
```

## **Matrizes**

São arranjos bidimensionais 

vetor de vetores

(lin, col)

| Vantagem | Desvantagem |
| --- | --- |
| Acesso imediato aos elementos pela sua posição | Tamanho fixo |
|  | Dificuldade para se realizar inserções e deleções |

```java
int[][] mat = new int[n][n];
for(int i=0; i<n;i++){
	for(int j=0;j<n;j++){
		mat[i][j]= sc.nextInt();
	}
}
```

A interface **`IntStream`** inclui métodos como:

- **`map`:** Para transformar cada elemento do stream aplicando uma função.
- **`filter`:** Para filtrar elementos com base em uma condição.
- **`sum`, `average`, `min`, `max`:** Para realizar operações de redução, como soma, média, mínimo e máximo.
- **`forEach`:** Para iterar sobre os elementos do stream e realizar uma ação para cada elemento.
- **`toArray`:** Para converter o stream em um array de inteiros.
- E muitos outros métodos úteis para manipulação de fluxos de inteiros.

## Trabalhando com matriz

Criar, acessar adicionar na matriz, procurar e transformar em array ordenado.

```java
package matrizes;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o número de linhas e colunas");
        int l = sc.nextInt();
        int c = sc.nextInt();

        int[][] mat = new int[l][c];

        for (int i = 0; i < l; i++) {
        	System.out.println("Digite os valores da linha " + (i+1) + " separados por espaço");
            for (int j = 0; j < c; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        print(mat, l, c);
        
        System.out.println("Digite um número para procurar");
        int n = sc.nextInt();
        
        
        
        
        
//        procurando usando stream e array ordenado
        
        int[] arrayOrdenado = Arrays.stream(mat)
                .flatMapToInt(Arrays::stream)
                .sorted()
                .toArray();
        
        int indice = Arrays.binarySearch(arrayOrdenado, n);
        if (indice >= 0) {
            int indiceLinha = indice / c;
            int indiceColuna = indice % c;
            System.out.println("Número encontrado na posição: [" + indiceLinha + ", " + indiceColuna + "]");
            System.out.println((indiceLinha>0)? "Up: " + mat[indiceLinha-1][indiceColuna]: ""); 
            System.out.println((indiceLinha<l-1)? "Down: " + mat[indiceLinha+1][indiceColuna]: "");
            System.out.println((indiceColuna<c-1)? "Rigth: " + mat[indiceLinha][indiceColuna+1]: "");
            System.out.println((indiceColuna>0)? "Left: " + mat[indiceLinha][indiceColuna-1]: "");
        
        } else {
            System.out.println("Número não encontrado na matriz.");
        }
        
        
        
        
//        procura com o for
        
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat[i].length; j++) {
				if (mat[i][j] == n) {
					System.out.println("Position " + i + "," + j + ":");
					if (j > 0) {
						System.out.println("Left: " + mat[i][j-1]);
					}
					if (i > 0) {
						System.out.println("Up: " + mat[i-1][j]);
					}
					if (j < mat[i].length-1) {
						System.out.println("Right: " + mat[i][j+1]);
					}
					if (i < mat.length-1) {
						System.out.println("Down: " + mat[i+1][j]);
					}
				}
			}
		}
        
        

        
        
        sc.close();
    }

    public static void print(int[][] mat, int l, int c) {
    	System.out.println("Print com dois for");
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();  
        }
        System.out.println("Print com toString");
        for (int[] linha : mat) {
            System.out.println(Arrays.toString(linha));
        }

        System.out.println("Print com dois loop for each");
        for (int[] linha : mat) {
            for (int elemento : linha) {
                System.out.print(elemento + " ");
            }
            System.out.println();  
        }

    }

}
```

Data-hora e duração

Data hora local é sem fuso horário

- Usar quando o momento exato não interessa as outras pessoas de outro fuso
- data de nascimento, excel → uso na loja , data da venda (presumindo nào interessar o fuso)

Data hora global é com fuso horário

- Usar quando o momento exato importa as outros fusos
- Quando será um sorteio, quando o comentario foi postado, inicio e fim do evento.

Duração é o tempo decorrido entra duas datas-horas

TimeZone

GMT - Greenwich mean time

é o horário de Londres

também chamado de z ou zulu time

UTC- é o padrão

padrão ISO 8601

data hora global

2022-07-23T14:52:02**-03:00**

GMT-3

todas as horas são relativas as horas de Londres

2022-07-23T14:52:02Z

é o horário de Londres

### Operações com data hora

Instanciação →

(agora) → instanciar uma hora do momento atual

Texto ISO 8601 → acessar uma api, trazer requisição de data em texto e é necessário converter para data hora

Texto formato customizado → o texto não está em formato ISO, vc vai precisar manipular e converter para data hora

dia, mês, ano, [horário] → instanciar data hora a partir desses inputs, info solta

Formatação →

Data hora em ISO 8601

Data hora em texto formato customizado

Obter dados de uma data hora local →

Data hora local em dia, mês, ano, horário

Converter data hora global para local →

Data hora global, timezone(sistema local) para da

Boas práticas: armazene UTC, mostre local

Cálculos com data-hora

Data-hora +/- tempo → data hora

Data-hora 1, Data-hora 2 → duração

docs DateTimeFormatter

[https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html](https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html)

```java
import java.time.LocalDate

--------------------------------------------

LocalDate d01 = LocalDate.now();
LocalDateTime d02 = LocalDateTime.now();
Instant d03 = Instant.now();

LocalDate d04 = LocalDate.parse("2022-07-20");
LocalDate d05 = LocalDateTime.parse("2022-07-20T01:30:26");
LocalDate d06 = Instant.parse("2022-07-20T01:30:26Z");
LocalDate d07 = Instant.parse("2022-07-20T01:30:26-03:00");

DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());

LocalDate d08= LocalDate.parse("20/07/2022", fmt1);
LocalDate d09= LocalDateTime.parse("20/07/2022 01:30", fmt2);

LocalDate d10 = LocalDate.of(2022, 7, 20);
LocalDateTime d11 = LocalDateTime.of(2022, 7, 20, 1, 30);

System.out.println("d04 = " + d04.format(fmt1));
System.out.println("d04 = " + fmt1.format(d04));
-----------------------------------------------
//output
/*
	d01 = 2022-07-023
	d02 = 2022-07-23T18:35:48.586963400
Gerou 3 horas depois, pois pegou a hora de Londres
	d03 = 2022-07-23T21:35:48.586963400Z
	d07 = 2022-07-20T04:30:26Z
	d10 = 2022-07-20
	d11 = 2022-07-20T01:30

	d04 = 20/07/2022

*/

```

```java
for (String s : ZoneId.getAvailableZoneIds()){
	System.out.println(s)
}

//vai mostrar todas as zonas que pode usar

LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault())
LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"))

```

`getDayOfMonth()`

`getMonthValue()`

`getYear()`

`getHour()`

```java
LocalDate pastWeekLocalDate = d04.minusDays(7);
LocalDate nextWeekLocalDate = d04.plusDays(7);

//Somando uma unidade de tempo
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
Date d = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
System.out.println(sdf.format(d));
Calendar cal = Calendar.getInstance();
cal.setTime(d);
cal.add(Calendar.HOUR_OF_DAY, 4);
d = cal.getTime();
System.out.println(sdf.format(d));

//Obtendo uma unidade de tempo
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
Date d = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
System.out.println(sdf.format(d));
Calendar cal = Calendar.getInstance();
cal.setTime(d);
int minutes = cal.get(Calendar.MINUTE);
int month = 1 + cal.get(Calendar.MONTH);
System.out.println("Minutes: " + minutes);
System.out.println("Month: " + month);
```

Long diff = checkout.getTime() - checkIn.getTime() 

TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS

# Git e Github

Git → controle de versionamento (versões)

Github → Serviço online de hospedagem de projeto gerenciado pelo Git

Configurar chave SSH, serve para que o github reconheça seu computador

Criar essa chave no computador e passa para o github

Copiar e colar no no git bash

 `ssh-keygen -t rsa -b 4096 -C "your_email@example.com"`

**git init** 

**git add .**

**git commit -m ”g”**

**git status**

**git branch -M main**

**git switch**

**git remote add origin git@github.com:seuusuario/seurepo.git**

**git push -u origin main**

**Git Status**

Modified → modificados

Untracked → arquivos novos que nao foram salvos ainda

Deleted → deletados

**Staged**

**Commited**

**Git diff** → é a diferença de alterações

**Git checkout** (codigo do commit ou main)→ permite modificar temporariamente os arquivos do projeto o estado de um dado commit ou branch

**`importante`** → Antes de voltar pro main, certifique-se que não fez nehuma alteração no commit que vc está, para desfazer as alterações feitas use 

git reset

git clean -df

git checkout -- .

**Arquivo .gitignore** →

é um arquivo que indica o que não deve ser salvo pelo git.

Não deve ser salvo, arquivo compilados, arquivos de biblioteca externa usadas no projeto (nas dependências ele já vai baixar), arquivos de configuração da sua IDE, arquivos de configuração do seu sistema.

### Erros comuns

Remover arquivos da área de stage (é onde coloca os arquivos que serão salvos )

git status

git reset

Como desfazer modificações não salvas (voltar pro ultimo commit)

git status 

git reset

git clean -df

git checkout -- .

O que fazer quando abre o editor VIM

Estas ações podem abrir o editor VIM no terminal:

Fazer um commit sem mensagem

Fazer um merge de três vias 

Habilitar o modo de edição 

`i`

Sair do VIM, salvando as alterações

`<ESC>`

`:wq`

`<ENTER>`

Sair do VIM, descartando as alterações

`<ESC>`

`:q!`

`<ENTER>`

Como desfazer meu ultimo commit (esqueceu de algo no commit, mas n quer salvar tudo em outro commit, então desfazer o commit sem fazer modificações no arquivo)

git status

git reset --soft HEAD~1

git status 

git add . 

git commit -m “vvv”

Deletando commits e também modificando nos arquivos

git status

git reset --hard cod_do_commit

para recuperar os que ja esta no repositorio → `git pull`

Atualizar o repositorio local em relaçao ao remoto

git status 

git pull origin main

Como resolver push rejeitado por histórico diferentes

Quando o repo local está atrasado em relação ao remoto

git pull

Sobrescrever histórico no github

pode dar um git pull ou git push -f origin main (se vc sabe q o seu repo local está mais atualizado)

Resolvendo pull com conflito 

quando vai mesclar dois históricos que mexeram no mesmo arquivo

merge conflict

Como apontar o projeto para outro repositório remoto

git remote set-url origin {link ssh ou https}

git remote -v

git push -u origin main

## Enumeração

Exemplo: Ciclo de vida de um pedido: PendingPayment, Precessing, Shipped, Delivered

entities.enums

definir constantes

na classe de order cria uma variavel do tipoOrderStatus que é do tipo enums

![Untitled](Curso%20Java%20completo%2017f21959a45c4c5f9369aaacabde1abd/Untitled%205.png)

Converter String para enum

OrderStatus os1 = OrderStatus.valueOf(”PendingPayment”);

OrderStatus os2 = OrderStatus.Delivered;

Views, Controllers(entre tela e sistema), Entities, Services, Repositories(Objetos responsáveis por acessar os dados do banco de dados repo de dados qlq) → categorias de classes

Services → exemplo, salvar, pesquisar, enviar email e o repositories que faz as interações com o banco

## Composição

É um tipo de associação que permite que um objeto contenha outro 

Relação “tem-um” ou “tem-vários”

todo-parte

Exercício sobre:   https://github.com/acenelio/composition1-java

dentro de um classe instanciar outra classe q só existe pra complementar essa, sem o todo a parte não existe tb. 

## Herança

Permite o reuso de atributos e métodos(dados e comportamento)

herda da super classe

extends

Upcasting → casting da subclasse para superclasse - uso comum é no polimofirsmo.

```java
Atribuir um objeto da sub class para a super class
```

Downcasting → casting da superclasse para subclasse → instanceof - uso comum é em métodos que recebem parâmetros genéricos: ex: Equals.

```java
Nao pode converter da superclasse para subclasse, mas pode forçar,
colocando na frente o tipo da sub classe
mas nao pode converter de suubclasse pra subclasse nem forçando
```

![Untitled](Curso%20Java%20completo%2017f21959a45c4c5f9369aaacabde1abd/Untitled%206.png)

### Sobreposição

É a implementação de um método de uma superclasse na subclasse (mudar a implementação q já existe)

É fortemente recomendável usar a anotação “@Override” em um método sobrescrito

### Super

usa a msm regra da super classe

reuso 

### Classes e métodos final

Classe: evita que a classe seja herdada

Métodos evita que o método seja sobreposto.

Pra que usar? por questões de segurança dependendo da regra de negocio, as vezes é desejável garantir que uma classe não seja herada, ou que o método nao seja sobreposto

convém colocar final em métodos sobreposto pq pode causar inconsistências 

performance: atributos de tipo de uma classe final são analisados de forma mais rápida em tempo de execução

## Polimorfismo

É um recurso que permite que variáveis de um mesmo tipo mais genérico possam apontar para objetos de tipos específicos diferentes, tendo assim comportamentos diferente conforme cada tipo especifico

## Classes abstratas

São classes que não podem ser instanciadas

é uma forma de garantir herança total: somente subclasses não abstratas podem ser instanciadas, mas nunca a superclasse abstrata

não pode instanciar a super classe genérica, 

## Métodos abstratos

São métodos que não possuem implementação 

Métodos precisam ser abstratos quando a classe é genérica demais para conter sua implementação por exemplo classe formas e as subclasses retângulo, circulo….. e o métodos seria calcular área.

Se a classe possuir pelo menos um métodos abstratos a classe também é abstrata 

## Tratamento de exceções

### **Estrutura try-catch**

**Bloco try**
• Contém o código que representa a execução normal do trecho de código que
pode acarretar em uma exceção
**Bloco catch**
• Contém o código a ser executado caso uma exceção ocorra
• Deve ser especificado o tipo da exceção a ser tratada (upcasting é permitido)

O `throw` permite que uma função continue a execução mesmo quando ocorre uma exceção, enquanto o `throws` indica que a função precisa ser invocada dentro de um bloco `try-catch`. O método será encerrado imediatamente após ocorrer uma exceção, permitindo que o fluxo do programa continue.

Ao usar o `throws`, você está informando que uma exceção pode ser lançada por esse método e quem chamar o método será notificado disso. A pessoa que chamar o método deverá tratar a exceção, dependendo se ela for do tipo checked ou unchecked.

Por fim, o `throw` é a ação de lançar efetivamente a exceção.

### Stack trace

e.printStackTrace(); 

Ajuda a detectar o que aconteceu e onde.

### Bloco finally

• É um bloco que contém código a ser executado independentemente de ter
ocorrido ou não uma exceção.
• Exemplo clássico: fechar um arquivo, conexão de banco de dados, ou outro
recurso específico ao final do processamento.

## Exceções personalizadas

Sugestão de package Model

![Untitled](Curso%20Java%20completo%2017f21959a45c4c5f9369aaacabde1abd/Untitled%207.png)

criar classe de exceção e extends Exception (obriga a tratar) ou RunTimeExceptions(não precisa tratar)

Serial Version

## Estrutura de dados

QuickSort

MergeSort

BubbleSort

Implementações SET

1. **AbstractSet**: `AbstractSet` é uma classe abstrata em Java que fornece uma implementação parcial da interface `Set`. Ela é projetada para ser estendida por subclasses que desejam implementar um conjunto. Ela gerencia a maioria dos métodos da interface `Set`, deixando apenas a implementação do método `iterator()` para as subclasses.
2. **ConcurrentHashMap.KeySetView**: `ConcurrentHashMap.KeySetView` é uma visão (view) de um conjunto de chaves em um `ConcurrentHashMap`. Ele fornece acesso concorrente às chaves contidas no mapa, permitindo que várias threads leiam e iterem sobre o conjunto de chaves de forma segura.
3. **ConcurrentSkipListSet**: `ConcurrentSkipListSet` é uma implementação de conjunto baseada em listas vinculadas paralelas (skip list). Ela fornece um conjunto ordenado, que é thread-safe para operações de leitura e iterar sobre o conjunto, tornando-a adequada para ambientes concorrentes.
4. **CopyOnWriteArraySet**: `CopyOnWriteArraySet` é uma implementação de conjunto que usa um array subjacente, onde todas as operações de modificação, como adição, remoção e atualização, são copiadas em um novo array. Isso torna as operações de leitura muito eficientes, mas as operações de modificação podem ser caras, especialmente em cenários concorrentes.
5. **EnumSet**: `EnumSet` é uma implementação especializada de conjunto projetada para enumerações em Java. Ela é altamente otimizada e é representada internamente como um bit set, proporcionando um desempenho eficiente para operações de conjunto em enums.
6. **HashSet**: `HashSet` é uma implementação de conjunto que armazena elementos sem duplicatas e não garante a ordem dos elementos. Ela usa uma tabela de dispersão (hash table) para armazenar os elementos, o que resulta em inserções, remoções e pesquisas de tempo constante (em média) quando a função de dispersão é bem distribuída.
7. **JobStateReasons**: `JobStateReasons` é uma classe em Java relacionada à API de impressão. Ela fornece uma lista de razões para o estado atual de um trabalho de impressão, como "job completed", "job aborted", etc.
8. **LinkedHashSet**: `LinkedHashSet` é uma implementação de conjunto que mantém a ordem de inserção dos elementos, além de não permitir duplicatas. Ela é implementada como uma combinação de uma tabela de dispersão com uma lista vinculada, garantindo ordem previsível durante iterações.
9. **TreeSet**: `TreeSet` é uma implementação de conjunto baseada em uma árvore binária de busca balanceada (por padrão, uma árvore vermelho-negra). Ele mantém os elementos em ordem natural ou de acordo com um comparador fornecido durante a criação do conjunto. Isso permite que os elementos sejam recuperados em ordem ordenada.

### métodos importantes:

| add | Baseado no equals ou ponteiro |
| --- | --- |
| remove  | Baseado no equals ou ponteiro |
| contains | Baseado no equals ou ponteiro |
| clear | esvazia |
| size | qntd de elementos |
| removeIf | x → x.length() == 3 ou charArt(0) ==’t’…… e outros (sintaxe) |
| addAll(other) | uniao → Adiciona os elementos do outro sem repetição  |
| retainAll(other) | intersecção → remove os elementos com contidos em other  |
| removeAll(other) | diferença → remove os elementos contidos em other  |

## Recursividade

Problemas a resolver ↔ problema um pouco mais simples ↔ problema um pouco mais simples ↔ caso base

# Arquivos

ler arquivos com a classe File e Scanner

```java
File file = new File("c:\\temp\\in.txt");
Scanner sc = null;
try{
	sc = new Scanner (file);
	while(sc.hasNextLine()){
		sysout(sc.nextline());
	}
	sc.close();(melhor coloca no finally)
}

```

FileReader →stream de leitura de caracteres a partir de arquivos

BufferedReader→ lê mais rápido

Bloco try-with-resources → garante que os recursos serão fechados

instanciar no bloco try e ai ele vai fechar automaticamente.

![Untitled](Curso%20Java%20completo%2017f21959a45c4c5f9369aaacabde1abd/Untitled%208.png)

FileWriter → stream de escrita de caracteres em arquivos

![Untitled](Curso%20Java%20completo%2017f21959a45c4c5f9369aaacabde1abd/Untitled%209.png)

BufferedWriter → mais rápido

```java
public static void main(String[] args) {
	String[] lines = new String[] { "Good morning", "Good afternoon", "Good night" };
	String path = "C:\\temp\\out.txt";
	try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
		for (String line : lines) {
		bw.write(line);
		bw.newLine();
	}
	} catch (IOException e) {
		e.printStackTrace();
	}
}
```

Manipulando pasta com file

```java
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a folder path: ");
	String strPath = sc.nextLine();
	File path = new File(strPath);
	File[] folders = path.listFiles(File::isDirectory);
	System.out.println("FOLDERS:");
	for (File folder : folders) {
		System.out.println(folder);
	}
	File[] files = path.listFiles(File::isFile);
	System.out.println("FILES:");
	for (File file : files) {
		System.out.println(file);
	}
	boolean success = new File(strPath + "\\subdir").mkdir();
	System.out.println("Directory created successfully: " + success);
	sc.close();
}
```

### Interface

Uma interface **é uma maneira de declarar o comportamento de uma classe**. Nesta declaração não especificamos exatamente como acontece internamente cada comportamento. Para uma interface são declarados somente o nome do método e seus parâmetros. Esta especificação de parâmetros é feita através de seus tipos.

Interface Taxa e temos a classe TaxaBrasil, TaxaEUA e todos implements taxa

Chama a Taxa e depois especifica qual classe isso evita muitas mudanças se a taxa mudar.

acoplamento forte - sem interface 

acoplamento fraco - com interface

Inversão de controle → é quando a própria classe instancia a dependência → forte acoplamento, mais pontos de alteração

injeção de dependência → upcasting, quem vai instanciar vai ser a classe que estiver chamando 

services → faz o cálculos entre duas classes interligadas

Comparable → deve implementar na classe para poder comparar os objetos

como um objeto vai ser comparado com o outro, “CompareTo”

Default methods → ou métodos padrão, é prover implementação padrão para métodos, de modo a evitar

1.  a repetição de implementação em toda classe que implemente a interface 
2. a necessidade de criar classes abstratas para prover o reuso da implementação.

coloca os defaults methods na interface(sao implementadas)

![Untitled](Curso%20Java%20completo%2017f21959a45c4c5f9369aaacabde1abd/Untitled%2010.png)

## Generics

permite que classes, interfaces e metodos possam ser implementados parametrizados por tipo.

ajuda no reuso, type safety e peformace 

### Genéricos delimitados

Delimitar quais tipos 

<? extends Shape> → qlq tipo q extenda de shape 

Super Number

pode ser um super tipo de number, ent não podemos atribuir valores dessa lista em uma var number 

pq o super de number é object, que poder ser string boolean…

e não podemos armazenar outros tipos em number

# Diferença de Comparator e Comparable

Comparable → compare to (um parâmetro)

comparar o objeto atual com outro - classe comparada com ela mesma

vai verificar e ordenar

-1 pra o que tem q vir antes, pra esquerda

1 vai pra trás, pra direita

0 quando é igual

Comparator  → compare (dois parâmetros)

 classe seja comparada com outra

as regras de -1 esquerda, 1 direita e 0 igual, são a mesma

- Use **`Comparable`** quando você quer definir uma ordem natural para a classe e os objetos dessa classe devem ser comparáveis usando essa ordem em particular. Isso é útil quando você quer que os objetos dessa classe sejam ordenados de uma maneira específica e predeterminada.
- Use **`Comparator`** quando você quer fornecer várias maneiras de ordenar objetos de uma classe ou quando a classe não tem controle sobre como ela é comparada com outras classes. Isso permite flexibilidade ao fornecer diferentes critérios de comparação, sem modificar a própria classe.

Em resumo, use **`Comparable`** para definir uma ordem natural para objetos de uma classe e **`Comparator`** para fornecer critérios de comparação externos à classe.

obs: treeset → por default usa o equals e hashcode, no entando quando implementa alguma interface de comparação, ele passa a ordenar e comparar por esse metodo

o hashset → tem o foco no equals e hashcode, no entanto ele n garante ordem, entao para ordenar teria que ordenar antes de colocar no hashset

linkedhashset → msm q o hash mas guarda a ordem

## **Equals e hashCode**

forma de comparação entre objetos.

equals comparar o conteúdo, já o == compara o endereço de memoria 

 

### Dicas - Eclipse

Ctrl + Shift + F → formatação automática

Alt + S → gerar construtor, getters e setters…

Ctrl + space → abreviação

Ctrl + Shift + O → faz as importações necessárias

Ctrl + 7 → comentar