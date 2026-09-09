package example.day07;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Exam4 {
    public static void main(String[] args) {
        // 메소드 래퍼런스 : 람다식이 단순히 기존 메소드만 호출하는 경우 간결하게 표현하는 방법
        // 1. Integer.praseInt("문자"); // 문자 --> 정수 변환 함수

        Function<String , Integer> function1 = (x) -> {return Integer.parseInt(x);};
        Function<String , Integer> function2 = Integer::parseInt;
        System.out.println(function1.apply("10")); // "10" --> 10

        // 2. 
        List<String> names = List.of("유재석" , "강호동" , "신동엽" , "서장훈");
            // 1) 
            for(int i = 0; i<=names.size()-1;i++){
                System.out.println(names.get(i));
            }
            //3)
            names.stream().forEach((name) -> {System.out.println(name);});
            // 4) 메소드참조는 메소드명 명시하고 ()소괄호 작성하지 않는다.
            names.stream().forEach(System.out::println);

        // 3. 이름 글자수 출력하세요.
            for(int i=0;i<=names.size()-1;i++){
                System.out.println(names.get(i).length()); // 글자수
            }
            names.stream().map((name) -> {return name.length();}).forEach((result) -> {System.out.println(result);});
            // 메소드 래퍼런스 방식 , 주의할점은 메소드뒤에 () 소괄호 사용하지 않는다. 내부적으로 메소드 호출하는 구조
            names.stream().map(String::length).forEach(System.out::println);
            // 4. names 리스트 내 문자열 각각 대입하여 Student 객체 만드세요.
                // 전통방식
                List<Student> list1 = new ArrayList<>();
                for(int i=0;i<names.size();i++){
                    Student student = new Student( names.get(i) );
                    list1.add(student);
                }System.out.println(list1);
                // 스트림 API
                List<Student> list2 = names.stream().map((name) -> {return new Student(name);}).toList();
                // 메소드참조(래퍼런스)
                List<Student> list3 = names.stream().map(Student::new).toList();

    } // main end
}
class Student{
    private String name;

    @Override
    public String toString() {
        return "Student [name=" + name + "]";
    }

    public Student(String name){
        this.name = name;
    }
}
