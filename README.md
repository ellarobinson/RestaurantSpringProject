**Why am I doing this?**

I am doing this project to showcase the skills I have learnt on this course, including the fundamentals of programming with Java, API development with Spring Boot, databases (H2, MySQL), and automated testing with JUnit & Mockito. I am also demonstrating my Project Management knowledge through the use of Git and Jira.

**How did I expect the challenge to go?**

I expected the coding of this challenge to be relatively achievable as I have worked diligently on this course, however I did expect to encounter some problems with testing. Additionally, I was unsure on how I would perform in the project managament aspect of this project.

**What went well / what didn't go as expected?**

I was successful in completing the challenge of developing an application backend with full CRUD functionality, including several custom queries and a custom exception. I also created successful unit and integration tests, which achieved over 90% coverage. I originally intended to create multiple custom exception but only managed one.

**What possible improvements could be made?**

This project could be improved with more custom exceptions. At present the database holds a table of Customer records, however it could also have a table of Employee records.


**Postman requests & outputs, and in MySQL database:**

Create Customer:
![image](https://user-images.githubusercontent.com/97603570/157855627-508b281f-4ec0-4004-bf21-16b4633b62a5.png)
![image](https://user-images.githubusercontent.com/97603570/157855670-07bec8fe-e79f-4a71-b3f5-7dfd9e2dc86d.png)

Read All Customers:
![image](https://user-images.githubusercontent.com/97603570/157855735-0dcb6258-f0d2-4232-84a7-7481c7cc72cd.png)
![image](https://user-images.githubusercontent.com/97603570/157855789-83b086ef-b20c-4406-a248-7cb763bfa70a.png)

Read Customer By Id:
![image](https://user-images.githubusercontent.com/97603570/157855877-ec9a2d00-b693-4f5f-ad9d-555d23fe68c7.png)

Read Customer By Name:
![image](https://user-images.githubusercontent.com/97603570/157855911-1aaa8660-6020-4f3d-8ad4-5f9d7339fd0a.png)

Read Customer By Phone:
![image](https://user-images.githubusercontent.com/97603570/157855980-c8406b94-52a6-44ce-b19b-4f89e658438c.png)

Update Customer:
![image](https://user-images.githubusercontent.com/97603570/157856032-8a49be02-ba60-4c05-8b55-54d1e1c1246d.png)
![image](https://user-images.githubusercontent.com/97603570/157856083-7e694d5b-54b0-42dd-b625-360914176a85.png)

Update Customer Visits:
![image](https://user-images.githubusercontent.com/97603570/157856135-e10ba49e-0e25-4500-9faa-9842c9644460.png)
![image](https://user-images.githubusercontent.com/97603570/157856154-8db19a0a-cb64-4852-ab81-e7d7055d813b.png)

Delete Customer:
![image](https://user-images.githubusercontent.com/97603570/157856211-61fba916-4d7f-4fa6-a552-f4f53df44ceb.png)
![image](https://user-images.githubusercontent.com/97603570/157856237-4ec393e6-ead7-43cf-a47b-5de405b2d81b.png)


**Test results & Coverage report:**
![image](https://user-images.githubusercontent.com/97603570/157712664-9522610c-25e6-4467-af44-c1b11e2ebb92.png)


**Jira board:**
https://ellarobinson.atlassian.net/jira/software/projects/RFP/boards/2/roadmap?shared=&atlOrigin=eyJpIjoiMjgwMzJlNmE1ZjVjNDZjMjkwZWUxMzNiNzhmYmFjODYiLCJwIjoiaiJ9


**Risk Assessment:**

Risk: The application is broken.

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
