## Collection接口的常用方法

    addAll(Collection)：添加Collection中所有元素
    add(element)：添加一个元素
    removeAll(Collection)：移除包含在该集合中的元素
        note:Iterator一旦定义之后，list就不能在进行修改，不然就会出现错误
    retainAll(Collection)：仅保留同时存在该Collecion中的元素
    containsAll(Collection)：是否存在该Collecion中的所有元素
    toArray()：获得一个包含所有对象的指定类型的数组

## List集合

    add(int index, Object obj)
    addAll(int index, Collection col)
    remove(int index)
    set(int index, Object obj)
    get(int index)
    indexOf(Object obj)
    lastIndexOf(Object obj)
    listIterator()
    listIterator(int index)
    subList(int fromIndex, int toIndex)

## Set集合
