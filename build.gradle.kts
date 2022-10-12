plugins {
    id("java")
}

group = "dev.mostlysecure"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    implementation("net.portswigger.burp.extender:burp-extender-api:2.3")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}