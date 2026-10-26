# CS320 Portfolio

This repository contains deliverables from CS320: Software Test, Automation QA.

## Contents

### 📁 Portfolio Artifacts 📁 CS 320
**Artifact 1: Contact Service Files**
* [Contact.java](Contact.java)
* [ContactService.java](ContactService.java)
* [ContactTest.java](ContactTest.java)
* [ContactServiceTest.java](ContactServiceTest.java)

**Artifact 2: Task Service Files**
* [Task.java](Task.java)
* [TaskService.java](TaskService.java)
* [TaskTest.java](TaskTest.java)
* [TaskServiceTest.java](TaskServiceTest.java)

**Artifact 3:  Appointment Service Files**
* [Appointment.java](Appointment.java)
* [AppointmentService.java](AppointmentService.java)
* [AppointmentTest.java](AppointmentTest.java)
* [AppointmentServiceTest.java](AppointmentServiceTest.java)

* *Description:* Java service files containing validation framework handling unique IDs, contact fields, and targeted JUnit 5 exception testing rules.

**Artifact 4: Project Two Summary and Reflections Report**
* [ProjectTwo.docx](ProjectTwo.docx)
* *Description:* Report outlining automated regression testing coverage, architectural optimization choices, and defensive software testing techniques.

---

## Reflection

#### How can I ensure that my code, program, or software is functional and secure?

To break down the testing approach, looking at the absolute requirements, such as the exact character limits, immutable and null rules from the assignment was the first step. Unit testing allows us to isolate individual classes and methods separate from an actual database or user interface. The JUnit coverage tool showcasing zero missed lines across all the files along with 100% coverage for all classes and packages. This way, we can ensure each line of code and the error catches inside the constructors, setters, and the update methods were completely ran and passed without skipping any branches. Restructuring the contact and new task package and test files to utilize the parameterized tests because the old way in module three was creating too much overhead also went well. Switching to an @ParameterizedTest with @ValueSource and @NullSource allowed passing multiple bad inputs into a single method, following the single responsibility principle of testing only one element per test and keeping the whole application running fast and as expected. All in all, it felt like rewriting this three times, and learning that the simple way is usually more secure is the main takeaway to keep things functioning and secure.

#### How did you interpret the user needs and turn it into a program?

Interpreting the requirements meant creating tests to specifically break the limits for each requirement and show that the exceptions work/reject as expected, to ensure the code will catch it and throw an exception. Evaluating multiple data structures matters because different projects have different setups. Since our milestones are serverless and run on local, in-memory HashMap structures, integration testing and mocking frameworks did not need to be implemented. However, they are used when an app hooks up to a live booking system. Thinking of other cases that would require more than the customer intended is also key to bring up to see if other features should be addressed. 

#### How did you approach designing software?

Structuring the test using the Arrange, Act, Assert format as best as possible was the main approach to help obtain 100% coverage and ensure the assertThrows blocks passed all raw null references directly to here, first. When designing the software architecture, the original plan was trying to wrap fields inside an Optional block for safety to prevent null values from being attacked. However, learning how the Optional method adds too much performance overhead and is better used as a return type, utilizing the standard if statements was best for this case. Consistency with previous packages was maintained for easier maintenance, and staying current with testing methodologies remains essential.
