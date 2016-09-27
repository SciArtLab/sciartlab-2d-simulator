package com.xmunch.processing.testing;

import com.xmunch.processing.utils.XMProcessingUtils;

public enum CellState {

    alive("alive"), dead("dead");

    private final String code;

    private CellState(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public int getColor() {

        XMProcessingUtils utils = new XMProcessingUtils();

        if (getCode().equals("alive"))
            return utils.color(100, 200, 10);
        else if (getCode().equals("dead"))
            return utils.color(10, 100, 10);
        else
            return utils.color(0);

    }
}
