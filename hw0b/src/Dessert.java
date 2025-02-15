public class Dessert {
    public int flavor;
    public int price;
    public static int numDesserts;
    public Dessert(Integer f,Integer p) {
        flavor = f;
        price = p;
        numDesserts++;
    }
    public void printDessert(){
        System.out.println(this.flavor + " " + this.price + " " + Dessert.numDesserts);
    }

    public static void main(String[] args){
        System.out.println("I love dessert!");
    }
}