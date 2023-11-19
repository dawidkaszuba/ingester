server:
    port: 8080

spring:
    kafka:
        bootstrap-servers: localhost:9092
        consumer.groupId: group
        imagesToProcessTopic:
            partitions: 2

    jpa:
        hibernate:
            ddl-auto: none
        show-sql: false
        generate-ddl: true
        properties:
            hibernate:
                jdbc:
                    time_zone: UTC
    datasource:
        url: jdbc:mysql://localhost:3306/<db-name>?useTimezone=true
        username: username
        password: password
        driver-class-name: com.mysql.cj.jdbc.Driver

news:
    api:
        token: <token>
        url: https://api.currentsapi.services

kafka:
    imagesToProcessTopic:
        name: imagesToProcessTopic
        partitions: 2
        replicationFactor: 2
    processedImagesTopic:
        name: processedImagesTopic
        partitions: 2
        replicationFactor: 1


feign:
    client:
        config:
            default:
                connectTimeout: 5000
                readTimeout: 5000
                url: https://api.currentsapi.services