# bug report repository for spring gateway MVC

## summary

Adding spring-cloud-starter-gateway-mvc to a basic spring
boot project causes simple POST form controllers to fail. Request parameters are completely deleted. Debugging shows that the FormFilter of spring gateway mvc is the cause of this issue.

Also, if a required parameter is missing, the controller method is still executed, but the parameter is null.

## steps to reproduce

### 1. start the application

```shell
./gradlew bootRun
```

### 2. basic form submission

```shell
curl -v -X 'POST' 'http://localhost:8080/form' --da
ta-raw 'name=Bob'
```

Expected output:

    HTTP/1.1 200 OK
    Hello, Bob!

Actual output:

    HTTP/1.1 200 OK
    Hello, !

### 3. faulty form submission

```shell
curl -v -X 'POST' 'http://localhost:8080/form' --data-raw 'foo=bar'
```

Expected output:

    HTTP/1.1 400

Actual output:

    HTTP/1.1 200 OK
    Hello, !
