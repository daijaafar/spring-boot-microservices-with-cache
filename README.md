# spring-boot-microservices-with-cache
 
### Technologies stack
- Spring Boot Starter version 2.3.4.RELEASE
- Rabbit MQ as message broker

Consists of two small applications namely App Common and App Order

### Responsibilities:

1. **App Common**: Contain an REST API to set a particular day is open for order, and publish it to message broker.

2. **App Order**: Subcribe to message broker and update to the Java Map instance. It also contain an REST API so we can check if a particular day is open for order. This information is fetch from Java Map instance. Instead of fetching from the instance everytime, the information is stored in cache and configured to be clear once an hour.

### Quick start

1. Start up the message broker
   - Run command `docker container run -it --name rabbitmq -p 15672:15672 -p 5672:5672 -p 61613:61613 pcloud/rabbitmq-stomp:3`
   - You can login to the Rabbit MQ Admin at localhost:15672 with username admin and password admin
2. Start App Common 
   - Run command at root folder `mvn -pl app-common -am spring-boot:run`
3. Start App Order
   - Run command at root folder `mvn -pl app-order -am spring-boot:run`
3. Call REST API `POST localhost:8081/schedule?date=2020-11-06&isOpen=true`
4. Call REST API `GET localhost:8082/isOpen?date=2020-11-06`

