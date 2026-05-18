# Setup Test to Run Concurrently
Let's say my test suite contains 100 test cases. To run each one test sequentially takes a lot of time. I learned how to set so that Selenium runs the tests in concurrent.

## Steps to configure:
1. Under `resource` folder, create new file named `junit-platform.properties`
2. Copy and paste these 2 lines into the file:
```java
junit.jupiter.execution.parallel.enabled=true
junit.jupiter.execution.parallel.mode.default=concurrent
```
3. Save.
