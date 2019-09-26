package com.zhao.design.mode.iterator;

public class ContainerImpl implements Container {

    String[] names = {"zhangsan","lisi","wanger","zhouwu"};

    @Override
    public Iterator getIterator() {
        return null;
    }

    private class IteratorIml implements Iterator{

        int index;
        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            if(index >= names.length) {
                throw new RuntimeException();
            }
            return names[index ++];
        }
    }

}
