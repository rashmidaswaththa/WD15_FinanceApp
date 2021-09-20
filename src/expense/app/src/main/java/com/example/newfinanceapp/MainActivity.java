package com.example.newfinanceapp;

import android.Manifest;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.activity.result.contract.ActivityResultContracts;

import java.io.ByteArrayOutputStream;


public class MainActivity extends AppCompatActivity {

    //Image attachment
    private ImageView imageView;
    private ImageButton imageButton;
    private ImageButton cameraButton;

    //insert form
    private EditText note_text;
    private EditText amount_text;
    private Spinner s1;
    private Spinner s2;

    MyDatabaseHelper DB;
    private String noteDB;
    private String amountDB;
    private String methodDB;
    private String categoryDB;
    private Bitmap imageDB;

    private Uri imageUri;

    //permission constants
    //private static final int CAMERA_REQUEST_CODE= 1001;
    private static final int STORAGE_REQUEST_CODE= 1000;

    //image pick code
    private static final int IMAGE_PICK_CAMERA_CODE = 1002;
    private static final int IMAGE_PICK_GALLERY_CODE = 1003;

    //arrays of permisiions
    //private String [] cameraPermissions;
    private String [] storagePermissions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tool bar
        ImageView left_arrow = findViewById(R.id.left_arrow);
        ImageView check = findViewById(R.id.check);
        TextView title = findViewById(R.id.title);
        ImageView clear = findViewById(R.id.clear);


        //Expense insert form

        EditText note_text = findViewById(R.id.addField1_text);
        EditText amount_text = findViewById(R.id.addField2_text);
        Spinner s1 = (Spinner) findViewById(R.id.paymethod_list);
        Spinner s2 = (Spinner) findViewById(R.id.category_list);

        //views
        imageView = findViewById(R.id.insertImage);
        imageButton = findViewById(R.id.uploadImage_btn);
        cameraButton = findViewById(R.id.camera_button);

        //date base connection
        DB = new MyDatabaseHelper(this);

        //init permission arrays
        //cameraPermissions = new String[] {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE};
        storagePermissions = new String[] { Manifest.permission.READ_EXTERNAL_STORAGE};


        left_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You clicked in left icon" , Toast.LENGTH_SHORT).show();
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note = note_text.getText().toString().trim();
                String amount = amount_text.getText().toString().trim();
                String pay = s1.getSelectedItem().toString().trim();
                String cat = s2.getSelectedItem().toString().trim();

                //byte[] image = onActivityResult(requestCode, resultCode, data).image;
                Boolean insert = DB.insertData(note, amount, pay, cat);

                if(insert == true){
                    Toast.makeText(MainActivity.this, "Inserted Successfully" , Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Failed!" , Toast.LENGTH_SHORT).show();
                }


            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Deleted Successfully" , Toast.LENGTH_SHORT).show();
            }
        });

        title.setText("Manage Expense");



        //handle image upload button
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check runtime permission
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(!checkStoragepermission()){
                        requestStoragepermission();
                    }else {
                        //permission already granted
                        pickImageFromGallery();

                    }
                }else{
                    ////system os is less than marshmallow
                    pickImageFromGallery();

                }

            }



        });

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check runtime permission
//                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
//                    if(!checkCamerapermission()){
//                        requestCamerapermission();
//                    }else{
//                        //permission already granted
//                        pickImageFromCamera();
//
//                    }
//                }else{
//                    ////system os is less than marshmallow
//                    pickImageFromCamera();
//
//                }

                pickImageFromCamera();

            }

        });
    }

    private boolean checkStoragepermission(){
        //check if storage permission is enabled or not

        boolean result = ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE ) == (PackageManager.PERMISSION_GRANTED);
        return result;
    }

    private void requestStoragepermission(){
        //request the storage permission
        ActivityCompat.requestPermissions(this, storagePermissions,STORAGE_REQUEST_CODE);
    }

//    private boolean checkCamerapermission(){
//        //check if storage permission is enabled or not
//
//        boolean result = ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA) == (PackageManager.PERMISSION_GRANTED);
//        boolean result1 = ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE ) == (PackageManager.PERMISSION_GRANTED);
//        return result && result1;
//    }

//    private void requestCamerapermission(){
//        //request the camera permission
//        ActivityCompat.requestPermissions(this, cameraPermissions,CAMERA_REQUEST_CODE);
//
//    }



    //pick image from gallery
    private void pickImageFromGallery() {
        //intent to pick image
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent , IMAGE_PICK_GALLERY_CODE);

    }

    //pick image from camera
    private void pickImageFromCamera() {


        //put image uri
        //imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, val );
        //intent to pick image

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
        startActivityForResult(cameraIntent, IMAGE_PICK_CAMERA_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
//            case CAMERA_REQUEST_CODE: {
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//
//                    //permission was granted
//                    pickImageFromCamera();
//                } else {
//                    //permission was denied
//                    Toast.makeText(this, "Permission denied..!", Toast.LENGTH_SHORT).show();
//                }
//            }
//         break;
            case STORAGE_REQUEST_CODE: {
                if ((grantResults.length > 0) && grantResults[1] == PackageManager.PERMISSION_GRANTED) {

                    //boolean storageAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;

                    //permission was granted
                    pickImageFromGallery();
                } else {
                    //permission was denied
                    Toast.makeText(this, "Permission denied..!", Toast.LENGTH_SHORT).show();
                }
            }
            break;
       }


        }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {
//            //SET IMAGE TO VIEW
//            //imageView.setImageURI(data.getData());
//
//            Uri selectedImage = data.getData();
//            String[] filePathColumn = { MediaStore.Images.Media.DATA };
//
//            Cursor cursor = getContentResolver().query(selectedImage,
//                    filePathColumn, null, null, null);
//            cursor.moveToFirst();
//
//            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//            String filePath = cursor.getString(columnIndex);
//            cursor.close();
//
//            Bitmap yourSelectedImage = BitmapFactory.decodeFile(filePath);
//
//            imageView.setImageBitmap(yourSelectedImage);
//            ByteArrayOutputStream stream = new ByteArrayOutputStream();
//            yourSelectedImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
//            byte image [] = stream.toByteArray();
//
//        }else if(requestCode == CAMERA_REQUEST){
//            Bitmap photo = (Bitmap) data.getExtras().get("data");
//            imageView.setImageBitmap(photo);
//            // convert bitmap to byte
//            ByteArrayOutputStream stream = new ByteArrayOutputStream();
//            photo.compress(Bitmap.CompressFormat.PNG, 100, stream);
//            byte image [] = stream.toByteArray();
//        }


        if(resultCode == RESULT_OK && requestCode == IMAGE_PICK_GALLERY_CODE){
            //image is picked
            imageView.setImageURI(data.getData());
            //imageView.setImageURI(imageUri);

            }
            else if(requestCode == IMAGE_PICK_CAMERA_CODE){
                //picked from camera
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
                //crop image
               // imageView.setImageURI(imageUri);

            }


        }
    }



