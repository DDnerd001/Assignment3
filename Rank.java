enum Rank{
    UNIQUE(4),
    RARE(3),
    UNCOMMON(2),
    COMMON(1);


    int value;
    Rank(int v){
      value=v;
    }

    int showValue() {
      return value;
    }
}
