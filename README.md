**Why am I doing this?**

I am doing this project to showcase the skills I have learnt on this course, including the fundamentals of programming with Java, API development with Spring Boot, databases (H2, MySQL), and automated testing with JUnit & Mockito. I am also demonstrating my Project Management knowledge through the use of Git and Jira.

**How did I expect the challenge to go?**

I expected the coding of this challenge to be relatively achievable as I have worked diligently on this course, however I did expect to encounter some problems with testing. Additionally, I was unsure on how I would perform in the project managament aspect of this project.

**What went well / what didn't go as expected?**

I was successful in completing the challenge of developing an application backend with full CRUD functionality, including several custom queries and a custom exception. I also created successful unit and integration tests, which achieved over 90% coverage. I originally intended to create multiple custom exception but only managed one.

**What possible improvements could be made?**

This project could be improved with more custom exceptions. At present the database holds a table of Customer records, however it could also have a table of Employee records.


**Postman requests and the output from the API:**

Create Customer:
![image](https://user-images.githubusercontent.com/97603570/157475242-232cd766-8527-4bc6-97e6-a0efa1606b35.png)

Read All Customers:
![image](https://user-images.githubusercontent.com/97603570/157475755-1276effb-3330-4dbc-b337-5b7a5720f3dc.png)

Read Customer By Id:
![image](https://user-images.githubusercontent.com/97603570/157475915-4da8e41a-2079-4615-befe-0b6a79263d04.png)

Read Customer By Name:
![image](https://user-images.githubusercontent.com/97603570/157476085-d4ed7db6-8c56-4f55-8b1f-e7815fe476eb.png)

Read Customer By Phone:
![image](https://user-images.githubusercontent.com/97603570/157476229-76bc3db1-953c-4c8a-a0e2-158532d020f6.png)

Update Customer:
![image](https://user-images.githubusercontent.com/97603570/157476648-69d1b606-9a36-4931-b0d6-97a65ef9818b.png)

Delete Customer:
![image](https://user-images.githubusercontent.com/97603570/157477115-8a0b0e65-e03f-4091-bee6-eb4750ffea6a.png)


**Database:**
![image](https://user-images.githubusercontent.com/97603570/157477386-8c4dfbb3-20bb-4cc0-9e34-3aa492de26bf.png)


**Test results & Coverage report:**
![image](https://user-images.githubusercontent.com/97603570/157712664-9522610c-25e6-4467-af44-c1b11e2ebb92.png)


**Jira board:**
https://ellarobinson.atlassian.net/jira/software/projects/RFP/boards/2/roadmap?shared=&atlOrigin=eyJpIjoiMjgwMzJlNmE1ZjVjNDZjMjkwZWUxMzNiNzhmYmFjODYiLCJwIjoiaiJ9


**Risk Assessment:**

Risk: The application is broke.

Evaluation: Part or all of the functionality of the application doesn't work.

Likelihood: Medium

Impact Level: High

Response: Created Service Unit Tests and Controller Integration Tests.

Control Measure: Run tests before deploying.

---
Risk: Two or more customers are given the same ID.

Evaluation: The wrong customer's information is found, updated, or deleted.

Likelihood: Low

Impact Level: High

Response: Make "customerID" unique.

Control Measures: Annotated customerID as @ID @GeneratedValue(strategy = GenerationType.IDENTITY)

---
Risk: A customer record is made twice.

Evaluation: There is an out-of-date customer record in the database to be found and used incorrectly.

Likelihood: Low

Impact Level: Medium

Response: Make "phone" and "email" unique, so multiple records cannot be made with the same phone number or email address.

Control Measure: Annotated "phone" and "email" columns as @UniqueContraint

---
Risk: Customer details are accidentally changed when updating numOfVisits.

Evaluation: Customer's details are incorrect.

Likelihood: Medium

Impact Level: High

Response: Created a function to update numOfVisits by 1 and nothing else.

Control Measure: Use the "/updateVisit/{id}" function, rather than update the whole record.

---
Risk: Customer cannot be found because customerID is unknown.

Evaluation: The customer's information cannot be found.

Likelihood: High

Impact Level: Medium

Response: Created function to find a customer by their phone number.

Control Measure: Use the "/getByPhone/{phone}" function, rather than getById.
