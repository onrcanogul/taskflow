# TaskFlow Microservices Project

A distributed system for managing tasks, notifications, and reports using a microservices architecture. This project is built with **Spring Boot**, **Kafka**, **RabbitMQ**, **PostgreSQL**, and containerized using **Docker Compose**.

## Table of Contents

- [Overview](#overview)
- [Architecture](#architecture)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Installation](#installation)
- [Running the Project](#running-the-project)
- [Environment Variables](#environment-variables)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)

---

## Overview

TaskFlow is a microservices-based project designed to handle task management, user interactions, notifications, and reporting. It demonstrates a scalable, distributed architecture with inter-service communication, centralized configuration, and fault tolerance.

---

## Architecture

The project comprises the following services:

1. **Config Service**: Centralized configuration management using Spring Cloud Config.
2. **Eureka Service**: Service registry and discovery using Netflix Eureka.
3. **Task Service**: Manages tasks, integrates with Kafka for event streaming.
4. **User Service**: Handles user-related operations.
5. **Notification Service**: Sends notifications, uses RabbitMQ for messaging.
6. **Report Service**: Generates and retrieves reports.

### Infrastructure

- **RabbitMQ**: Used for asynchronous messaging.
- **Kafka**: Handles streaming events for inter-service communication.
- **PostgreSQL**: Relational database for each service.
- **Redis**: Used for caching purposes.
- **Docker Compose**: Orchestrates the entire stack.

---

## Features

- Task creation, retrieval, and updates.
- Real-time notifications using RabbitMQ.
- Distributed event streaming via Kafka.
- Centralized configuration with Spring Cloud Config.
- Service discovery using Eureka.
- Database persistence with PostgreSQL.

---

## Tech Stack

- **Backend**: Spring Boot, Spring Cloud (Config, Eureka, Gateway)
- **Messaging**: Kafka, RabbitMQ
- **Database**: PostgreSQL, Redis
- **Containerization**: Docker, Docker Compose
- **Build Tool**: Maven

---

## Installation

### Prerequisites

Ensure you have the following installed:

- **Docker**: Version 20.x or higher
- **Docker Compose**: Version 2.x or higher
- **Java**: JDK 17 or higher
- **Maven**: Version 3.8.x or higher
