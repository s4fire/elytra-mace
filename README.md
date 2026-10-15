# Elytra Mace

A client-side Fabric mod for Minecraft Java Edition 26.3.

## Requirements

- Minecraft Java Edition 26.3
- Fabric Loader 0.19.5 or compatible
- Fabric API for Minecraft 26.3
- JDK 25
- IntelliJ IDEA (recommended)

## Development

Open this repository as a Gradle project in IntelliJ IDEA and allow Gradle to sync.

Build the mod using the Gradle wrapper:

- Windows: `gradlew.bat build`
- macOS/Linux: `./gradlew build`

The built JAR will be in `build/libs/`.

## Client-only

The Fabric metadata sets `environment` to `client` and defines only a client entrypoint. There is no server entrypoint or server-side component.

## Project status

This first commit is the initial project scaffold. It currently only logs that the client mod initialized; the targeting and automation features are not implemented yet. They will be added incrementally and checked against Minecraft 26.3 APIs.
