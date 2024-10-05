# O que faz essa aplicação?
Essa aplicação serve para gerenciar um sistema de uma empresa.
Fará a adição de um funcionário, modificará suas informações, poderá pegar suas informações e também deletá-lo. 
Ou seja, essa aplicação fará um simples CRUD, porém haverá a implementação do Spring Security para fazer um controle de quem terá ou não autorização para realizar tais requisições.

# Quais as tecnologias utilizadas?
### Spring Boot v3.3.4:
* Spring Data JPA --> Para criar as interações com o banco de dados.
* Spring Security --> Responsável pela autenticações e autorizações para saber se o usuário está apto a fazer determinada requisição.
* Lombok --> Irá reduzir a quantidade de boilerplate, tendo uma melhor legibilidade do código.
* PostgreSQL --> Banco de dados utilizado na aplicação
* Swagger --> Será o framework utilizado para fazer a documentação da API.
