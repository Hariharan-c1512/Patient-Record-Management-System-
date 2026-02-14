Patient Record Management System

A Java-based web application developed using JSP, Servlets, JDBC, and Oracle Database for managing patient records. The system allows users to add new patient details, view a specific patient record, and view all stored patient records.

📌 Project Objective

To develop an online application for entering, storing, and viewing patient-related information such as:

Patient Name

Disease / Diagnosis

Admission Date

Age

Remarks

This project implements MVC architecture and demonstrates server-side validation, database interaction, and request handling using Servlets.

🛠️ Technologies Used

Java (JDK 8+)

JSP & Servlets

JDBC

Oracle Database

HTML

Apache Tomcat (9+ recommended)

🗂️ Project Structure
PatientRecordManagementSystem
│
├── src
│   └── com.wipro.patient
│       ├── bean        → JavaBeans (PatientBean)
│       ├── dao         → DAO classes (PatientDAO)
│       ├── service     → Business logic (Administrator)
│       ├── servlets    → Controller (MainServlet)
│       └── util        → DB utilities & custom exceptions
│
├── WebContent
│   ├── menu.html
│   ├── addPatient.jsp
│   ├── viewPatient.jsp
│   ├── displayPatient.jsp
│   ├── viewAllPatients.jsp
│   ├── displayAllPatients.jsp
│   ├── success.html
│   └── error.html
│
└── README.md

🗄️ Database Design
Table: PATIENT_TB
Column Name	Data Type	Constraints
PATIENTID	VARCHAR2(12)	Primary Key
PATIENTNAME	VARCHAR2(50)	NOT NULL
DISEASE	VARCHAR2(50)	NOT NULL
ADMISSION_DATE	DATE	NOT NULL
AGE	NUMBER	
REMARKS	VARCHAR2(100)	
Sequence: PATIENT_SEQ

Start Value: 10

Max Value: 99

Increment By: 1

🧠 Patient ID Generation Logic
Format: YYYYMMDD + first 2 letters of patient name (uppercase) + sequence number
Example: 20240215PA11

🔄 Application Flow
Menu Options

Add Patient Record

View Patient Record

View All Patient Records

Add Patient Record

User submits patient details

Validations performed

Record inserted into database

Redirects:

success.html on success

error.html on failure

View Patient Record

Search using Patient Name and Admission Date

Displays matching record or appropriate message

View All Patient Records

Displays all available patient records

Shows message if no records exist

✅ Validations Implemented

Null checks for mandatory fields

Patient name length ≥ 2

Disease length ≥ 2

Age must be greater than 0

Duplicate record check (Patient Name + Admission Date)
<img width="640" height="473" alt="Screenshot 2026-02-14 001751" src="https://github.com/user-attachments/assets/09990b97-040a-4bf3-b874-48a064b7eb7b" />
<img width="677" height="286" alt="Screenshot 2026-02-14 001737" src="https://github.com/user-attachments/assets/5169f19d-bde4-4156-9512-87e60e7288b0" />
<img width="621" height="343" alt="Screenshot 2026-02-14 001728" src="https://github.com/user-attachments/assets/188353a6-a319-46fe-afb6-8d712b09dd20" />


🧪 Sample Test Cases Covered

Add patient record with valid values

Add patient record with invalid patient name

Add patient record with null values

Add duplicate patient record

View patient record with valid details

View patient record with invalid details

Test addRecord() method in Servlet

Test viewRecord() method in Servlet

Fetch all records

Fetch all records when table is empty

<img width="643" height="322" alt="Screenshot 2026-02-14 001408" src="https://github.com/user-attachments/assets/b13e5b46-ad1c-4b9c-9014-46ee71e9691b" />

🚀 How to Run the Project

Import the project into Eclipse IDE

Configure Oracle DB and update DB credentials in DBUtil

Create the table and sequence in Oracle

Deploy the project on Apache Tomcat
