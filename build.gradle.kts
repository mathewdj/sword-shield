plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.11")
}

repositories {
    jcenter()
}

val cucumberVersion = "4.7.4"
val junitVersion = "5.5.0"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("io.cucumber:cucumber-java:${cucumberVersion}")
    testImplementation("io.cucumber:cucumber-junit:${cucumberVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:${junitVersion}")
}
