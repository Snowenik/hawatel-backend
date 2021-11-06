## Konfiguracja i uruchomienie

- API działa na `localhost:8080/api`
- Należy utworzyć bazę danych o nazwie `hawatel` (lub zmienic nazwe w `application.properties`)
- Konfiguracja PostgreSQL znajduje się w `/src/main/resources/application.properties`
- Username dla bazy danych jest ustawiony(domyślny) jako `postgres`, hasło: `admin`
- Po uruchomieniu aplikacji, klasa `/src/main/java/com/hawatel/monolithic/LoadUsers.java` tworzy 2 użytkowników:
dane pierwszego(login: marek123, hasło: marek123), dane drugiego(login: hawatel123, hasło: hawatel123)
- Należy tę klasę usunąć po pierwszym uruchomieniu żeby nienadpisywała/rzucała wyjątków
- Po konfiguracji, aby uruchomic aplikację należy przejść do jej głównego katalogu i wpisać w terminalu `mvnw spring-boot:run`


