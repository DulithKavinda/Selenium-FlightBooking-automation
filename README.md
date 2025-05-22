# PHPTravels Automation Project

This is a complete Selenium automation project using Java, TestNG and Maven. It automates the user signup, login, hotel search, and booking confirmation flow on the PHPTravels demo website
(https://phptravels.net).


##  Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager

##  Features
- Page object model
- Explicit waits
- XPath/CSS selectors
- Assertions
- Screenshots on success/failure
- Full flow automation



##  Flight Booking Automation Test Case Description

This automated test case uses Selenium WebDriver and TestNG to simulate a complete flight booking process on https://phptravels.net/.

Steps performed:

1. Navigate to the Website
   - Launches the browser and opens https://phptravels.net/.

2. Select Flights Tab
   - Clicks on the "Flights" tab to begin flight search.

3. Enter Flight Search Details
   - From: SIN - Singapore Changi Airport
   - To: JFK - John F Kennedy International
   - Depart Date: May 22, 2025
   - Travellers: 1
   - Clicks the Search button

4. Filter and Select Flight
   - Applies "Direct" filter under Stops
   - Selects the first available flight from the list

5. Fill in Personal and Traveller Information
   - Personal Info:
     - First Name, Last Name, Email, Phone, Address
     - Nationality: Sri Lanka
     - Current Country: Sri Lanka
   - Traveller Info:
     - First Name, Last Name, Passport Number, Email, Phone

6. Choose Payment Method
   - Selects "Pay Later" option
   - Agrees to Terms and Conditions
   - Confirms booking

7. Confirmation and Exit
   - Verifies the invoice page is displayed
   - Captures screenshot of the invoice
   - Closes the browser
