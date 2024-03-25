# java-chess

## 체스 게임 설명

- 체스 게임은 화이트 팀과 블랙 팀으로 나뉜다
- 체스 게임이 시작되면 화이트 팀부터 한 수씩 턴이 진행된다

## 1-2단계 요구사항

콘솔 UI에서 체스 게임을 할 수 있는 기능을 구현한다.  
1단계는 체스 게임을 할 수 있는 체스판을 초기화한다.  
체스판에서 말의 위치 값은 가로 위치는 왼쪽부터 a ~ h이고, 세로는 아래부터 위로 1 ~ 8로 구현한다.

### 입력 요구사항

- [x] 체스 게임을 시작할지 여부를 입력받을 수 있다.
- [x] 체스 게임을 종료할지 여부를 입력받을 수 있다.
- [x] 체스 말의 이동정보를 입력받을 수 있다
  ```
  move b2 b3
  ```
    - [ ] 요구하는 형식의 입력이 들어오지 않으면 예외를 발생시킨다.

### 출력 요구사항

- [x] 체스판의 상태를 출력할 수 있다.
    - [x] 체스판의 초기 상태를 출력할 수 있다
    - [x] 매 턴마다 최신화된 체스판의 상태를 출력할 수 있다
- [x] 체스판에서 각 진영은 대문자(검은색)와 소문자(흰색)로 출력한다.

### 도메인 요구사항

- [x] 체스 보드 초기화
    - [x] 게임 시작시 체스판을 초기화할 수 있다.
    - [x] 체스판의 초기상태는 다음과 같다.
      ```
      RNBQKBNR
      PPPPPPPP
      ........
      ........
      ........
      ........
      pppppppp
      rnbqkbnr
      ```
        - [x] 체스판의 열은 왼쪽부터 a-h까지의 알파벳으로 이루어져 있다.
        - [x] 체스판의 행은 밑부터 1-8까지의 숫자로 이루어져 있다.
        - [x] 기물들은 화이트 또는 블랙의 색깔을 가진다.

    - [ ] 기물 이동
        - [x] 기물들의 위치는 체스보드 범위를 벗어날 수 없다.
        - [x] 기물들은 각자의 행마법을 따라 이동할 수 있다
            - [x] 룩은 직선으로 이동할 수 있다
            - [x] 비숍은 대각선으로 이동할 수 있다
            - [x] 퀸은 직선/대각선으로 이동할 수 있다
            - [x] 킹은 방향과 무관하게 1칸 이동할 수 있다
            - [x] 나이트는 알파벳 L자 모양으로 앞으로 두칸 이동한 다음 왼쪽, 오른쪽 으로 한칸 움직일 수 있다
            - [x] 폰의 행마법
                - [x] 폰은 초기 상태에서 한칸 또는 두칸씩 전진할 수 있다
                - [x] 폰은 초기 상태에서 움직인 이후에는 한칸씩만 전진할 수 있다
                - [x] 상대 기물이 한칸 대각선에 있다면, 이동할 수 있다

    - [x] 체스 보드
        - [x] 체스보드 상태를 업데이트 할 수 있다
            - [x] 기물들이 이동할 수 있다면 기물의 위치를 옮긴다
            - [x] 기물들이 이동할 수 없다면 기물의 위치를 옮기지 않는다
                - [x] 도착지에 같은 팀의 기물이 있다면 이동할 수 없다
                - [x] 비숍/룩/퀸은 이동 경로에 다른 기물이 있다면 이동할 수 없다

## 1-2단계 개선사안

### 1차 리뷰 개선 사안

#### domain

- board /ChessBoardCreator : 초기 위치 데이터 와 생성 책임 분리
    - NomalPieceSetting : 게임 초기 위치 데이터 저장 및 전달
    - ChesBoardCreator : 보드판 초기화 및 생성
- piece : 추상화 준위 일관화
    - 기존 : instanceOf를 통해 객체마다 행마 가능여부 판단
    - 수정 : chessBoard를 넘겨주어 piece가 행마 가능여부 판단
    - 수정 이유 : instanceOf 사용 지양 및 추상화 준위 유지를 통한 다형성 활용
- game/ChessGame : 턴제 도입
- position / Direction : 8방향 도메인
- position / DirectionJudge : 두 위치에 따른 방향 판단 책임
- position / Position
    - findPath 메서드 : start에서 destination까지의 직선/대각선 경유 경로 반환
    - 메서드 단순화 및 일관성 확대
- util/retryHelper : 오류 발생시 재입력을 도와주는 유틸 클래스

#### controller

- 게임 흐름 구체화
    - start 입력 받기
        - 예외 입력 시, `start를 입력해야 게임이 시작됩니다.` 안내 메세지 출력
        - 정상 입력 시, 게임 객체 생성 및 초기 게임판 상태 출력
    - 잘못된 커멘드 입력 시 오류 발생
    - end가 입력되기 전까지 game 실행
        - while(true)로 인한 무한루프 위험 개선

#### 기타 리팩터링 사안

- 테스트 커버리지 확대
- 클린코드화
