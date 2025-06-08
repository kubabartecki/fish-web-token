# API
## How to run
1. With frontend and db → use `docker-compose.yml` from the parent directory
2. Only backend → run `./gradlew bootRun`, but remember to have also db running

## How to use
### API documentation is available at `/swagger-ui/index.html` endpoint

#### Old API documentation:
1. Register account
- Use POST `/api/v1/auth/register` endpoint to register a user account
- In body pass JSON like: ```{
    "username": "a",
    "password": "a"
}```
- User will be created if a unique username is passed

2. Login
- Use POST `/login` endpoint
- In the body pass the same JSON as in registration
- In the Authorization response header there will be JWT

3. Get test data
- Use GET `/api/v1/fish/444` endpoint
- Pass JWT in the Authorization request header
