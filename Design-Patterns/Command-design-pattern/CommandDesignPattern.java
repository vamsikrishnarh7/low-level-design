/*
 * Remote example with single button
 */

public class CommandDesignPattern{
    public static void main(String[] args) {
        Light light = new Light();
        LightCommand lightCommand = new LightCommand(light);
        Remote remote = new Remote();
        remote.setCommand(lightCommand);

        remote.pressButton();

    }
}
interface Command{
    void execute();
}
class Remote{
    
    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }
    public void pressButton(){
        command.execute();
    }

}
class Light{
    public void on(){
        System.out.println("Light on");
    }
    public void off(){
        System.out.println("Light off");
    }
}
class LightCommand implements Command{
    Light light;

    public LightCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute(){
        light.on();
    }
}