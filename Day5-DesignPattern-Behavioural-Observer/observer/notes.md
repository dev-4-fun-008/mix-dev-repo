Observer Design Pattern
---------------------------

The Observer design pattern is a behavioral design pattern that allows an object, known as the subject, to maintain 
a list of dependents, known as observers, that are notified of any state changes automatically. This pattern is 
particularly useful when there is a one-to-many relationship between objects, where one subject's change in state 
should trigger updates to multiple observers.

Key Components
1. Subject (Observable):
    * Maintains a list of observers.
    * Provides methods to add, remove, and notify observers.

2. Observer:
    * Defines an interface or abstract class for updating objects.
    * Each observer registers itself with a subject to receive updates.

3. ConcreteSubject:
    * Implements the subject interface.
    * Keeps track of its state and notifies observers when changes occur.

4. ConcreteObserver:
    * Implements the observer interface.
    * Updates its state to match the subject's state when notified.

* Workflow
    * The subject holds a list of observers and broadcasts notifications whenever its state changes.
    * Observers receive the notifications and update themselves accordingly