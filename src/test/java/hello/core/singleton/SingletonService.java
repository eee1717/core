package hello.core.singleton;

public class SingletonService {


    // SpringContainer를 사용하면 자동으로 싱글톤패턴이 적용된다.
    private  static  final  SingletonService instance = new SingletonService();

    public  static  SingletonService getInstance(){
        return  instance;
    }

  private  SingletonService() {

  }

  public  void  logic() {
        System.out.println("싱글톤 객체 로직 호출");
  }

}
