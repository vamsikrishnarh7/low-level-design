import java.util.ArrayList;
import java.util.List;

public class YouTubeObserverPattern {
    public static void main(String[] args) {
        Channel channel1 = new Channel("ThinkSchool");
        Subscriber subscriber1 = new Subscriber("vamsi", channel1);
        Subscriber subscriber2 = new Subscriber("mahesh", channel1);

        channel1.subscribe(subscriber1);
        channel1.subscribe(subscriber2);

        channel1.uploadVideo("The Situation of Indian Education System");

    }
}

abstract class IChannel { // observable
    abstract void subscribe(ISubscriber subscriber);
    abstract void unsubscribe(ISubscriber subscriber);
    abstract void notifySubscribers();

}
abstract class ISubscriber{
    abstract void update();
}

class Channel extends IChannel{
    private String name, latestVideo;
    private List<ISubscriber> subscribersList;

    public Channel(String name){
        this.name = name;
        this.subscribersList = new ArrayList<>();
    }

    @Override
    void subscribe(ISubscriber subscriber) {
        if(!subscribersList.contains(subscriber)){
            subscribersList.add(subscriber);
            System.out.println("New subscriber added");
        }            
        else{
            System.out.println("already subscribed");
        }        
    }
    @Override
    void unsubscribe(ISubscriber subscriber) {
        subscribersList.remove(subscriber);
        System.out.println("unsubscribed");
    }
    @Override
    void notifySubscribers() {
        for(ISubscriber subscriber : subscribersList){
            subscriber.update();
        }
    }
    
    public String getVideo(){
        return "Checkout our new video "+latestVideo;
    }
    
    public void uploadVideo(String title){
        latestVideo = title;
        System.out.println(title+" is uploaded to "+name);
        notifySubscribers();
    }

    public String getName(){
        return name;
    }

    public List<ISubscriber> getSubscribers(){
        return subscribersList;
    }

}

class Subscriber extends ISubscriber{
    private String name;
    private Channel channel;

    public Subscriber(String name, Channel channel){
        this.name = name;
        this.channel = channel;
    }

    @Override
    public void update(){
        String latestVideo = channel.getVideo();
        System.out.println("Hey "+this.name+"!\nWatch our new video \""+latestVideo+"\"-"+channel.getName());
    }

    public String getName(){
        return name;
    }

}

