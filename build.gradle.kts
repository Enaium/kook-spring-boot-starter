plugins {
    `java-library`
    `maven-publish`
    signing
}



java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21

    withSourcesJar()
}

group = "cn.enaium"
version = "0.4.0"

repositories {
    mavenCentral()
}

val springboot: String by project
val annotations: String by project

dependencies {
    implementation("org.jetbrains:annotations:$annotations")

    implementation("org.springframework.boot:spring-boot-starter-webflux:$springboot")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:$springboot")

    testImplementation("org.springframework.boot:spring-boot-starter-test:$springboot")
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = "kook-spring-boot-starter"
            from(components["java"])

            pom {
                name.set("kook-spring-boot-starter")
                description.set("KOOK机器人的spring-boot-starter")
                url.set("https://github.com/Enaium/kook-spring-boot-starter/")

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("enaium")
                        name.set("Enaium")
                        email.set("enaium@outlook.com")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/Enaium/kook-spring-boot-starter.git")
                    developerConnection.set("scm:git:https://github.com/Enaium/kook-spring-boot-starter.git")
                    url.set("https://github.com/Enaium/kook-spring-boot-starter/")
                }
            }
        }
    }
    repositories {
        maven {
            url = uri(
                "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
            )
            credentials {
                username = project.properties["ossrhUsername"].toString()
                password = project.properties["ossrhPassword"].toString()
            }
        }
    }
}

signing {
    project.properties["signing.secretKeyRingFile"]?.let {
        sign(publishing.publications["mavenJava"])
    }
}