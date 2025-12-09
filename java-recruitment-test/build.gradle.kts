plugins {
    id("io.micronaut.minimal.application") version "4.6.1"
}

group = "com.scorpio"
version = "0.0.1-RELEASE"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
        vendor = JvmVendorSpec.ADOPTIUM
    }
}

micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.scorpio.*")
    }
}

dependencies {
    annotationProcessor(mn.lombok)
    annotationProcessor(mn.micronaut.serde.processor)

    implementation(mn.micronaut.serde.jackson)
    implementation(mn.snakeyaml)

    compileOnly(mn.lombok)

    runtimeOnly(mn.logback.classic)

    testImplementation(mn.assertj.core)
    testImplementation(mn.mockito.junit.jupiter)
    testImplementation(mn.micronaut.test.rest.assured)

    testRuntimeOnly(mn.junit.jupiter.engine)
    testRuntimeOnly(mn.junit.platform.launcher)
}
