# Report

## - Main goal:

Improve and automatize the current electricity billing system. Get rid of manual reading and
billing process

## - Design pattern used: Singleton.

Automated electricity billing system includes in itself one headquarter that provides its
services to many customers. As the basic principle of Singleton letsyou ensure that a class
has only one instance, while providing a global access point to this instance, it is a perfect fit
for our project. As we would use a database to collect and store data about customers it is
also good and safe choice due to single instance of such database

## - Classes created:

**Database** - main class of our project, where the Singletonpattern is implemented.
It has several features like: _findDebtors(), deleteCustomer(),addCustomer(),
calculateCosts(), newRandom(), getCustomer(), accountExist(), getInstance(), Database()._
The findDebtors() called every month by default to find the debtors and to switch off their
lights. The deleteCustomer() function is called by the customer if s/he refuses to use our
service. The addCustomer() function is called, when the new user wants to sign up to use
our service. The calculateCosts() function runs always to calculate costs of the users. The
newRandom() function is used to generate the amount of money for our system and for
customers. The getCustomer() function is used to check if the user exists in our system. The
accountExist() is used to check if the given email is used in our system. The getInstance() is
used to create a Singleton class. The Database() is a just constructor.

**Customer** - consists of information about the user.Includes account details and some
functions users can operate with, such as making payments, checking the balance, and
watching the history of bills.
The following functions belong to Customer class:
+ _makePayment( float payment )_ : void - this functionallows a customer to add some
amount of money to the balance. If the customer can pay some bill fully, the function
decreases the balance and sends the amount of money to close that bill. The function
doesn't return anything.
+ _getSummary(): List<Bill>_ - the function returnsall bills that a customer has ever had.
+ _getRemainder(): float_ - the function returns theamount of money needed for a customer
to close the debts.
+ _getBalance()_ : float - returns the balance of acustomer.
+ _setToDebtor()_ : - If the user doesn't have enoughmoney in his/her balance, the function
will be called to set the state of the customer to debtor.


+ _updateCurrentBill(int month, int year): void_ - The function will be called when the month is
ended. The function adds the bill of the months that just ended to the list of all bills that
customer has.

**Account** - contains private fields of emails and passwordsfor each customer. Provide
getters for email and password, while providing only the setter for the passport

**Bill** - Has information about the current state ofthe user according to a particular month.
Uses a boolean variable to indicate the state of the customer. True sets if the customer paid
for a month otherwise it is False and the user considered as a debtor.



