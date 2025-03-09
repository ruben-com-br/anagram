# Anagram Generator

Este projeto é uma aplicação web simples que gera todos os anagramas possíveis de uma string fornecida pelo usuário. Ele foi desenvolvido utilizando Java 21, Maven e Thymeleaf para o frontend.

## Tecnologias Utilizadas

- *Java 21:* A versão mais recente do Java foi usada para desenvolver o backend da aplicação.
- *Maven:* Gerenciador de dependências para compilar, testar e executar o projeto.
- *Thymeleaf:* Motor de template utilizado para gerar a interface web.

## Funcionalidade

A aplicação recebe uma string como parâmetro de consulta na URL e gera todos os anagramas possíveis dessa string. A entrada é validada para garantir que contenha apenas letras e não esteja vazia.

### Exemplos de uso:
- Para gerar anagramas da string "abc", acesse:
  http://localhost:8080/anagram?text=abc

- Caso a string contenha caracteres não permitidos (como números ou símbolos), a aplicação retornará uma mensagem de erro.

## Como Rodar o Projeto

1. *Clone o repositório:*

git clone https://github.com/ruben-com-br/anagram.git


2. *Acesse o diretório do projeto:*

cd anagram-generator


3. *Compile e execute a aplicação utilizando Maven:*

Para compilar e rodar o projeto, use o seguinte comando:

mvn spring-boot:run


4. *Acesse a aplicação:*

Abra o navegador e acesse o seguinte link para gerar os anagramas:

http://localhost:8080/anagram?text=<seu-texto-aqui>

Exemplo:
http://localhost:8080/anagram?text=abc


Se você inserir um texto inválido, como um número ou string vazia, a aplicação exibirá uma mensagem de erro explicando a razão da falha.

## Como Funciona

### Geração de Anagramas:

- A aplicação utiliza um algoritmo recursivo para gerar todos os anagramas possíveis da string fornecida.
- Para strings de comprimento 1, o único anagrama possível é a própria string.
- Para strings de comprimento 2, são gerados ambos os anagramas possíveis (inversão dos caracteres).
- Para strings de comprimento maior, a função recursiva divide a string em substrings menores e gera anagramas dessas substrings, concatenando o caractere fixo com os resultados.

### Exemplo de Resposta:

Para o parâmetro de entrada "abc", a aplicação retornará os seguintes anagramas:

abc, acb, bac, bca, cab, cba


## Como Testar

A aplicação pode ser testada com vários casos de entrada, incluindo:

- *Entrada válida com letras:* abc, abcd, a, etc.
- *Entrada inválida com caracteres não permitidos:* ab1, 123, etc.
- *Entrada vazia:* (erro de validação).

## Dependências

- Spring Boot
- Thymeleaf

## Licença

Este projeto é de uso livre. Sinta-se à vontade para contribuir ou usar este código de acordo com a licença do seu projeto.
