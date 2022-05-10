정적 팩토리 메소드
=============

- 객체 생성 역할을 하는 클래스 메서드
- 장점
    - 이름을 가질 수 있어서 의미를 더 명확히 할 수 있다
    - 호출할 때 마다 객체를 생성하지 않고 캐싱가능
        - Enum, 객체 전역 변수 collection 등
    - (상속 사용시) 하위 자료형 객체 반환 가능
    - 객체 생성 캡슐화 가능
        - dto <-> entity시 속성을 들어낼 필요 없이 변환 가능

        ```java
        public class MenuDto {
          private String name;
          private int price;
        
          pulbic static MenuDto from(Menu menu) {
            return new MenuDto(menu.getName(), menu.getPrice());
          }
        }
        
        // 정적 팩토리 메소드
        MenuDto menuDto = menuDto.from(menu);
        
        // 생성자
        MenuDto menuDto = new MenuDto(menu.getName(), menu.getPice()); 
        ```

- **정적 팩토리 메서드 네이밍 컨벤션**
    - `from`: 하나의 매개 변수를 받아서 객체를 생성
    - `of`: 여러개의 매개 변수를 받아서 객체를 생성
    - `getInstance`|`instance`: 인스턴스를 생성. 이전에 반환했던 것과 같을 수 있음.
    - `newInstance`|`create`: 새로운 인스턴스를 생성
    - `get[OtherType]`: 다른 타입의 인스턴스를 생성. 이전에 반환했던 것과 같을 수 있음.
    - `new[OtherType]`: 다른 타입의 새로운 인스턴스를 생성.

출처 : [https://tecoble.techcourse.co.kr/post/2020-05-26-static-factory-method/](https://tecoble.techcourse.co.kr/post/2020-05-26-static-factory-method/)