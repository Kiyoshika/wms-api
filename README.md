# Warehouse Management System (API)
An experimental project for fun to build a small-scale API that you may see within a Warehouse Management System.

## Features
* (TODO) Create and manage fulfillment centers
* (TODO) Create and manage bin locations
* (TODO) Create and manage products
* (TODO) Manage inventory
* (TODO) Purchase Order service (vendor/inbound)
* (TODO) Appointment service (inbound)
* (TODO) Receiving service (inbound)
* (TODO) Picking service (outbound)
* (TODO) Replenishment service
* (TODO) Order service
* (TODO) Pick path planning / order batching
* Lots of other stuff

## Building
This is a spring boot app using JDK21 and Postgres 17. For local development, docker compose is used to setup any services required for local development.

[SDK Man](https://sdkman.io/) is used to manage the JDK for easier management.

1. Use `sdk env install` to install this project's JDK
2. Run `docker compose up` to start up the services
3. Use the run configuration (IntelliJ) or manually:
    * `SPRING_PROFILES_ACTIVE=local ./gradlew clean assemble flywayMigrate bootRun --stacktrace`
4. For authentication, a default user `admin` with password `admin` is created; this API uses BasicAuth (this user can be updated/deleted from the database if needed)

### Database Migrations
This project uses flyway to handle database migrations. Migration scripts are located in `src/main/resources/db/migration`

### Connecting to DB
After running the docker compose, you can connect to the database locally with
```
psql -h localhost -d wms -U admin -W
```
The password is also `admin` as shown in the credentials above

### Code Formatting
This project uses gradle spotless. Use it with:
```text
./gradlew :spotlessApply
```