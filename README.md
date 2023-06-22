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

# Feed 

### Base endpoint 
- BASE URL: http://localhost:8080/api/newsfeed

## Get feed

### Endpoint Info
  - endpoint: http://localhost:8080/api/auth/newsfeed
  - Type: GET


### Response
- 201 OK User was created
```bash
   {
    "content": [
        {
            "id": 1,
            "spot_id": "5IQfg3XiRgQpbKnbyiIDNx",
            "description": "my favorite song"
        }
    ],
    "pageNo": 0,
    "pageSize": 10,
    "totalElements": 1,
    "totalPages": 1,
    "last": true
}
```

## Create feed item

### Endpoint Info
  - endpoint: http://localhost:8080/api/auth/newsfeed
  - Type: POST
    
### Body
- [x] spot_id
- [x] description

### Response
- 201 OK User was created
```bash
 {
    "id": 3,
    "spot_id": "5IQfg3XiRgQpbKnbyiIDN2333",
    "description": "my favorite song222"
}
```

## Delete feed item

### Endpoint Info
  - endpoint: http://localhost:8080/api/auth/newsfeed/{id}
  - Type: Delete
    
### Response
- 201 OK User was created
```bash
  Item was sucessfully deleted. 
```

## edit feed item

### Endpoint Info
  - endpoint: http://localhost:8080/api/auth/newsfeed/{id}
  - Type: PUT

### Body
- [x] spot_id
- [x] description
    
### Response
- 201 OK User was created
```bash
 {
    "spot_id": "5IQfg3XiRgQpbKnbyiIDN", 
    "description":"my favorite song"
   
}
```

## Get single feed item
### Endpoint Info
  - endpoint: http://localhost:8080/api/auth/newsfeed/{id}
  - Type: GET

### Response
- 201 OK User was created
```bash
 {
    "spot_id": "5IQfg3XiRgQpbKnbyiIDN", 
    "description":"my favorite song"
   
}
```










