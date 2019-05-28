---
title: Programação Funcional na JVM
theme: solarized
revealOptions:
    transition: 'fade'
---
# Programação Funcional na JVM

## Uma introdução com Clojure

_Gregório Melo_ @ ThoughtWorks

---

### Sobre mim

<img alt="Log do podcast Tecnologicamente Arretado" src="./img/podcast.png" />

---

### Por que falar de Clojure?

<img alt="Capa do livro Programação Funcional: Uma introdução em Clojure" src="./img/livro.jpg" width="40%" />

---

### O que é Programação Funcional?

- Funções <!-- .element: class="fragment" data-fragment-index="1" -->
- Estado <!-- .element: class="fragment" data-fragment-index="2" -->

---

### Programação Funcional

- Funções como cidadãs de primeira classe <!-- .element: class="fragment" data-fragment-index="1" -->
- Estruturas de dados imutáveis <!-- .element: class="fragment" data-fragment-index="2" -->
- Funções puras <!-- .element: class="fragment" data-fragment-index="3" -->

---

### Funções como cidadãs de primeira classe

```javascript
const nome = "Gregório Melo";
const quantasVezes = 2;
const hackeragem = (texto, vezes) => texto.toUpperCase()
                                          .repeat(vezes);

hackeragem(nome, 2);
// "GREGÓRIO MELOGREGÓRIO MELO"
```

---

### Estruturas de dados imutáveis (JavaScript)

```javascript
const escalação = ["Cássio", "Fágner", "Manoel", "Henrique"];

escalação.concat("Danilo Avelar");
// [ "Cássio", "Fágner", "Manoel",
//   "Henrique", "Danilo Avelar" ]

escalação
// [ "Cássio", "Fágner", "Manoel", "Henrique" ]
```

---

### Estruturas de dados imutáveis (Java)

```java
List<String> escalação = new ArrayList<>();

escalação.add("Cássio");
escalação.add("Fágner");
escalação.add("Manoel");
escalação.add("Henrique");

System.out.println(escalação.size());
```

---

### Funções puras

```javascript
const música = "Quem espera que a vida seja feita de" +
 " ilusão pode até ficar maluco ou morrer na solidão";

const resumir = (texto) => {
  if (texto.length > 20) {
    return texto.substring(0, 20) + "...";
  } else {
    return texto + "..."
  }
}

resumir(música); // "Quem espera que a vi..."

música; // "Quem espera que a vida seja feita de ilusão pode até ficar maluco ou morrer na solidão"
```

---

## Estudo de caso

### Encurtar uma lista de resumos de filmes

---

### Pré-Java 8

```
List<String> resumos = new ArrayList<>();

for (Filme filme : filmes) {
    resumos.add(encurtar(filme.getResumo()));
}

return resumos;
```

---

### Pós-Java 8

```
return filmes
    .stream()
    .map(Filme::getResumo)
    .map(Representacao::encurtar)
    .collect(Collectors.toList());
```

---

### Clojure

```
(map #(encurtar (:resumo %)) filmes)
```

---

## O que é Clojure?

- Lisp <!-- .element: class="fragment" data-fragment-index="1" -->
- JVM <!-- .element: class="fragment" data-fragment-index="2" -->

---

## Exemplos de Clojure

---

## Por que aprender?

- Lisp <!-- .element: class="fragment" data-fragment-index="1" -->

---

## Como aprender?

- Meu livro <!-- .element: class="fragment" data-fragment-index="1" -->
- Living Clojure <!-- .element: class="fragment" data-fragment-index="2" -->
- Joy of Clojure <!-- .element: class="fragment" data-fragment-index="3" -->
- Functional Thinking <!-- .element: class="fragment" data-fragment-index="4" -->

---

## Outras linguagens (JVM)

- Scala
- Kotlin
- Groovy

---

## Outras linguagens (fora da JVM)

- ECMAScript
- ReasonML (ou elm)
- TypeScript
