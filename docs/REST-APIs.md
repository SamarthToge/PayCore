- Auth
1. POST /api/v1/auth/login
2. POST /api/v1/auth/logout
3. POST /api/v1/auth/register
4. POST /api/v1/auth/refresh

- User
1. POST  /api/v1/users
2. GET   /api/v1/users
3. GET  /api/v1/users/{email}
4. PUT  /api/v1/users/{userId}
5. DELETE  /api/v1/users/{email}

- Goals
1. POST  /api/v1/goals
2. GET   /api/v1/goals
3. PATCH /api/v1/goals/{id}
4. DELETE /api/v1/goals/{id}
   
- Borrow And Receive
1. POST  /api/v1/loans
2. GET   /api/v1/loans
3. GET   /api/v1/loans/{name=?}
4. PATCH /api/v1/loans/{id}
5. DELETE /api/v1/loans/{id}

- Receipts
1. POST  /api/v1/receipts
2. GET   /api/v1/receipts
3. GET   /api/v1/receipts/{id}
4. PUT   /api/v1/receipts/{id}
5. DELETE   /api/v1/receipts/{id}
   
- Statement or UPI app screenshot
1. POST  /api/v1/scans

- DashBoard

- Subscriptions

- Invests