plugins {
    war
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("javax:javaee-api:8.0.1")
    implementation("org.primefaces:primefaces:13.0.0")
    implementation("org.postgresql:postgresql:42.7.8")
    testImplementation("junit:junit:4.13.2")
    compileOnly("com.jcraft:jsch:0.1.55")
    compileOnly("org.apache.ant:ant-jsch:1.10.14") {
        isTransitive = false
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

tasks.register<Copy>("copyLibs") {
    from(configurations.compileClasspath)
    from(configurations.runtimeClasspath)
    from(configurations["testRuntimeClasspath"])

    into("$projectDir/lib")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
