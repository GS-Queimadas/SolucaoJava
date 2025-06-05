
# 🔥 Solução Java para Monitoramento de Queimadas

Este é um projeto Java com **Spring Boot**, criado para facilitar o **gerenciamento de informações sobre queimadas**. O sistema permite **cadastrar, consultar, atualizar e excluir ocorrências de queimadas**, com o objetivo de auxiliar o trabalho de órgãos ambientais e da defesa civil.

Nos últimos anos, o Brasil tem enfrentado um aumento expressivo nas queimadas, causadas por estiagens e práticas humanas como a limpeza de áreas com fogo. Isso gera graves prejuízos ambientais, sociais e econômicos. Apesar de sistemas nacionais de monitoramento como os do INPE, ainda existem desafios na **integração e descentralização das informações**, especialmente para os órgãos municipais.

Pensando nisso, foi idealizado o **VIAF – Vigilância Ativa do Fogo**, uma plataforma digital voltada ao suporte de decisões em tempo real. O sistema busca integrar dados operacionais, climáticos, geográficos e institucionais, promovendo uma atuação mais estratégica e colaborativa entre **prefeituras, Defesa Civil e Corpo de Bombeiros**.

Este projeto representa o início da construção do VIAF por meio de um **protótipo de banco de dados relacional** e de uma aplicação backend que permitirá registrar e consultar informações fundamentais sobre queimadas, suas causas, condições climáticas envolvidas e ações de resposta.


---

## 🚀 Tecnologias Utilizadas

- ☕ **Java 17**
- 🌱 **Spring Boot 3.x**
- 💾 **Spring Data JPA**
- 🧪 **H2 Database** (para testes)
- 📦 **Maven**

---


## ✅ Pré-requisitos

Antes de rodar o projeto, você precisa ter:

- 🔧 Java 17 ou superior instalado
- 📦 Maven 3.8 ou superior instalado

---

## ▶️ Como Executar

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

🔗 A aplicação estará disponível em: `http://localhost:8080/swagger-ui/index.html`

Acesso administrativo:
usuário: admin
senha: admin

Acesso usuários comuns:
usuário: user
senha: password
---


## 💡 Observações

Este projeto é parte da solução desenvolvida para a disciplina de Engenharia de Software, com foco na **monitorização ativa de queimadas** e **acessibilidade para áreas de infraestrutura limitada**.

---

Desenvolvido com 💻 por [GS-Queimadas](https://github.com/GS-Queimadas)

```
André de Sousa Neves - RM553515

Isabela Barcellos Freire  - RM553746

Thaís Gonçalves Leoncio - RM553892

