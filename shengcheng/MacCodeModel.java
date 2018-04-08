package android_serialport_api;

import java.util.Hashtable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.tvfactory.R;
import com.tvfactory.bean.DevInfoBean;

public class MacCodeModel {

    private static String TAG = "MacCodeModel";
    static LinearLayout mFloatLayout;

    public static void showMacCode(Context mContext) {
        Log.e(TAG, "showMacCode");
        LayoutParams wmParams = new WindowManager.LayoutParams();

        WindowManager mWindowManager = (WindowManager) mContext
                .getSystemService(mContext.WINDOW_SERVICE);

        wmParams.type = LayoutParams.TYPE_PHONE;

        wmParams.format = PixelFormat.RGBA_8888;

        wmParams.flags = LayoutParams.FLAG_NOT_FOCUSABLE;

        wmParams.gravity = Gravity.LEFT | Gravity.TOP;

        wmParams.x = 0;
        wmParams.y = 0;

        wmParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        wmParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        LayoutInflater inflater = LayoutInflater.from(mContext);

        mFloatLayout = (LinearLayout) inflater.inflate(R.layout.show_mac_code,
                null);

        TextView EthMac = (TextView) mFloatLayout
                .findViewById(R.id.ethernet_mac);
        

        ImageView EthMacImage = (ImageView) mFloatLayout
                .findViewById(R.id.ethernet_mac_image);

        String ethMac = getEthMac(mContext);

        EthMac.setText(ethMac);
        EthMacImage.setImageBitmap(createOneDImage(ethMac));



        mWindowManager.addView(mFloatLayout, wmParams);
        mFloatLayout.measure(View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED), View.MeasureSpec
                .makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

    }


    private static String getEthMac(Context mContext) {

        return DevInfoBean.getDevMac();
    }

    public static Bitmap createOneDImage(String mString) {
        int QR_WIDTH = 500;
        int QR_HEIGHT = 200;
        try {
            if (mString == null || "".equals(mString) || mString.length() < 1) {
                return null;
            }
            Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
  
            BitMatrix bitMatrix = new MultiFormatWriter().encode(mString,  
                    BarcodeFormat.CODE_128, QR_WIDTH, QR_HEIGHT, hints);
            int[] pixels = new int[QR_WIDTH * QR_HEIGHT];
            for (int y = 0; y < QR_HEIGHT; y++) {
                for (int x = 0; x < QR_WIDTH; x++) {
                    if (bitMatrix.get(x, y)) {
                        pixels[y * QR_WIDTH + x] = 0xff000000;
                    } else {
                        pixels[y * QR_WIDTH + x] = 0xffffffff;
                    }
                }
            }
            Bitmap bitmap = Bitmap.createBitmap(QR_WIDTH, QR_HEIGHT,
                    Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, QR_WIDTH, 0, 0, QR_WIDTH, QR_HEIGHT);
            return bitmap;
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static boolean removeMacCode(Context mContext) {
        Log.e(TAG, "removeMacCode");
        if (mFloatLayout != null) {
            WindowManager mWindowManager = (WindowManager) mContext
                    .getSystemService(mContext.WINDOW_SERVICE);

            mWindowManager.removeView(mFloatLayout);
            mFloatLayout = null;
            return true;
        }
        return false;

    }

}
