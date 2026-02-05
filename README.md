# My TV Programme (Java Desktop App)

A simplified subscription TV platform (Netflix-like) developed for the **Object-Oriented Programming** course (2023–2024).

## Features
- Role-based access: **Admins** & **Subscribers**
- Admin actions: add/edit/delete Movies/Series/Seasons/Episodes
- Search with multiple filters (title/type/actor/category/age rating/min rating)
- Reviews (1–5 stars + text), edit/delete by subscriber
- Favorites list per subscriber
- File-based persistence (data remains after restart)

## Tech stack
- Java (Desktop GUI)
- OOP principles (inheritance/abstraction/encapsulation)
- JUnit tests (for non-GUI classes)

## Project structure
- `src/api/` : application logic
- `src/gui/` : GUI (Swing/JFrames)
- `test/` : JUnit tests

## Run
1. Open the project in IntelliJ IDEA
2. Set the JDK
3. Run `src/Main.java`

## Demo credentials (for testing only)
- Admin:
  - `admin1` / `password1`
  - `admin2` / `password2`
- Subscriber:
  - `user1` / `password1`
  - `user2` / `password2`

## Notes
- Data initialization & persistence are handled via the included `.txt` / `.dat` files.
- This repository is published for portfolio purposes.

## Author
- <Ioakeim Mertekis>

