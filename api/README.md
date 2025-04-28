# API
## How to run

## How to use
1. Register account
- Use POST `/api/v1/auth/register` endpoint to register a user account
- In body pass JSON like: ```{
    "username": "a",
    "password": "a"
}```
- User will be created if unique username will be passed

2. Login
- Use POST `/login` endpoint
- In body pass same JSON as in registration
- In Authorization response header there will be JWT

3. Get test data
- Use GET `/api/v1/fish/444` endpoint
- Pass JWT in Authorization request header
