package Section10.Challenges.GroceryList;

record Grocery(String name, int count) {

    public Grocery(String name){
        this(name ,1);
    }

    @Override
    public String toString() {
        return String.format("|%d %s|",count, name);
    }

}
