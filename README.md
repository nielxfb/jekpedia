# JekPedia

JekPedia is a Java application that manages job applicants through various phases of the hiring process. The project demonstrates the use of several design patterns, including Singleton, State, and Iterator.

## Project Structure

```
.classpath
.gitignore
.project
.settings/
	org.eclipse.jdt.core.prefs
bin/
	abstraction/
		IPhase.class
		IRandom.class
		Iterable.class
	database/
		Database.class
	iterator/
		ApplicantIterator.class
	main/
		Main.class
	model/
		Applicant.class
		PhaseThread.class
	state/
		FinishedState.class
		InterviewState.class
		ProblemSolvingState.class
		SubmissionState.class
		UiUxTestState.class
	util/
		...
	view/
		...
src/
	abstraction/
	database/
	iterator/
	main/
	model/
	state/
	util/
	view/
```

## Design Patterns

### Singleton

The Singleton pattern is used for the database connection to ensure that only one instance of the [Database](src/database/Database.java) class exists throughout the application.

- Database.java

```java
public class Database {
    private static Database instance;

    private Database() {
        applicants = new ArrayList<>();
    }

    public static Database getInstance() {
        return instance = (instance == null) ? new Database() : instance;
    }
}
```

### State

The State pattern is used to manage the different phases of the job application process. Each applicant goes through various phases, and each phase is represented by a state class implementing the [IPhase](src/abstraction/IPhase.java) interface. The phases are managed in a separate thread for each applicant.

- IPhase.java
- SubmissionState.java
- InterviewState.java
- ProblemSolvingState.java
- FinishedState.java
- UiUxTestState.java
- PhaseThread.java

```java
public class Applicant {
    public Applicant(String id, String name, Integer jobExperience, String jobPreference) {
        this.currentPhase = new SubmissionState();
        new Thread(new PhaseThread(this)).start();
    }
}
```

### Iterator

The Iterator pattern is used to iterate over the list of applicants. The [ApplicantIterator](src/iterator/ApplicantIterator.java) class implements the  [Iterable](src/abstraction/Iterable.java) interface to provide a way to traverse the collection of applicants.

- Iterable.java
- ApplicantIterator.java

```java
public class ApplicantIterator implements Iterable<Applicant> {
    private int currentIndex;
    private ArrayList<Applicant> applicants;

    public ApplicantIterator(ArrayList<Applicant> applicants) {
        currentIndex = 0;
        this.applicants = applicants;
    }

    @Override
    public Applicant getNext() {
        Applicant next = applicants.get(currentIndex);
        currentIndex++;
        return next;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < applicants.size();
    }
}
```

## Running the Application

To run the application, execute the `main` method in the [Main.java](src/main/Main.java) file.

```java
public class Main {
    public static void main(String[] args) {
        new HomePage();
    }
}
```

The application provides a console-based interface to register new applicants and view existing applicants' forms.