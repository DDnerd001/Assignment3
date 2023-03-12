import java.lang.*;


public class Card implements Comparable<Card>{

  private int id;
  private String name;
  private Rank rank;
  private long price;

  public Card(int id, String name, Rank rank){
    this.price=0;
    this.id = id;
    this.name = name;
    this.rank = rank;

  }

  public int getID(){return this.id;}
  public String getName(){return this.name;}
  public Rank getRank(){return this.rank;}
  public int getRankValue(){return this.rank.getValue();}

  public long getPrice(){return this.price;}


  @Override
  public String toString(){
    return String.format("%d %s %s", this.id, this.name, this.rank );
  }

  @Override
  public int hashCode(){return this.id;}

  public boolean equals(Card input){return (this.id==input.getID())&&(this.name.equals(input.getName()))&&(this.rank==input.getRank());}

  @Override
  public int compareTo(Card other){
    int thisRank = this.getRankValue();
    int otherRank = other.getRankValue();
    if(thisRank!=otherRank){
      return Integer.compare(thisRank, otherRank);
    } else {
      int stringCompare = this.name.compareTo(other.getName());
      if(stringCompare!=0){
        return stringCompare;
      }else{
        return Integer.compare(this.getID(), other.getID());
      }
    }
  }


}
