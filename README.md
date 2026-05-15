# Selenium Java Test Setup

Automated test suite built with Selenium 4 + Java + JUnit 5,
documenting my learning journey into Software QA automation.

## Prerequisites
- Windows 10/11
- Internet connection
- GitHub account

## IntelliJ Installation

1. Download IntelliJ Idea from [jetbrains website](https://www.jetbrains.com/idea/download/?section=windows). Ensure select correct OS.
2. Install downloaded `.exe` file.
3. Tick all boxes in Installation Options.

## New Test Project Setup

1. Open IntelliJ Idea.
2. At the navigation bar, click on **File > New > Project**.
3. Under Build system, select **Maven**.
4. Under JDK dropdown, select **Download JDK** and select **Microsoft OpenJDK 21**. (JDK = Java Development Kit. Ver 21 is Long Term Support/stable build)
5. Click **Create** and wait for the project to initialize.
6. Click **Run** on `Main.java` to verify the setup works.

## Maven Dependencies Setup

In  `pom.xml` add the following dependencies and build after `</properties>`

```xml
    <dependencies>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.25.0</version>
        </dependency>
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.8.0</version>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.11.1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.2.5</version>
            </plugin>
        </plugins>
    </build>
```
