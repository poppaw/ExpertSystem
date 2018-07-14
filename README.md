# ExpertSystem
In the field of Artificial Intelligence, an expert system is a computer system/program that emulates the decision-making ability of a human expert. Expert systems are designed to solve complex problems by reasoning about knowledge, represented mainly as if-then rules rather than through conventional procedural code. The first expert systems were created in the 1970s and then proliferated in the 1980s. Expert systems were among the first truly successful forms of artificial intelligence (AI) software.

An expert system is divided into two subsystems: the inference engine and the knowledge base. The knowledge base represents facts and rules. The inference engine applies the rules to the known facts to deduce new facts. Inference engines can also include explanation and debugging abilities.

# Your task
### 1. Chose a topic where you are an expert or assumed to be one
* buying advisor (cars, computer parts, etc.), trip advisor, disease/symptome expert ("doctor" system), computer "error" diagnostic tool ("is your PC plugged in?"), etc.
* don't choose/create a super-duper complicated topic ;)
* make it fun :)
### 2. Create a ruleset in XML format that contains the rules
* this contains the questions your expert system will ask its users
### 3. Create a knowledge base in XML that contains the facts
* the expert system will match user answers against these facts
* if there's one or more match it'll present its findings to the user
### 4. Implement the design in Java according to the diagram: *ExpertSystem.png*
### 5. Implement a simple Java console application that helps users to decide in your program's area of expertise

## Example - Car Buying Advisor
Let's assume we're writing an expert system that helps people to choose buying a car. 
It asks a series of questions and based on users answer tries to select one or more match the user.

##### Rules
In the *Rules.xml* file there are 3 questions and possible answers to that question a user can choose from. 
For example when the program ask a question based on the 2nd Rule (id="comfort") the user can select from the values comfort and   speed. 
If the user chooses comfort then his answer to this question is considered true (because of the value="true" attribute).

##### Facts (knowledge-base)
The *Facts.xml* contains facts, which means in the context in our example if the user who plans to buy a car answers question 
in a way that the "family", "money", "comfort" and "luxury" related questions (identified by their id) 
in a negative way (with an answer evaluating to false) then the expert system will advise her to buy a Lada :)

