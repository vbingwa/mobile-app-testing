Overview
This project contains automated tests for the sample mobile application provided by Sauce Labs. 
The tests are designed using Appium and Java for Android and cover key functionalities.

Requirements
Java: JDK 11 or later
Appium: Installed and running
Android Studio: For Android SDK and emulator
Maven: For dependency management
Node.js: Required for installing Appium via npm

Setup

1. Install Dependencies
Appium
Install Appium globally using npm:

npm install -g appium
Start the Appium server:

appium
Java
Ensure Java JDK 11 or later is installed. You can check this by running:


java -version
Set up your JAVA_HOME environment variable if not already set.

Maven
Ensure Maven is installed. You can check this by running:


mvn -version
If Maven is not installed, download and install it from the Maven website.

2. Project Setup
Clone this repository:


git clone https://github.com/your-repo/your-project.git
cd your-project
Navigate to the project directory and install the required Maven dependencies:


mvn clean install
Update the BaseTest class in src/test/java with the correct path to the App APK and device/emulator ID.

3. Test Data
The test data is stored in src/test/resources/testdata.json. Update this file with your test data if needed.

4. Running Tests
Ensure the Appium server is running.

Run the tests using Maven:

mvn test or IDE
This command will execute all the test classes in the src/test/java directory.


Test Data Management: Use the testdata.json file to manage test data.
Appium Server Not Starting: Ensure no other process is using port 4723.
Test Failures: Check the logs for details on failed tests and verify that the correct elements are targeted.
Contributing
