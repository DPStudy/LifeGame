# LifeGame
디자인 패턴 학습을 위한 LifeGame 구현 연습

# CRC table

| Class | Responsibility    | Collaborators |
|-------|-------------------|---------------|
| Cell  | 하나의 셀의 상태를 표현 | Drawer : Cell을 그려달라고 요청함 |
| Board | Cell들을 생성 및 관계 설정 | Cell : 명령(상태 변경 및 업데이트)을 전달 <br> Drawer : Board를 그려달라고 요청함 |
| Timer | 주기적으로 tick을 발생시킴 | Board : tick을 날림 |
| Drawer | 화면에 board의 상태를 그림 | Board, Cell |
| User | 사용자의 입력을 받아 Board에 Cell을 추가함 | Board : cell 추가 요청 |
| Main | 프로그램의 Entry Point | .. 전체 ㅋㅋ |

# Diagram

![Class diagram](Class Diagram.png)

# Design Pattern

디자인 패턴 학습을 위해 과하게 사용할 예정

* Abstract Factory
 * Pass!
* Builder
 * Cell 생성에 사용
  * Director : Main class
  * Builder : Cell
  * Concrete Builder : NormalCell (...?)
  * Product : Cell
* Factory Method
 * Board 내에서 Drawer 생성에 사용
  * Creator : Board
  * Concrete Creator : NormalBoard
  * Product : Drawer
  * Concrete Product : ConsoleDrawer
* Prototype
 * Pass!
* Singleton
 * 사용자의 입력을 처리할 클래스를 하나만 유지하기 위한 용도로 사용
  * Singleton : User
* Adapter
 * Pass!
* Bridge
 * Pass!
* Composite
 * Board 가 Drawing할 때 Cell의 Drawing도 호출할 때 사용
  * Component : DrawUser (...)
  * Composite : NormalBoard
  * Leaf : NormalCell
* Decorator
 * Pass!
* Facade
 * Console 화면 출력에 필요한 명령어를 숨김
  * Facade : ConsoleDrawer
  * Subsytem Classes : Java console output classes
 * User 사용자의 입력을 받는 명령어를 숨김
  * Facade : User
  * Subsystem Classes : Java console input classes
* Flyweight
 * Pass!
* Proxy
 * Pass!
* Chain of Responsibility
 * Pass!
* Command
 * Pass!
* Interpreter
 * Pass!
* Iterator
 * java의 Collection Iterator를 사용할꺼예요
* Mediator
 * Cell이 다른 Cell들과 통신을 하기 위한 용도
  * Mediator : 생략
  * Concrete Mediator : CellMediator
  * Colleagues : NormalCell Objects
* Memento
 * Pass!
* Observer
 * Timer 에서 사용
  * Subject : Timer
  * Observer : Observer
  * Participant : Board
* State
 * Cell의 상태에 따라에 따라 동작을 구분
  * Context : Board
  * State : Cell
  * Concreate State : NormalCellState (? 두개 만들어야겠네..)
* Strategy
 * Pass!
* Template Method
 * Pass!
* Visitor
 * Pass!


