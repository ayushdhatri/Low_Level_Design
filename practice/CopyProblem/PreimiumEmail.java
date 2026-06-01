package Low_Level_Design.practice.CopyProblem;

public class PreimiumEmail extends Email{

    private String cc;
    private String bcc;

    // Default constructor
    public PreimiumEmail() {
        super();
    }

    // Parameterized constructor
    public PreimiumEmail(String sender,
                         String receiver,
                         String subject,
                         String body,
                         String cc,
                         String bcc) {
        super(sender, receiver, subject, body);
        this.cc = cc;
        this.bcc = bcc;
    }

    // Copy constructor
    public PreimiumEmail(PreimiumEmail obj) {
        super(obj); // copy Email fields
        this.cc = obj.cc;
        this.bcc = obj.bcc;
    }

    // Getters
    public String getCc() {
        return cc;
    }

    public String getBcc() {
        return bcc;
    }

    // Setters
    public void setCc(String cc) {
        this.cc = cc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    @Override
    public PreimiumEmail copy() {
        return new PreimiumEmail(this);
    }


}