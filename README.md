<p align="center"><strong>UNIVERSIDADE TECNOLÓGICA FEDERAL DO PARANÁ</strong></p>
<p align="center">Câmpus Guarapuava</p>
<p align="center">Tecnologia em Sistemas para Internet</p>

<strong>Carlos Henrique K. Pereira</strong>

Desenvolvimento para WEB 4

Prof. Dr. Roni Fabio Banaszewski

***

### **Primeira Avaliação**
Desenvolver um sistema utilizando as tecnologias Servlets e JSP com o padrão MVC. [Segunda Avaliação - Spring](https://github.com/carloskotacho/mathematics-spring)

### Tópicos:

* **Encaminhamento e redirecionamento**
    * Usar encaminhamento fora do modelo MVC (ex. um servlet encaminhando a requisição para outro)
    * Usar redirecionamento depois de requisições POST de um formulário para evitar o reenvio destes dados ao atualizar a página com F5. 
* **Escopo de requisição, sessão e aplicação**
* **Cookies**
    * Cookie que dura apenas uma sessão
    * Cookie com tempo de vida além de uma sessão
* **Filtros**
    * Filtro normal de intercepção de requisição ou resposta
    * Filtro com modificação da parâmetros via Wrapper
    * Filtro para tratamento de ataques XSS
* **Controle de erros e exceção via web.xml**
    * Tratamento por código de status ou ~~exceção específica~~
    * Tratamento genérico
* **Autenticação e autorização com JAAS**
    * Usar JDBC Realm com formulário e senha com hash SHA-256
    * Precisa ter formulário de cadastro de usuários
* **Expression Language para acessar os objetos de domínio (beans) da camada de modelo do MVC**
* **JSTL**
    * forEach
    * if
* **Template**

### Inicial #1:
Verifique se as credenciais do banco de dados estão corretas. `MysqlDataBase.java`

|  URL   |  DATABASE |  DRIVER_CLASS   |  USER  |  PASSWORD |
| :----: | :-------: | :--------------:| :-----:| :--------:|
| jdbc:mysql://127.0.0.1/ | `matematica` | com.mysql.jdbc.Driver | `root` | `12345` |

Crie um admin.

login: `admin`
<br/>
pwd: `admin`

```sql
DROP DATABASE IF EXISTS matematica;
CREATE DATABASE matematica;
USE matematica;

CREATE TABLE usuarios (
    login varchar(64) NOT NULL PRIMARY KEY,
    pwd varchar(64) NOT NULL
);

INSERT INTO usuarios VALUES ('admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918');

CREATE TABLE roles (
    login varchar(20) NOT NULL,
    role varchar(20) NOT NULL,  
    primary key(login, role)
);

INSERT INTO roles VALUES ('admin', 'ADMINISTRADOR');

COMMIT;
```
## Contribuindo

[![0](https://sourcerer.io/fame/carloskotacho/carloskotacho/matematica-servlet-jsp/images/0)](https://sourcerer.io/fame/carloskotacho/carloskotacho/matematica-servlet-jsp/links/0)
[![1](https://sourcerer.io/fame/carloskotacho/carloskotacho/matematica-servlet-jsp/images/1)](https://sourcerer.io/fame/carloskotacho/carloskotacho/matematica-servlet-jsp/links/1)
[![2](https://sourcerer.io/fame/carloskotacho/carloskotacho/matematica-servlet-jsp/images/2)](https://sourcerer.io/fame/carloskotacho/carloskotacho/matematica-servlet-jsp/links/2)
[![3](https://sourcerer.io/fame/carloskotacho/carloskotacho/matematica-servlet-jsp/images/3)](https://sourcerer.io/fame/carloskotacho/carloskotacho/matematica-servlet-jsp/links/3)
[![4](https://sourcerer.io/fame/carloskotacho/carloskotacho/matematica-servlet-jsp/images/4)](https://sourcerer.io/fame/carloskotacho/carloskotacho/matematica-servlet-jsp/links/4)
[![5](https://sourcerer.io/fame/carloskotacho/carloskotacho/matematica-servlet-jsp/images/5)](https://sourcerer.io/fame/carloskotacho/carloskotacho/matematica-servlet-jsp/links/5)
[![6](https://sourcerer.io/fame/carloskotacho/carloskotacho/matematica-servlet-jsp/images/6)](https://sourcerer.io/fame/carloskotacho/carloskotacho/matematica-servlet-jsp/links/6)
[![7](https://sourcerer.io/fame/carloskotacho/carloskotacho/matematica-servlet-jsp/images/7)](https://sourcerer.io/fame/carloskotacho/carloskotacho/matematica-servlet-jsp/links/7)
