package name.zhw.morefun;

import android.os.Bundle;
import android.os.IBinder;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

import android.os.RemoteException;

import android.app.AlertDialog;

import com.shengpay.smartpos.shengpaysdk.ITerminalAidl;

/**
 * This class echoes a string called from JavaScript.
 */

public class morefun extends CordovaPlugin {
    public ITerminalAidl terminalAidl;
    private TerminalInfoServConn terminalInfoServConn;
    public boolean b;

    /**
    * 服务是否连接
    */
    public boolean isServiceConnection = false;

    protected void serviceConnected() {
        try {
            terminalAidl.setAppId("name.zhw.morefun");
            isServiceConnection = true;
        } catch (Exception e) {

        }
    }

    class TerminalInfoServConn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            terminalAidl = ITerminalAidl.Stub.asInterface(service);
            serviceConnected();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

    public void Alert2(String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(cordova.getActivity());
        builder.setTitle(s);
        builder.create().show();
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        // Alert2(action);
        if (action.equals("ServiceLoding")) {
            this.ServiceLoding(callbackContext);
            return true;
        } else {
            if (!isServiceConnection) {
                callbackContext.error("硬件服务未完成初始化");
                return true;
            }
            try {
                if (action.equals("print_setGray")) {
                    //print_setGray(int gray);
                    //print_print();

                    int i = args.getInt(0);
                    terminalAidl.print_setGray(i);

                } else if (action.equals("print_setFont")) {
                    //print_setFont(int font);
                    int i = args.getInt(0);
                    terminalAidl.print_setFont(i);

                } else if (action.equals("print_setFontSize")) {
                    //print_setFontSize(int size);
                    int i = args.getInt(0);
                    terminalAidl.print_setFontSize(i);

                } else if (action.equals("print_setFontWidth")) {
                    //print_setFontWidth(int width);
                    int i = args.getInt(0);
                    terminalAidl.print_setFontWidth(i);

                } else if (action.equals("print_setFontHeight")) {
                    //print_setFontHeight(int height);
                    int i = args.getInt(0);
                    terminalAidl.print_setFontHeight(i);

                } else if (action.equals("print_setXSpace")) {
                    //print_setXSpace(int xSpace);
                    int i = args.getInt(0);
                    terminalAidl.print_setXSpace(i);

                } else if (action.equals("print_setYSpace")) {
                    //print_setYSpace(int ySpace);
                    int i = args.getInt(0);
                    terminalAidl.print_setYSpace(i);

                } else if (action.equals("print_setLeftSpace")) {
                    //print_setLeftSpace(int leftSpace);
                    int i = args.getInt(0);
                    terminalAidl.print_setLeftSpace(i);

                } else if (action.equals("print_feedline")) {
                    //print_feedline(int line);
                    int i = args.getInt(0);
                    terminalAidl.print_feedline(i);

                } else if (action.equals("print_writeToBuffer")) {
                    //print_writeToBuffer(String content);
                    String s = args.getString(0);
                    terminalAidl.print_writeToBuffer(s);
                } else if (action.equals("print_printText")) {

                    //print_printText(String text);
                    String s = args.getString(0);
                    terminalAidl.print_printText(s);

                } else if (action.equals("print_printBarCode")) {
                    //print_printBarCode(String content);
                    String s = args.getString(0);
                    terminalAidl.print_printBarCode(s);

                } else if (action.equals("print_printQrCode")) {
                    //print_printQrCode(int offset, String content,int height);
                    int offset = args.getInt(0);
                    String content = args.getString(1);
                    int height = args.getInt(2);
                    terminalAidl.print_printQrCode(offset,content,height);
                } else if (action.equals("print_setBatchPrint")) {
                    //print_setBatchPrint(boolean isBatchPrint)
                    boolean offset = args.getBoolean(0);
                    terminalAidl.print_setBatchPrint(offset);
                }else if (action.equals("print_batchPrint")) {
                    //print_batchPrint()
                   terminalAidl.print_batchPrint();
                }
            } catch (Exception e) {
                callbackContext.error(e.toString());
            }
            callbackContext.success("");
        }

        return false;

    }

    private void ServiceLoding(CallbackContext callbackContext) {

        try {
            Intent terminalIntent = new Intent();
            terminalIntent.setClassName("com.shengpay.smartpos.shengpaysdk",
                    "com.shengpay.smartpos.shengpaysdk.Service.TerminalService");
            terminalInfoServConn = new TerminalInfoServConn();
            b = cordova.getActivity().bindService(terminalIntent, terminalInfoServConn, Context.BIND_AUTO_CREATE);
            callbackContext.success("已执行 待完成");
        } catch (Exception e) {
            Alert2("错误"+e.toString());
            callbackContext.error(e.toString());
        }

    }

}
