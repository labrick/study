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

    HashSet类，TestSet.java中重载了equals(Object obj)和hashCode()方法
    TreeSet类，其中不能直接使用add方法，不知为什么，见TestSet.java例程
        comparator()
        first()
        last()
        headSet()
        subSet()
        tailSet()

## Map集合

    clear()
    isEmpty()
    size()
    put(key k, value v)
    containsValue(Object key)
    get(Object key)
    keySet()
    values()
