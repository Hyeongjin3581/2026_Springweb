package example.day07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Exam1 {
    public static void main(String[] args) {
        TestService testService = new TestService();
        int result1 = testService.plus(3,5);


        int result3 = TestService.plus2(10,5);

        // @Autowired private TestService testService;
        // int result4 = testService.plus(10,5)


        // 인스턴스(주체p) VS static(주체x)
    }
}

@Component 
class TestService{
    // private TestService(){
    // private static final TestService instance = new TestService();
    // public static TestService getInstance(){return instance;}

    int plus (int x , int y){return  x + y;}
    static int plus2(int x , int y){return x  + y ;}

    void 달리기(){
        System.out.println( this );
    }
}