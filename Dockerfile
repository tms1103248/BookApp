# формируем образ на основании мавена и джавы
FROM maven:3.8.3-openjdk-17

#сборка в контейнер
#COPY скопирует все что есть на уровне докерфайла и копирует в докер образ
COPY . .
RUN mvn  clean install

#запуск спринг бут чрез мавен
CMD mvn spring-boot:run

