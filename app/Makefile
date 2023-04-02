run-dist:
	./build/install/app/bin/app build/resources/main/file1.json build/resources/main/file2.json

clean:
	./gradlew clean

build:
	./gradlew clean build

run:
	./gradlew run

lint:
	./gradlew checkstyleMain checkstyleTest

test:
	./gradlew test

build-run: build run

.PHONY: build