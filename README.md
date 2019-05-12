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
----------------------------------------------------------------------------------------
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
Branch Rest End Points
---------------------------------------------------------------------------------------
## Create Branch

*   End Point: /api/branches/create 
*   Description: Create a branch
*   Method: POST
```
Request Body: 
{
  "address": {
    "addressLine1": "192, Likon Road",
    "addressLine2": "Swis saffaire estate",
    "city": "LewPath",
    "state": "Kansas",
    "zipCode": "12345"
  },
  "branchName": "Likon Branch",
  "contactEmail": "sam.joseph@gmail.com",
  "contactNumber": "9839303930",
  "manager": "Sam Josepth"
}
```
Response Body: 
```
a1a7c444-7ad3-49b9-8326-202db37204e2
```
---------------------------------------------------------------------------------------
## Show all branches
* End Point: /api/branches/
* Description: Show all branches
* Method: GET
---------------------------------------------------------------------------------------
Response Body:   
---------------------------------------------------------------------------------------
```
[
  {
    "uuid": "e89defa8-b91f-48dc-8731-f3c83fedfc43",
    "branchName": "Likon Branch",
    "manager": "Sam Josepth",
    "contactNumber": "9839303930",
    "contactEmail": "sam.joseph@gmail.com",
    "address": {
      "addressLine1": "192, Likon Road",
      "addressLine2": "Swis saffaire estate",
      "city": "LewPath",
      "state": "Kansas",
      "zipCode": "12345"
    }
  },
  {
    "uuid": "a1a7c444-7ad3-49b9-8326-202db37204e2",
    "branchName": "Likon Branch",
    "manager": "Ram Josepth",
    "contactNumber": "9832203930",
    "contactEmail": "ram.joseph@gmail.com",
    "address": {
      "addressLine1": "200, Likon Road",
      "addressLine2": "Ravine saffaire estate",
      "city": "LewPath",
      "state": "Kansas",
      "zipCode": "12345"
    }
  }
]
```
----------------------------------------------------------------------------------------
## Find Branch Detail
* End Point : /api/branches/{uuid}
* Description: Show branch detail
* Method: GET
----------------------------------------------------------------------------------------
Request: http://localhost:8080/api/branches/a1a7c444-7ad3-49b9-8326-202db37204e2
```
{
  "branchName": "Likon Branch",
  "manager": "Ram Josepth",
  "contactNumber": "9832203930",
  "contactEmail": "ram.joseph@gmail.com",
  "address": {
    "addressLine1": "200, Likon Road",
    "addressLine2": "Ravine saffaire estate",
    "city": "LewPath",
    "state": "Kansas",
    "zipCode": "12345"
  }
}
```
----------------------------------------------------------------------------------------
