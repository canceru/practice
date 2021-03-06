package user;

import operation.IOperation;

public abstract class User {
    protected String name;

    protected IOperation[] iOperations;

    public User(String name) {
        this.name = name;
    }

    public abstract int menu();


    public IOperation doOperation(int choice) {
        return this.iOperations[choice];
    }

}
