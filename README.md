# My TV Programme (Java Desktop App)

A simplified subscription TV platform (Netflix/Disney+ style) developed as a university project for **Object-Oriented Programming (2023–2024)**.

The application supports two roles (**Admins** and **Subscribers**) and provides content management (movies/series), advanced search, reviews, favorites, and file-based persistence.

> UI/branding is used for educational purposes.

---

## Features

### Admin
- Add / edit / delete **Movies**
- Add / edit / delete **Series**, including **Seasons** and **Episodes**
- Search content with multiple filters
- View full details of each movie/series (including ratings & reviews)

### Subscriber
- Register new account (subscribers only)
- Login / logout (role is inferred from credentials)
- Search movies and series with multiple filters (AND logic)
- Add / edit / delete reviews (text + 1–5 rating)
- Manage personal **Favorites** list

### Persistence
- Data is stored in files and remains available after restarting the application (users, content, reviews, favorites).

---

## Tech Stack
- **Java** (Desktop GUI using Swing)
- Object-Oriented Design (encapsulation, inheritance, abstraction)
- **JUnit 4** for unit testing (non-GUI classes)

---

## Project Structure
- `src/api/` → application logic (models, operations, data handling)
- `src/gui/` → GUI (Swing/JFrames)
- `test/` → JUnit tests (logic layer)
- `lib/` → `junit-4.13.1.jar` & `hamcrest-core-1.3.jar` (included for easy local test execution)

---

## How to Run
1. Open the project in **IntelliJ IDEA**
2. Set the **Project SDK** (Java 17 recommended)
3. Run: `src/Main.java`

---

## How to Run Tests
- Ensure `lib/` is added as a library dependency in IntelliJ (if not already)
- Run all tests from the `test/` folder:
  - Right-click `test/` → **Run 'All Tests'**

---

## Demo Credentials (for testing only)

**Admins**
- `admin1` / `password1`
- `admin2` / `password2`

**Subscribers**
- `user1` / `password1`
- `user2` / `password2`

---

## Data Files
The project includes initial data and persistence files:
- `Admins.txt`
- `Subscribers.txt`
- `Movies.dat`
- `Series.dat`
- `Favourites.txt`

> These files are used for initialization and are updated during application usage.

---

## Screenshots
> Quick walkthrough of the main user flows.

### Authentication & Registration
![Splash](docs/screenshots/01-splash.jpg)
![Login](docs/screenshots/02-login.jpg)
![Registration](docs/screenshots/03-register.jpg)
![Subscription success](docs/screenshots/04-subscription-success.jpg)
![Subscriber login success](docs/screenshots/05-login-success.jpg)

### Subscriber Flow
![Subscriber welcome](docs/screenshots/06-subscriber-welcome.jpg)
![Subscriber menu](docs/screenshots/07-subscriber-menu.jpg)
![Content grid](docs/screenshots/08-content-grid.jpg)
![Details & reviews](docs/screenshots/09-series-details-reviews.jpg)
![Favorites](docs/screenshots/10-favorites-list.jpg)

### Search
![Search form](docs/screenshots/11-search-form.jpg)

### Admin Flow
![Admin login success](docs/screenshots/12-admin-login-success.jpg)
![Admin welcome](docs/screenshots/13-admin-welcome.jpg)
![Admin actions](docs/screenshots/14-admin-actions-menu.jpg)
![Select object to add](docs/screenshots/15-admin-add-object-select.jpg)
![Add movie form](docs/screenshots/16-admin-add-movie-form.jpg)

---

## Authors
- **Ioakeim Mertekis**
- **Evangelia Andrioti** (Greek: Ευαγγελία Ανδριώτη)

---

## Notes
This repository is published for **portfolio** purposes.

The project was originally developed in a **GitHub Classroom** environment and later migrated here for portfolio presentation.
