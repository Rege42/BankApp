# BankApp
Веб-приложение на основе Spring Boot для летней практики 2023

# BankAppGenerator
Создает случайный объект типа BankAccount и передает его через GET

GET http://localhost:8080/generate - Запрос для генерации аккаунта со случайными данными

# BankAppLoader
Вызывает BancAccountGenerator через REST API, а потом сохраняет полученный объект BankAccount в БД (PostgreSQL) при помощи JPA. Также содержит класс TechResponse, отвечающий за отобажение успешности выполения сервиса. Если была поймана ошибка, то будет получен результат ERROR и описание ошибки, в ином же случае будет получен SUCCESS.

GET http://localhost:8081/load - Запрос на сохранение аккаунта в БД (необходим запущенный первый сервис)

# BankAppKafka
Приложение включает в себя BankAppGenerator и BankAppLoader, переделанные для использования логики Kafka.
Настройки Kafka и Zookeeper находится в файле docker-compose.yml, а параметры producer и consumer в классах config и service и файлах application.properties
