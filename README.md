# Ingester
Mikroserwis pobierający i przetwarzający dane z API: https://currentsapi.services/en

Aplikacja udostępnia endpointy do wyszukiwania newsów w powyższym API.
Po wyszukaniu danych zapisuje je do bazy danych.
Jeśli wyszukany news posiada url do obrazka to wtedy takie informacje o obrazku tj. url oraz id newsa są wrzucane na topic Kafki.
Dalszym przetwarzaniem zajmuje się image-service. Po przetworzeniu obrazka image-serwis wrzuca na Kafkę
informacje o obrazku w postaci nowego urla (lokalizacji do której został pobrany obrazek) oraz id newsa.
Informacje o obrazku są aktualizowane w bazie danych.

### Endpointy do wyszukiwania newsów:

- "POST api/search-news", przykładowe body request:
```json
{
    "language": "en",
    "keywords": "Hamas",
    "category": "national",
    "country": "PL",
    "startDate": "2023-11-13T10:00:00+00:00",
    "endDate": "2023-11-13T12:00:00+00:00",
    "limit": 5,
    "pageSize": 5,
    "pageNumber": 1
}
```

- "POST api/search-news", przykładowe body request:
```json
{
    "language": "en"
}
```

### Autorzy
- Dawid Kaszuba (dawid.kaszuba1@edu.ueakt.pl)

