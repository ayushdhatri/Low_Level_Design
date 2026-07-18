package Low_Level_Design.Problems.ECommerceLLD.services.filterService;

import java.util.*;

import Low_Level_Design.Problems.ECommerceLLD.models.Product;
public interface Criteria {
    List<Product> satisfy(List<Product> products);
} 
