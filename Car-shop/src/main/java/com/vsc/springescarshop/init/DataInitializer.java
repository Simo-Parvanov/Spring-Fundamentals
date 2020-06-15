package com.vsc.springescarshop.init;

import com.vsc.springescarshop.data.models.Brand;
import com.vsc.springescarshop.data.models.Model;
import com.vsc.springescarshop.services.services.BrandService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

import static com.vsc.springescarshop.data.models.VehicleCategory.*;

@Component
public class DataInitializer implements CommandLineRunner {
    private final BrandService brandService;

    private static final Map<String, Set<Model>> SAMPLE_BRANDS = Map.of(
            "Bmw",
            Set.of(
                    new Model("M1", CAR, 1978, 1981, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/26/BMW_M1%2C_front_right_%28Brooklyn%29.jpg/560px-BMW_M1%2C_front_right_%28Brooklyn%29.jpg"),
                    new Model("M2", CAR, 2016, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/2017_BMW_M2_Automatic_3.0_Front.jpg/560px-2017_BMW_M2_Automatic_3.0_Front.jpg"),
                    new Model("M3", CAR, 2008, 2012, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/2018_BMW_M3_3.0.jpg/560px-2018_BMW_M3_3.0.jpg"),
                    new Model("M4", CAR, 2014, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/2015_BMW_M4_%28F82%29_coupe_%2824220553394%29.jpg/560px-2015_BMW_M4_%28F82%29_coupe_%2824220553394%29.jpg"),
                    new Model("M5", CAR, 1984, 1988, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/BMW%2C_Techno_Classica_2018%2C_Essen_%28IMG_8995%29.jpg/560px-BMW%2C_Techno_Classica_2018%2C_Essen_%28IMG_8995%29.jpg"),
                    new Model("M6", CAR, 1990,2004, "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/2017-03-07_Geneva_Motor_Show_0996.JPG/560px-2017-03-07_Geneva_Motor_Show_0996.JPG"),
                    new Model("7", CAR, 1977, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/6/62/2006_BMW_730d_%28E65%29_sedan_%282015-07-09%29_01.jpg/560px-2006_BMW_730d_%28E65%29_sedan_%282015-07-09%29_01.jpg"),
                    new Model("8", CAR, 2018, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/2019_BMW_M850i_xDrive%2C_front_1.23.20.jpg/560px-2019_BMW_M850i_xDrive%2C_front_1.23.20.jpg"),
                    new Model("5", CAR, 1972, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/2018_BMW_520d_M_Sport_Automatic_2.0_%281%29.jpg/560px-2018_BMW_520d_M_Sport_Automatic_2.0_%281%29.jpg"),
                    new Model("6", CAR, 2003, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/2018_BMW_630i_GT_M_Sport_Automatic_2.0_Front.jpg/560px-2018_BMW_630i_GT_M_Sport_Automatic_2.0_Front.jpg"),
                    new Model("Z4", CAR, 2002, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/2011_BMW_Z4_sDrive23i_M_Sport_Highline_2.5.jpg/560px-2011_BMW_Z4_sDrive23i_M_Sport_Highline_2.5.jpg"),
                    new Model("X1", CAR, 2009, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/BMW_X1_%28E84%2C_Facelift%29_%E2%80%93_Frontansicht%2C_31._Dezember_2012%2C_D%C3%BCsseldorf.jpg/560px-BMW_X1_%28E84%2C_Facelift%29_%E2%80%93_Frontansicht%2C_31._Dezember_2012%2C_D%C3%BCsseldorf.jpg"),
                    new Model("i3", CAR, 2013, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/2018_BMW_i3_facelift_%281%29.jpg/560px-2018_BMW_i3_facelift_%281%29.jpg"),
                    new Model("X1", CAR, 2009, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/2018_BMW_X1_sDrive18i_xLine_1.5_Front.jpg/560px-2018_BMW_X1_sDrive18i_xLine_1.5_Front.jpg"),
                    new Model("X2", CAR, 2017, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/2018_BMW_X2_xDrive20D_M_Sport_X_Automatic_2.0.jpg/560px-2018_BMW_X2_xDrive20D_M_Sport_X_Automatic_2.0.jpg"),
                    new Model("X3", CAR, 2003, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/2018_BMW_X3_xDrive20d_SE_Automatic_2.0_Front.jpg/560px-2018_BMW_X3_xDrive20d_SE_Automatic_2.0_Front.jpg"),
                    new Model("X4", CAR, 2014, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/2018_BMW_X4_xDrive20d_M_Sport_Automatic_2.0_Front.jpg/560px-2018_BMW_X4_xDrive20d_M_Sport_Automatic_2.0_Front.jpg"),
                    new Model("X5", CAR, 1999, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/2019_BMW_X5_M50d_Automatic_3.0.jpg/560px-2019_BMW_X5_M50d_Automatic_3.0.jpg"),
                    new Model("X6", CAR, 2007, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/2020_BMW_X6_xDrive30d_M_Sport_Automatic_3.0.jpg/560px-2020_BMW_X6_xDrive30d_M_Sport_Automatic_3.0.jpg"),
                    new Model("X7", CAR, 2018, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/2019_BMW_X7_xDrive40i_in_white%2C_front_left.jpg/560px-2019_BMW_X7_xDrive40i_in_white%2C_front_left.jpg"),
                    new Model("G11", CAR, 2015, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a3/2017_BMW_750i_%28G12%29_front_3.23.18.jpg/560px-2017_BMW_750i_%28G12%29_front_3.23.18.jpg"),
                    new Model("G30", CAR, 2016, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/2018_BMW_520d_M_Sport_Automatic_2.0_%281%29.jpg/560px-2018_BMW_520d_M_Sport_Automatic_2.0_%281%29.jpg"),
                    new Model("G32", CAR, 2017, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/2018_BMW_630d_GT_M_Sport_Automatic_3.0_Front.jpg/560px-2018_BMW_630d_GT_M_Sport_Automatic_3.0_Front.jpg"),
                    new Model("Z1", CAR, 1989,1991, "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/BMWZ1.jpg/560px-BMWZ1.jpg"),
                    new Model("Z3", CAR, 1995, 2002, "https://upload.wikimedia.org/wikipedia/commons/thumb/a/aa/2001_BMW_Z3_Roadster_Automatic_2.2_Front.jpg/560px-2001_BMW_Z3_Roadster_Automatic_2.2_Front.jpg"),
                    new Model("Z4", CAR, 1995, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/2019_BMW_Z4_M40i_Automatic_3.0.jpg/560px-2019_BMW_Z4_M40i_Automatic_3.0.jpg"),
                    new Model("Z5", CAR, 1989, 2016, "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d6/BMW_Z4%2C_Paris_Motor_Show_2018%2C_Paris_%281Y7A1387%29.jpg/560px-BMW_Z4%2C_Paris_Motor_Show_2018%2C_Paris_%281Y7A1387%29.jpg"),
                    new Model("Z8", CAR, 2000, 2003, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/BMW_Z8_%282009-05-20%29.JPG/560px-BMW_Z8_%282009-05-20%29.JPG"),
                    new Model("F800S", MOTORCYCLE, 2006, 2010, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/33/BMW_F_800_Sport_Edition_1.jpg/440px-BMW_F_800_Sport_Edition_1.jpg"),
                    new Model("R1200GS", MOTORCYCLE, 2004, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/BMW_R1200GS_July_2010.jpg/1024px-BMW_R1200GS_July_2010.jpg"),
                    new Model("R1300S", MOTORCYCLE, 2008, 2016, "https://upload.wikimedia.org/wikipedia/commons/thumb/0/03/BMW_K1300S.jpg/600px-BMW_K1300S.jpg"),
                    new Model("K1600", MOTORCYCLE, 2001, null, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f5/K1600_Seite.jpg/600px-K1600_Seite.jpg")
            ));

    public DataInitializer(BrandService brandService) {
        this.brandService = brandService;
    }

    @Override
    public void run(String... args) throws Exception {
        if(brandService.getBrandsCount() == 0) {
            SAMPLE_BRANDS.forEach((brand, models) -> {
                Brand newBrand = Brand.create(brand, models);
                brandService.createBrand(newBrand);
            });
        }
    }
}
