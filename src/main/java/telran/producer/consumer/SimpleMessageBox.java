package telran.producer.consumer;

public class SimpleMessageBox implements MessageBox {
    private String message;

    @Override
    synchronized public void put(String message) throws InterruptedException {
        while (this.message != null) {
            wait();
        }
        notifyAll();
    }

    @Override
    synchronized public String take() throws InterruptedException {
        while (message == null) {
            wait();
        }
        String msg = message;
        message = null;
        notifyAll();
        return msg;
    }

    @Override
    synchronized public String poll() {
        if(message != null) {
            message = null;
            notifyAll();
        }
        return message;
    }
}