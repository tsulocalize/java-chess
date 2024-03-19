# java-chess

체스 미션 저장소

## 기능 구현 목록

### 입력

- [x] 게임 시작을 입력 받는다.
- [x] 게임 종료를 입력 받는다.

### 출력

- [ ] 초기화한 체스판을 출력한다.
    - [ ] 룩은 R, 나이트는 N, 비숍은 B, 퀸은 Q, 킹은 K, 폰은 P로 출력한다.
    - [ ] 검은색 진영은 대문자, 흰색 진영은 소문자로 출력한다.
    - [ ] 기물이 없는 위치는 .을 출력한다.

### 도메인

- 체스판
    - [x] 체스 게임을 할 수 있는 체스판을 초기화한다.
        - [x] 검은색 룩은 a8, h8에 위치한다. 흰색 룩은 a1, h1에 위치한다.
        - [x] 검은색 나이트는 b8, g8에 위치한다. 흰색 나이트는 b1, g1에 위치한다.
        - [x] 검은색 비숍은 c8, f8에 위치한다. 흰색 나이트는 c1, f1에 위치한다.
        - [x] 검은색 퀸은 d8에 위치한다. 흰색 퀸은 d1에 위치한다.
        - [x] 검은색 킹은 e8에 위치한다. 흰색 킹은 e1에 위치한다.
        - [x] 검은색 폰은 a7~h7에 위치한다. 흰색 폰은 a2~h2에 위치한다.
- 기물
    - 기물은 진영을 가진다.
- 위치
    - 가로 위치, 세로 위치를 가진다.

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
