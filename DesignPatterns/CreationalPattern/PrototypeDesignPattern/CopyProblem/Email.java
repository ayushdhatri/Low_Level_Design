package Low_Level_Design.DesignPatterns.CreationalPattern.PrototypeDesignPattern.CopyProblem;

public class Email implements Prototype<Email> {
    private String sender;
    private String receiver;
    private String subject;
    private String body;

    public Email(String sender, String receiver, String subject, String body){
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.body = body;
    }
    // copy constructor
    public Email(Email email){
        this.sender = email.getSender();
        this.receiver = email.getReceiver();
        this.subject = email.getSubject();
        this.body = email.getBody();
    }

    public String getSender(){
        return this.sender;
    }
    public String getReceiver(){
        return this.receiver;
    }
    public String getSubject(){
        return this.subject;
    }
    public String getBody(){
        return this.body;
    }
    public void setSender(String sender){
        this.sender = sender;
    };
    public void setReceiver(String receiver){
        this.receiver = receiver;
    };
    public void setSubject(String subject){
        this.subject = subject;
    };
    public void setBody(String body){
        this.body = body;
    };
    public void display(){
        System.out.println("Sender : " + this.sender);
        System.out.println("Receiver : " + this.receiver);
        System.out.println("Subject : " + this.subject);
        System.out.println("Body : " + this.body);

    }
    @Override
    public Email copy() {
        return new Email(this);
    }

}
