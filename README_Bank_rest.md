# Система управления банковскими картами

---

### Возможности

---

* Администратор: Создание пользователя 
* Автоматические миграции базы данных (Liquibase)
* Поддержка Docker & Docker Compose

### Стек технологий

---

* Java 17
* Spring Boot 3
* PostgreSQL 15
* Liquibase
* Docker & Docker Compose

### Требования

---

* Java 17 или выше
* Maven 
* Docker 
* Docker Compose 

### Установка и запуск

---
Клонирование репозитория
```bash
git clone https://github.com/Zizann86/bank_rest.git
cd bank_rest
```

Для сборки проекта необходимо выполнить в корне проекта
```bash
mvnw clean package
```
Для запуска проекта выполнить:
```bash
mvn spring-boot:run
```
Или из интегрированной среды разработки (IDE) запустить src/main/java/BankcardsApplication

После запуска приложение будет доступно по адресу: http://localhost:9090

Для запуска приложения с использованием контейнеров Docker Compose, выполните следующую команду:

```bash
docker compose up --build
```
Настройки для запущенных сервисов указаны в docker-compose.yml
