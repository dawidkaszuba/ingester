# Ingester
 Mikroserwis pobierający i przetwarzający dane z API: https://currentsapi.services/en

### Wymagania

- Java 17
- Kafka
- baza danych MySql

### Jak uruchomić

- skopiuj plik /config/application.yaml.tpl w tej samej lokalizacji i uzupełnij parametry
- uruchom Kafkę lokalnie lub podepnij się do zewnętrznej
- w głównym katalogu odpal: `mvn spring-boot:run`

### Autorzy
- Dawid Kaszuba (dawid.kaszuba1@edu.ueakt.pl)
