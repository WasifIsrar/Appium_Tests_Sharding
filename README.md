# Appium_Tests_Sharding
Test Sharding for Android using Appium with TestNG

Running a large suite of Mobile App UI Tests running sequentially could take too much time. To counter this issue, we have TestNG's capability to divide tests to run on different devices.

Here we are running two classes in parallel. Each Class representing a TestNG test in TestNG.xml. We also have added a listener class which is made thread safe using ThreadLocal class of JAVA which ensures results are displayed correctly for each test.
