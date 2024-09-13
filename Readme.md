# Spring

-   Java (객체 지향) 기반 Framework
-   객체 지향 애플리케이션을 개발할 수 있다.

### POJO (Plain Old Java Object)

Java로 생성하는 순수한 객체
<br>
객체 지향적인 원리에 충실하면서 환경과 기술에 종속되지 않고, 필요에 따라 재사용할 수 있는 방식으로 설계된 Object

### 객체 지향 프로그래밍

프로그램을 명령어 단위가 아닌 여러개의 독립된 단위로 표현하는 것.
<br>
프로그램을 유연하고 변경이 용이하다.

### 다형성

어떤 객체의 속성이나 기능이 상황에 따라 여러 가지 성질을 가질 수 있는 것

장점
<br>
역할과 구현을 분리하여 유연하고, 변경이 용이하다.
확장 가능한 설계를 할 수 있고 변경이 Client에 영향을 주지 않는다.
<br>
단점
<br>
역할의 변경은 Client와 Server 큰 영향을 끼치며, 구현의 복잡성이 증가한다.
<br>

Java의 다형성

-   역할 = Interface
-   구현 - Interface의 구현체
-   Overriding - 다형성으로 Interface를 구현한
    객체를 실행시점에 변경할 수 있음

### SOLID

#### SRP (Single Responsibility Principle) - 단일 책임 원칙

하나의 클래스는 하나의 책임만 갖는다.
<br>
하나의 책임은 모호한 표현 -> 변경을 기준으로 변경이 있을 때 파급 효과가 적다면 단일 책임 원칙을 잘 따른 것

#### OCP (Open Close Principle) - 개방-폐쇄 원칙

확장에는 열려 있으나, 변경에는 닫혀 있어야한다.
<br>
다형성을 활용하여 구현

문제점
<br> 구현체의 변경 시 Client 코드가 변경됨
<br> 객체의 생성, 연관관계를 맺는 별도의 조립, 설정자 필요

#### LSP (Liskov Substitution Principle) - 리스코프 치환 원칙

프로그램의 객체는 정확성을 깨뜨리지 않으면서, 하위 타입의 인스턴스로 바꿀 수 있어야 한다.
<br>
다형성에서 하위 클래스는 Interface 규약을 다 지켜야 한다.

#### ISP (Interface Segregation Principle) - 인터페이스 분리 원칙

특정 Client를 위한 Interface 여러 개가 범용 Interface 하나보다 낫다.
<br>
Ex. Car Interface -> Drive, Management Interface
<br>
Interface가 명확해지며, 대체 가능성이 높아진다.

#### DIP (Dependency Inversion Principle) - 의존 관계 역전 원칙

프로그래머는 추상화에 의존하고, 구체화에 의존하면 안된다.
<br>
구현 클래스가 아닌 Interface에 의존해야함
<br>
구현체에 의존하면 변경이 어려워 진다.

### 다형성만으로 OCP와 DIP를 지킬 수 없음 -> Spring Container와 DI
