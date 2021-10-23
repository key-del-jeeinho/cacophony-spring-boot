#feature/refactor | 해야할것들
## Feature Summary
### Dashboard
- feature 이름 : refactor
- feature 주 작업 : 기술부채 청산 및 코드 점검
- Feature 시작일 :  2021.10.23
- Feature 예상 종료일 : 2021.10.27

### Function Summary

기존 주먹구구식으로 짠 코드들을 검증하고, 개선할 수 있는 부분들은 개선한다.

이는 이후 여러 기능(simple command, action, vote, voice 등)을 지원하기 이전에, 

여유가 나는 시간에 현재 코드의 부채를 청산하여, 이후 레거시 코드로 인한 지연을 최소화하기 위함이다

또한 SOLID 원칙을 다시한번 상기하여 변경으로인해 기존 코드의 신뢰성이 떨어지지 않게 하기 위함이다.

## Add Test Code
> 언젠가 다가올 `버그의 지옥` 에 빠지지 않기 위해서

현재 작성된 코드들에 대한 테스트를 작성하고 수행한다

테스트 작성의 완료 기준은 JaCoCo plugin 의 TestCoverage 측정 방식중 Instruction 기준 80% 이상으로 한다.
## Add JavaDoc
> 위키로는 만족하지 못할 (나포함)모든 사람들을 위해서

새롭게 작성된 모든 코드들에 Javadoc 을 작성한다

자바독 작성의 완료 기준은 **모든 Class** 및 **사용자가 사용할 수 있는(즉 내부로직 처리용이 아닌) 
모든 Member**(Fiels, Method) 에 대해 doc 작성을 완료하는것으로 한다.
## Inspect Code
> 과연 내 코드가 얼마나 SOLID 원칙이나 OOP 개념을 적용하였는지 검사하고 refactor 한다

기존 코드들이 SOLID 원칙을 얼마나 지켰는지 검사한다

코드 검사 완료 기준은 IntelliJ 에서 지원하는 Class Diagram 기능으로 프로젝트 내 클래스들의 연관관계 다이어그램을 보았을때, 
SOLID 원칙을 포함한 OOP 기본원칙들에 위배되는 관계가 없고, 그 이외의 코드에서도 자신이 판단하였을때 코드가 효율적이지 않은 경우를 기준으로 한다.


## Rename Legacy Words
> doSomething, trigger 등의 기획이 확실히 정립된 이후 사라진 단어들을 코드에서 제거한다

사용자 및 개발시의 워딩으로 인한 혼동을 방지하기위해 모든 참조변수 이름, 클래스 명, 메서드 명, 패키지 명 등에서 

2021.10.23 기준 최신버전인 Wiki 와 ReadMe 혹은 기획서 등에 기재되어있지 않은 워딩은 전부 기재된 워딩으로 변경한다 

단, 현재 Wiki 등에서 해당 워드와 상응하는 워딩을 찾을 수 없을경우 TODO 를 통해 이를 표시하고 **기술부채로서 남겨둔다**