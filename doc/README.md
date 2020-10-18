# 사용법

### compile.sh
java 코드들은 class파일로 컴파일하는 스크립트.

`./server.sh [java home directory]`

* java home directory: java home directory, 입력되지 않으면 환경변수로 설정되어 있다고 가정하고 경로없이 사용 

### server.sh
#### server를 실행시키는 스크립트, compile.sh가 사전에 실행되어야 한다.


`./server.sh [hostname] [port] [java home directory]`

`ex) ./server.sh 11.22.31.12 /usr/lib/jvm/jdk-11.0.8`

* hostname: rmi server의 hostname, 이 hostname을 이용하여 client에서 접속한다. 
  입력되지 않으면 hostname은 localhost ip
* port: rmi server의 port, 입력되지 않으면 1099
* java home directory: compile.sh와 동일

### client.sh
`./client.sh [hostname] [port] [java home directory]`

`ex) ./client.sh 11.22.31.12 2001 /usr/lib/jvm/jdk-11.0.8`

* hostname: 연결하고자 하는 RMI server의 hostname, 입력되지 않으면 localhost로 연결
* port: 연결하고자 하는 RMI server의 port, 입력되지 않으면 1099번 사용
* java home directory: compile.sh와 동일