#### Sample Requests

| Function | Request Type | URL | Request Body |
| -------- | ------------ | --- | ------------ |
| Save Employee | POST | localhost:8080/emp/save | ``{ "name": "Test" }`` |
| Get all Employees | GET | localhost:8080/emp/all |  |
| Get Employee by ID | GET | localhost:8080/emp/{empId} | |
| Delete an Employee | DELETE | localhost:8080/emp/{empId} |  |
| Update an Employee | PUT | localhost:8080/emp/update | ``{"id":1, "name":"Dev"}`` |