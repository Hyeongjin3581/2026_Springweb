package example.day06;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

public class Exam {
    public static void main(String[] args) {
         // [1] 리터럴 (상수) = 기본값
         int a = 3; 
         int b = 3;
         // 두 변수가 참조하는 값은 3 하나.

        // [2] 참조란? 어떠한 값의 위치
        String c = new String("유재석");
        String d = new String("강호동"); 
        // 두 변수가 참조하는 값은 총 2개 (인스턴스1개당 참조값 1개)
        Test t = new Test();
        t.name = new String("유재석");
        // t 변수가 참조하는 값 1개(1개 안에 1개가 또 들어있음.)  T -> 101번지 -> 201번지

        // 자바 참조
        // 1] '자유' 카테고리 등록
        Category c1 = new Category(1,"자유",new ArrayList<>() );
        // c1은 참조를 몇개 하고있을까? 1개. c1 -> category(101번지) 기본타입 제외. 

        //2] '자유' 카테고리에 게시물 작성
        Board b1 = new Board(1,"제목1",c1); 
        // b1은 참조를 몇개하고 있나요? 1개 b1 -> Board(101번지) - > Category(201번지) 기본타입 제외. 

        // *]  b1을 통해서 c1을 알 수 있나요? 가능하죠. Category통해 가능. 
        // 그래서 JPA개발자는 이 구조를 DB에 Join처럼 사용가능하다고 생각함.  단방향참조(FK)
        // c1을 통해서 b1을 참조할 수 있나요? nonono / category에는 board에 내용이 없으니 안됨 ㅇㅇ

        // JPA 개발자는 이 구조에서 영감을 받아서 양방향 참조를 떠올림. 

        // 3] category에 board를 넣어주자. 
        c1.getList().add(b1);
            // c1 - > category -> list(board)
            // *] c1을 통해 b1 참조가능해짐. 
        
            //b1 -> c1 -> b1 ->c1 ..... 무한참조 <순환참조>
            // 양방향쪽에 @ToString.Exclude 주입한다.
            // ToString() 이란? Object(슈퍼) 클래스의 객체 주소값 반환 함수
            // + 오버라이딩 : 객체 주소값 대신 문자열로 반환 함수(주로)

            //데이터베이스에서의 단방향 : 참조[FK] 테이블에 PK테이블의 PK값을 저장한다.
            //데이터베이스에서의 양방향 : x 없음 ㅋㅋ  , 참조/매핑 테이블  (실무적으로 권장x) join으로 하면 되니깐
            // 데이터베이스는 mapping테이블을 만들 필요가 없음 : join으로 해결 가능함. 
            // 실무에서는 양방향 비권장 : 불필요한 자료들까지 호출하기 때문. 

        System.out.println(b1);

    }
} //class end


@Data @AllArgsConstructor 
class Board{
    private int bno;
    private String btitle;
    private Category category;  // 참조 FK
}
@Data @AllArgsConstructor
class Category{
    private int cno;
    private String cname;
    @ToString.Exclude // toString 사용금지
    private List<Board> list = new ArrayList<>(); // 참조 FK 
}

class Test {
    String name;
}
