# Movie Management System

## Problem Statement

A digital media company wants to build a centralized web-based application to manage its movie catalog. Currently, movie records are stored manually, leading to data redundancy and inconsistencies.

You are required to develop a **Spring MVC-based web application** that performs complete CRUD (Create, Read, Update, Delete) operations on movie records.

The application must follow a proper Spring MVC layered architecture.

---

## Objective

Implement a **Movie Management System** that allows administrators to:

1. Add a new movie
2. View all movies
3. Update existing movie details
4. Delete a movie

---

## Technical Constraints

Your solution must:

* Use **Spring MVC architecture**
* Follow a layered structure:

```
Controller → Service → Repository (DAO) → Database
```

* Use the following annotations where appropriate:

    * `@Controller`
    * `@RequestMapping`
    * `@GetMapping`
    * `@PostMapping`
    * `@PathVariable`
    * `@ModelAttribute`

* Use **JPA/Hibernate** for persistence

* Use **MySQL** as the database

* Use **JSP** or **Thymeleaf** as the view technology

---

## Entity Specification

Create a `Movie` entity mapped to a database table named `movies` with the following fields:

* `id` (Primary Key, Auto-generated)
* `title`
* `genre`
* `director`
* `releaseYear`
* `rating`

The database table must be generated automatically using JPA entity mapping.

---

## Functional Requirements

### 1. Create Movie

* Accept movie details from a form.
* Save the movie to the database.

### 2. Read Movies

* Display all movies in a tabular format.
* Each record must contain **Edit** and **Delete** options.

### 3. Update Movie

* Fetch movie by ID.
* Allow modification of details.
* Save updated information to the database.

### 4. Delete Movie

* Delete movie by ID.
* Redirect to the updated movie list.

---

## Input / Output Specification

**Input:**

* HTML form submission

**Output:**

* Rendered JSP or Thymeleaf pages

**HTTP Methods:**

* `GET` → Fetch data
* `POST` → Submit data
* `PUT` → Update data
* `DELETE` → Delete data

---

## Submission Instructions

* Read the assessment questions carefully.
* Complete the implementation on your local machine.
* Push the relevant source files along with the output screenshot to your GitHub repository as instructed.
* Ensure the project runs successfully before submission.

