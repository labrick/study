## 异常类

    | ArithmeticException               | 算术异常类(RuntimeException)
    | ArrayIndexOutOfBoundsException    | 数组下标越界异常类(RuntimeException)
    | ArrayStoreException               | 将与数组类型不兼容的值赋值给数组元素时抛出的异常(RuntimeException)
    | ClassCastException                | 类型强制转换异常类(RuntimeException)
    | ClassNotFoundException            | 为找到相应类异常
    | EOFException                      | 文件已结束异常类
    | FileNotFoundException             | 文件未找到异常类
    | IllegalAccessException            | 访问某类被拒绝时抛出的异常
    | IndexOutOfBoundsException         | 当某对象(如数组或字符串)的索引超出范围时抛出该异常(RuntimeException)
    | InstantiationException            | 试图通过newInstance()方法创建一个抽象类或抽象接口的实例时抛出的异常
    | IOException                       | 输入输出异常类
    | NegativeArraySizeException        | 建立元素个数为负数的数组异常类(RuntimeException)
    | NullPointerException              | 空指针异常类(RuntimeException)
    | NumberFormatException             | 字符串转换为数字异常类(RuntimeException)
    | NoSuchFieldException              | 字段未找到异常类
    | NoSuchMethodException             | 方法未找到异常类
    | SecurityException                 | 小应用程序(Applet)执行浏览器的安全设置禁止的动作时抛出的异常(RuntimeException)
    | SQLException                      | 操作数据库异常类
    | StringIndexOutOfBoundsException   | 字符串索引超出范围异常(RuntimeException)

    catch(Exception e)
    Exception是try代码块传递给catch代码块的变量类型，e是变量名。
    getMessage()：输出错误性质
    toString()：给出异常的类型与性质
    printStackTrace()：指出异常的类型、性质、栈层次及出现在程序中的位置。

    以下四种情况下不执行finally语句块
    1. 在finally语句块中发生了异常
    2. 在前面的代码中用了System.exit()退出了程序
    3. 程序所在的线程死亡
    4. 关闭CPU
