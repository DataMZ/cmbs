package com.cmbs.ssm.pojo;

/**
 * @author: zwc
 * @date: 2018/9/13 23:19
 * @description:
 */
public class OperatorVo extends Operator {
    private long startLine;
    private long numPerPage;

    public long getStartLine() {
        return startLine;
    }

    public void setStartLine(long startLine) {
        this.startLine = startLine;
    }

    public long getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(long numPerPage) {
        this.numPerPage = numPerPage;
    }
}
