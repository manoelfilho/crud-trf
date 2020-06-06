# crud-trf

<h2>CRUD com API Spring Boot 2.1, Front-end com Angular 9 e banco de dados MySQL</h2>

<h3>Dependências:</h3>

<strong>Mysql versão 5.6 ou superior</strong> </br></br>

<strong>Back-end:</strong></br>
java 8</br>
maven</br></br>

Front-end: </br>
node v13.10.1</br>
npm 6.13.7</br>
angular cli</br>


<strong>Configurações do Back-end:</strong></br>

Antes de instalar a aplicação, precisamos de um banco de dados e uma tabela pronta para uso do Spring. As configurações estão presentes no arquivo application.properties do Spring Boot no seguinte diretório:

api-desafio/src/main/resources</br>

Precisamos setar as seguintes configurações para uso do MYSQL (Configs da máquina do usuário):</br>

spring.datasource.url: jdbc:mysql://127.0.0.1:3306/desafio_trf</br>
spring.datasource.username: root</br>
spring.datasource.password: root</br>
spring.datasource.driver-class-name=com.mysql.jdbc.Driver</br>

<strong>Instalação do Backend:</strong><br/>

Na pasta api-desafio<br/>
mvn clean install -DskipTests=true<br/>
cd target<br/>
java -jar desafio-0.0.1-SNAPSHOT.jar<br/><br/>

Algumas empresas de testes estão disponíveis no arquivo api-desafio/examples.sql<br/>


<strong>Instalação do front-end:</strong><br/>

Na pasta front-desafio<br/>
npm install<br/><br/>

Executando o Front: <br/>
ng serve --open<br/>



