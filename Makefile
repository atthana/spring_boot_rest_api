up:
	docker-compose up -d

run-maven:
	cd crudapi && mvn spring-boot:run

down:
	docker-compose down --remove-orphans

ps:
	docker-compose ps
