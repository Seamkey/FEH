package com.company.skills;

import com.company.Constants;
import com.company.Unit;

public abstract class Skill {

    protected Unit unit;
    protected Constants.SkillType skillType;
    protected Constants.SkillCondition [] conditions = new Constants.SkillCondition[0];

    protected String name;
    protected String description;
    protected boolean seal = false;
    protected boolean active = false;

    public void update(){
        for (Constants.SkillCondition condition : conditions){
            if (!unit.checkCondition(condition)) {
                if (active) deactivate();
                active = false;
                return;
            }
        }
        if (!active) activate();
        active = true;
    }

    public abstract void activate();
    public abstract void deactivate();

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Constants.SkillType getSkillType(){
        return skillType;
    }

    public Constants.SkillCondition[] getConditions() {
        return conditions;
    }

    public void setSeal(){ //To establish whether the skill goes into the seal slot or not
        seal = true;
    }

    public boolean isSeal(){
        return seal;
    }

    public boolean isActive() {
        return active;
    }

    public void setUnit(Unit unit) { //To perform modifications to the Unit this is set on
        this.unit = unit;
    }
}
