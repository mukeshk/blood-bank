# blood-bank
Blood Bank Application

---------------------------------------------------------------------------------------
Account Rest End Points
---------------------------------------------------------------------------------------
## Create Member Account

*   End Point: /api/accounts/create 
*   Description: Create a member account with bank.
*   Method: POST
```
Request Body: 
{
  "address": {
    "addressLine1": "111, Rener Gateway",
    "addressLine2": "LewPath, Kansas",
    "city": "LewPath",
    "state": "Kansas",
    "zipCode": "12345"
  },
  "birthDate": "12/05/2019",
  "bloodGroup": "A_POSITIVE",
  "email": "joe.done@gmail.com",
  "firstName": "Joe",
  "gender": "MALE",
  "lastName": "Mathew",
  "middleName": "Done"
}
```
Response Body: 
```
83a081a7-a757-4b01-a236-988942b7f296
```
---------------------------------------------------------------------------------------
## Show all account members
* End Point: /api/accounts/
* Description: Show all members having account with bank.
* Method: GET
---------------------------------------------------------------------------------------
Response Body:   
---------------------------------------------------------------------------------------
```
[
  {
    "uuid": "83a081a7-a757-4b01-a236-988942b7f296",
    "firstName": "Joe",
    "middleName": "Done",
    "lastName": "Mathew",
    "email": "joe.done@gmail.com",
    "gender": "MALE",
    "bloodGroup": "A_POSITIVE",
    "birthDate": "2019-05-12",
    "address": {
      "addressLine1": "111, Rener Gateway",
      "addressLine2": "LewPath, Kansas",
      "city": "LewPath",
      "state": "Kansas",
      "zipCode": "12345"
    }
  },
  {
    "uuid": "2d4c8ba3-77c0-484b-aed5-9ba6edcd3238",
    "firstName": "Narendra",
    "middleName": "Mihir",
    "lastName": "Raj",
    "email": "test@gmail.com",
    "gender": "MALE",
    "bloodGroup": "A_POSITIVE",
    "birthDate": "1980-01-11",
    "address": {
      "addressLine1": "144, Chandani Chowk",
      "addressLine2": "Delhi 439301",
      "city": "Delhi",
      "state": "Delhi",
      "zipCode": "430320"
    }
  }
]
```
----------------------------------------------------------------------------------------
## Find Account Detail
* End Point : /api/accounts/{uuid}
* Description: Show account detail
* Method: GET
```
Request: http://localhost:8080/api/accounts/83a081a7-a757-4b01-a236-988942b7f296
```
{
  "address": {
    "addressLine1": "111, Rener Gateway",
    "addressLine2": "LewPath, Kansas",
    "city": "LewPath",
    "state": "Kansas",
    "zipCode": "12345"
  },
  "birthDate": "12/05/2019",
  "bloodGroup": "A_POSITIVE",
  "email": "joe.done@gmail.com",
  "firstName": "Joe",
  "gender": "MALE",
  "lastName": "Mathew",
  "middleName": "Done"
}
```
----------------------------------------------------------------------------------------
