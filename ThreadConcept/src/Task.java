import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Task implements Runnable {
    List<Integer> myelements;

    Task() {
        myelements = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            myelements.add(i);
        }
        counter = 0;
    }

    volatile int counter;

    @Override
    public void run() {
        try {
            readerWriter();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void readerWriter() throws InterruptedException {
        System.out.println(System.currentTimeMillis());
        if(Thread.currentThread().getName().equals("Thread-0")){
            Thread.sleep(1000);
        }
        while (counter < myelements.size()) {
            System.out.println(System.currentTimeMillis()+" "+Thread.currentThread().getName() + " is printing now " + myelements.get(counter));
            counter++;
        }
    }
}
