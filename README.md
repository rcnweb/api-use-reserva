
# API Use Reserva

_Pré-requisitos:_

* docker version 1.10.3
* JDK8
* Maven

## Instalação

1. Com o docker instalado em sua máquina para gerar a imagem da aplicação com o seguinte comando na raiz do projeto:

   `mvn clean package docker:build -Dmaven.test.skip=true`
   
2. Com a imagem criada você poderá rodar o container da aplicação com o seguinte comando:

   `docker run -p 8080:8080 api-reserva-web`

3. Uma vez o container rodando você vai poder acessar e testar pelas urls:

- `Entrypoint Rest >> http://localhost:8080/api-use-reserva/persons` 
- `Entrypoint API Graphiql >> http://localhost:8080/graphiql` 
- `Entrypoint Swagger >> http://localhost:8080/swagger-ui.html#` 
 

## Testando API via Graphql ou Postman:

## GraphQL 

### CREATE

> Criando uma pessoa, observe que o GraphQL atende a quantidade de campos que deseja como retorno ou inclusão.
```
mutation {
    createPerson(input: {
                   name: "Rafael", 
                   lastName: "Neto", 
                   birthDate: "1982-07-10T16:50:22-04:00",
                   contacts: [ 
                                 { type: "WORK", number: "(99) 9999-9999" }, 
                                 { type: "HOUSE", number: "(99) 99999-9999" }
                             ]}) 
  {
    id
    name
    lastName
    birthDate
    contacts {
      type
      number
    }
  }
}
```

### UPDATE

> Atualizando uma pessoa, observe que o GraphQL atende a quantidade de campos que deseja como retorno ou inclusão.
```
mutation {
  updatePerson(input: {
                 id: 1, 
                 name: "Leticia",  
                 lastName: "Marques", 
                 birthDate: "2000-01-11T11:00:30-01:00", 
                 contacts: [ 
                               { type: "OFFICE", number: "(99) 9999-9999" }
                           ]}) 
  {
    id
    name
    lastName
    birthDate
    contacts {
      type
      number
    }
  }
}
```

### DELETE

> Deletando uma pessoa,  retornará um boolean e status 200.
```
mutation {
	deletePerson(id: 1)
}
```

### GET / Filtro pessoas

> Esse entrypoint não só faz a consulta por uma pessoa, mas filtra  por outros campos.  O ideal é que tenha um único entrypoint para qualquer tipo de consulta.
```
{
  persons(input: {name: "Leticia"}) 
  {
    id
    name
    lastName
    birthDate
    contacts {
      type
      number
    }
  }
}

Outro exemplo por idPessoa:

{
  persons(input: {id: 2}) 
  {
    id
    name
    lastName
    birthDate
  }
}

```
## Features

- `Springboot` 
- `Swagger` 
- `GraphQL` 
- `H2` 

## Débitos Técnicos

- `MongoDB - Pelo pouco tempo não consegui montar uma imagem do docker com o mongodb, mas com o spring boot é bem simples alterar a camada de persistência, ou no model é só colocar @Document.` 
- `Serviço de cloud` 
- `Testes unitários com JUnit, Integração e aceitação` 
- `CI com Jenkins como exemplo` 
- `Gerenciamento do exception poderiamos colocar o logstash , o ganho seria um dashboard.` 




