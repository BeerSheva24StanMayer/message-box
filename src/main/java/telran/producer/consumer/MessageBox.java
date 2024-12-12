package telran.producer.consumer;
public interface MessageBox {
    void put(String message);
    String take() throws InterruptedException;
    String poll();
}