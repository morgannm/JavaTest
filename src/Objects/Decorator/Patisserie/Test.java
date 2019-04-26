package Objects.Decorator.Patisserie;

import Objects.Decorator.Patisserie.Couche.*;

public class Test{
    public static void main(String[] args){
        Patisserie pat = new CoucheChocolat(
                new CoucheCaramel(
                        new CoucheBiscuit(
                                new CoucheChocolat(
                                        new Gateau()))));
        System.out.println(pat.preparer());
    }
}