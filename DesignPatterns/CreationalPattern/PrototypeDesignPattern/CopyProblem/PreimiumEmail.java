package Low_Level_Design.DesignPatterns.CreationalPattern.PrototypeDesignPattern.CopyProblem;

public class PreimiumEmail extends Email{
    private String cc;
    private String bcc;

    PreimiumEmail(String sender, String receiver, String subject, String body, String cc, String bcc){
        super(sender, receiver, subject, body);
        this.cc = cc;
        this.bcc = bcc;
    }
    
    // Copy Constructor 
    PreimiumEmail(PreimiumEmail email){
        super(email);
        this.cc = email.getCc();
        this.bcc = email.getBcc();
    }

    @Override
    public PreimiumEmail copy(){
        return new PreimiumEmail(this);
    }

    public String getCc(){
        return this.cc;
    }

    public String getBcc(){
        return this.bcc;
    }

    public void setCc(String cc){
        this.cc = cc;
    }

    public void setBcc(String bcc){
        this.bcc = bcc;
    }


}
