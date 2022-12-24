# Roll_The_Dice - Roll The Dice!
Link to application: http://localhost:3000
Roll The Dice is a local multiplayer game about 2 players rolling 2 dice each and then getting points if they win the dice duel.

It was built using Visual Studio Code, IntelliJ, and the database is kept and managed on Postman. I used axios in Visual Studio Code.

To run the project, we need to open and run the IntelliJ project, then open a command prompt, switch to the directory of the visual studio folder, and launch "npm start" at the root. This will launch the website.

The biggest challenges I faced with this project were basically everything related to IntelliJ, from building the project to linking it with Visual Studio. I solved the first part of this by basing my project on the Teacher App we did in class and that was submitted on Léa. The second part, I solved by mioing the teacher a lot and searching on the internet through forums and tutorials. Features I hope to impement in the future are almost everything related to the achievements, because I never figured out how to set up a goal that is completely written by the user to be able to be verified as completed or not, since it can be anything, even impossible things, tasks that don't make sense, or contain typos which could confuse the code.

In my IntelliJ project, I have a Player object which is linked One-To-One with an achievements object, since each player only has one goal, and Many-To-One with a Team object since many Players can be in one Team. However, When building a Player object, putting a Player in a team is optional. All of these classes have a Request and a Response class, and Player and Team have a Controller, Repository, and Service.

In my Visual Studio Project, my main class, App.js, renders a Main Menu item, which contains the basics of a Main Menu, like the title and logo. That Main Menu renders a Profile Pick object, a Player Stats object, a Team Stats Object, and a Password Object. Profile Pick contains a Table with all the Players and 2 input boxes for each player to choose their profiles. Player Stats contains a table with all of the player's stats and a form to add a new player. Team Stats is the same thing, but with Teams instead of Players. Password is an input box used o enter a password to access the admin corner, where you can delete profiles or edit profile names. Profile Pick renders a Match object, which is just 2 buttons that roll the players' dice and show the results. Match renders a Match Result object which shows who won the round and the new scores.

End-Points:
 - Get All Players: http://localhost:8081/api/players , GET
 - Get All Players by userName: http://localhost:8081/api/players?userName={userName} , GET
 - Add Player: http://localhost:8081/api/players , POST
 - Delete Player: http://localhost:8081/api/players/{playerId} , DELETE
 - Get All Players in Team: http://localhost:8081/api/players/{teamId}/team , GET
 - Add Player in Team: http://localhost:8081/api/players/{teamId}/team , POST
 - Update Player: http://localhost:8081/api/players/{playerId} , PUT
 - Get All Teams: http://localhost:8081/api/team , GET
 - Get All Teams by Id: http://localhost:8081/api/team/{teamId} , GET
 - Add Team: http://localhost:8081/api/team , POST
