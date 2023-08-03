# Spring Boot Multipart File Upload example

### Rest APIs provided by the application:
1. POST /upload -  Uploading a file to a static folder
2. GET /files   -  Get the list of uploaded file names

#### Prerequisite
1. Java 17
2. Spring Boot 3.1.0
3. Maven


#### Request and Response samples

1. File upload curl request

```
curl --location 'http://localhost:8080/upload' \
--form 'file=@"/Users/Downloads/rsz_test_2995440.png"'
```

Sample response

```
File uploaded successfully: rsz_test_2995440.png
```

2. Get uploaded file names curl request

```
curl --location 'http://localhost:8080/files'
```

Sample response

```
[
    "2023-07-25.pdf",
    "Invoice 222162 from ABC Ltd.pdf"
]
```

