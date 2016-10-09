package ru.kostikov;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Алексей on 09.10.2016.
 */
public class IterConverterImp implements IterConverter{



    @Override
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        Iterator<Integer> result = new Iterator<Integer>() {
            Iterator<Integer> subIter = null;

            @Override
            public boolean hasNext() {

                while (it.hasNext() || subIter != null){
                    if (subIter == null){
                        subIter = it.next();
                    }

                    if (subIter.hasNext()){
                        return subIter.hasNext();
                    } else {
                        subIter = null;
                    }
                }
                return false;
            }

            @Override
            public Integer next() {

                if (!this.hasNext()){
                    throw new NoSuchElementException();
                }

                return subIter.next();
            }
        };

        return result;
    }
}
