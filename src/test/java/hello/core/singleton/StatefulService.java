package hello.core.singleton;

// ctrl + shift + t  지정한 class junit 생성
public class StatefulService {

 //   private  int price ; // 상태를 유지하는 필드

    public  int order(String name, int price){
        System.out.println("name = " +name+" price = " + price );
      // this.price= price;// 여기가문제
      return price;
    }


    //StatefulServiceTest할때필요했던것들
/*   public  int getPrice(){
     //   return  price;
    }*/


}
