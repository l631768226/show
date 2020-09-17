package com.ly.show.mapper;

import org.apache.ibatis.jdbc.SQL;

public class AssociationSelectProvider {

    public String searchAssociation(final String type, final String gutMicrobiota,
                                    final String metabolite, final String gene){
        return new SQL(){
            {
                SELECT(" A.*, B.PMID ");
                FROM(" Association AS A, Literature AS B ");
                WHERE(" A.`Index` = B.`Index` ");
                WHERE(" A.humanMouse = " + "'" + type + "' ");
                if(gutMicrobiota != null && !"".equals(gutMicrobiota)){
                    WHERE(" A.GutMicrobiota = " + "'" + gutMicrobiota + "' ");
                }
                if(metabolite != null && !"".equals(metabolite)){
                    WHERE(" A.Metabolite = " + "'" + metabolite + "' ");
                }
                if(gene != null && !"".equals(gene)){
                    WHERE(" A.Gene = " + "'" + gene + "' ");
                }
            }
        }.toString();
    }

}
