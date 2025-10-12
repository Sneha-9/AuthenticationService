plugins {
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
//    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    implementation("org.apache.logging.log4j:log4j-api:2.25.1")
    implementation("org.apache.logging.log4j:log4j-core:2.25.1")

    implementation("org.postgresql:postgresql:42.7.7")
    // https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp
    implementation("com.squareup.okhttp3:okhttp:5.1.0")
    implementation("com.google.code.gson:gson:2.13.2")
    //implementation("org.apache.httpcomponents:httpclient:4.5.14")


    // This dependency is used by the application.
    //implementation(libs.guava)
}
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}
application {
    // Define the main class for the application.
    mainClass = "com.sneha.Main"
}
tasks.test {
    useJUnitPlatform()
}