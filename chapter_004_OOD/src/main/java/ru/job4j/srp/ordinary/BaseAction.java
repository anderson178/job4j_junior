package ru.job4j.srp.ordinary;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 14.08.2019
 */

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseAction implements UserAction {
    final int key;
    final String info;

    /**
     * Get key
     *
     * @param key - key
     * @return - key
     */
    @Override
    public int key(int key) {
        return this.key;
    }

    /**
     * Get info action
     *
     * @return - Get info action
     */
    @Override
    public String getInfo() {
        return this.info;
    }

    /**
     * Method execute action. Is empty
     */
//    @Override
//    public void execute() {
//    }


}
