#**payment-demo**
***payment-demo*** is a demo web application based on *Spring*, *Angular* and many other technologies.

###**Application structure**

 - Login page (registration + login)
 - Home page (add/edit credit card details + logout)

Application allows you to navigate home.html if you have access to.  *Client management* module provides functionality to create  users. These users are used to login to the system.

The application has the following traits:

 - **Spring security secures access to resources** *(The server side won't get you data which you don't have access to. While angular will hide every element on the UI which should not be accessible by the user)* ;
 - **Spring MVC based RESTful web services** provides JSON answers on HTTP methods GET/POST
 - **ORM** based domain model;
 - **Server side validation**(Spring validators);
 - **Static web pages** i.e. HTML;
 - **Annotation based Spring and Hibernate configuration**;
 - **Use of in-memory database H2;

###**Technologies**:

 - **Java 8*;
 - **Spring Framework 4** *(Core, Boot, MVC, Transaction, Security, ORM)*;
 - **Hibernate Framework**;
 - **Gradle**;
 - **jUnit**;
 - **Java Script** (**AngularJS, Bootstrap**, ajax, *plugins*);
 -  **Bower**

### Quick setup:

 - Clone https://github.com/cscib/payment-demo
 - Run "bower install"
 - From Intellij run  PaymentDemoApplication


