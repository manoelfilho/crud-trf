# crud-trf

CRUD com API Spring Boot 2.1, Front-end com Angular 9 e banco de dados MySQL.

Dependências:

Mysql versão 5.6 ou superior

Back-end:
java 8
maven

Front-end: 
node v13.10.1
npm 6.13.7
angular cli


Configurações do Back-end:

Antes de instalar a aplicação, precisamos de um banco de dados e uma tabela pronta para uso do Spring. As configurações estão presentes no arquivo application.properties do Spring Boot no seguinte diretório:

api-desafio/src/main/resources

Precisamos setar as seguintes configurações para uso do MYSQL (Configs da máquina do usuário):

spring.datasource.url: jdbc:mysql://127.0.0.1:3306/desafio_trf
spring.datasource.username: root
spring.datasource.password: root
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

Instalação do Backend:

Na pasta api-desafio
mvn clean install -DskipTests=true
cd target
java -jar desafio-0.0.1-SNAPSHOT.jar

Algumas empresas de testes estão disponíveis no arquivo api-desafio/examples.sql


Instalação do front-end:

Na pasta front-desafio
npm install

Executando o Front: 
ng serve --open



