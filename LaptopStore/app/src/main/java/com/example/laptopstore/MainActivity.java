package com.example.laptopstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.Context.CONTEXT_RESTRICTED;

public class MainActivity extends AppCompatActivity {
    private Adapter a;
    private ImageButton ibc;
    private LinearLayout bac;
    private int lap_img[];
    private String lap_des[];
    private String lap_name[];
    private RecyclerView recyclerView;
    private ArrayList<lap> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ibc = findViewById(R.id.ibcart);
        Spinner mModels = findViewById(R.id.spinner);
        bac = findViewById(R.id.back);
        ibc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddToCartShopping.class));
            }
        });
        list = new ArrayList<lap>();

        lap_name = new String[]
                {"acer", "asus", "dell", "hp", "lenova", "samsung"};
        lap_img =
                new int[]{R.drawable.acer, R.drawable.asus, R.drawable.dell, R.drawable.hp, R.drawable.lenova,
                        R.drawable.samsung
                };

        lap_des = new String[]
                {"Screen Size\t15.6 inches\n" +
                        "Max Screen Resolution\t1920 x 1080 pixels\n" +
                        "Processor\t2.2 GHz Intel Core i3\n" +
                        "RAM\t6 GB DDR3\n" +
                        "Hard Drive\t1000 GB Mechanical Hard Drive\n" +
                        "Graphics Coprocessor\tIntel HD Graphics 620\n" +
                        "Chipset Brand\tintel\n" +
                        "Card Description\tIntegrated\n" +
                        "Graphics Card Ram Size\t2 GB\n" +
                        "Brand Name\tAcer\n" +
                        "Item model number\tE5-576-392H\n" +
                        "Operating System\tWindows 10\n" +
                        "Product Dimensions\t15 x 10.2 x 1.2 inches\n" +
                        "Item Dimensions L x W x H\t15.02 x 10.2 x 1.19 inches\n" +
                        "Color\tObsidian Black\n" +
                        "Processor Brand\tIntel\n" +
                        "Computer Memory Type\tDDR3 SDRAM\n" +
                        "Batteries\t1 Lithium Metal batteries required. (included)",
                        "Screen Size\t11.6 inches\n" +
                                "Max Screen Resolution\t1366*768 pixels\n" +
                                "Processor\t1.6 GHz Intel Celeron\n" +
                                "RAM\t4 GB DDR3L\n" +
                                "Hard Drive\t16 GB emmc\n" +
                                "Graphics Coprocessor\tIntel HD Graphics\n" +
                                "Chipset Brand\tintel\n" +
                                "Card Description\tIntegrated\n" +
                                "Graphics Card Ram Size\t4\n" +
                                "Average Battery Life (in hours)\t10 hours\n" +
                                "Brand Name\tASUS\n" +
                                "Series\tASUS Chromebook\n" +
                                "Item model number\tC202SA-YS02\n" +
                                "Operating System\tChrome\n" +
                                "Processor Brand\tIntel\n" +
                                "Flash Memory Size\t16.00\n" +
                                "Batteries\t1 Lithium Metal batteries required. (included)"
                        , "Screen Size\t35.6 centimeters\n" +
                        "Max Screen Resolution\t1366 x 768\n" +
                        "Processor\t2 GHz Intel Mobile CPU\n" +
                        "RAM\t4 GB SO-DIMM DDR3\n" +
                        "Hard Drive\t120 GB flash_memory_solid_state\n" +
                        "Graphics Coprocessor\tIntel HD Graphics 4400\n" +
                        "Chipset Brand\tIntel\n" +
                        "Brand Name\tDell\n" +
                        "Series\tE7440\n" +
                        "Hardware Platform\tPC\n" +
                        "Operating System\tWindows 10\n" +
                        "Item Weight\t3.59 pounds\n" +
                        "Product Dimensions\t9.1 x 13.3 x 0.8 inches\n" +
                        "Item Dimensions L x W x H\t9.1 x 13.3 x 0.8 inches\n" +
                        "Processor Brand\tIntel\n" +
                        "Processor Count\t1\n" +
                        "Computer Memory Type\tSODIMM\n" +
                        "Batteries\t1 Lithium ion batteries required. (included)"
                        , "Screen Size\t11.6 inches\n" +
                        "Screen Resolution\t1366x768\n" +
                        "Max Screen Resolution\t1366 x 768\n" +
                        "Processor\t1.1 GHz Celeron M 585\n" +
                        "RAM\t8 GB SDRAM\n" +
                        "Hard Drive\t32 GB eMMC\n" +
                        "Graphics Coprocessor\tIntel UHD Graphics 600\n" +
                        "Chipset Brand\tintel\n" +
                        "Brand Name\tHP\n" +
                        "Series\tHP Stream\n" +
                        "Item model number\t11-AH117\n" +
                        "Hardware Platform\tPC\n" +
                        "Operating System\tWindows 10 S\n" +
                        "Color\tJet Black\n" +
                        "Processor Brand\tIntel\n" +
                        "Computer Memory Type\tDDR4 SDRAM\n" +
                        "Flash Memory Size\t32 GB\n" +
                        "Batteries\t1 Lithium Polymer batteries required. (included)"
                        , "Screen Size\t14 inches\n" +
                        "Max Screen Resolution\t1920X1080 pixels\n" +
                        "Processor\t2.1 GHz MTK 8121\n" +
                        "RAM\t6 GB LPDDR3\n" +
                        "Hard Drive\t64 GB Flash Memory Solid State\n" +
                        "Chipset Brand\tIntel\n" +
                        "Card Description\tIntegrated\n" +
                        "Wireless Type\t802.11.ac\n" +
                        "Number of USB 3.0 Ports\t1\n" +
                        "Brand Name\tLenovo\n" +
                        "Item model number\t81JW0000US\n" +
                        "Hardware Platform\tChrome\n" +
                        "Operating System\tChrome\n" +
                        "Product Dimensions\t12.8 x 0.8 x 9.2 inches\n" +
                        "Color\tBusiness Black\n" +
                        "Processor Brand\tIntel\n" +
                        "Processor Count\t4\n" +
                        "Flash Memory Size\t64.0\n" +
                        "Batteries\t1 Lithium Polymer batteries required. (included)"
                        , "Screen Size\t11.6 inches\n" +
                        "Screen Resolution\t1366 x 768\n" +
                        "Processor\t1.7 GHz Exynos 5000 Series\n" +
                        "RAM\t8 GB SDRAM DDR3\n" +
                        "Hard Drive\t16 GB flash memory solid state\n" +
                        "Wireless Type\t802.11abg, 802.11.n\n" +
                        "Average Battery Life (in hours)\t7 hours\n" +
                        "Item model number\tXE303C12-A01\n" +
                        "Hardware Platform\tPC\n" +
                        "Operating System\tother\n" +
                        "Color\tSilver\n" +
                        "Computer Memory Type\tDDR3 SDRAM\n" +
                        "Hard Drive Interface\tSolid State\n" +
                        "Audio-out Ports (#)\t1\n" +
                        "Power Source\tAC\n" +
                        "Batteries\t1 Lithium Polymer batteries required. (included)"};
        ImageButton log = findViewById(R.id.logOut);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        for (int i = 0; i < lap_img.length; i++) {
            list.add(new lap(lap_name[i], lap_img[i], lap_des[i]));

        }
        // set up the RecyclerView
        recyclerView = findViewById(R.id.rv);
        //recyclerView.Adapter=Adapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        a = new Adapter(list, this);
        recyclerView.setAdapter(a);

        mModels.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                a.clear();
                if (position <= 5) {
                    a.add(new lap(lap_name[position], lap_img[position], lap_des[position]));
                    Toast.makeText(MainActivity.this, "You are selecetd successfully!!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Total is 50000", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void logout() {

        this.finish();

    }

}

