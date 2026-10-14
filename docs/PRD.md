# PayCore Product Requirement Document

## Problem
Students and users need a simple way to track income, expenses, and later use an internal wallet for safe app-to-app transfers.

## Phase 1 Features
- User registration
- User login
- JWT authentication
- Create accounts
- Create categories
- Add manual income/expense transactions
- Balance and Balance After recur transaction
- Who borrow money and from whom i borrow money.
- Goals and add Money in the goal.
- Scan receipt, Make transaction throw it and mange them.
- Add screenshot of upi app history or bank statement and add it in out app transaction.
- Recurring Transactions, Recharge management and auto set recur transaction.
- Investment tips also with risk %;
- Edit/delete transactions
- Monthly summary
- Category-wise report
- Dashboard charts

## Phase 2 Features
- Wallet creation
- Razorpay test-mode top-up
- Internal wallet transfer
- Transaction history
- Double-entry ledger
- Idempotency keys
- Concurrency control
- Admin reconciliation
- Redis rate limiting
- Notifications

## Out of Scope
- Real bank transfer
- Real UPI payout
- Production money handling
- RBI/PPI compliance

## Tech Stack
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- React.js
- Tailwind CSS
- JWT
- Razorpay Test Mode
- Redis
- Docker
- GitHub Actions