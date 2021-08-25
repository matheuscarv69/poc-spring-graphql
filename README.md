# 🚀 POC Spring GraphQL 📚

Este projeto trata-se de uma POC usando como tecnologias principais Java, Spring Boot e GraphQL, além delas foram utilizadas tecnologias como Flyway e Redis para fins de acadêmicos.

[![GitHub stars](https://img.shields.io/github/stars/matheuscarv69/poc-spring-graphql?color=7159)](https://github.com/matheuscarv69/orange-talents-05-template-proposta/stargazers)
![Maven Central with version prefix filter](https://img.shields.io/maven-central/v/org.apache.maven/apache-maven/3.6.3?color=7159)

## 🤔 O que é este projeto?

Esse é um projeto que foi inicialmente desenvolvido no curso API GraphQL com Spring Boot da Udemy, porém sofreu algumas alterações na arquitetura utilizada e na adoção de novas tecnologias afim de aumentar o desafio.

Basicamente o projeto possui operações de CRUD nas entidades de domínio, com algumas particularidades que o GraphQL possibilita a implementação.

## ⚡ Disponibilidade 

Essa aplicação já está sendo executada no [Heroku](https://www.heroku.com/), no link abaixo você poderá acessar o playground do GraphQL, nele poderás visualizar os endpoints, tipos de objetos e muito mais.

[Api-Spring-GraphQL](https://poc-spring-graphql.herokuapp.com/playground)

## 🛠 Pré-Requisitos

### 📍 Local

Se você quiser fazer alguma modificação no código precisará ter instalado em sua máquina as seguintes ferramentas:

- [Java JDK 11+](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
- [Maven 3.6.3](https://maven.apache.org/download.cgi)

### 🐳 Docker

Este projeto conta com um **docker-compose**, inclusive a própria imagem da aplicação já está configurada para ser
executada no docker. 

Os requisitos para isso são:

- [Docker](https://www.docker.com/products/docker-desktop) - Baixe de acordo com o seu SO
- [Docker-compose](https://docs.docker.com/compose/install/) - Se estiver utilizando Windows, o Docker desktop já possui o docker-compose instalado

A imagem da aplicação também está disponível no Docker Hub:

- [matheuscarv69/api-spring-graphql](https://hub.docker.com/r/matheuscarv69/api-spring-graphql)

Caso queria executa-lá através dessa imagem, abaixo tem alguns comandos que podem lhe ajudar:

## ⬇ 1. Pull

```shell
docker pull matheuscarv69/api-spring-graphql
```
## 🏃‍♂️ 2. Running

Lembrando que essa aplicação se conecta  à alguns bancos de dados, como Postgres e Redis, então certifique-se de que tens esses dois bancos executando em sua máquina ou em algum serviço online.

O comando abaixo executa a imagem baixada em um container, essa aplicação possui algumas env vars, atenção para as que possuem o sufixo **HOST**, neste você deve colocar o ipv4 da sua máquina, no caso de estar rodando os bancos de dados em um outro container ou mesmo executando localmente na sua máquina.

```shell
docker run -d -p 8080:8080 -e POSTGRES_HOST="192.168.0.115:5432" -e DB_USER="postgres" -e DB_PASSWORD="password" -e DB_SCHEMA="pocgraphql" -e CACHE_HOST="192.168.0.115" -e CACHE_PORT="6379" -e CACHE_EXPIRATION="10000" matheuscarv69/api-spring-graphql
```

## 🎲 Executando a API com o docker-compose
Com esse repositório já clonado em sua máquina e com todos os pré-requisitos atendidos.

1. Você deve ir até a raiz do projeto onde o arquivo **docker-compose.yml** está.
2. Deve abrir um terminal na raiz do projeto.
3. Agora certifique-se que o seu Docker já está em execução.
4. Execute o seguinte comando no terminal:

```bash
docker-compose up -d
```

5. Com isso sua aplicação já está em execução por padrão na porta local 8080

## 📝Fazendo requisições - Insomnia

Esse aplicação têm um workspace com todas as requisições disponíveis configurado no aplicativo **Insomnia**, clicando no botão abaixo você pode
baixar o workspace de requests utilizados nesse projeto.
<br/>
<br/>

[![Run in Insomnia}](https://insomnia.rest/images/run.svg)](https://insomnia.rest/run/?label=api-spring-grapqhl&uri=https%3A%2F%2Fgist.githubusercontent.com%2Fmatheuscarv69%2Fdd13fc73f1e421e4317e1e600a7227ac%2Fraw%2Ff642240c237a35f1170a190f3831abc891eb4fa4%2Fapi-spring-graphql%252520-%252520requests)

## 🚀 Tecnologias 👩‍🚀

As seguintes tecnologias foram utilizadas no desenvolvimento do projeto.

- Java 11
- Spring Boot 2.5.3
    - Web
    - Data JPA
    - Cache
    - Data Redis
    - Validation
    - Profiles (dev e prod)
- GraphQL
- Flyway
- Postgres
- Redis

## 🚀 GraphQL 👩‍🚀

O [GraphQL](https://graphql.org/learn/) é uma linguagem de consulta e ambiente de execução voltada a servidores para as APIs cuja prioridade é fornecer exatamente os dados que os clientes solictam e nada mais em apenas uma única chamada.

O GraphQL foi desenvolvido para tornar as APIs mais rápidas, flexíveis e intuitivas para os desenvolvedores. Atua como uma alternativa à arquitetura REST e ainda disponibiliza ambientes de desenvolvimento integrados como o GraphiQL e o Playground, em ambos é possível executar chamadas, verificar métodos, tipos e muitos mais, atua praticamente como uma documentação da API.

## ⚡ Flyway 👾
O [Flyway](https://flywaydb.org/) é uma ferramenta utilizada para versionamento de banco de dados, ele se propõe a trazer ordem e organização para os scripts SQL que são executados no banco de dados.

Entre as muitas possibilidades essa ferramenta oferece pode-se destacar:

- Sincronizar o banco de dados com a versão da aplicação;
- Saber quais scripts foram executados ou não;
- Automatizar a execução dos scripts;
- Criar banco de dados do zero
- Permite criar um rollback de mudanças

## 🎲 Redis 👾
O [Redis](https://redis.io/) é um armazenamento de estrutura de dados de chave-valor de código aberto e na memória. Ele pode ser usado como banco de dados, cache e agente de mensagens.

O Redis fornece estruturas de dados como strings, hashes, listas, conjuntos, conjuntos classificados com consultas de intervalo, bitmaps, hiperloglogs, índices geoespaciais e fluxos.

## 👨🏻‍💻 Autor

<br>
<a href="https://github.com/matheuscarv69">
 <img style="border-radius: 35%;" src="https://avatars1.githubusercontent.com/u/55814214?s=460&u=ffb1e928527a55f53df6e0d323c2fd7ba92fe0c3&v=4" width="100px;" alt=""/>
 <br />
 <sub><b>Matheus Carvalho</b></sub></a> <a href="https://github.com/matheuscarv69" title="Matheus Carvalho">🚀</a>

Feito por Matheus Carvalho, entre em contato!✌🏻
 <p align="left">
    <a href="mailto:matheus9126@gmail.com" alt="Gmail" target="_blank">
      <img src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white&link=mailto:matheus9126@gmail.com"/></a>
    <a href="https://www.linkedin.com/in/matheus-carvalho69/" alt="Linkedin" target="_blank">
        <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white&link=https://www.linkedin.com/in/matheus-carvalho69/"/></a>  
    <a href="https://www.instagram.com/_mmcarvalho/" alt="Instagram" target="_blank">
      <img src="https://img.shields.io/badge/Instagram-E4405F?style=for-the-badge&logo=instagram&logoColor=white&link=https://www.instagram.com/_mmcarvalho/"/></a>  
  </p>

