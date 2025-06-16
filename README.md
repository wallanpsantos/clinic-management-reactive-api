# Sistema de Clínica - API Reativa

> Uma API REST reativa para gerenciamento de clínica construída com Spring WebFlux, R2DBC e Redis

## 📋 Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Tecnologias](#-tecnologias)
- [Funcionalidades](#-funcionalidades)
- [Pré-requisitos](#-pré-requisitos)
- [Instalação e Execução](#-instalação-e-execução)
- [Documentação da API](#-documentação-da-api)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Contribuição](#-contribuição)

## 🎯 Sobre o Projeto

Este projeto demonstra a construção de uma API REST reativa para um sistema de gerenciamento de clínica médica. Utiliza programação reativa com Project Reactor, acesso não-bloqueante ao banco de dados PostgreSQL através do R2DBC, cache distribuído com Redis para alta performance, e implementa inteligência artificial com Spring AI para funcionalidades avançadas.

## 🚀 Tecnologias

### Core Framework
- **Java 17** - Linguagem de programação
- **Spring Boot 3.5.0** - Framework principal
- **Spring WebFlux** - Framework reativo para APIs REST
- **Project Reactor** - Programação reativa (Mono/Flux)

### Banco de Dados e Persistência
- **PostgreSQL** - Banco de dados relacional principal
- **Spring Data R2DBC** - Acesso reativo ao banco de dados
- **Spring Data JPA** - ORM tradicional para operações específicas
- **Flyway** - Migrations e versionamento do schema
- **H2 Database** - Banco em memória para testes

### Cache e Performance
- **Redis Stack** - Cache distribuído com suporte a estruturas avançadas
- **Spring Data Redis Reactive** - Integração reativa com Redis

### Inteligência Artificial
- **Spring AI 1.0.0** - Framework de IA integrado
- **Spring AI Vector Store Redis** - Armazenamento de vetores para IA

### Resiliência e Monitoramento
- **Spring Cloud 2025.0.0** - Microserviços e cloud
- **Resilience4j** - Circuit breaker e patterns de resiliência
- **Spring Boot Actuator** - Métricas e health checks

### Mensageria
- **Apache Kafka** - Sistema de mensageria distribuída
- **Spring Kafka** - Integração com Kafka

### Validação e Configuração
- **Bean Validation (Jakarta)** - Validação de dados
- **Spring Boot Configuration Processor** - Processamento de configurações
- **Lombok** - Redução de boilerplate

### Containerização e Deploy
- **Docker** - Containerização da aplicação
- **Docker Compose** - Orquestração de containers
- **Spring Boot Docker Compose** - Integração automática

### Testes
- **JUnit 5** - Framework de testes
- **Testcontainers** - Testes de integração com containers
- **Spring Boot Test** - Testes de aplicação Spring
- **Reactor Test** - Testes para código reativo
- **Spring REST Docs** - Documentação automática da API

### Build e Documentação
- **Maven** - Gerenciamento de dependências e build
- **AsciiDoctor** - Geração de documentação

## ✨ Funcionalidades

- 🔄 **Programação Reativa**: Construído com `Mono` e `Flux` para alta performance
- 📊 **CRUD Completo**: Operações completas para Pacientes, Médicos e Consultas
- 📄 **Paginação e Filtros**: Listagens paginadas com filtros dinâmicos
- ⚡ **Cache Distribuído**: Redis Stack para cache performático e escalável
- 🤖 **Inteligência Artificial**: Integração com Spring AI para funcionalidades avançadas
- 📨 **Mensageria**: Comunicação assíncrona com Apache Kafka
- 🛡️ **Resiliência**: Circuit breakers e patterns de tolerância a falhas
- 🗄️ **Migrations**: Gerenciamento automático do schema com Flyway
- ✅ **Validação**: Validação robusta com Jakarta Validation
- 🛡️ **Tratamento de Erros**: Handler global centralizado
- 📊 **Monitoramento**: Métricas e health checks com Actuator
- 🐳 **Containerização**: Suporte completo a Docker e Docker Compose
- 📖 **Documentação**: Documentação automática da API com Spring REST Docs

## 📋 Pré-requisitos

- **Docker** e **Docker Compose**
- **JDK 17** ou superior
- **Maven 3.6+**

## 🛠 Instalação e Execução

### Opção 1: Execução com Docker (Recomendado)

```bash
# 1. Construir o pacote da aplicação
mvn clean package

# 2. Subir todos os serviços
docker-compose up --build -d

# 3. Verificar se os serviços estão rodando
docker-compose ps
```

**Aplicação disponível em:** http://localhost:8080

**Redis Insight disponível em:** http://localhost:8001 (para monitoramento do Redis)

### Opção 2: Execução Local (Desenvolvimento)

```bash
# 1. Iniciar PostgreSQL e Redis
docker-compose up postgres redis -d

# 2. Executar a aplicação
mvn spring-boot:run
```

### Parar os Serviços

```bash
docker-compose down
```

### Parar e Limpar Volumes

```bash
docker-compose down -v
```

## 📚 Documentação da API

**Base URL:** `http://localhost:8080/api`

> **Nota:** Todos os dados nos exemplos são fictícios e destinados apenas para demonstração.

### 👥 Pacientes

#### Listar Pacientes
```http
GET /api/pacientes
```

**Parâmetros:**
- `page` (opcional, padrão: 0) - Número da página
- `size` (opcional, padrão: 10) - Itens por página  
- `nome` (opcional) - Filtro por nome (case-insensitive)

**Exemplos:**
```bash
# Listar com paginação
curl "http://localhost:8080/api/pacientes?page=0&size=5"

# Filtrar por nome
curl "http://localhost:8080/api/pacientes?nome=Silva"
```

#### Criar Paciente
```http
POST /api/pacientes
```

**Payload:**
```json
{
  "nome": "Carlos Andrade",
  "email": "carlos.andrade@example.com",
  "telefone": "11987654321",
  "dataNascimento": "1985-08-20",
  "cpf": "111.222.333-44",
  "endereco": "Avenida Principal, 456, Rio de Janeiro, RJ"
}
```

**Exemplo:**
```bash
curl -X POST -H "Content-Type: application/json" \
-d '{"nome": "Carlos Andrade", "email": "carlos.andrade@example.com", "telefone": "11987654321", "dataNascimento": "1985-08-20", "cpf": "111.222.333-44", "endereco": "Avenida Principal, 456, Rio de Janeiro, RJ"}' \
"http://localhost:8080/api/pacientes"
```

#### Buscar Paciente por ID
```http
GET /api/pacientes/{id}
```

**Exemplo:**
```bash
curl "http://localhost:8080/api/pacientes/1"
```

#### Atualizar Paciente
```http
PUT /api/pacientes/{id}
```

**Exemplo:**
```bash
curl -X PUT -H "Content-Type: application/json" \
-d '{"nome": "Carlos de Andrade", "telefone": "21999998888"}' \
"http://localhost:8080/api/pacientes/1"
```

#### Deletar Paciente
```http
DELETE /api/pacientes/{id}
```

**Exemplo:**
```bash
curl -X DELETE "http://localhost:8080/api/pacientes/1"
```

### 👨‍⚕️ Médicos

#### Listar Médicos
```http
GET /api/medicos
```

**Parâmetros:**
- `page`, `size` - Paginação
- `especialidade` (opcional) - Filtro por especialidade

**Exemplos:**
```bash
# Listar todos
curl "http://localhost:8080/api/medicos"

# Filtrar por especialidade
curl "http://localhost:8080/api/medicos?especialidade=Cardiologia"
```

#### Criar Médico
```http
POST /api/medicos
```

**Payload:**
```json
{
  "nome": "Dra. Helena Costa",
  "email": "helena.costa@example.com",
  "telefone": "81912345678",
  "crm": "54321-PE",
  "especialidade": "Dermatologia"
}
```

**Exemplo:**
```bash
curl -X POST -H "Content-Type: application/json" \
-d '{"nome": "Dra. Helena Costa", "email": "helena.costa@example.com", "telefone": "81912345678", "crm": "54321-PE", "especialidade": "Dermatologia"}' \
"http://localhost:8080/api/medicos"
```

#### Buscar Médico por ID
```http
GET /api/medicos/{id}
```

**Exemplo:**
```bash
curl "http://localhost:8080/api/medicos/1"
```

### 📅 Consultas

#### Listar Consultas
```http
GET /api/consultas
```

**Parâmetros:**
- `page`, `size` - Paginação
- `pacienteId` (opcional) - Filtro por paciente
- `medicoId` (opcional) - Filtro por médico
- `status` (opcional) - Filtro por status: `AGENDADA`, `CONFIRMADA`, `REALIZADA`, `CANCELADA`
- `inicio`, `fim` (opcional) - Filtro por período (formato: `YYYY-MM-DDTHH:MM:SS`)

**Exemplos:**
```bash
# Consultas de um paciente
curl "http://localhost:8080/api/consultas?pacienteId=1"

# Consultas em período
curl "http://localhost:8080/api/consultas?inicio=2025-01-01T00:00:00&fim=2025-01-31T23:59:59"
```

#### Agendar Consulta
```http
POST /api/consultas
```

**Payload:**
```json
{
  "pacienteId": 1,
  "medicoId": 1,
  "dataConsulta": "2025-10-20T14:30:00",
  "observacoes": "Check-up anual.",
  "valor": 300.00
}
```

**Exemplo:**
```bash
curl -X POST -H "Content-Type: application/json" \
-d '{"pacienteId": 1, "medicoId": 1, "dataConsulta": "2025-10-20T14:30:00", "observacoes": "Check-up anual.", "valor": 300.00}' \
"http://localhost:8080/api/consultas"
```

#### Buscar Consulta por ID
```http
GET /api/consultas/{id}
```

**Exemplo:**
```bash
curl "http://localhost:8080/api/consultas/1"
```

#### Alterar Status da Consulta
```http
PATCH /api/consultas/{id}/status
```

**Payload:**
```json
{
  "status": "CONFIRMADA"
}
```

**Exemplo:**
```bash
curl -X PATCH -H "Content-Type: application/json" \
-d '{"status":"CONFIRMADA"}' \
"http://localhost:8080/api/consultas/1/status"
```

## 📊 Monitoramento e Saúde

### Health Check
```http
GET /actuator/health
```

### Métricas
```http
GET /actuator/metrics
```

### Informações da Aplicação
```http
GET /actuator/info
```

## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/br/clinica/
│   │   ├── config/          # Configurações (Redis, Database, etc.)
│   │   ├── controller/      # Controllers REST reativos
│   │   ├── dto/            # DTOs e Request/Response objects
│   │   ├── entity/         # Entidades do banco de dados
│   │   ├── exception/      # Tratamento global de exceções
│   │   ├── repository/     # Repositórios R2DBC
│   │   ├── service/        # Lógica de negócio reativa
│   │   └── ai/            # Integração com Spring AI
│   └── resources/
│       ├── db/migration/   # Scripts Flyway
│       └── application.yml # Configurações da aplicação
└── test/                   # Testes automatizados
    ├── integration/        # Testes de integração
    └── unit/              # Testes unitários
```

## 🤝 Contribuição

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

---

**🐾💻 Desenvolvido usando Spring WebFlux, tecnologias reativas e inteligência artificial** 
