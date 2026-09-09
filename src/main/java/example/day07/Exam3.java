package example.day07;

import java.util.Comparator;
import java.util.List;

public class Exam3 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // 1. 컬렉션(List/Set/Map) 순회
            //1) 일반 for문
            for(int index = 0 ; index <= numbers.size()-1 ; index++){
                System.out.println(numbers.get(index));
            }
            // 2) 향상된 for문
            for(Integer data : numbers){
                System.out.println(data);
            }
            // 3) forEach 문
            numbers.forEach((data) ->{
                System.out.println(data);
            });

            // 2. 스트림API , 리스트객체.stream().중간연산1().중간연산2().최종연산();
            // 1) stream().forEach((순회변수명 ) -> {실행문}) / return 이 없는 단순 순회 제공
            numbers.stream().forEach((data) -> {System.out.println(data);});
            // 2) stream().map((순회변수명) -> {return값;}).최종연산(); / return 있는 순회 제공
            List<Integer> newList = numbers.stream().map((data) -> {return data;}).toList(); 
            // 3) stream().filter( (순회변수명) -> {return 조건식;}).최종연산(); / boolean 으로 값 반환
            List<Integer> newList2 = numbers.stream().filter((data) -> {return data % 2 ==0;}).toList();
            // 4)  stream().sorted().최종연산(); 오름차순 /  sorted(Comparator.reverseOrder()) 사용시 내림차순.
            List<Integer> newList3 = numbers.stream().sorted(Comparator.reverseOrder()).toList(); 
            // 5) stream().distinct().최종연산(); 중복제거후 반환. / 중간에.Limit(개수)사용시 개수만큼 반환  
            List<Integer> newList4 = numbers.stream().distinct().limit(3).toList();
            // 6) 중간연산은 여러번 가능 , 최종연산은 1번만 가능.
            List<Integer> newList5 = numbers.stream()
                                                                    .distinct()
                                                                    .filter((x) -> {return x % 2 == 0;})
                                                                    .map((x) -> {return x;})
                                                                    .sorted(Comparator.reverseOrder())
                                                                    .limit(3)
                                                                    .toList();
            System.out.println(newList5); // [10, 8, 6]
            // *) JPA에서 Entity <--> DTO 변환과정에서 사용됨.

            //메서드	return의 의미
            // filter()	   이 데이터를 통과시킬지 여부를 boolean으로 반환
            // map()	이 데이터를 어떤 값으로 바꿀지 새로운 값을 반환

            // 스트림이란? 컬렉션(리스트) 인스턴스를 흐름단위로 중간연산과 최종연산 제공 API(미리만든클래스/메소드)
            // 메소드레퍼런스API : 미리 만들어진 메소드를을 간편하게 호출하는 방법 제공 API
            // System.out.println("메소드호출 정석"); --> System.out : : print("메소드호출 래퍼런스방식");


    } // main end
}
