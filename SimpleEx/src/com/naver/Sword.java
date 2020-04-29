package com.naver;

public class Sword extends Weapon{
   
   public Sword() {}
   
   public Sword(String name, int attackPower) {
      super(name, attackPower);
}
   
   @Override
   public void describe() {
   System.out.println("칼로 마구 찌릅니다.");
      
   }


   
   @Override
   public String toString() {
      return  super.getName();
   }

}