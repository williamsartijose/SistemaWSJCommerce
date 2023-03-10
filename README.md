# SistemaWSJCommerce

# Sobre o Sistema:
O sistema deve manter um cadastro de usuário, produtos e suas categorias. Cada usuário possui nome, email, telefone, 
data de nascimento e uma senha de acesso. Os dados dos produtos são: nome, descrição, preço e imagem.
O sistema deve apresentar um catálogo de produtos, os quais podem ser filtrados pelo nome do produto. A partir desse catálogo,
o usuário pode selecionar um produto para ver seus detalhes e para decidir se o adiciona a um carrinho de compras. 
O usuário pode incluir e remover itens do carrinho de compra, bem como alterar as quantidades de cada item.
Uma vez que o usuário decida encerrar o pedido, o pedido deve então ser salvo no sistema com o status de "aguardando pagamento".
Os dados de um pedido são: instante em que ele foi salvo, status, e uma lista de itens, onde cada item se refere a um produto e sua quantidade no pedido. 
O status de um pedido pode ser: aguardando pagamento, pago, enviado, entregue e cancelado.
Quando o usuário paga por um pedido, o instante do pagamento deve ser registrado. 
Os usuários do sistema podem ser clientes ou administradores, sendo que todo usuário cadastrado por padrão é cliente.
Usuários não identificados podem se cadastrar no sistema, navegar no catálogo de produtos e no carrinho de compras. 
Clientes podem atualizar seu cadastro no sistema, registrar pedidos e visualizar seus próprios pedidos.
Usuários administradores tem acesso à área administrativa onde pode acessar os cadastros de usuários, produtos e categorias.
Link:Protótipos de tela: https://www.figma.com/file/gJvohZcKvEDxqVGz2OvPQx/WSJCommerce?t=YYh32zg17TZRlVrq-6

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven
## Front end
- HTML / CSS / JS / TypeScript
- ReactJS
- React Native
- Apex Charts
- Expo
## Implantação em produção
- Back end: Heroku
- Front end web: Netlify
- Banco de dados: Postgresql

# Como executar o projeto

## Back end
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/williamsartijose/SistemaWSJCommerce

# entrar na pasta do projeto back end
cd backend

# executar o projeto
./mvnw spring-boot:run
```

## Front end web
Pré-requisitos: npm / yarn

```bash
# clonar repositório
git clone https://github.com/williamsartijose/SistemaWSJCommerce

# entrar na pasta do projeto front end web
cd front-web

# instalar dependências
yarn install

# executar o projeto
yarn start
```



### Modelo conceitual 
![Web 0](https://github.com/williamsartijose/SistemaWSJCommerce/blob/main/Imagem/imgDoc/49daadd836f3ce8f307b4ceaa4240e28-0.jpg)
![Web 1](https://github.com/williamsartijose/SistemaWSJCommerce/blob/main/Imagem/imgDoc/49daadd836f3ce8f307b4ceaa4240e28-1.jpg)
![Web 2](https://github.com/williamsartijose/SistemaWSJCommerce/blob/main/Imagem/imgDoc/49daadd836f3ce8f307b4ceaa4240e28-2.jpg)
![Web 3](https://github.com/williamsartijose/SistemaWSJCommerce/blob/main/Imagem/imgDoc/49daadd836f3ce8f307b4ceaa4240e28-3.jpg)
![Web 4](https://github.com/williamsartijose/SistemaWSJCommerce/blob/main/Imagem/imgDoc/49daadd836f3ce8f307b4ceaa4240e28-4.jpg)
![Web 5](https://github.com/williamsartijose/SistemaWSJCommerce/blob/main/Imagem/imgDoc/49daadd836f3ce8f307b4ceaa4240e28-5.jpg)
![Web 6](https://github.com/williamsartijose/SistemaWSJCommerce/blob/main/Imagem/imgDoc/49daadd836f3ce8f307b4ceaa4240e28-6.jpg)
![Web 7](https://github.com/williamsartijose/SistemaWSJCommerce/blob/main/Imagem/imgDoc/49daadd836f3ce8f307b4ceaa4240e28-7.jpg)



## Banco de dados H2, entidade User


```bash
# application.properties
spring.profiles.active=test
spring.jpa.open-in-view=false

# application-test.properties
- Dados de conexão com o banco H2
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
- H2 Client
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
- JPA, SQL
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.defer-datasource-initialization=true
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true


# Recomendação para campo tipo Instant

@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
private Instant moment;   

Caso precise aprender sobre data-hora em Java (LocalDate, LocalDateTime
e Instant):
https://www.youtube.com/watch?v=WnJUI-jMQGE

#Relacionamento muitos-para-um - @ManyToOne

public class Order {
...
@ManyToOne
@JoinColumn(name = "client_id")
private User client;


public class User {
...
@OneToMany(mappedBy = "client")
private List<Order> orders = new ArrayList<>();

# Relacionamento um-para-um - @OneToOne


public class Payment {
...
@OneToOne
@MapsId
private Order order;



public class Order {
...
@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
private Payment payment;



# Relacionamento muitos-para-muitos -@ManyToMany


public class Product {
...
@ManyToMany
@JoinTable(name = "tb_product_category",
joinColumns = @JoinColumn(name = "product_id"),
inverseJoinColumns = @JoinColumn(name = "category_id"))
private Set<Category> categories = new HashSet<>();


public class Category {
...
@ManyToMany(mappedBy = "categories")
private Set<Product> products = new HashSet<>();



```

# Autor

William Sarti José

https://www.linkedin.com/in/william-analistadesistema/
