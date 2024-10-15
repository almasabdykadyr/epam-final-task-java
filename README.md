# Сервис Управления Библиотекой

## Введение

Для эффективного управления библиотекой предлагается микросервисная архитектура, разделенная на несколько отдельных сервисов: **User Service**, **Book Service**, **Rent Service** и **Notification Service**. Взаимодействие между сервисами осуществляется через систему обмена сообщениями **Apache Kafka**.
## Общая Архитектура

1. **User Service**: Управляет пользователями системы.
2. **Book Service**: Управляет информацией о книгах.
3. **Rent Service**: Обрабатывает аренду и возврат книг.
4. **Notification Service**: Отправляет уведомления пользователям.
5. **Eureka**: Service discovery.

## Описание Сервисов

### 1. User Service

**Функции:**
- Хранение и управление пользователями

**Entities:**
- **User**
   - `id` (UUID)
   - `email` (string)
   - `password` (string)
   - `firstName` (string)
   - `lastName` (string)
   - `role` (enum: USER, ADMIN)
   - `created_at` (timestamp)

**API Endpoints:**
- `POST /api/users/register` – Регистрация нового пользователя.
- `GET /api/users/{id}` – Получение информации о пользователе.
- `PUT /api/users/{id}` – Обновление информации о пользователе.
- `DELETE /api/users/{id}` – Удаление пользователя.

### 2. Book Service

**Функции:**
- Управление каталогом книг.

**Entities:**
- **Book**
   - `id` (UUID)
   - `title` (string)
   - `description` (string)
   - `author` (string)
   - `isbn` (string)
   - `published_date` (date)

**API Endpoints:**
- `POST /api/books` – Добавление новой книги.
- `GET /api/books` – Получение списка книг с фильтрацией.
- `GET /api/books/byId/{id}` – Получение информации о конкретной книге.
- `PUT /api/books/byId/{id}` – Обновление информации о книге.
- `DELETE /api/books/byId/{id}` – Удаление книги из каталога.

### 3. Rent Service

**Функции:**
- Обработка аренды и возврата книг.
- Управление сроками аренды и штрафами.

**Entities:**
- **Rent**
   - `id` (UUID)
   - `user_id` (UUID)
   - `book_id` (UUID)
   - `rent_date` (timestamp)
   - `due_date` (timestamp)
   - `return_date` (timestamp, nullable)
   - `status` (enum: RENTED, RETURNED, OVERDUE)
   - `created_at` (timestamp)

**API Endpoints:**
- `POST /api/rents` – Создание новой аренды (аренда книги).
- `GET /api/rents` – Получение списка аренд с фильтрацией.
- `GET /api/rents/{id}` – Получение информации о конкретной аренде.
- `PUT /api/rents/{id}/return` – Возврат арендованной книги.
- `DELETE /api/rents/{id}` – Отмена аренды.

## TODO: дописать сервисы аренды и нотификации

## Взаимодействие через Kafka

### Темы Kafka

1. **user.events**
   - События, связанные с пользователями (регистрация, обновление профиля и т.д.).

2. **book.events**
   - События, связанные с книгами (добавление, обновление, удаление книг).

3. **rent.events**
   - События, связанные с арендой (создание аренды, возврат книги и т.д.).

4. **notification.events**
   - События для отправки уведомлений.

## Технологии и Инструменты

- **Язык программирования**: Java.
- **Фреймворки**: Spring Boot.
- **Базы данных**: PostgreSQL, MongoDB.
- **Apache Kafka**: Для обмена сообщениями между сервисами.
- **Контейнеризация**: Docker для упаковки сервисов.

## Пример взаимодействия (в идеале)

1. **Регистрация Пользователя:**
   - Пользователь отправляет `POST /api/users/register` в **User Service**.
   - **User Service** создает пользователя и публикует событие в `user.events`.
   - **Notification Service** подписывается и отправляет приветственное письмо.

2. **Добавление Книги:**
   - Администратор отправляет `POST /api/books` в **Book Service**.
   - **Book Service** добавляет книгу и публикует событие в `book.events`.
   - При необходимости другие сервисы могут реагировать на это событие.

3. **Аренда Книги:**
   - Пользователь отправляет `POST /api/rents` в **Rent Service**.
   - **Rent Service** создает аренду, публикует событие в `rent.events`.
   - **Book Service** обновляет количество доступных копий.
   - **Notification Service** отправляет подтверждение аренды.

## TODO: ЗАКОНЧИТЬ НАПИСАНИЕ СЕРВИСОВ, И ИСПОЛЬЗОВАННЫХ ТЕХНОЛОГИЙ, ДОБАВИТЬ SWAGGER, AUTH ЧЕРЕЗ KEYCLOAK

добавил spring cloud config для подтягивания конфигов.