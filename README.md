# Social-Media-Profile-Application-Project

This README describes the social media application we've created for Project 5. We chose Option 2, which defines a social network "profile" application. There are 9 main classes used in the functionality of the program, and their descriptions and test cases will be detailed below.

Please ensure that the "usernames.txt" file exists with the Server and ClientHandler class.

##Server.java

Handles the creation of ServerSocket , DataInputStream and DataOutputStream objects for the server to communicate with a client, and creates a new thread for each client that connects to the server.

##ClientHandler.java

Accepts and processes user input from the GUI classes to manipulate the GUI and Profile classes, in order to handle the backend processing of the application. The run() method in ClientHandler constantly accepts a signal from the Client class, and accepts input and procceses it according to that signal. For example, the signal "1" is to register a new user, "2" is to try to login a user, "7" is to cancel a sent friend request, etc.

##Client.java

Creates Socket, DataInputStream and DataOutputStream objects in order for the client machine to communicate with the server. Then, starts the application GUI by displaying the login screen.

##LoginPage.java

Creates a GUI allowing the user to either login to an existing account, or go to a new GUI to register an account. The Login button sends information from the GUI to the server to check the username and password, allowing the user to login. When a user logs in, it sends them to the Profile GUI.

##Registration.java

Creates a GUI allowing the user to either register a new account, or go to a new GUI to login to an existing one. The registration button saves information from the GUI in a specific file for that user. That file is used for persistent data storage and retrieval of data throughout the application. When an account has been registered, it sends the user back to the Login GUI.

##ProfileGUI.java

Creates the GUI for a user looking at their own profile. The GUI contains the following features:

Profile Area - To view Bio, Username, Real Name, Likes, Birthday, Email, Education
Friends List - Lists all the users current friends
Friend Requests - Lists all the users current incoming friend requests. There are buttons to both accept and decline a given friend request.
All Users Tab - Lists all the users currently on the server. You can access anyone's profile by selecting their username and pressing the "Go to profile" button underneath it.
Search Bar - Allows you to search for a specific user on the server. You can go to their profile by selecting their username and pressing the "Go to profile" button.
Logout button - Logs the user out and returns to the login GUI.
Refresh button - Refreshes the page to check for any incoming friend requests.
Edit button - Allows user to edit the information in their profile. Takes them to the ProfileEditPage GUI
##OtherProfileGUI.java

Creates the GUI for a user looking at another users profile. The GUI contains the following features:

Profile Area - To view Bio, Username, Real Name, Likes, Birthday, Email, Education
Back Button - To return to the ProfileGUI for the specific user
Send/Cancel Friend Request - Sends or cancels a friend request to a specific user. The other user will see the friend request in their ProfileGUI.
Remove Friend - Removes the users as friends. If the users aren't friends, does nothing.
##ProfileEditPage.java

Creates the GUI for the edit page for a profile. Allows users to enter their information into the specified fields for each item, and includes a "Confirm" button that saves the changes made. Also includes a "Delete profile" button, which will remove the profile from the server, and remove any friends/friend requests the profile had with other users.

##Profile.java

Saves all the information for each profile in a class in order to get/set the values from that class. Also processes information from user file to the application to handle formatting.

##ProfileEditPage Testing

We have made sure that the Profile Edit Page class does have a test verifying that this class exists and inherits from the Object. We also made sure that each field in this class must have a test verifying that it exists, along with verifying it has the correct type and access modifier. In addition, we also checked if every method in this class does have a test verifying that it exists, along with verifying it has the correct return type and access modifier. 

##ProfileGUI Testing

We have made sure that the ProfileGUI class does have a test verifying that this class exists and inherits from the Object. We also made sure that each field in this class must have a test verifying that it exists, along with verifying it has the correct type and access modifier. In addition, we also checked if every method in this class does have a test verifying that it exists, along with verifying it has the correct return type and access modifier. 

##OtherProfileGUI Testing

We have made sure that the OtherProfileGUI class does have a test verifying that this class exists and inherits from the Object. We also made sure that each field in this class must have a test verifying that it exists, along with verifying it has the correct type and access modifier. In addition, we also checked if every method in this class does have a test verifying that it exists, along with verifying it has the correct return type and access modifier. 

##Profile Testing

We have made sure that the Profile class does have a test verifying that this class exists and inherits from the Object. We also made sure that each field in this class must have a test verifying including the constructor that it exists, along with verifying it has the correct type and access modifier. In addition, we also checked if every method in this class does have a test verifying that it exists, along with verifying it has the correct return type and access modifier. 

##GUI Testing

For the login and registration page GUI, we tested null input along with invalid inputs like if username already exists, incorrect password(not containing minimum of 8 characters), weak password, or if we entered any invalid email id(not containing “@“ sign). For the profile page GUI, we tested the friend lists with more friends than the size of a panel and made sure if our scroll bar works in that case. For the edit page GUI, we made sure that the name, email, likes and date of birth fields aren’t empty and also added the tool tip for text fields when cursor lingers over the component so that the user knows what format the date of birth and email is to be edited in.

##Server Testing

We made sure we connected multiple clients from the same system. We also made sure to test remote clients using the Purdue servers to see if our code works fine on Purdue’s system. We have also made sure that the Server class does have a test verifying that this class exists and inherits from the Object. We also made sure that each field in this class must have a test verifying that it exists, along with verifying it has the correct type and access modifier. In addition, we also checked if every method in this class does have a test verifying that it exists, along with verifying it has the correct return type and access modifier.

##ClientHandler Testing

We have made sure that the ClientHandler class does have a test verifying that this class exists and inherits from the Object. We also made sure that each field in this class must have a test verifying including the constructor that it exists, along with verifying it has the correct type and access modifier. In addition, we also checked if every method in this class does have a test verifying that it exists, along with verifying it has the correct return type and access modifier. 

##RegistrationTestCases.java

In the RegistrationTestCases class, the registrationClassDeclarationTest test case is the check for the appropriate creation of the Registration Class, with correct modifiers, superclasses, and interfaces to verify the properties of the class. This returns errors and the appropriate messages to fix the class and if the appropriate superclasses and interfaces are used, those messages don't appear in the terminal.

The FieldDeclarationTest methods are important to check the existence, modifiers, and correct data type of the variables. The same principle applies for the Label, Button, and text fields declaration tests, to check if the labels, buttons, and text fields are non-final and non-static, and of the correct type.

The method tests are important to confirm the return type, parameters, and expected exceptions for each of the methods. The methods in Registration class all have no parameters except for ActionPerformed and main method and the return type is void for all the methods. None of the methods have exceptions to check for either. The main method is the only method in this group that doesn't have a check for being static.

Lastly, the constructor test ensures the correct parameters are used while creating an instance of the class.

##LoginTestCases.java

In the LoginTestCases class, the loginClassDeclarationTest test case is the check for the appropriate creation of the login Class, with correct modifiers, superclasses, and interfaces to verify the properties of the class. This returns errors and the appropriate messages to fix the class and if the appropriate superclasses and interfaces are used, those messages don't appear in the terminal.

The FieldDeclarationTest methods are important to check the existence, modifiers, and correct data type of the variables. The same principle applies for the Label, Button, and text fields declaration tests, to check if the labels, buttons, and text fields are non-final and non-static, and of the correct type.

The method tests are important to confirm the return type, parameters, and expected exceptions for each of the methods. The methods in Registration class all have no parameters except for ActionPerformed and main method and the return type is void for all the methods. None of the methods have exceptions to check for either. The main method is the only method in this group that doesn't have a check for being static.

Lastly, the constructor test ensures the correct parameters are used while creating an instance of the class.
