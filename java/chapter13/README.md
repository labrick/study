## 枚举类型

    java.lang.Enum...
    values()：将枚举类型成员以数组形式返回
    valuesOf()：将普通字符串转换为枚举实例
    compareTo()：比较两个枚举对象在定义时的顺序
    ordinal()：得到枚举成员的位置索引

### 枚举类型中的构造方法

    必须用private修饰符

### 枚举特点

    类型安全
    紧凑有效的数据定义
    可以和程序其他部分完美交互
    运行效率高

## 泛型

    泛型实质上就是使程序员定义安全的类型。
    Object类为最上层的父类，使用这些实例时，必须正确地将该实例转换为原来的类型，否则在运行时将会发生classCastException异常
    泛型的高级用法包括限制泛型可用类型、使用类型通配符等

    MutiOverClass<T1, T2>
    class 类型名<T extends anyClass>
    A<? extends List> a=null;
    a=new A<ArrayList>();
    a=new A<LinkedList>();

### 总结

    泛型的类型参数只能是类类型，不可以是简单类型，如“A<int>”这种泛型定义就是错误的。
    泛型类型个数可以是多个
    可以使用extends关键字限制泛型的类型
    可以使用通配符限制泛型的类型
    
