package ua.lviv.lgs.minimum;

public interface Iterator {
    public boolean hasNext();
    public Integer next();
}
class Collection{
    private static Number[] arr;
    Collection (Number[] arr){
        this.arr=arr;
    }
    public class Forward implements Iterator{
        private int count = 0;

        @Override
        public boolean hasNext() {
            return count<arr.length;
        }

        @Override
        public Integer next() {
            return (Integer) arr[count++];
        }
    }
    public Forward createForward(){
        return new Forward();
    }
    public class Backward implements Iterator{
        private int count = arr.length-1;

        @Override
        public boolean hasNext() {
            return count>=0;
        }

        @Override
        public Integer next() {
            count=count-2;
            return (Integer) arr[count+2];
        }
    }
    public Backward createBackward(){
        return new Backward();
    }

    public Iterator createAnonymousIterator() {
        return new Iterator() {
            private int i = arr.length - 1;

            @Override
            public boolean hasNext() {
                return i >= 0;
            }

            @Override
            public Integer next() {
                return (Integer) arr[i--];
            }
        };
    }
    public Iterator createLocalIterator() {
        class LocalIterator implements Iterator {

            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < arr.length;
            }

            @Override
            public Integer next() {
                return (Integer) arr[i++];
            }
        }

        return new LocalIterator();
    }


    static class StaticIterator implements Iterator {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < arr.length;
        }

        @Override
        public Integer next() {
            return (Integer) arr[i++];
        }
    }

    static StaticIterator createStaticIterator() {
        return new StaticIterator();
    }
}
