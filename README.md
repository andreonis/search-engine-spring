# search-engine-spring

The following documents are indexed:
Document 1: “the brown fox jumped over the brown dog”
Document 2: “the lazy brown dog sat in the corner”
Document 3: “the red fox bit the lazy dog”
A search for “brown” should now return the list: [document 1, document 2].
A search for “fox” should return the list: [document 1, document 3]

How to look for a word:
type that http adress into browser and switch question marks with word you are looking for
http://localhost:8080/?word=???

Booting with IDE:
run Main class in : src/main/java/com/searchengine

How to boot in terminal with Maven:
mvn spring-boot:run

