package com.company;

public class Weapon {

    private String name;
    private WeaponType weaponType;
    private int might;
    private int range;

    //private int durability;

    public Weapon(){
        setName("-");
        setWeaponType(new WeaponType(Constants.WeaponType.None));
        setMight(0);
        setRange(0);
    }

    public Weapon(String name, Constants.WeaponType weaponType, int mt, int range){
        setName(name);
        setWeaponType(new WeaponType(weaponType));
        setMight(mt);
        setRange(range);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public int getMight() {
        return might;
    }

    public void setMight(int might) {
        this.might = might;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
