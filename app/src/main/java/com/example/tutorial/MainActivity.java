package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;



public class MainActivity extends AppCompatActivity{
    private static final int CAMERA_REQUEST=1888;


    ImageView img;
    Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img=(ImageView)this.findViewById(R.id.image1);
        Button btn=(Button) this.findViewById(R.id.button);


        btn.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {

                Intent cam=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cam,CAMERA_REQUEST);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            if(requestCode==CAMERA_REQUEST){
               // Bundle extras = data.getExtras();
                ImageView img=(ImageView)this.findViewById(R.id.image1);
                Bitmap photo=(Bitmap) data.getExtras().get("data");
                img.setImageBitmap(photo);
            }
        }catch(Exception e){

            System.out.println(e);
        }

    }


}