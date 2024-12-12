package telran.producer.consumer;

public class SimpleMessageBox implements MessageBox{
private String message;
    @Override
    synchronized public void put(String message) {
        this.message = message;
        notify();
    }

    @Override
    synchronized public String take() throws InterruptedException {
        while(message == null) {
            wait();
        }
        String msg = message;
        message = null;
        return msg; //may not be null
    }

    @Override
    synchronized public String poll() {
        return message; //it may be null
    }

}