package com.company;

import com.company.map.Map;

public class Game {

    public static void main(String[] args) {
        Map map = new Map();

        Unit lukas = new Unit("Infantry", 50, "Lukas", 32, 22, 50, 13);
        Weapon slayingLance = new Weapon("Slaying Lance+", Constants.WeaponType.Lance, 14, 1);
        Unit camilla = new Unit("flying", 40, "Camilla", 34, 32, 28, 35);
        Weapon slayingAxe = new Weapon("Slaying Axe", Constants.WeaponType.Axe, 14, 1);
        lukas.equipWeapon(slayingLance);
        camilla.equipWeapon(slayingAxe);

//        map.setUnit(camilla, 0,0);
//        map.setUnit(lukas, 1, 0);
//        map.draw();
//
//        System.out.println();
//        System.out.println();

        while (camilla.getRemainingHp()>0 && lukas.getRemainingHp()>0){
            Combat.start(camilla, lukas);
        }

    }

}
