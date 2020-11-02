#  실행 방법 및 테스트 결과
###  컴파일
* 기본 디렉토리에서 실행

#### arguments
- `java home directory` (optional): javac에 대한 환경변수가 설정되어 있지 않다면, java home directory를 인자로 넘겨주어야 한다.

	```
	// .java 파일들을 컴파일, java home directory는 optional
    ./compile.sh [java home directory]
    ex) ./compile.sh /usr/lib/jvm/jdk-11.0.8 
	``` 
### 서버 실행
* 실행에 앞서 `compile.sh`가 실행되어야 한다.
* out 디렉토리 안에서 실행되어야 한다.

```
cd out
./server.sh [host name] [port] [java home directory]
ex) ./server.sh 11.22.31.12 2001 
```

이런 결과가 나온다면 제대로 실행된 것이다

    ##############################
    # Starting rmiregistry
    ##############################
    ##############################
    # Starting rmi server
    ##############################
    [RMI-SERVER] START


#### arguments
- `host name` (optional) : server가 실행되는 컴퓨터의 public ip주소, 입력되지 않으면 localhost 사용
- `port` (optional) : RMI registry가 실행될 포트, 지정되지 않으면 1099번 사용
- `java home directory` (optional):  java, rmiregistry가 환경변수에 설정되어 있지 않다면 java home directory를 인자로 넘겨주어야 한다.

### 클라이언트 실행
* 실행에 앞서 `compile.sh`가 실행되어야 한다.
* out 디렉토리 안에서 실행되어야 한다. 

```
cd out
./client.sh [hostname] [port] [java home directory]
ex) ./client.sh 11.22.31.12 2001 /usr/lib/jvm/jdk-11.0.8
```

#### arguments
*  hostname (optional) : 연결하고자 하는 RMI registry의 hostname, 입력되지 않으면 localhost로 연결
*  port (optional) : 연결하고자 하는 RMI registry의 port number, 입력되지 않으면 1099번 사용
*  java home directory (optional) : java가 환경변수에 설정되어 있지 않다면 java home directory를 인자로 넘겨주어야 한다.

실행 시 이런 화면이 뜰 것이다.

    Choose the option
    1. get server date & time
    2. get local date & time

여기서 1번을 선택하면 remote object의 remoteDate 메소드를 호출하여 그 결과를 출력하며,
2번을 선택하면 이런 창이 뜬다

    Choose the language
    1. Korean
    2. English

여기서 선택하는 language 정보로 remote object의 regionalDate 메소드를 호출하여 그 결과를 출력한다.

## 로컬 환경에서 실행하는 경우

하나의 컴퓨터에서 server/client를 모두 실행하는 경우

    ./compile.sh
    cd out
    ./server.sh &
    ./client.sh

필요한 경우 chmod + x를 사용하여 실행 권한을 지정해줘야 한다.

## remote 환경에서 실행하는 경우

서버, 클라이언트용 컴퓨터가 다른 경우
server computer는 1099번, 1100번 포트가 반드시 열려있어야 한다.

### server computer

    ./compile.sh
    cd out
    ./server.sh [server computer의 ip address]

### client computer

    ./compile.sh
    cd out
    ./client.sh [server computer의 ip address]

## Testing

### 테스트 환경
서버와 클라이언트 모두
* Ubuntu 18.04 LTS
* java 11.0.8 2020-07-14 LTS
* Java(TM) SE Runtime Environment 18.9 (build 11.0.8+10-LTS)
* Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.8+10-LTS, mixed mode)

에서 테스트한 결과 정상적으로 작동하는 것을 확인했다.