package com.unip.aps.model;

/**
 * Created on 4/5/2017.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public enum RequestCode {
    MESSAGE, MESSAGE_LIST;

    private static RequestCode[] cachedValues;

    /**
     * Recupera o RequestCode identificado pelo ordinal passado.
     *
     * @param code
     *
     * @return
     */
    public static RequestCode fromInteger(Integer code) {
        if (cachedValues == null) {
            cachedValues = RequestCode.values();
        }

        return cachedValues[code];
    }
}