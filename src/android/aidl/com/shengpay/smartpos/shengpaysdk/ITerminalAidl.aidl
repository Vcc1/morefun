// ITerminalInfoAidl.aidl
package com.shengpay.smartpos.shengpaysdk;

// Declare any non-default types here with import statements

interface ITerminalAidl {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void setAppId(String appId);

    String getTerminalID();
    String getFirmId();
    String getSerialNo();

    void print_getStatus();
    void print_setGray(int gray);
    void print_setFont(int font);
    void print_setFontSize(int size);
    void print_setFontWidth(int width);
    void print_setFontHeight(int height);
    void print_setXSpace(int xSpace);
    void print_setYSpace(int ySpace);
    void print_setLeftSpace(int leftSpace);
    void print_feedline(int line);
    void print_writeToBuffer(String content);
    void print_print();
    void print_printText(String text);
    void print_printBarCode(String content);
    void print_printQrCode(int offset, String content,int height);
    void print_printImage(int offset, in byte[] bitmap);

    void mag_enableTrack(int pos);
    void mag_disableTrack(int pos);
    void mag_resetTrack();
    void mag_searchCard();
    void mag_stopSearch();

    void ic_searchCard(int slot);
    void ic_stopSearch(int slot);
    boolean ic_isICCardExist(int slot);

    void rf_searchCard();
    void rf_stopSearch();
    void rf_LEDOn(int pos, int color);
    void rf_LEDOff(int pos);

    void scanDecoder();
    void searchM1Card(int sectorNo, int keyType, String key, int blockNo);

    void print_setBatchPrint(boolean isBatchPrint);
    void print_batchPrint();

    void print_setAlignment(int alignment);
}
