A Java console app that manages student enrolment.
## Features

### 
 Enroll students into courses: add/update/delete/view

 Add/update/delete/view a particular enrollment

 Show all enrollments for a particular semester

 Show enrollments of a particular student

 File IO to persist data
__________________________________________________________________________________________________________________________
## Design Patterns

### 1. Singleton

	StudentEnrolmentList (in CoreDatabase)
  
	AddEnrolment, DeleteEnrolment, GetEnrolmentBySemester, GetEnrolmentByStudent, UndoDelete, UpdateEnrolment (in Actions)

### 2. Builder

	Course, Student (in CoreDatabase)

### 3. Command

	AddEnrolment, DeleteEnrolment, GetEnrolmentBySemester, GetEnrolmentByStudent, , UndoDelete, UpdateEnrolment (in Actions)

### 4. Facade

	StudentEnrolmentList (in CoreDatabase)
  
	GetAllEnrolment (in Actions)

### 5. Iterator

	built in StudentEnrolmentList (in CoreDatabase)
  
	called in DeleteEnrolment (in Actions)

### 6. Memento

	UndoDelete (in Actions)

### 7. Prototype

	built in StudentEnrolmentList (in CoreDatabase)
  
	called in UndoDelete (in Actions)

### 8. Strategy

	ChooseAction (in ActionChooser)

### 9. Chain of Responsibilities

	built in StudentEnrolment (in CoreDatabase)
  
	called in GetEnrolmentByStudent (in Actions)

### 10. Visitor

	built in ActionVisitor (in ActionVisitor)
  
	called in AddEnrolment, DeleteEnrolment (in Actions)
__________________________________________________________________________________________________________________________
## Assignment from
Software Architecture Design and Implementation course
