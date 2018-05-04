package com.company;

import com.company.map.Map;

public class Main {

    public static void main(String[] args) {
        Map map = new Map(6,8);
        Unit lukas = new Unit("Infantry", 50, "Lukas", 32, 22, 50, 13);
        Weapon slayingLance = new Weapon("Slaying Lance+", Constants.WeaponType.Lance, 14, 1);
        Unit camilla = new Unit("flying", 40, "Camilla", 34, 32, 28, 35);
        Weapon slayingAxe = new Weapon("Slaying Axe", Constants.WeaponType.Axe, 14, 1);
        lukas.equipWeapon(slayingLance);
        camilla.equipWeapon(slayingAxe);

        while (camilla.getRemainingHp()>0 && lukas.getRemainingHp()>0){
            Combat.start(camilla, lukas);
        }


    }

}
