## 线程

### 创建线程

#### 继承Thread类方式

    public Thread(String threadName)
    public Thread()
    
#### 实现Runnable接口方式

    public class Thread extends Object implements Runnable
    public Thread(Runnable r)
    public Thread(Rrunnalbe r, String name)

    1. 建立Runnable对象
    2. 使用参数为Runnable对象的构造方法创建Thread实例
    3. 调用start()方法启动线程

#### 两种方法的比较

    实现Runnable接口的优缺点：
    从面向对象的角度来看，Thread类是一个虚拟处理机严格的封装，因此只有当处理机模型修改或扩展时，才应该集成该类；
    由于java技术只允许单一继承，所以如果已经继承了Thread类，就不能再继承其他任何类，这会使用户只能采用实现Runnable接口的方法创建线程。

    集成Thread类的优缺点：
    当一个run()方法体现在继承Thread的类中时，可以用this指向实际控制运行的Thread实例，因此，代码不再需要使用控制语句"Thread.currenThread().sleep()"，而可以简单地使用"Thread.sleep()"。继承Thread类的方法使代码变得简单易读。

当用户需要使线程从非可执行状态转换到可执行状态时，可以使用interrupt()方法，引用interrupt()方法可以使用如下代码：

### 线程控制

    new SleepingThread().interrupt()
    thread.wait(int ms)
    thread.wait()   thread.notify()
    thread.suspend()    thread.resume()

    thread.currentThread().getThreadGroup().getName()
    ThreadGroup group = new ThreadGroup("group")
    Thread thread = new Thread(group, "the first thread of group")



    

