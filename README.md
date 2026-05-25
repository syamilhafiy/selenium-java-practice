# DemoQA - TestNG Practice

Documenting my Selenium Java learning process via freeCodeCamp's
[Selenium Java Course](https://www.youtube.com/watch?v=QQliGCtqD2w&t=2217s)
on YouTube, using [DemoQA](https://demoqa.com/) as the practice site.

---

## Tech Stack
![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=java&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=flat&logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-FF6C37?style=flat&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apachemaven&logoColor=white)

---

## What's Different from Previous Practice

| Feature | Previous (LinkedIn Learning) | This Project |
|---------|------------------------------|--------------|
| Test framework | JUnit 5 | TestNG |
| Project structure | Flat — all files in one folder | Packaged — base, pages, tests separated |
| JavaScript | Not used | `JavaScriptExecutor` for scroll and click |
| Architecture | Simple POM | Layered — `BasePage → HomePage → Page` |

---

## Project Structure

```
src/
├── main/java/
│   └── com/
│       ├── base/
│       │   └── BasePage.java              ← core driver methods (find, click, set)
│       ├── demoqa.pages/
│       │   ├── forms/
│       │   │   ├── FormsPage.java         ← forms menu navigation
│       │   │   └── PracticeFormPage.java  ← form element interactions
│       │   └── HomePage.java              ← main page navigation
│       └── utilities/
│           ├── JavaScriptUtility.java     ← JS scroll and click methods
│           └── Utility.java               ← static driver reference
│
└── test/java/part3_4.com.demoqa/
├── base/
│   └── BaseTest.java                  ← TestNG setup and teardown
└── tests/part3/forms/
└── RadioButtonTest.java           ← radio button test cases
```

---

## Tests Covered

| # | Topic | Status |
|---|-------|--------|
| 1 | Page Object Model structure | ✅ |
| 2 | JavaScript scroll to element | ✅ |
| 3 | JavaScript click to bypass overlays | ✅ |
| 4 | Radio buttons | ✅ |

---

## Key Concepts Learned

1. **TestNG** — uses `@BeforeClass`, `@BeforeMethod`, `@AfterClass` instead of JUnit's `@BeforeEach`, `@AfterEach`
2. **Packaged structure** — separates `base`, `pages`, `utilities`, and `tests` into distinct packages for scalability
3. **JavaScriptExecutor** — used for `scrollIntoView()` and JS click to bypass ad overlays common on DemoQA
4. **Static driver pattern** — `BasePage.driver` is shared across all page classes via static reference
