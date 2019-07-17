---
title: Programação Funcional na JVM
theme: solarized
revealOptions:
    transition: 'fade'
---
# Programação Funcional

## Uma introdução

_Gregório Melo_ @ ThoughtWorks

---

### Sobre mim

---

### tecnologicamentearretado.com.br

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

---

### Funções como cidadãs de primeira classe

#### Referências a funções

```javascript
const nome = "Gregório Melo";
const quantasVezes = 2;
const hackeragem = (texto, vezes) => texto.toUpperCase()
                                          .repeat(vezes);

hackeragem(nome, 2);
// "GREGÓRIO MELOGREGÓRIO MELO"
```

---

### Funções como cidadãs de primeira classe

#### Funções como argumentos

```javascript
const comoCebolinha = (texto) => texto.replace(/r/g, "l");
const comComemoracao = (texto) => texto.concat("\nVai, Corinthians!");

const transformarTexto = (texto, estrategia) => estrategia(texto);

transformarTexto("Programação funcional", comoCebolinha);
// "Ploglamação funcional"

transformarTexto("Programação funcional", comComemoracao);
// "Programação funcional
// Vai, Corinthians!"
```

---

### Estruturas de dados imutáveis

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

### Estruturas de dados mutáveis (Java)

```java
List<String> escalação = new ArrayList<>();

escalação.add("Cássio");
escalação.add("Fágner");
escalação.add("Manoel");
escalação.add("Henrique");

System.out.println(escalação.size());
// 4
```

---

### Estruturas de dados _imutáveis_ (Java)

```java
List<Filme> filmes = of(
  new Filmes("Auto da Compadecida"),
  new Filmes("Lisbela e o prisioneiro")
);

filmes.add("Titanic");
// lasqueira
```

---

### Estruturas de dados imutáveis (Clojure)

```clojure
(def geodude {:nome "Geodude" :tipo "Rocha"})
(def snorlax {:nome "Snorlax" :tipo "Normal"})

(def pokémons-favoritos (list geodude snorlax))

(def mime {:nome "Mr. Mime" :tipo "Psíquico"})

(cons mime pokémons-favoritos)
;; ({:nome "Mr. Mime", :tipo "Psíquico"}
;;  {:nome "Geodude", :tipo "Rocha"}
;;  {:nome "Snorlax", :tipo "Normal"})

pokémons-favoritos
;; ({:nome "Geodude", :tipo "Rocha"}
;;  {:nome "Snorlax", :tipo "Normal"})
```

---

### Funções puras

---

### Funções puras (JavaScript)

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

### Funções puras (Clojure)

```clojure
(def musica "Quem espera que a vida seja feita de ilusão pode até ficar maluco ou morrer na solidão")

(defn encurtar [resumo]
  (if (> (.length resumo) 20) (-> resumo
                                  (.substring 0 18)
                                  (str "..."))
      resumo))

(encurtar musica)
;; "Quem espera que a ..."

musica
;; "Quem espera que a vida seja feita de ilusão pode até ficar maluco ou morrer na solidão"
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

## Ao vivo

---

## Por que aprender?

---

## Por que aprender?

### Aprimorar código OO <!-- .element: class="fragment" data-fragment-index="0" -->

#### Código mais robusto <!-- .element: class="fragment" data-fragment-index="1" -->
#### Novas ideias para resolver problemas <!-- .element: class="fragment" data-fragment-index="2" -->

---

## Por exemplo, _type alias_

---

## Por que aprender?

```java
public Reserva buscar(String localizador,
                      String codigoAeroporto) { ... }
```

---

## Por que aprender?

```java
public Reserva buscar(String localizador,
                      String codigoAeroporto) { ... }

buscar("CGH", "L0C4LI");
```

---

## Por que aprender?

```java
public Reserva buscar(Localizador localizador,
                      CodigoAeroporto codigoAeroporto) { ... }

buscar(localizador, codigoAeroporto);
```

---

## Por que aprender?

```java
public Reserva buscar(CPF cpf,
                      CodigoAeroporto codigoAeroporto) { ... }

buscar(cpf, codigoAeroporto);
```

---

## Por que aprender?

### Arquitetura robusta e escalável <!-- .element: class="fragment" data-fragment-index="0" -->

#### Segregação das mudanças de estado <!-- .element: class="fragment" data-fragment-index="1" -->
#### Métodos e classes bem isoladas <!-- .element: class="fragment" data-fragment-index="2" -->

---

## Por que aprender?

### Arquitetura robusta e escalável

#### Event sourcing & CQRS
#### DDD & arquitetura hexagonal

---

## Como aprender?

- Meu livro <!-- .element: class="fragment" data-fragment-index="1" -->
- Living Clojure <!-- .element: class="fragment" data-fragment-index="2" -->
- Joy of Clojure <!-- .element: class="fragment" data-fragment-index="3" -->
- Functional Thinking <!-- .element: class="fragment" data-fragment-index="4" -->
- Java 8 Prático <!-- .element: class="fragment" data-fragment-index="5" -->

---

## Outras linguagens (JVM)

- Scala
- Kotlin
- Groovy

---

## Outras linguagens (fora da JVM)

- F#
- Elixir
- Haskell

---

## Outras linguagens (no front)

- ReasonML
- elm
- TypeScript

---

# Valeu!
