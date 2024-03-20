# java-chess

체스 미션 저장소

## 기능 요구사항

### 게임

- [ ] 첫번째 턴은 흰색 진영이다.
- [ ] 첫 명령어가 start가 아닐 경우 게임을 종료한다.
- [ ] 게임 도중 명령어가 start일 경우 게임을 초기화한다.
- [ ] 기물이 이동할 수 없는 경우 턴을 넘긴다.
- [ ] 명령어가 end일 때까지 턴을 반복한다.
- [ ] King을 잡으면 게임을 종료한다.

### 체스판

- [x] 체스 게임을 할 수 있는 체스판을 초기화한다.
- [x] 기물의 가로 위치 값은 왼쪽부터 a ~ h이다.
- [x] 기물의 세로 위치 값은 아래부터 1 ~ 8이다.

### 기물

- [x] Rook, kNight, Bishop, Queen, King, Pawn
- [ ] 각 기물의 이동 규칙에 따라 이동한다.
- [ ] 이동할 수 없다면 예외가 발생한다.

### 입력

- [x] 게임 명령어를 입력받는다.
    - [x] start, move, end만 가능하다.
    - [ ] `move source위치 target위치`를 입력받는다.
- [x] 올바르지 않은 형태의 명령어가 입력될 경우 다시 입력받는다.

### 출력

- [x] 게임 시작 문구를 출력한다.
- [x] 기물이 없는 위치는 점(.)으로 표시한다.
- [x] 기물이 있는 위치는 이름의 첫글자로 표시한다.
- [x] 검은색 진영은 대문자, 흰색 진영은 소문자로 표시한다.

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
