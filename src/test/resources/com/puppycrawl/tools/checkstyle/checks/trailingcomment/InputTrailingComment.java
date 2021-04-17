package com.puppycrawl.tools.checkstyle.checks.trailingcomment;
/*
 * Config:
 * legalComment = "^NOI18N$"
 */
public class InputTrailingComment {
    int i; // don't use trailing comments :) // violation
    // it fine to have comment w/o any statement
    /* good c-style comment. */
    int j; // violation /* bad c-style comment. */
    void method1() { /* some c-style multi-line // violation
                        comment*/
        Runnable r = (new Runnable() {
                public void run() {
                }
            }); /* we should allow this */
    } // we should allow this
    /*
      Let's check multi-line comments.
    */
    /* c-style */ // violation // cpp-style
    /* c-style 1 */ // violation /*c-style 2 */

    /* package */ void method2(long ms /* we should ignore this */) {
        /* comment before text */int z;
        /* int y */int y/**/;
    }

    /**
     * comment with trailing space.
     */
    final static public String NAME="Some Name"; // NOI18N
    final static public String NAME2="Some Name"; /*NOI18N*/
    String NAME3="Some Name"; /*NOI18N // violation
*/
    /* package */ void method3() {
        /* violation on this block */
        // violation here for format NOT FOUND
    }

    private static class TimerEntry {
        /* ok */ final String operation = null;
        /* ok */ final long start = 0L;
    }

    /**
     * violation above this line.
     **/
    /* package */ void addError() {
    }
}
