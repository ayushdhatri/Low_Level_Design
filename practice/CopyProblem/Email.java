package Low_Level_Design.practice.CopyProblem;


public class Email implements Copyable<Email> {
    private String sender;
    private String receiver;
    private String subject;
    private String body;

    // Default constructor
    public Email() {
    }

    // Copy constructor
    public Email(Email obj) {
        this.sender = obj.sender;
        this.receiver = obj.receiver;
        this.subject = obj.subject;
        this.body = obj.body;
    }

    // Parameterized constructor
    public Email(String sender, String receiver, String subject, String body) {
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.body = body;
    }

    // Getters
    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    // Setters
    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public Email copy() {
        return new Email(this);
    }
}