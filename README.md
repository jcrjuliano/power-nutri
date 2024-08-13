# PowerNutri

PowerNutri é uma aplicação Java Spring Boot para gerenciamento e acompanhamento nutricional.
Este projeto foi criado com o objetivo de automatizar o acompanhamento de dietas, substituindo a necessidade de gerenciar dietas via planilhas Excel. 
Ele utiliza PostgreSQL como banco de dados e pode ser facilmente configurado usando Docker.

## Funcionalidades

- Cadastro de Pacientes
- Gerenciamento de Programas Nutricionais
  - Separação por Dias Normais e Finais de Semana
- Cadastro de Refeições
  - Associação de Alimentos com Quantidade
- Relacionamento entre Refeições e Alimentos através de uma tabela intermediária

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.x
- PostgreSQL
- Docker
- Maven

## Configuração do Ambiente de Desenvolvimento

### Requisitos
Docker e Docker Compose
Java 17+
Maven

### Configuração do Banco de Dados com Docker
Para configurar e iniciar o banco de dados PostgreSQL, você pode usar o docker-compose.yaml fornecido na raiz do projeto.

Certifique-se de que o Docker esteja instalado e rodando.
Navegue até a raiz do projeto.

Execute o seguinte comando para iniciar o banco de dados:

``
docker-compose up -d
``

O banco de dados estará acessível na porta padrão 5432.
