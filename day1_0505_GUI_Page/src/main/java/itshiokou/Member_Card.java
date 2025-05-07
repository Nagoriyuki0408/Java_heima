package itshiokou;
public class Member_Card {
    private static final String[] cardNames = {"Silver_Card","Golden_Card","Original Card"};
    private static final double[] carddiscount = {0.9,0.8,1.0};
    String card_type;
    String License_Number;
    String Owner_Name;
    String Telephone;
    double Card_Balance;
    int Free_Tickets;
    public Member_Card( String License_Number,String Owner_Name,String Telephone,double Card_Balance,int Free_Tickets){
        this.License_Number = License_Number;
        this.Owner_Name = Owner_Name;
        this.Telephone = Telephone;
        this.Card_Balance = Card_Balance;
        this.Free_Tickets = Free_Tickets;
        this.card_type=cardNames[2];
    }
    public  void  Handel_Card() {
        if(this.Card_Balance>=5000) this.card_type=cardNames[1];
        else if(this.Card_Balance>=2000) this.card_type = cardNames[0];
    }
    public  double comsume(double comsumption){
        if(this.card_type==cardNames[1]) comsumption*=carddiscount[1];
        else if(this.card_type==cardNames[0]) comsumption*=carddiscount[0];
        else comsumption*=carddiscount[2];
        if(comsumption>=200 && this.card_type==cardNames[1]){
        Free_Tickets++;
        }
        this.Card_Balance-=comsumption;
        return this.Card_Balance;
    }
    public void show_card(){
        System.out.println(this.card_type);
        System.out.println(this.License_Number);
        System.out.println(this.Owner_Name);
        System.out.println(this.Telephone);
        System.out.println(this.Card_Balance);
        System.out.println(this.Free_Tickets);
    }
    public static void main(String[] args){
        Member_Card[] cards = new Member_Card[] {
                new Member_Card("CoA12345", "Tom", "13800001111", 20000.0, 2),
                new Member_Card("CoB67890", "Bob", "13900002222", 15000.5, 1),
                new Member_Card("CoC24680", "Sam", "13700003333", 2300.0, 0),
                new Member_Card("CoD13579", "Lily", "13600004444", 50.0, 5)
        };
        for(Member_Card card:cards){
            card.Handel_Card();
        }
        cards[0].comsume(5000);
        cards[0].show_card();

    }
}
