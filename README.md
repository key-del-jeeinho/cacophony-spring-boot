![](https://img.shields.io/badge/download-v1.0.1RELEASE-blue) 
![](https://img.shields.io/badge/License-Apache2.0-lightgrey)
[ ![](https://img.shields.io/badge/Orign-JDA-brightgreen) ](https://github.com/DV8FromTheWorld/JDA)

<img align="right" src="https://github.com/key-del-jeeinho/cacophony-spring-boot/blob/master/logo.png" height="250" width="250">

# Cacophony Library

Cacophony 는 기존 자바진영의 Major Discord API 클라이언트인 
JDA 를 기반으로 개발된 Discord API Client Library 입니다.

기존 JDA 및 여타 Java DiscordAPI Client 들의 문제점을 해결함과 동시에 
**패셔너블하고 편리한 디스코드 봇 개발** 을 목표로 개발하였습니다.

## Summary | 요약
Cacophony Library 는 JDA 와 마찬가지로, 디스코드의 공식 문서에 의거하여 DiscordAPI 에서 지원중단된 API endpoint 나 프로토콜의 지원이 불가합니다.

_자세한 내용은 [Discord 문서](https://discord.com/developers/docs/reference) 를 참고해주세요_

- [Cacophony Library](#cacophony-library)
  - [Summary | 요약](#summary--요약)
  - [Usages | 사용법](#usages--사용법)
    - [Flow System](#flow-system)
    - [EntryPoint](#entrypoint)
  - [Download | 다운로드](#download--다운로드)
    - [Gradle](#gradle)
    - [Maven](#maven)
  - [Support | 문의방법](#support--문의방법)
  - [Wiki | 위키](#wiki--위키)

## Usages | 사용법

### Flow System
> 카코포니 라이브러리는 기본적으로 Entry -> Action 형태의 Flow 묶음으로 이루어져 있습니다

- Flow 의 구성요소

    Entry : Action 을 실행할 조건을 검사하는 블록

    Action : 봇에서 실행할 행동을 담은 블록

Flow 구조

- Cacophony 에 있는 특정한 Event 가 발생했을 때 (Entry) 다음 로직을 실행한다 (Action)
- 예를들어, 유저의 채팅이 감지되면(Entry), 채팅 내용을 log 에 출력한다(Action)

다음과 같은 Flow 를 모은 형태로 봇이 개발되게 됩니다

### EntryPoint
> 진입지점 메서드를 통해 더욱 간단하게 Flow 를 생성할 수 있습니다

```java
//Example001
when( //EntryBlock 을 설정하는 진입지점(EntryPoint = when)
    onChat().and().onJoin() //채팅이벤트나 입장이벤트가 발생했을경우 (EntryPoint = onChat)
).doSomething( //ActionBlock 을 설정하는 메서드
    //람다를 통해 Action 을 구현한다
    event -> System.out.println( 
        event.getClass().getSimpleName() + " 가 발생하였습니다!"
    )
).complete(); //완성된 Flow 를 디스코드 봇에 등록한다

//Example002
when( //EntryBlock 을 설정하는 진입지점(EntryPoint = when)
    onJoin() //입장이벤트가 발생했을경우 (EntryPoint = onJoin)
).doSomething( //ActionBlock 을 설정하는 메서드
    //람다를 통해 Action 을 구현한다
    event -> System.out.println( 
        event.getClass().getSimpleName() + " 가 발생하였습니다!"
    )
).complete(); //완성된 Flow 를 디스코드 봇에 등록한다
```
_[이곳](https://github.com/key-del-jeeinho/cacophony-spring-boot/tree/master/cacophony-example) 에서 더 많은 예제들을 확인하세요!_

진입지점은 Flow 나 Block 등을 더욱 편리하게 생성할 수 있도록 구성된 static method 입니다.

진입지점 method 로는 when(), onChat(), onReact() 등이 있습니다

_자세한 내용은 [위키](#wiki--위키) 에서 확인해주세요!_

```
💡 Entry 와 EntryPoint(진입지점) 은 **완전히 다른 개념** 입니다!!
헷갈리지 않도록 주의해주세요!
```

## Download | 다운로드

Cacophony Library 는 [MavenCentral](https://repo1.maven.org/maven2/io/github/key-del-jeeinho/) 에 등록되어있습니다!

### Gradle
```groovy
repositories {
    mavenCentral()
}

dependencies {
    //gradle 버전이 낮은경우, 'implementation' 을 'compile' 로 바꾸어주세요!
    implementation 'io.github.key-del-jeeinho:cacophony-spring-boot-starter:VERSION'
}
```

### Maven
```xml
<dependency>
    <groupId>io.github.key-del-jeeinho</groupId>
    <artifactId>cacophony-spring-boot-starter</artifactId>
    <version>VERSION</version>
</dependency>
```

```
💡 현재 해당 라이브러리는 Spring Boot 기반 환경에서만 작동합니다!

-> VanillaJava 를 사용하시는 분들은 추후 업데이트를 기대해주세요
```

## Support | 문의방법
[이곳](https://github.com/key-del-jeeinho/cacophony-spring-boot/issues) 에서 이슈를 작성하여 문의하시거나, 디스코드 `JeeInho#8790` 혹은 이메일 `velocia.developer@gmail.com` 으로 문의해주세요!

```
💡 이메일 문의시 답변까지 많은 시간이 소요될 수 있습니다. 되도록이면 Github Issue 나 Discord 를 통해 문의해주세요!
```

## Wiki | 위키
~~_COMMING SOON!_~~

<a href="https://github.com/key-del-jeeinho/cacophony-spring-boot"><img align="center" src="https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Fkey-del-jeeinho%2Fcacophony-spring-boot&count_bg=%2379C83D&title_bg=%23555555&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false"/></a>
