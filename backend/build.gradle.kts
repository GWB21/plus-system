plugins {
    java
    id("org.springframework.boot") version "3.4.1"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.jetbrains.kotlin.jvm") version "1.9.10"
    id("org.jetbrains.kotlin.plugin.spring") version "1.9.10"
}

group = "com.cas"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.22")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.22")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.4.1")
    testImplementation("org.mockito:mockito-core:5.10.0")
    testImplementation("org.mockito:mockito-junit-jupiter:5.10.0")
    testImplementation("net.bytebuddy:byte-buddy-agent:1.15.10")
}


tasks.withType<Test> {
    useJUnitPlatform()

    doFirst {
        val byteBuddyAgent = configurations.testRuntimeClasspath.get().files.find { it.name.contains("byte-buddy-agent") }
        println("Byte Buddy Agent Path: ${byteBuddyAgent?.absolutePath ?: "Not Found"}")
        if (byteBuddyAgent != null) {
            jvmArgs("-javaagent:${byteBuddyAgent.absolutePath}")
        } else {
            throw GradleException("byte-buddy-agent not found in testRuntimeClasspath.")
        }
    }
}
