## 文件类

### 创建文件类

    new File(String filePath)
    new File(String parent,String child)
    new File(File parent, String child)

### File类方法

    String getName()
    String getParent()
    String getPath()
    String getAbsolutePath()
    boolean exists()
    boolean isFile()
    boolean idDirectory()
    boolean isAbsolute()：判断是不是绝对路径
    boolean delete()
    boolean mkdir()
    boolean mkdirs()：创建路径中包含的所有父文件夹和子文件夹，如果所有父文件夹和子文件夹都成功创建，返回结果为true
    boolean setReadOnly()
    long length()：获取文件的长度
    long lastModified()
    String[] list()：获取文件夹中的文件和子文件夹的名称，并存放到字符串数组中
    File[] listFiles()：获取文件夹中的文件和子文件夹的名称，并存放到File类的数组中

### 文件字节输入/输出流

    new FileInputStream(File file)
    new FileInputStream(String filePath)
    new FileOutputStream(File file)
    new FileOutputStream(String filePath)

### 文件字符输入/输出流

    new FileReader(File file)
    new FileReader(String filePath)
    new FileWriter(File file)
    new FileWriter(String filePath)

### 带缓存的输入/输出流

    BufferedInputStream(InputStream in)：创建带有32字节的缓存区
    BufferedInputStream(InputStream in, int size)：创建指定大小的缓存区
    BufferedOutputStream(OutputStream out)：创建带有32字节的缓存区
    BufferedOutputStream(OutputStream out, int size)：创建指定大小的缓存区
    BufferedReader
        read()：读取单个字符
        readLine()：读取一个文本行，返回为字符串
    BufferedWriter
        write(String s, int off, int len)
        flush()
        newLine()：写入一个行分隔符

### 对象序列化

    Object object = readObject()：反序列化方法（从输入流中获取序列化的对象数据）
    Object object = writeObject()：序列化方法（将对象写入到输出流）
    注意这里Serializable接口是java.io.Serializable

## 文件及文件夹操作

    
