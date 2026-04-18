rootProject.name = "lab3"

tasks.register<Copy>("copyLibs") {
    // скидываем всё нужное в libs
    from(configurations.compileClasspath)
    from(configurations.runtimeClasspath)

    into("$projectDir/lib")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
