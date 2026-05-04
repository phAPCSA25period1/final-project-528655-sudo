[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=23508791)
# AP Computer Science A – Final Project
## Software & Systems Development Capstone

Welcome to your **Final Project repository**.

This repository will hold:
- Your complete Java project
- Your project journal and planning artifacts
- Your final, working software product

This is not just an assignment — it is a **capstone software project**.

---

## 📌 Project Overview (Read Carefully)

In this project, you will:
- Design and build a **real piece of software**
- Solve **one real problem** for **one clearly defined user**
- Work using **agile development**
- Show evidence of **professional software practices**
- Use AI responsibly as a planning and support tool

You will leave this course with something you can confidently say:

> “I built this software.”

---

## 🔁 Required Workflow (How You Must Work)

### ✅ Daily GitHub Commits (Required)
You are expected to:
- Make **at least one meaningful commit every class day**
- Write **descriptive commit messages** that explain:
  - What you changed
  - Why you changed it
  - What goal it supports

✅ Good commit messages:
- `Sprint 1: Created Player class and tested constructor`
- `Sprint 2: Implemented 2D map and verified movement logic`

🚫 Poor commit messages:
- `updates`
- `stuff`
- `final version`

Your commit history is **evidence of your thinking and progress**.

---

## 🔁 Agile Development & Sprints

You will complete **4 sprints**.
Each sprint includes:
- Planning
- Building
- Testing
- Feedback and reflection

Each sprint ends with:
- A sprint grade
- A sprint reflection
- Feedback exchanged with peers

🚫 You may NOT complete multiple sprints at once.
✅ Each sprint grade is **final**.

---

## 🧪 Testing Expectations

Testing is required every sprint.

✅ Testing may include:
- Running the program with different inputs
- Print‑based testing
- Driver program testing
- Verifying logic and edge cases

You should be able to explain:
- What you tested
- How you tested it
- What you discovered or fixed

---

## 🗂️ Required Project Components

Your final project must include:

- ✅ Multiple interacting Java classes
- ✅ Encapsulation (`private` fields, appropriate getters/setters)
- ✅ Arrays and/or ArrayLists
- ✅ A purposeful **2D array**
- ✅ A working driver program (`main`)
- ✅ A class diagram matching your final code
- ✅ Clear documentation

---

## 📋 Project: School Counselor Scheduler

### Problem Statement

Students at our school struggle to book counselor appointments because there's no centralized, organized way to schedule meetings. This project provides a **simple console-based application** that allows students to view available time slots, enter their information, and book confirmed appointments with an automatically assigned counselor.

### Features

- **Self-Service Scheduling**: Students can independently view availability and book appointments
- **Automatic Counselor Assignment**: Counselors are assigned to students based on last name ranges
- **Persistent Storage**: Bookings are saved to a CSV file (`appointments.csv`) for record-keeping
- **Input Validation**: The application validates grade level input (9–12) before accepting
- **Availability Display**: Students see all available time slots before making a booking
- **Meeting Details**: Appointments capture time, date, reason, meeting type (in-person/virtual), and notes

### System Architecture

#### Class Descriptions

| Class | Purpose |
|-------|---------|
| **Main** | Entry point; drives the user interaction flow via console prompts |
| **Student** | Represents a student with name, grade level, and an assigned counselor |
| **Counselor** | Represents a school counselor with a name |
| **Appointment** | Encapsulates appointment data (student, counselor, day, time, reason, type, notes) |
| **AppointmentManager** | Manages the weekly schedule (HashMap), loads/saves bookings (ArrayList), and provides availability queries |

#### Key Design Decisions

1. **HashMap for Schedule**: Maps weekday names to lists of available time slots, allowing easy lookup and modification
2. **ArrayList for Bookings**: Stores all booked appointments as string arrays for flexible data management
3. **Automatic Counselor Assignment**: Student constructor assigns a counselor based on alphabetical last name ranges
4. **CSV Persistence**: All bookings are saved to a file to maintain records across runs
5. **Input Validation**: Grade level is validated in a loop until valid input is received

### How to Use

1. **Run the application**:
   ```
   javac *.java
   java Main
   ```

2. **Follow the prompts**:
   - View available appointment slots for each weekday
   - Enter your first and last name
   - Enter your grade level (9–12)
   - Choose a preferred day and time
   - Specify a reason for the meeting
   - Indicate meeting type (in-person or virtual)
   - Add any additional notes
   - Confirm the booking

3. **View bookings**: Check the `appointments.csv` file to see all recorded appointments

### Data Structure: The 2D Array

The appointment data is stored using a **2D array structure** within the ArrayList:
- Each row represents one appointment as a `String[]`
- Each column represents: Student Name, Grade, Counselor, Day, Date, Time, Reason, Meeting Type, Notes
- This 2D structure allows the AppointmentManager to efficiently parse, query, and save appointment records

### Testing

The application has been tested with:
- Valid and invalid grade inputs (error handling)
- Multiple bookings across different days and times
- CSV file loading and persistence
- Counselor assignment logic for various last name ranges

### Requirements Met

- ✅ **Multiple interacting classes**: Student, Counselor, Appointment, AppointmentManager, Main
- ✅ **Encapsulation**: All fields are private with appropriate getters/setters
- ✅ **ArrayList**: Used in AppointmentManager to store booked appointments
- ✅ **HashMap**: Used to manage the weekly schedule (day → time slots)
- ✅ **2D Array structure**: Appointment data stored as `String[]` within ArrayList
- ✅ **Working driver program**: Main class provides full user interaction
- ✅ **File I/O**: CSV file for persistent storage of bookings
- ✅ **Encapsulation**: Private fields with controlled access
- ✅ **Input validation**: Grade level validation with exception handling
- ✅ A program that runs and works

Inheritance and interfaces are optional but encouraged.

---

## 🤖 Using AI (Allowed, With Responsibility)

You may use AI to:
- Organize ideas
- Plan sprints
- Debug code
- Suggest design improvements

You must:
- Document how you used AI
- Understand every line of code you submit
- Not use AI to generate entire solutions
- Credit AI in your commit messages when you use it

---

## 📖 Project Journal & Artifacts

Throughout development, maintain:
- **Sprint Planning**: Goals and tasks for each sprint
- **Design Decisions**: Why you chose certain class structures, data types, and algorithms
- **Testing Notes**: What you tested and what you learned
- **Reflection**: What went well, what was challenging, what you'd do differently

These artifacts provide evidence of your **thinking process**, not just the final code.

---

## ✅ Grading Rubric

Your final project will be graded on:

| Criterion | Excellent | Proficient | Developing |
|-----------|-----------|-----------|-----------|
| **Design & Architecture** | Well-organized classes with clear responsibilities; thoughtful use of data structures | Multiple classes with mostly clear purposes; appropriate data structures | Few classes or unclear separation of concerns |
| **Code Quality** | Clean, readable code; meaningful names; proper encapsulation | Generally clear code; mostly consistent style; some encapsulation | Hard to follow; poor naming; weak encapsulation |
| **Functionality** | Application works reliably with multiple features; handles edge cases | Core features work; minor bugs; basic error handling | Incomplete features; frequent crashes |
| **Testing & Validation** | Thorough testing documented; edge cases verified | Reasonable testing; most cases work | Minimal testing; obvious cases fail |
| **Documentation** | Clear READMEs, comments, and diagrams; easy to understand workflow | Adequate documentation and comments | Sparse or unclear documentation |
| **Professional Practices** | Consistent, meaningful commits; working on one sprint at a time; clear history | Regular commits with decent messages | Sparse commits; poor messages |

---

## 🔧 Technical Requirements Met

Your project successfully demonstrates:

- **Object-Oriented Design**: Multiple classes working together with clear roles
- **Data Management**: HashMap for schedule, ArrayList for bookings, 2D array structure for appointment records
- **File I/O**: Persistent storage using CSV
- **Input Handling**: Console input with validation and error handling
- **Exception Handling**: Try-catch blocks for robust error management
- **Encapsulation**: Private fields with controlled getter/setter access
- **Code Organization**: Logical package structure and meaningful class hierarchy

---

## 📚 Resources

- **Java Documentation**: https://docs.oracle.com/javase/
- **ArrayList & HashMap**: Refer to official Java collections documentation
- **CSV File Format**: Plain text, comma-separated values for data persistence
- **AP CSA Course Guide**: College Board's official AP Computer Science A framework

---

## 🎓 Learning Outcomes

By completing this project, you have demonstrated:

✅ Ability to design and build a real software system
✅ Understanding of object-oriented programming principles
✅ Proficiency with Java collections (ArrayList, HashMap)
✅ File I/O and data persistence
✅ Problem-solving through iterative development
✅ Professional software development practices
✅ Clear communication of technical design

---

## 💡 Future Enhancements

Possible improvements for a future version:

- **GUI Interface**: Swing or JavaFX for a graphical interface
- **Database Integration**: Replace CSV with a real database (SQL)
- **Authentication**: Login system for students and counselors
- **Notifications**: Email or SMS reminders for upcoming appointments
- **Counselor Dashboard**: View and manage counselor schedules
- **Cancellation & Rescheduling**: Allow students to modify existing bookings
- **Analytics**: Track appointment trends and counselor availability

---

## 📝 Author & Submission

- **Student**: Final Project Capstone – AP Computer Science A
- **Course**: AP Computer Science A – 2025–2026
- **Submission Date**: May 4, 2026
- **Repository**: School Counselor Scheduler Application

---

**Thank you for using the School Counselor Scheduler. This project represents your growth as a software developer. You built this software—be proud!**
- Review and evaluate AI suggestions
- Understand and explain your final code

AI should act like:
> A junior developer you supervise — not something that builds the project for you.

---

## 📘 Project Journal

All planning, work logs, testing notes, and reflections live in **your project journal**.

If it happened during this project, it should be documented there.

---

## ✅ Final Submission Expectations

By the end of the project:
- Your program should run reliably
- Your technical requirements should be met
- Your code should be readable and organized
- Your repository should look **professional**

---

# ✨ Final Step: README Update (Very Important)

When your project is complete, you must **rewrite this README**
so it reflects **your software**, not the assignment.

Your final README should include:

---

## 🔹 Project Title

## 🔹 What This Software Does
Explain your project in plain language.

## 🔹 Who It’s For
Describe the user and the problem being solved.

## 🔹 How to Run the Program
Clear steps so someone else can run your project.

## 🔹 Technical Overview
Brief description of:
- Main classes
- Key data structures
- Program logic

## 🔹 Class Diagram
Include or link your final class diagram.

## 🔹 Known Limitations / Future Improvements
What works well, and what you would improve with more time.

---

## 🎯 Final Reminder

This repository represents **you as a developer**.

Take pride in:
- Your process
- Your commits
- Your code
- Your documentation

Build something real.
Build it thoughtfully.
Build it well.
