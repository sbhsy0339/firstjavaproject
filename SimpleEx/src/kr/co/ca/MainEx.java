package kr.co.ca;

import com.naver.Bow;
import com.naver.Hammer;
import com.naver.Hero;
import com.naver.Monster;
import com.naver.NoHaveWeaponException;
import com.naver.Sword;
import com.naver.Weapon;


public class MainEx {
   public static void main(String[] args) {
      
      Monster m = new Monster(10);
      
      Weapon[] weapons = {new Bow("활", 1), new Sword("검", 5), new Hammer("망치", 10)};
      int hasWeaponIdx = 0;
      
      Hero spyderman = new Hero(weapons, hasWeaponIdx);
      
      spyderman.attack(m);
      
      try {
         spyderman.changeWeapon(1);
      } catch (NoHaveWeaponException e) {
         System.out.println("무기 변경에 실패했습니다.");
      }
      
      
      try {
         spyderman.changeWeapon(100);
      } catch (NoHaveWeaponException e) {
         System.out.println("무기 변경에 실패했습니다.");
      }
      
      
      spyderman.attack(m);
      
      
   }
}