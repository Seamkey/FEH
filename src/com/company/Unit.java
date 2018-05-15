package com.company;

import com.company.skills.NoSkill;
import com.company.skills.Skill;

import java.util.HashMap;

public class Unit {

    private String unitType;
    public boolean defeated = false;

    //Heroes
    private int maxHp;
    private int remainingHp;
    private String name;
//    private int level;
//    private int exp;

    private int str; //atk
    private int spd;
    private int def;
    private int res;

//    private int hit; //skill/hitrate
//    private int magic;
//    private int luck;

    private int terrainBonus = 0; //TODO Terrain effects exist as well

    private final int numSkills = 4;
    public Skill[] skills = new Skill[numSkills];
    public HashMap<Constants.SkillCondition, ConditionValue> conditionTable = new HashMap<>();

    private Weapon weapon = new Weapon();

    public Unit() {
        setunitType("-");
        initSkills();
    }

    public Unit(String unitType, int maxHp, String name, int str, int spd, int def, int res){ //Heroes
        setunitType(unitType);
        setMaxHp(maxHp);
        setRemainingHp(maxHp);
        setName(name);

        setStr(str);
        setSpd(spd);
        setDef(def);
        setRes(res);

        initSkills();
    }

    /*
    * Skill related methods
    * */
    private void initSkills(){ //Make sure skill list is filled with objects
        for (int i=0; i<numSkills; i++){
            skills[i]= new NoSkill();
        }
    }

    public void equipSkill(Skill skill){ //Note: Skill has to be created already
        int slot = skill.getSkillType().ordinal();
        if (skill.isSeal()) slot = numSkills-1; //if its a seal
        dequipSkill(slot);
        skills[slot] = skill;
        skill.setUnit(this);
        for (Constants.SkillCondition condition : skill.getConditions()){
            setCondition(condition);
        }
        skill.update();
    }

    public void dequipSkill(Constants.SkillType condition){ //careful with number for seals
        dequipSkill(condition.ordinal());
    }

    private void dequipSkill(int skill){
        for (Constants.SkillCondition condition : skills[skill].getConditions()){
            removeCondition(condition);
        }
        if (skills[skill].isActive()) skills[skill].deactivate();
        skills[skill]=new NoSkill();
    }

    public void updateSkills(){
        for (Skill skill : skills){
            skill.update();
        }
    }

    //TODO get something more intuitive for the condition table
    public void setCondition(Constants.SkillCondition condition){
        ConditionValue v = conditionTable.putIfAbsent(condition, new ConditionValue(false, 1));
        if (v != null) {
            v.increaseShared();
            conditionTable.replace(condition, v);
        }
    }

    public void removeCondition(Constants.SkillCondition condition){
        ConditionValue v = conditionTable.get(condition);
        if (v != null){
            v.decreaseShared();
            if (v.getNumShared() == 0) conditionTable.remove(condition);
        }
    }

    public void updateCondition(Constants.SkillCondition condition, boolean activated){
        ConditionValue v = conditionTable.get(condition);
        if (v != null){
            v.setFulfilled(activated);
            conditionTable.replace(condition, v);
        }
        updateSkills();
    }

    public boolean checkCondition(Constants.SkillCondition condition){
        ConditionValue v = conditionTable.get(condition);
        if (v != null) return v.isFulfilled();
        else return false;
    }

    /*
    * basic methods
    * */

    @Override
    public String toString() {
        return name + ": " + remainingHp + "HP";
    }

    public String toString(boolean verbose){
        return String.format("%s | %d/%dHP%nATK: %d SPD: %d%nDEF: %d RES: %d",
                name, remainingHp, maxHp, str, spd, def, res);
    }

    public char draw(){ //TODO Actually do something here
        return this.name.charAt(0);
    }

    public boolean equals(Unit unit) { //TODO Find other method of comparison. Maybe hashcode
        return name == unit.getName();
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getTerrainBonus(){
        return terrainBonus;
    }

    public void setTerrainBonus(int terrainBonus){
        this.terrainBonus = terrainBonus;
    }

    public String getunitType() {
        return unitType;
    }

    public void setunitType(String unitType) {
        this.unitType = unitType;
    }

    public boolean isDefeated() {
        return defeated;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getRemainingHp() {
        return remainingHp;
    }

    public void setRemainingHp(int remainingHp) {
        if (remainingHp<=0) {
            remainingHp = 0;
            defeated=true;
            System.out.println(String.format("%s died", name));
        }
        this.remainingHp = remainingHp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }


}
