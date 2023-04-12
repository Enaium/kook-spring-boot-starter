plugins {
    `java-library`
    `maven-publish`
    signing
}


java.sourceCompatibility = JavaVersion.VERSION_17
java.targetCompatibility = JavaVersion.VERSION_17

val spring = "3.0.5"

dependencies {
    compileOnly("org.springframework.boot:spring-boot-starter-webflux:$spring")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:$spring")

    testImplementation("org.springframework.boot:spring-boot-starter-test:$spring")
}

tasks.test {
    useJUnitPlatform()
}

java {
    setProperty("archivesBaseName", "kook-spring-boot-starter")
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = "kook-spring-boot-starter"
            from(components["java"])
            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
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
    sign(publishing.publications["mavenJava"])
}