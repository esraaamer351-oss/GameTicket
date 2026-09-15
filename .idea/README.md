# GameTicket 🎟️

A simple Java console application for booking and managing game tickets (football matches). Built as a practice project using core Java (OOP, collections, exception handling).

## Features
- View a list of predefined matches (national & international)
- Book a ticket for a fan
- Remove a booked ticket
- Upgrade a ticket
- Custom exception handling for invalid operations

## Tech Stack
- Java (JDK 13+)
- Built with Eclipse

## Project Structure
```
GameTicket/
└── src/
    └── gameticket_package/
        └── GameTicket.java   # main app + all classes (Match, Ticket, Fans, Category1/2/3, myexception)
```

## How to Run
1. Make sure you have Java installed (JDK 8 or higher):
   ```bash
   java -version
   ```
2. Compile the project:
   ```bash
   cd src
   javac gameticket_package/GameTicket.java
   ```
3. Run it:
   ```bash
   java gameticket_package.GameTicket
   ```
4. Follow the on-screen menu to book, remove, or upgrade a ticket.

## Author
Made by Abdelrhman.
