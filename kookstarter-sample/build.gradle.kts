plugins {
    java
    id("org.springframework.boot") version "3.0.5"
    id("io.spring.dependency-management") version "1.1.0"
}

dependencies {
    implementation(project(":kookstarter"))

    implementation("org.springframework.boot:spring-boot-starter-webflux")
}