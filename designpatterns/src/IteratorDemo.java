/**
 * 迭代器模式
 *
 * 不关心容器的内部结构，可以遍历
 * http://blog.csdn.net/zhengzhb/article/details/7610745
 * http://www.tutorialspoint.com/design_pattern/iterator_pattern.htm
 * Created by Tikitoo on 2015/12/2.
 */
public class IteratorDemo {
    public static void main(String[] args) {
        NameRepo nameRepo = new NameRepo();
        for(Iterator iter = nameRepo.getIterator(); iter.hasNext();) {
            String name = (String) iter.next();
            System.out.println("name: " + name);
        }
    }

}

interface Iterator {
    boolean hasNext();

    Object next();
}

interface Container {
    Iterator getIterator();
}

class NameRepo implements Container {
    String names[] = {"Rebort", "John", "Mark", "Micheal"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    class NameIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
