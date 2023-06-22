# Meowsic
Part of my spring learning Journey. This is Social media API where users can share their favorite artists using the spotify ids. The spotify api is called by the clien.


## TOOLS 
- java
- Spring boot

# Love API 

# User

### Base endpoint 
- BASE URL: http://localhost:8080/api/auth

## Register a user 

### Endpoint Info
  - endpoint: http://localhost:8080/api/auth/register
  - Type: POST

### Body
- [x] username property 
- [x] email Property 
- [x] password property

### Response
- 201 OK User was created
```bash
    User registered successfully
```

## Login 

### Endpoint Info
  - endpoint: http://localhost:8080/api/auth/login
  - Type: POST

### Body
- [x] usernameOrEmail
- [x] password

### Response
- 201 OK User was created
```bash
   {
    "accessToken": "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhbmdlbGR6YW1icmFubzk5QGdtYWlsLmNvbSIsImlhdCI6MTY4NzQ2ODQzNywiZXhwIjoxNjg4MDczMjM3fQ.53Qae9t8_5IKMN8F0Dk6Q1QUSwNthgvIjSy_Q4C5KyENz0Oy1G6LnsVqMJfCVN-c",
    "tokenType": "Bearer"
   }
```

