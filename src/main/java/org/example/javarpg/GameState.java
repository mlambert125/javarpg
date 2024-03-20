package org.example.javarpg;

public class GameState {
    private CharacterSprite sprite = CharacterSprite.MAN_RED;

    public CharacterSprite getSprite() {
        return sprite;
    }

    public void setSprite(CharacterSprite sprite) {
        this.sprite = sprite;
    }
}
