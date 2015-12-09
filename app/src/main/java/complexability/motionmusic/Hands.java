package complexability.motionmusic;

/**
 * Created by Sorawis on 12/1/2015.
 */

/*************************************************************
* Hand class for holding information about each hand
 ***********************************************************/
public class Hands {
    protected String effect_1;
    protected String effect_2;
    protected String effect_3;
    protected String instrument;
    protected int effectCount;

    /**
     * Constructor -> initialize all values when creating a hand object
     * (May be useful when adding DEFAULT settings
     */
    Hands(){
        effect_1 = "None";
        effect_2 = "None";
        effect_3 = "None";
        instrument = "Electric Guitar";
        effectCount = 0;
    }
    public void setEffectCount(int count){
        effectCount = count;
    }
    /*
    * Helper function to change effect
    * Takes New effect and effect number
     */
    public void changeEffect(String newEffect, int effectNum){
        switch(effectNum){
            case 1:
                this.effect_1 = newEffect;
                break;
            case 2:
                this.effect_2 = newEffect;
                break;
            case 3:
                this.effect_3 = newEffect;
                break;
            default:
        }
    }
    /*
    * Helper function to change the instrument of the hand
     */
    public void changeInstrument(String newInstrument) {
        instrument = newInstrument;
    }
    /*
    Helper function to increment effect count
     */
    public void increaseEffectCount() {
        if (effectCount < 3) {
            effectCount = effectCount + 1;
        }
    }
    public int getEffectCount(){
        return effectCount;
    }

    /*
    Helper function to decrement effect count
 */
    public void decreaseEffectCount(){
        if(effectCount > 0){
            effectCount = effectCount - 1;
        }
    }
    public String getInstrument(){
        return instrument;
    }
    public String getEffect(int effectNum){
        switch(effectNum){
            case 1:
                return effect_1;
            case 2:
                return effect_2;
            case 3:
                return effect_3;
            default:
                return "NONE";
        }
    }
/*****************************************************
 * Will replace literal strings for effects and instruments
 * in the future when the app has synth built-in
 *****************************************************/
    /**
     * Created by Sorawis on 12/1/2015.
     */
    public static class effect {
        protected boolean status;
        protected String effectName;
        protected int level;
        effect(String Name){
            effectName = Name;
        }
        public void enable(){
            status = true;
        }
        public void disable(){
            status = false;
        }
        public boolean getStatus(){
            return status;
        }
        public int getLevel(){
            return level;
        }
        public void increaseLevel() {
            if (level < 100) {
                level++;
            }
        }
        public void decreaseLevel(){
            if(level > 0){
                level--;
            }
        }
    }

    /**
     * Created by Sorawis on 12/1/2015.
     */
    public static class Instrument {
        protected String instrument_name;

        //There will be other parameters in the future

        Instrument(String name){
            instrument_name = name;
        }

        public String getInstrument_name(){
            return instrument_name;
        }
    }
}
