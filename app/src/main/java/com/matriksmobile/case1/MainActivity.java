package com.matriksmobile.case1;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // index 0 a, index 1 b, index 2 c
    private TextView tvProductA, tvProductB, tvProductC, tvMaxProduct, tvSide1, tvSide2, tvSide3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvProductA = findViewById(R.id.tvProductA);
        tvProductB = findViewById(R.id.tvProductB);
        tvProductC = findViewById(R.id.tvProductC);
        tvMaxProduct = findViewById(R.id.tvMaxProduct);
        tvSide1 = findViewById(R.id.tvSide1);
        tvSide2 = findViewById(R.id.tvSide2);
        tvSide3 = findViewById(R.id.tvSide3);

        getProcduct();
        getDecare();
    }

    @SuppressLint("SetTextI18n")
    private void getProcduct() {
        List<Double> total = new ArrayList<>();
        List<Double> first = getProductCalculator(YearEnum.FIRSTYEAR);
        List<Double> second = getProductCalculator(YearEnum.SECONDYEAR);
        List<Double> third = getProductCalculator(YearEnum.THIRDYEAR);
        List<Double> fourth = getProductCalculator(YearEnum.FOURTHYEAR);

        for (int i = 0; i < first.size(); i++) {
            total.add(i, first.get(i) + second.get(i) + third.get(i) + fourth.get(i));
        }

        tvProductA.setText("a : " + String.valueOf(total.get(0)) + " dönüm");
        tvProductB.setText("b : " + String.valueOf(total.get(1)) + " dönüm");
        tvProductC.setText("c : " + String.valueOf(total.get(2)) + " dönüm");

        int index = total.indexOf(Collections.max(total));
        double value = total.get(index);
        switch (index) {
            case 0:
                tvMaxProduct.setText("En çok " + String.valueOf(value) + " a ürünü üretilmiştir.");
                break;
            case 1:
                tvMaxProduct.setText("En çok " + String.valueOf(value) + " b ürünü üretilmiştir.");
                break;
            case 2:
                tvMaxProduct.setText("En çok " + String.valueOf(value) + " c ürünü üretilmiştir.");
                break;

        }
    }

    private List<Double> getProductCalculator(YearEnum yearEnum) {

        List<Double> products = new ArrayList<>();
        double firstField = 10, secondField = 10, thirdField = 10;

        switch (yearEnum) {
            case FIRSTYEAR:

                products.add(firstField);
                products.add(secondField);
                products.add(thirdField);

                return products;

            case SECONDYEAR:

                products.add(firstField);
                products.add((secondField * 50 / 100.0));
                products.add(products.get(1) + thirdField);

                return products;

            case THIRDYEAR:

                products.add((firstField * 20 / 100.0));
                products.add((firstField - products.get(0)) + secondField);
                products.add(thirdField);

                return products;

            case FOURTHYEAR:

                products.add((firstField * 1 / 100.0));
                products.add(secondField);
                products.add(thirdField);

                return products;

            default:

                return products;
        }
    }

    @SuppressLint("SetTextI18n")
    private void getDecare() {
        // 1 dönüm 1000 m2 olarak alındğı düşünülürse 1 alan 10.000 m2 dir.
        double firstField = 10 * 1000, secondField = 10 * 1000, thirdField = 10 * 1000;

        // 1 alanın bir yatay eksendeki kenar uzunluğu
        double firstSide = Math.sqrt(firstField);
        double secondSide = Math.sqrt(secondField);
        double thirdSide = Math.sqrt(thirdField);

        tvSide1.setText(" 1. dönüm ile 2. dönüm arasındaki çit ayrım noktası " + String.valueOf(firstSide) + " metre");
        tvSide2.setText(" 2. dönüm ile 3. dönüm arasındaki çit ayrım noktası " + String.valueOf(firstSide + secondSide) + " metre");
        tvSide3.setText(" 3. çitin ayrım noktası " + String.valueOf(firstSide + secondSide + thirdSide) + " metre");
    }
}
