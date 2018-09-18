package com.cmbs.ssm.pojo;

/**
 * @author: zwc
 * @date: 2018/9/11 22:34
 * @description:
 */
public class Page {
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

    @Override
    public String toString() {
        return "Page{" +
                "startLine=" + startLine +
                ", numPerPage=" + numPerPage +
                '}';
    }
}
