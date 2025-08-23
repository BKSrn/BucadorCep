# Busca de Cep
Aplicação de console em Java para consulta de endereços pelo CEP usando a API pública ViaCEP. O programa valida o tamanho do CEP informado, realiza a requisição HTTP, exibe os dados no terminal e salva o resultado em um arquivo JSON formatado.

## Tecnologias
- Java 21

- HTTP Client (java.net.http)

- Gson

- Console I/O

## Aprendizados
- Consumo de API REST com HttpClient nativo do Java.

- Serialização e pretty-print de objetos em JSON com Gson.

- Uso de records para imutabilidade e clareza do modelo.

- Validação de entrada e criação de exceções personalizadas.

- Escrita de arquivos no formato JSON.

## Primeiros passos
- Pré-requisitos
Linguagem: [Java 21+](https://www.oracle.com/europe/java/technologies/downloads/)
Acesso à internet para consultar a API ViaCEP

## Instalação
Clone o repositório

```bash
git clone https://github.com/BKSrn/Buscador-Cep
```
- Navegue até a raiz do projeto

```bash
cd \buscadorCep
```
- Adicione a dependência do Gson (se usar execução direta)

Baixe o gson.jar do site do projeto ou use um gerenciador (Maven/Gradle).

### Exemplo com Maven (pom.xml):

```xml
<dependencies>
  <dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.11.0</version>
  </dependency>
</dependencies>
```

### Exemplo com Gradle:

```text
dependencies {
  implementation 'com.google.code.gson:gson:2.11.0'
}
```
## Uso
- Execute o programa principal (Main)

```bash
# Maven
mvn -q exec:java -Dexec.mainClass=Main

# Gradle (Application plugin)
gradle run

# via javac/java (com JAR do Gson)
- javac -cp gson-2.11.0.jar *.java
- java -cp .:gson-2.11.0.jar Main
```

- Quando solicitado, informe um CEP com exatamente 8 dígitos (somente números), por exemplo:

```text
Informe o cep
01001000
```

- Saída esperada no console:

```text
Endereco{cep='01001000', logradouro='Praça da Sé', bairro='Sé', localidade='São Paulo'}
```

- Um arquivo JSON será gerado na raiz do projeto:

```text
Endereços.json
```

## Testando

- CEP com 8 dígitos válidos: deve exibir o endereço e salvar o JSON.
- CEP com menos de 8 dígitos: exibe mensagem “O CEP deve conter 8 dígitos”.
- CEP com mais de 8 dígitos: exibe “O CEP não pode conter mais de 8 digitos”.
- CEP inexistente: a API ViaCEP retorna objeto com campos vazios ou “erro”; o programa lança RuntimeException genérica se falhar na requisição.

## Estrutura do projeto
- Main.java: fluxo principal; leitura do CEP, chamada da API, exibição e salvamento do JSON.
- ConsultaCep.java: realiza a requisição HTTP para ViaCEP e converte a resposta em EnderecoDto com Gson.
- EnderecoDto.java: record imutável que representa os campos principais do endereço (cep, logradouro, bairro, localidade).
- Arquivador.java: serializa o EnderecoDto e grava o arquivo Endereços.json com pretty printing.
- CepTamanhoException.java: exceção customizada para validar o tamanho do CEP.

## Exceções e validações
- Validação de comprimento do CEP antes da requisição:
- Menor que 8 → CepTamanhoException com mensagem apropriada.
- Maior que 8 → CepTamanhoException com mensagem apropriada.
- Falhas de rede, interrupções ou problemas ao parsear JSON resultam em RuntimeException com mensagem genérica.

## Melhorias futuras
Logs estruturados e camadas de serviço.
Testes automatizados (JUnit) e mocks de HTTP.
Opção de informar caminho/nome do arquivo de saída.
Empacotar com Maven/Gradle para distribuição (fat-jar).

