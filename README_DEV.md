# Ingester
 Mikroserwis pobierający i przetwarzający dane z API: https://currentsapi.services/en

## Wymagania

- Java 17
- Kafka
- baza danych MySql
- Docker

## Jak uruchomić

- skopiuj plik /config/application.yaml.tpl w tej samej lokalizacji i uzupełnij parametry
- uruchom Kafkę lokalnie lub podepnij się do zewnętrznej
- w głównym katalogu odpal: `mvn spring-boot:run`

## Tworzenie obrazu i wysyłanie do zewnętrznego registry

- zainstaluj: `mvn clean -Dmaven.test.skip=true install`
- Zbuduj obraz: `docker build -t dawidkaszuba/ingester:latest .`
- Wrzuć na zewnętrzne registry: `docker push dawidkaszuba/ingester:latest`



### Autorzy
- Dawid Kaszuba (dawid.kaszuba1@edu.ueakt.pl)
