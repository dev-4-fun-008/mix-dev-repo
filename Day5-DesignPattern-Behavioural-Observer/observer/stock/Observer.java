package designpatterns.behavioural.observer.stock;

public interface Observer<T> {
    void update(T data);
}
