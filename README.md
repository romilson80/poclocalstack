# POC LocalStack

## Descrição

Este projeto é uma aplicação Java desenvolvida com Spring Boot. A aplicação utiliza Docker para criar ambientes isolados e LocalStack para simular serviços AWS localmente.

## Requisitos

Antes de começar, certifique-se de que você tenha as seguintes ferramentas instaladas:

- [Java 17 ou superior](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) (ou [OpenJDK](https://openjdk.java.net/))
- [Maven 3.3.2 ou superior](https://maven.apache.org/download.cgi) 
- [Docker](https://www.docker.com/products/docker-desktop)
- [Docker Compose](https://docs.docker.com/compose/)

## Configuração do Ambiente

### Passo 1: Clonar o Repositório

Clone o repositório do projeto para sua máquina local:

```bash
git clone https://github.com/romilson80/poclocalstack.git
```
Para executar a infra estrutura da aplicação navegue ate 

###Sequence Diagram

```seq
Andrew->China: Says Hello 
Note right of China: China thinks\nabout it 
China-->Andrew: How are you? 
Andrew->>China: I am good thanks!
```