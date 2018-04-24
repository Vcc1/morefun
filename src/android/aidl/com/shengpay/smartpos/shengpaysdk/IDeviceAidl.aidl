// IMainAidlInterface.aidl
package com.shengpay.smartpos.shengpaysdk;
// Declare any non-default types here with import statements

interface IDeviceAidl {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    boolean login();
    void logout();

}
