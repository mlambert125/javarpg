package org.example.javarpg;

public class KeyboardState {
    /**
     * Whether the up key is currently pressed
     */
    private boolean keyUp = false;

    /**
     * Whether the down key is currently pressed
     */
    private boolean keyDown = false;

    /**
     * Whether the left key is currently pressed
     */
    private boolean keyLeft = false;

    /**
     * Whether the right key is currently pressed
     */
    private boolean keyRight = false;

    /**
     * Whether the space key is currently pressed
     */
    private boolean keySpace = false;

    /**
     * Whether the escape key is currently pressed
     */
    private boolean keyEscape = false;

    /**
     * Whether the up key is currently pressed
     *
     * @return whether the up key is currently pressed
     */
    public boolean isKeyUp() {
        return keyUp;
    }

    /**
     * Set whether the up key is currently pressed
     *
     * @param keyUp whether the up key is currently pressed
     */
    public void setKeyUp(boolean keyUp) {
        this.keyUp = keyUp;
    }

    /**
     * Whether the down key is currently pressed
     *
     * @return whether the down key is currently pressed
     */
    public boolean isKeyDown() {
        return keyDown;
    }

    /**
     * Set whether the down key is currently pressed
     *
     * @param keyDown whether the down key is currently pressed
     */
    public void setKeyDown(boolean keyDown) {
        this.keyDown = keyDown;
    }

    /**
     * Whether the left key is currently pressed
     *
     * @return whether the left key is currently pressed
     */
    public boolean isKeyLeft() {
        return keyLeft;
    }

    /**
     * Set whether the left key is currently pressed
     *
     * @param keyLeft whether the left key is currently pressed
     */
    public void setKeyLeft(boolean keyLeft) {
        this.keyLeft = keyLeft;
    }

    /**
     * Whether the right key is currently pressed
     *
     * @return whether the right key is currently pressed
     */
    public boolean isKeyRight() {
        return keyRight;
    }

    /**
     * Set whether the right key is currently pressed
     *
     * @param keyRight whether the right key is currently pressed
     */
    public void setKeyRight(boolean keyRight) {
        this.keyRight = keyRight;
    }

    /**
     * Whether the space key is currently pressed
     *
     * @return whether the space key is currently pressed
     */
    public boolean isKeySpace() {
        return keySpace;
    }

    /**
     * Set whether the space key is currently pressed
     *
     * @param keySpace whether the space key is currently pressed
     */
    public void setKeySpace(boolean keySpace) {
        this.keySpace = keySpace;
    }

    /**
     * Whether the escape key is currently pressed
     *
     * @return whether the escape key is currently pressed
     */
    public boolean isKeyEscape() {
        return keyEscape;
    }

    /**
     * Set whether the escape key is currently pressed
     *
     * @param keyEscape whether the escape key is currently pressed
     */
    public void setKeyEscape(boolean keyEscape) {
        this.keyEscape = keyEscape;
    }
}
