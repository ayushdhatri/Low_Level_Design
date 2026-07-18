package Low_Level_Design.Problems.ECommerceLLD.services.filterService;

import java.util.List;

import Low_Level_Design.Problems.ECommerceLLD.models.Product;

public class AndFilterCriteria implements Criteria{
    private List<Criteria> criteriaList;

    public AndFilterCriteria(List<Criteria> criteriaList){
        this.criteriaList = criteriaList;
    }

    @Override
    public List<Product> satisfy(List<Product> products) {
        
    }

    
    

    
}
