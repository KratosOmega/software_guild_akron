/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.rpgsatchel;

/**
 *
 * @author ilyagotfryd
 */
public class Potion implements MagicItem{

    @Override
    public int getItemSpellPower() {
        return 23;
    }

    @Override
    public String getItemName() {
        return "Potion";
    }

    @Override
    public int getItemWeight() {
        return 1;
    }
    
}
