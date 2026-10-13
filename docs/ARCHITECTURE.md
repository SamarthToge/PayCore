# PayCore Architecture

## High-Level Flow

React Frontend
    ↓
Spring Boot REST API
    ↓
MySQL Database

Phase 2 additions:
    ↓
Redis for rate limiting/idempotency cache
    ↓
Razorpay Test Mode for wallet top-up
    ↓
Ledger service for double-entry accounting
