package com.example.shengcheng;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	/**
     * ��Ҫ����һ��ά�������
     */
    private EditText codeEdit;
    /**
     * ���ɶ�ά�����
     */
    private Button twoCodeBtn;
     //    �������ɶ�ά�밴ť
    private ImageView codeImg;  
    /**
     * ����һά�밴ť
     */
    private Button oneCodeBtn;
   
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        codeEdit = (EditText) findViewById(R.id.code_edittext);
        twoCodeBtn = (Button) findViewById(R.id.btn_code);
        codeImg = (ImageView) findViewById(R.id.code_img);
        oneCodeBtn = (Button) findViewById(R.id.code_btn);
        
        setListener();
       
    }
    /**
     * �������ɶ�ά���ɨ���ά����¼�
     */
    private void setListener() {
        twoCodeBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {  //getText()����ı�����������
                String str = codeEdit.getText().toString().trim();
                Bitmap bmp = null;
                try {
                    if (str != null && !"".equals(str)) {
                        bmp = CreateTwoDCode(str);
                    }
                } catch (WriterException e) {
                    e.printStackTrace();
                }
                if (bmp != null) {
                    codeImg.setImageBitmap(bmp);
                }

            }
        });
        
        
        oneCodeBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = codeEdit.getText().toString().trim();
                int size = str.length();
                for (int i = 0; i < size; i++) {
                    int c = str.charAt(i);
                    if ((19968 <= c && c < 40623)) {
                        Toast.makeText(MainActivity.this, "�����������ʱ�̲���������", Toast.LENGTH_SHORT).show();
                        return;
                    }

                }
                Bitmap bmp = null;
                try {
                    if (str != null && !"".equals(str)) {
                        bmp = CreateOneDCode(str);
                    }
                } catch (WriterException e) {
                    e.printStackTrace();
                }
                if (bmp != null) {
                    codeImg.setImageBitmap(bmp);
                }
            }
        });
    }
    
	 /**
     * ���ڽ��������������ɳ�һά�� ע��Ŀǰ��������Ϊ���ĵĻ���ֱ�ӱ���Ҫ�޸ĵײ�jar��������
     *
     * @param content ��Ҫ����һά�������
     * @return �������ɺõ�һά��bitmap
     * @throws WriterException WriterException�쳣
     */
    public Bitmap CreateOneDCode(String content) throws WriterException {
        // ����һά����,����ʱָ����С,��Ҫ������ͼƬ�Ժ��ٽ�������,������ģ������ʶ��ʧ��
        BitMatrix matrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.CODE_128, 800, 200, null);
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        int[] pixels = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (matrix.get(x, y)) {
                    pixels[y * width + x] = 0xff000000;
                }
            }
        }

        Bitmap bitmap = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_8888);
        // ͨ��������������bitmap,����ο�api
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return bitmap;
    }
    /**
     * ��ָ�����������ɳɶ�ά��
     *
     * @param content ��Ҫ���ɶ�ά�������
     * @return �������ɺõĶ�ά���¼�
     * @throws WriterException WriterException�쳣
     */
    public Bitmap CreateTwoDCode(String content) throws WriterException {
        // ���ɶ�ά����,����ʱָ����С,��Ҫ������ͼƬ�Ժ��ٽ�������,������ģ������ʶ��ʧ��
        BitMatrix matrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.QR_CODE, 300, 300);
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        // ��ά����תΪһά��������,Ҳ����һֱ��������
        int[] pixels = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (matrix.get(x, y)) {
                    pixels[y * width + x] = 0xff000000;
                }
            }
        }

        Bitmap bitmap = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_8888);
        // ͨ��������������bitmap,����ο�api
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return bitmap;
    }


    
}
