public class MarioDecoratorPattern {
    public static void main(String[] args) {
        Character mario = new GunDecorator(
                          new HeightUpDecorator(
                          new HeightUpDecorator(
                          new Mario()
                          )));  
        System.out.println(mario.getAbilities());
    }
}

abstract class Character{
    abstract String getAbilities();
}
class Mario extends Character{
    
    @Override
    String getAbilities() {
        return "Basic Mario ";
    }
}

abstract class Decorator extends Character{
    protected Character character;
    public Decorator(Character c){
        this.character = c;
    }
    abstract String getAbilities();
}

class HeightUpDecorator extends Decorator {
    public HeightUpDecorator(Character c){
        super(c);
    }
    @Override
    public String getAbilities(){
        return character.getAbilities()+" with Hieght up ability ";
    }
}

class GunDecorator extends Decorator{
    public GunDecorator(Character c){
        super(c);
    }
    @Override
    public String getAbilities(){
        return character.getAbilities()+" with Gun ability";
    }
}
