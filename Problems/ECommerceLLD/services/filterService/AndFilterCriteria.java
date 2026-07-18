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
        // go to every single product

        // make that product pass through every single criteria

        // and if the product failes even of them then dont add them in the answer

        return products.stream()
            .filter(product -> criteriaList.stream()
                .allMatch(criteria -> !criteria.satisfy(List.of(product)).isEmpty()))
            .toList();

        
    }

    
    

    
}
