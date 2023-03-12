


public class Card implements Comparable<Card>{

  private long id;
  private String name;
  private Rank rank;
  private long price;

  public Card(long id, String name, Rank rank){
    this.price=0;
    this.id = id;
    this.name = name;
    this.rank = rank;

  }

  public long getID(){return this.id;}
  public String getName(){return this.name;}
  public Rank getRank(){return this.rank;}
  public int getRankValue(){return this.rank.getValue();}

  public long getPrice(){return this.price;}


  @Override
  public String toString(){
    return String.format("%d %s %s", this.id, this.name, this.rank );
  }

  @Override
  public int hashCode(){
    final int prime = 31;
		int result = 1;
		result = prime * result + (int) (this.id ^ (this.id >>> 32));
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.rank == null) ? 0 : this.rank.hashCode());
		return result;
  }

  public boolean equals(Object obj){
    if (this == obj){
			return true;
    }
		if (obj == null){
			return false;
    }
    Card input = (Card) obj;
    if ((this.name==null)^(input.name==null)){return false;}
    return (this.id==input.getID())&&(this.name.equals(input.getName()))&&(this.rank==input.getRank());
  }

  @Override
  public int compareTo(Card other){
    int stringCompare;
    int x = Integer.compare(this.getRankValue(), other.getRankValue());
    if (x!=0){return x;}
    if ((this.name==null)||(other.name==null)){
      if (other.name!=null){return -1;}
      if (this.name!=null){return 1;}
    }else{
      stringCompare = this.name.compareTo(other.getName());
      if(stringCompare!=0){return stringCompare;}
    }
    return Long.compare(this.getID(), other.getID());
  }




}

