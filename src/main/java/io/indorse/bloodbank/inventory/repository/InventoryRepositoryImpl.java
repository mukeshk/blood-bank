package io.indorse.bloodbank.inventory.repository;

import io.indorse.bloodbank.model.domain.BloodGroup;
import io.indorse.bloodbank.model.domain.Inventory;
import io.indorse.bloodbank.model.domain.InventoryType;
import io.indorse.bloodbank.model.dto.InventoryListDTO;
import io.indorse.bloodbank.model.dto.InventorySearchDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class InventoryRepositoryImpl implements InventoryRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Inventory> searchByCriteria(InventorySearchDTO searchCriteria) {

        StringBuffer queryBuffer =new StringBuffer();
        queryBuffer.append("SELECT e FROM Inventory e JOIN FETCH e.branch WHERE active=1 and e.expiryDate > CURRENT_TIMESTAMP");
        boolean conditionApplied = Boolean.FALSE;
        if(searchCriteria.getBloodGroup()!=null){
            queryBuffer.append(" AND e.bloodGroup='"+searchCriteria.getBloodGroup()+"'");
            conditionApplied = Boolean.TRUE;
        }
        if(searchCriteria.getInventoryType()!=null){
            if(conditionApplied){
                queryBuffer.append(" and ");
            }
            queryBuffer.append(" e.inventoryType='"+searchCriteria.getInventoryType()+"'");
            conditionApplied = Boolean.TRUE;
        }

        if(searchCriteria.getZipCode()!=null){
            if(conditionApplied){
                queryBuffer.append(" and ");
            }
            queryBuffer.append(" e.branch.address.zipCode='"+searchCriteria.getZipCode()+"'");
        }

        Query query = entityManager.createQuery(queryBuffer.toString());
        List<Inventory> inventories = query.getResultList();
        return inventories;
    }
}
