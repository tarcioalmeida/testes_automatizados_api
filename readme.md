# Documentação de testes funcionais nas API's fornecidas

##Como executar os testes

```bash
mvn test
```

Obs: No cenário 4, a API está retornando 400, não 409, como menciona a documentação, portanto este teste em específico não passa.

##Restrições

###Feature: Verificar se CPF  possui ou não possui restrições

###Contexto: Dada a definição de uma URL REST API


####Cenário 1: Validar GET a partir de um CPF com restrição e retornar status code 200
* Dado que eu defino o parâmetro do header content type como "application/json"
* E defino como parâmetro um CPF que possui restrições
* Quando envio a solicitação GET com o CPF parametrizado
* Então eu recebo o status code 200

####Cenário 2: Validar GET a partir de um CPF sem restrição e retornar status code 204
* Dado que eu defino o parâmetro do header content type como "application/json"
* E defino como parâmetro um CPF que não possui restrições
* Quando envio a solicitação GET com o CPF parametrizado
* Então eu recebo o status code 204


##Simulações

###Feature: Testar métodos CRUD de Simulações

###Contexto: Dada a definição de uma URL REST API


####Cenário 1: Validar GET para retornar todas as simulações e retornar status code 200
* Dado que eu defino o parâmetro do header content type como "application/json"
* Quando envio a solicitação GET
* Então eu recebo o status code 200

####Cenário 2: Validar POST com o preenchimento de todas as informações e retornar status code 201
* Dado que eu defino o parâmetro do header content type como "application/json"
* E defino o body com nome, cpf, email, <valor>, <parcelas> e seguro
* Quando envio a solicitação POST
* Então eu recebo o status code 201

Exemplos de Valores:
| Valor |
| ----|
| 0 (inválido)|
| 1000 (válido) |
| 40001 (inválido)|

Exemplos de Parcelas
| Parcelas |
| ----|
| 1 (inválido)|
| 12 (válido)|
| 49 (inválido)|

####Cenário 3: Validar POST faltando alguma informação a preencher e retornar status code 400
* Dado que eu defino o parâmetro do header content type como "application/json"
* E defino o body com alguma informação incompleta
* Quando envio a solicitação POST
* Então eu recebo o status code 400

####Cenário 4: Validar POST com um CPF já existente e retornar status code 409
* Dado que eu defino o parâmetro do header content type como "application/json"
* E defino o body com todas as informações preenchidas
* E com um CPF já existente nas simulações
* Quando envio a solicitação POST
* Então eu recebo o status code 409

(Obs: A API está retornando 400, não 409, como menciona a documentação, portanto o teste não passa)

####Cenário 5: Validar GET a partir de um dado CPF associado à uma simulação e retornar status code 200
* Dado que eu defino o parâmetro do header content type como "application/json"
* E defino como parâmetro um CPF associado à uma simulação existente
* Quando envio a solicitação GET com o CPF parametrizado
* Então eu recebo o status code 200


####Cenário 6: Validar GET a partir de um dado CPF não associado a alguma simulação existente e retornar status code 404
* Dado que eu defino o parâmetro do header content type como "application/json"
* E defino como parâmetro um CPF associado à uma simulação não existente
* Quando envio a solicitação GET com o CPF parametrizado
* Então eu recebo o status code 404

####Cenário 7: Validar PUT a partir de um CPF associado à uma simulação e retornar o status code 200
* Dado que eu defino o parâmetro do header content type como "application/json"
* E defino como parâmetro um CPF que é associado à uma simulação existente
* E defino um body com as informações a serem alteradas
* Quando envio a solicitação PUT com o CPF parametrizado
* Então eu recebo o status code 200

####Cenário 8: Validar PUT a partir de um CPF não associado à uma simulação existente e retornar status code 404
* Dado que eu defino o parâmetro do header content type como "application/json"
* E defino como parâmetro um CPF que é não é associado à uma simulação existente
* E defino um body com as informações a serem alteradas
* Quando envio a solicitação PUT com o CPF parametrizado
* Então eu recebo o status code 404

####Cenário 9: Validar DELETE a partir de um ID existente e retornar status code 200
* Dado que eu defino o parâmetro do header content type como "application/json"
* E defino como parâmetro um ID que é associado à uma simulação existente
* Quando envio a solicitação DELETE com o ID parametrizado
* Então eu recebo o status code 200

####Cenário 10: Validar DELETE a partir de um ID nexistente (não estava definido na documentação técnica)