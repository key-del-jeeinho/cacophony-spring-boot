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

## Rename Legacy Words
> doSomething, trigger 등의 기획이 확실히 정립된 이후 사라진 단어들을 코드에서 제거한다

사용자 및 개발시의 워딩으로 인한 혼동을 방지하기위해 모든 참조변수 이름, 클래스 명, 메서드 명, 패키지 명 등에서 

2021.10.23 기준 최신버전인 Wiki 와 ReadMe 혹은 기획서 등에 기재되어있지 않은 워딩은 전부 기재된 워딩으로 변경한다 

단, 현재 Wiki 등에서 해당 워드와 상응하는 워딩을 찾을 수 없을경우 TODO 를 통해 이를 표시하고 **기술부채로서 남겨둔다**