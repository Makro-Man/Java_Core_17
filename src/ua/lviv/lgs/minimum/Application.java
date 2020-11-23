package ua.lviv.lgs.minimum;

public class Application {
    public static void main(String[] args) {
        Integer [] arr = {1,2,3,44,11,8,-9,22,45,-10};
        Collection collection = new Collection(arr);
        Iterator iteratorForward = collection.createForward();
        while (iteratorForward.hasNext()){
           Integer next = iteratorForward.next();
           if (next%2!=0){
               System.out.println("0");
           }else{
               System.out.println(next);
           }
        }
        System.out.println();
        Iterator iteratorBackward = collection.createBackward();
        while (iteratorBackward.hasNext()){
            Integer next = iteratorBackward.next();
            System.out.println(next);
        }
        System.out.println();
        Iterator iteratorAnonym = collection.createAnonymousIterator();
        int i =1;
        while (iteratorAnonym.hasNext()){
            Integer next = iteratorAnonym.next();
            if (i%3==0){
                if (next%2!=0){
                    System.out.println(next);
                }
            }
            i++;
        }
        System.out.println();
        Iterator iteratorLocal = collection.createLocalIterator();
        while (iteratorLocal.hasNext()){
            Integer next = iteratorLocal.next();
            if (i%5==0){
                if (next%2==0){
                    int a=next-100;
                    System.out.println(a);
                }
            }
            i++;
        }
        System.out.println();
        Iterator iteratorStatic = Collection.createStaticIterator();
        while (iteratorStatic.hasNext()){
            Integer next = iteratorStatic.next();
            if (i%2==0){
                if (next%2==0){
                    System.out.println(next-1);
                }
            }
            i++;
        }
    }

}
