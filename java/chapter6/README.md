虚类（抽象类）的抽象方法调用时真正调用的他的子类的方法；
比如，Fruit为虚类：
    Apple extends Fruit
    Fruit apple = new Apple();
    此时Fruit类的apple的虚类方法实际是Apple类中的具体方法；
