package example.day03;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class Exam2 {
    public static void main(String[] args) {
        Student s1 = new Student(); // 1. @NoArgsConstructor
        Student s2 = new Student("유재석",100,90);
        s1.setKor(100); //  3. @Setter
        System.out.println(s2.getKor()); // 4. @Getter
        System.out.println(s2.toString()); // 5. @toString
        //6. 빌더 패턴 이용한 객체 생성 , 장점 : 순서무관 , 선택적 대입 , 유연한 객체생성.
        Student s3 = Student.builder() // 빌더패턴 시작
                            .kor(100)
                            .name("강호동")
                            .math(90)
                            .build();
            // 즉] new 생성자명(); vs 클래스명.builder().build(); 
            // 클래스명.메소드명() , 메소드가 static 이면 객체가 필요없음. 
            // vs 객체명.메소드명() 차이점 : 인스턴스를 통해서 참조.  

    }
}

@NoArgsConstructor // 매개변수 없는 생성자 (자동) 생성 
@AllArgsConstructor // 전체 매개변수가 있는 생성자. (자동) 생성 
// @RequiredArgsConstructor // final 멤버변수의 생성자 (자동) 생성 
@Getter @Setter // private 멤버변수의 getter / setter 메소드 (자동) 생성 
@ToString
@Data // Getter + Setter  + RequiredArgsConstructor + ToString + EqualsAndHashCode 묶음팩
@EqualsAndHashCode // 객체내 멤버변수의 값 모두 비교 메소드 (자동) 생성
@Builder // 빌더 패턴 지원
class Student{
    // 1. 멤버변수
    private String name;
    private int kor; // 국어점수
    private int math; // 수학점수

    // 2. 생성자 - > 롬복의 어노테이션으로 대체. 
    // 3. getter setter  - > 롬복 어노테이션 대체 . 
}