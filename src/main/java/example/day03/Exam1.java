package example.day03;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class Exam1 {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.method1();  // - 부모 메소드가 아닌 오버라이드 메소드 실행된다. 
        subClass.method2(); // - 실행은 가능하지만, 권장하지 않음.

    // 1. 클래스의 정보 반환 [리플랙션]
    Class<TestClass> clazz = TestClass.class;
    // 2. 
    try{
        Method method = clazz.getDeclaredMethod("method3");
        // 3. 메소드의 어노테이션 확인
        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        // 4. 특정 어노테이션의 속성 확인
        System.out.println(annotation.value());
        System.out.println(annotation.data());
        // 5. 동적 로딩
        TestClass testClass = clazz.getDeclaredConstructor().newInstance();
        method.invoke(testClass);
    }catch(Exception e){System.out.println(e);}
     





    } // main end
} // class end
// [3] 어노테이션 만들기 : @interface
@Retention(RetentionPolicy.RUNTIME) // 해당 어노테이션 생명주기 : 실행 중 유지
@Target (ElementType.METHOD) // 해당 어노테이션 사용처 : 메소드
@interface  MyAnnotation{
    String value(); // 추상 메소드
    int data() default 1; // 어노테이션 속성 , default 값
}   

//[4] 어노테이션 주입/사용:
class TestClass{
    @MyAnnotation( value =  "안녕하시와요" ) // 내가 만든 어노테이션()
    void method3(){System.out.println("메소드3 실행");}
    @MyAnnotation( value = "안녕하셔와유")
    void method4(){System.out.println("메소드4 실행");}
}

class SuperCalss{void method1(){}}  // - 상위 클래스
class SubClass extends SuperCalss{
    @Override // [1] 어노테이션 (컴파일 or 실행중 해당 메소드를 사용하는 방법/주석을 명시)
    void method1() {super.method1();}
    @Deprecated // [ 2 ] Deprecated : (더 이상 사용하지 않을 때 명시)
    void method2(){}
} // - 하위 클래스


