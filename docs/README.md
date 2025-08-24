# 기능 목록

## Model

--- 
### [x] BaseballNumber
- 숫자를 관리한다.(Collection 사용 - 일급 콜렉션) 
    - 서로다른 숫자.
    - 3자리 숫자
    - 1~9 범위의 숫자.
    - 잘못된 값이 들어오면 IllegalArgumentException을 발생시킨다.
- 입력받은 숫자와 컴퓨터가 가지고 있는 BaseballNumber를 비교하여 값을 출력한다.
  - Map<BaseballState, Integer> 반환.
  - Nothing 상태일 경우 EmptyMap 반환.


### [x] BaseballState
- 값을 관리한다. (Ball, Strike, Nothing)
- 뷰에 전달 될 값을 관리한다.(?)


### [x] BaseballNumberGenerator
- 숫자를 생성한다.
    - BaseballNumber 의 상수값을 이용한다. 
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.

### [x] BaseballGame
- 멤버 변수 BaseballNumber, BaseballNumberGenerator를 갖는다.
- 주입된 BaseballNumberGenerator 를 이용 해서 숫자를 생성한다.
- 한 라운드를 진행하고 결과를 리턴한다.
- 게임이 끝났는지 체크할 수 있다.
    - 이전에 들어온 값을 저장하여 체크한다.

## View

--- 
### 입력
- 서로 다른 3자리의 수
- 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수
---
### 출력

- 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시
    - 볼, 스트라이크 순서
    - 하나도 없는 경우 낫싱
  

```
1볼 1스트라이크
```

- 하나도 없는 경우

```
낫싱
```

- 3개의 숫자를 모두 맞힐 경우

```
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
```

- 게임 시작 문구 출력

```
숫자 야구 게임을 시작합니다.
``` 
---
## 실행 결과 예시

```
숫자 야구 게임을 시작합니다.
숫자를 입력해주세요 : 123
1볼 1스트라이크
숫자를 입력해주세요 : 145
1볼
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1스트라이크
숫자를 입력해주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1볼
...
```
