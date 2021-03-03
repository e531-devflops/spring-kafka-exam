# spring-kafka-exam
Spring Boot와 Apache Kafka를 이용한 Pub/Sub 모델 예제

<br />

## 개발 환경
- macOS 11.2.1
- Ubuntu 20.04.2 LTS (VM)
- Spring Boot 2.4.3
- Apache Kafka 2.7.0 (Scala 2.13)
- OpenJDK 11

<br />

## 개발 환경 셋팅
### 1. Apache Kafka 설치
VM 우분투 리눅스 환경에서 진행합니다.
<br />
먼저 Apache Kafka를 내려받습니다.

```bash
wget https://www.apache.org/dyn/closer.cgi?path=/kafka/2.7.0/kafka_2.13-2.7.0.tgz
```
압축을 푼 뒤 해당 폴더로 이동합니다.
```bash
tar -zxvf kafka_2.13-2.7.0.tgz

cd kafka_2.13-2.7.0
```
다음 ```config/server.properties``` 파일을 수정합니다.
```bash
listeners=PLAINTEXT://0.0.0.0:9092
advertised.listeners=PLAINTEXT://xxx.xxx.xxx.xxx:9092 # 해당 VM의 IP 주소 입력
```

### 2. Apache Kafka 실행
Apache Zookeeper를 먼저 실행한 뒤 Apache Kafka를 실행해야 합니다.
```bash
bin/zookeeper-server-start.sh config/zookeeper.properties

bin/kafka-server-start.sh config/server.properties
```

### 3. topic 생성
해당 예제를 실행하기 위해선 먼저 topic을 생성해야 합니다.
```bash
bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic quickstart-events
```

<br />

## 테스트
이 프로젝트를 다운받고 프로젝트를 ```build/run```하시면 Pub/Sub 테스트가 가능합니다.<br />
이 프로젝트는 IntelliJ IDEA에서 작성되었습니다.
<br />
<br />

Postman을 이용하여 API를 통해 Publish를 할 수 있습니다.<br />
![API_CALL](https://user-images.githubusercontent.com/9658336/109131854-8845af00-7796-11eb-9c5f-bcb3e4454934.png) <br />
Publish에 성공하면 ```success```를 반환합니다.

<br />
해당 명령어를 통해 VM 환경의 터미널에서 Subscribe 된 메세지를 확인 할 수 있습니다.

```bash
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic quickstart-events
```

![RESULT](https://user-images.githubusercontent.com/9658336/109131866-8c71cc80-7796-11eb-8c3d-9033c1d7bf19.png) <br />
![RESULT](https://user-images.githubusercontent.com/9658336/109131870-8d0a6300-7796-11eb-9a40-8fecee8e30f0.png) <br />

위의 결과처럼 정상적으로 ```produce/consume```하는 것을 확인 할 수 있습니다.
