
# 🔥 VIAF – Vigilância Ativa do Fogo

Este projeto, desenvolvido em **Java 17 com Spring Boot**, representa o backend do **VIAF – Vigilância Ativa do Fogo**. A solução visa centralizar e gerenciar informações sobre queimadas, fornecendo uma API RESTful para cadastrar, consultar e gerenciar ocorrências, regiões, agentes e causas.

## Contexto do Problema

As queimadas representam um grave problema ambiental e social no Brasil. A descentralização de dados e a falta de ferramentas integradas dificultam uma resposta rápida e coordenada por parte de órgãos municipais, como a Defesa Civil e o Corpo de Bombeiros. O VIAF foi idealizado para ser uma plataforma que integra dados operacionais e geográficos, promovendo uma atuação mais estratégica e colaborativa no combate às queimadas.

---

## 🏛️ Arquitetura da Solução

A aplicação foi estruturada seguindo uma arquitetura em camadas para garantir a separação de responsabilidades, alta coesão e baixo acoplamento, facilitando a manutenção e a escalabilidade.

-   **`Controller` (Camada de Apresentação):** Responsável por expor os endpoints da API REST, validar as requisições HTTP e serializar as respostas. Delega toda a lógica de negócio para a camada de Serviço.
-   **`Service` (Camada de Negócio):** Orquestra a lógica de negócio da aplicação. Realiza validações, processa os dados e coordena as interações entre os repositórios.
-   **`Repository` (Camada de Acesso a Dados):** Interfaces que estendem `JpaRepository` e abstraem a comunicação com o banco de dados, provendo métodos para operações CRUD.
-   **`DTO` (Data Transfer Object):** Objetos que transferem dados entre as camadas, especialmente entre `Controller` e `Service`. Evitam a exposição direta das entidades de domínio na API.
-   **`Model` (Camada de Domínio):** Contém as entidades JPA (`@Entity`) que representam os conceitos de negócio, como `Ocorrencia`, `Regiao`, etc.
-   **`Config` (Camada de Configuração):** Centraliza as configurações da aplicação, como a de segurança com Spring Security.

---

## 🚀 Tecnologias Utilizadas

-   ☕ **Java 17**
-   🌱 **Spring Boot 3.5.0**
-   💾 **Spring Data JPA**
-   🛡️ **Spring Security** (Autenticação e Autorização)
-   🧪 **H2 Database** (Banco de dados em memória)
-   📦 **Maven** (Gerenciador de dependências)
-   📖 **Swagger (Springdoc)** (Documentação da API)
---


## ✅ Pré-requisitos

Antes de rodar o projeto, você precisa ter:

- 🔧 Java 17 ou superior instalado
- 📦 Maven 3.8 ou superior instalado

---

## ▶️ Como Executar

> ⚠️ **Observação:** indicamos que execute esse código pela IDE InteliJ, pasra melhor visualização do projeto

1. **Clone o repositório:**

```bash
git clone https://github.com/GS-Queimadas/SolucaoJava.git
````

2. **Acesse a pasta do projeto:**

```bash
cd SolucaoJava
```

3. **Execute a aplicação com Maven:**

```bash
mvn spring-boot:run
```

🔗 A aplicação estará disponível em: `http://localhost:8080`

---
### 🔐 Credenciais de Acesso

- ### Usuário Admin (pode ler e escrever):
    -   `usuário: admin`
    -   `senha: admin`


- ### Usuário Comum (pode apenas ler):
    -   `usuário: user`
    -   `senha: password`

### 📖 Documentação Interativa (Swagger)
Para explorar todos os endpoints de forma interativa, acesse:
🔗 **http://localhost:8080/swagger-ui/index.html**

## 💡 Observações

Este projeto é parte da solução desenvolvida para a disciplina de Engenharia de Software, com foco na **monitorização ativa de queimadas** e **acessibilidade para áreas de infraestrutura limitada**.

---

Desenvolvido com 💻 por [GS-Queimadas](https://github.com/GS-Queimadas)

---

## 👨‍💻 Desenvolvedores

André de Sousa Neves - RM553515

Isabela Barcellos Freire  - RM553746

Thaís Gonçalves Leoncio - RM553892

---
