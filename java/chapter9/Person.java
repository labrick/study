public class Person{
    private String name;
    private long id_card;
    public Person(String name, long id_card){
        this.name = name;
        this.id_card = id_card;
    }
    // ..... set/get motheds
    public String getName(){
        return name;
    }
    public long getId_card(){
        return id_card;
    }
    public int hashCode(){
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + (int)(id_card ^ (id_card >>> 32));
        result = PRIME * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        final Person other = (Person)obj;
        if(id_card != other.id_card){
            return false;
        }
        if(name == null){
            if(other.name != null){
                return false;
            }
        }else if( !name.equals(other.name)){
            return false;
        }
        return true;
    }

    ///////////////////////////////////////
    
    // first that id_card smallest
    public int compareTo(Object o){
        Person person = (Person)o;
        int result = id_card > person.id_card ? 1
            : (id_card == person.id_card ? 0 : -1);
        return result;
    }
}

